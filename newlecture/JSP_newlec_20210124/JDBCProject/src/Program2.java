import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String sql = "UPDATE NOTICE SET HIT= ? WHERE ID=?";
			String sql = "DELETE NOTICE WHERE ID=?";
			con = DriverManager.getConnection(url,"newlec","tiger");
			st = con.prepareStatement(sql);
			
			st.setInt(1, 3);
			
			int result = st.executeUpdate();
			System.out.println(result);
//			while(rs.next()) {
//				String title = rs.getString("title");
//				System.out.println(title);
//			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
//				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
