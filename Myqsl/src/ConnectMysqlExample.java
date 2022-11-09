import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConnectMysqlExample {
    private static String DB_URL = "jdbc:mysql://localhost:3306/studen";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";
    public static void main(String[] args) throws SQLException {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("connect successfully!");
			String sql = "select * from student";
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("idStudent")+"_") ;
				System.out.println(rs.getString("full_name")+"_") ;
				System.out.println(rs.getDouble("score")+"\n") ;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
