package SignPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDAO {
	private static final String DB_URL = "jdbc:oracle:thin:@192.168.12.18:1521:xe";
	private static final String DB_USER = "PROJECT";
	private static final String DB_PASSWORD = "projectpw";
	Scanner sc = new Scanner(System.in);
	
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	// iD 중복여부 확인
	public boolean isIdExists(String id) {
		String sql = "SELECT COUNT(*) FROM users WHERE id = ?";
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 1-1. 로그인
	public boolean login(String id, String pw) {
		String sql = "SELECT * FROM users WHERE id = ? AND pw = ?";
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 1-2. 회원탈퇴
	public void deleteUser(String id) {
		String sql = "DELETE FROM users WHERE id = ?";
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			if (result > 0)
				System.out.println(">> 회원탈퇴가 완료되었습니다.");
			else
				System.out.println(">> 삭제할 수 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 1-3. 닉네임 변경
	public void updateName(String id) {
		String sql2 = "";
		sql2 += "UPDATE USERS SET ";
		sql2 += "NAME = ? ";
		sql2 += "WHERE ID = ? ";
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			
			System.out.print("새 닉네임: ");
			String newName = sc.nextLine();

			if (newName.isEmpty()) {
				System.out.println("❗ 닉네임은 비워둘 수 없습니다.");
			}

			System.out.println("name : " + newName);
			pstmt.setString(1, newName);
			pstmt.setString(2, id);

			int result = pstmt.executeUpdate();
			System.out.println("::처리건수 : " + result);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2-1. 회원가입
	public void insertUser(String id, String pw, String name) {
		if (isIdExists(id)) {
			System.out.println("❗ 동일한 아이디가 있습니다.");
			return;
		}

		String sql = "INSERT INTO users (id, pw, name) VALUES (?, ?, ?)";
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
			System.out.println(">> 회원가입이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3-1. 비밀번호 찾기
	public void resetPassword(String id, String newPw) {
		if (!isIdExists(id)) {
			System.out.println(">> 존재하지 않는 아이디입니다.");
			return;
		}

		String sql = "UPDATE users SET pw = ? WHERE id = ?";
		try (Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, newPw);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			System.out.println(">> 비밀번호가 성공적으로 변경되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
