import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String sql = "SELECT * FROM NEWLEC.NOTICE";
			con = DriverManager.getConnection(url,"scott","tiger");
			st = con.prepareStatement(sql);
			
//			st.setInt(1, 1);
//			st.setString(2, "재정학개론");
			
			rs = st.executeQuery();
//			System.out.println(result);
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				System.out.println(id+":"+title);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
