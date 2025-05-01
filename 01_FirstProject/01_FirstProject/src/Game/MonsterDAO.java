package Game;

import java.sql.*;

public class MonsterDAO {
    private static final String DB_URL = "jdbc:oracle:thin:@192.168.12.18:1521:xe";
    private static final String DB_USER = "PROJECT";
    private static final String DB_PASSWORD = "projectpw";

    private Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // 스테이지별 몬스터 가져오기
    public MonsterDTO getMonsterByStage(int stage) {
        String sql = "SELECT * FROM monsters WHERE stage = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, stage);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new MonsterDTO(
                    rs.getString("name"),
                    rs.getInt("hp"),
                    rs.getInt("str"),
                    rs.getInt("creditDrop"),
                    rs.getInt("stage")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
