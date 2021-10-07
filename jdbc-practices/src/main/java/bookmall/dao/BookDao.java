package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;



public class BookDao {
	public List<BookVo> findAll() {
		List<BookVo> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs  = null;
		try {
			conn = getConnection();

			//3.SQL 준비
			String sql = "select no, name, price, category_no from book order by no asc";
			pstmt = conn.prepareStatement(sql);
			
			//4.바인딩

			//5.SQL 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				Long categoryNo = rs.getLong(4);

				
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPrice(price);
				vo.setCategoryNo(categoryNo);
				
				result.add(vo);
			}

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
		return result;
	}
	
	public boolean insert(BookVo vo) {
		boolean result = false;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			
			//1.JDBC DRIVER 로딩
			//2.연결하기
			conn = getConnection();
			
			//3.SQL문 준비
			String sql = "insert into book values (null, ?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//4.바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategoryNo());
			
			//5.SQL 실행			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:"+e);
		} finally {
			try {
				//clean up
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
		
		return result;
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn =null;
		
		try {
			//1.JDBC DRIVER 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2.연결하기
			String  url ="jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			//String  url ="jdbc:mysql://115.22.10.42:3306/bookmall?charset=utf8";			
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
