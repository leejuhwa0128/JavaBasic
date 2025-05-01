package Game;

import java.sql.*;

public class GameDAO {
	// DB 연동
	private static final String DB_URL = "jdbc:oracle:thin:@192.168.12.18:1521:xe";
	private static final String DB_USER = "PROJECT";
	private static final String DB_PASSWORD = "projectpw";

	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	// USER 정보 가져오기
	public UserDTO getUserInfo(String id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		try (Connection conn = getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new UserDTO(rs.getString("name"), rs.getInt("credit"), rs.getInt("sword"), rs.getInt("str"),
						rs.getInt("armor"), rs.getInt("hp"), rs.getInt("stage"), rs.getInt("rank"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 무기 업데이트
	public void updateUserWeapon(String id, int credit, int sword, int str) {
		String sql = "UPDATE users SET credit = ?, sword = ?, str = ? WHERE id = ?";
		try (Connection conn = getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, credit);
			stmt.setInt(2, sword);
			stmt.setInt(3, str);
			stmt.setString(4, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 방어구 업데이트
	public void updateUserArmor(String id, int credit, int armor, int hp) {
		String sql = "UPDATE users SET credit = ?, armor = ?, hp = ? WHERE id = ?";
		try (Connection conn = getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, credit);
			stmt.setInt(2, armor);
			stmt.setInt(3, hp);
			stmt.setString(4, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 스테이지 업데이트
	public void updateStage(String id, int stage) {
		String sql = "UPDATE users SET stage = ? WHERE id = ?";
		try (Connection conn = getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, stage);
			stmt.setString(2, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 최고스테이지
	public void updateMaxStage(String id, int stage) throws Exception {
		String sql = "UPDATE users SET max_stage = CASE WHEN ? > max_stage THEN ? ELSE max_stage END WHERE id = ?";
		try (Connection conn = getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, stage); // 첫 번째 ?에 현재 스테이지 설정
			stmt.setInt(2, stage); // 두 번째 ?에 현재 스테이지 설정
			stmt.setString(3, id); // 세 번째 ?에 사용자 ID 설정

			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println(">> 최대 스테이지 갱신 성공.");
			} else {
				System.out.println(">> 최대 스테이지 갱신 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 랭킹
	public void updateUserRanks() throws Exception {
		String sql = "MERGE INTO users u ";
		sql += "USING (SELECT id, RANK() OVER (ORDER BY max_stage DESC) AS computed_rank FROM users) r ";
		sql += "ON (u.id = r.id) ";
		sql += "WHEN MATCHED THEN UPDATE SET u.rank = r.computed_rank";
		try (Connection conn = getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			int rows = stmt.executeUpdate();
			System.out.println("전체 유저 랭킹이 업데이트되었습니다. (총 " + rows + "명)");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 강화된 Armor 수치 기반으로 hp 재계산하는 메서드
	public void refreshUserHp(String id) {
		String sql = "SELECT armor FROM users WHERE id = ?";
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int armor = rs.getInt("armor");
				int baseHp = 100; // 기본 HP
				int newHp = baseHp + (armor * 250); // 강화 1당 250씩 증가

				// 업데이트
				String updateSql = "UPDATE users SET hp = ? WHERE id = ?";
				try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
					updateStmt.setInt(1, newHp);
					updateStmt.setString(2, id);
					updateStmt.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}