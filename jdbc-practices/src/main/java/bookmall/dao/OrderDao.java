package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderVo;


public class OrderDao {
	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs  = null;
		try {
			conn = getConnection();

			//3.SQL 준비
			String sql = "select no, ord_no, pay, addr, member_no from `order`";
			pstmt = conn.prepareStatement(sql);
			
			//4.바인딩
			
			//5.SQL 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String ordNo = rs.getString(2);
				int pay = rs.getInt(3);
				String addr = rs.getString(4);
				Long memberNo = rs.getLong(5);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setOrdNo(ordNo);
				vo.setPay(pay);
				vo.setAddr(addr);
				vo.setMemberNo(memberNo);
				
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
	
	public boolean insert(OrderVo vo) {
		boolean result = false;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			
			//1.JDBC DRIVER 로딩
			//2.연결하기
			conn = getConnection();
			
			//3.SQL문 준비
			String sql = "insert into `order` values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4.바인딩(binding)
			pstmt.setString(1, vo.getOrdNo());
			pstmt.setInt(2, vo.getPay());
			pstmt.setString(3, vo.getAddr());
			pstmt.setLong(4, vo.getMemberNo());
			
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
			String  url ="jdbc:mysql://115.22.10.42:3306/bookmall?charset=utf8";			
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
