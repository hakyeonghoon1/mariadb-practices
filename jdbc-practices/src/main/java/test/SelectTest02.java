package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest02 {
	public static void main(String[] args) {
		search("pat");
	}
	public static void search(String keyword) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs  = null;
		try {
			
			//1.JDBC DRIVER 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2.연결하기
			String  url ="jdbc:mysql://115.22.10.42:3306/employees?charset=utf8";			
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			//3.SQL 준비
			String sql ="select emp_no, first_name from employees where first_name like ?";
			pstmt = conn.prepareStatement(sql);
			
			//4.바인딩
			pstmt.setString(1, "%"+keyword+"%");
			
			//5.SQL 실행
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				
				System.out.println(empNo+ ":"+firstName);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:"+e);
		} catch (SQLException e) {
			System.out.println("error:"+e);
		} finally {
			try {
				//clean up
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
