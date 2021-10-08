package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderBookDao;
import bookmall.vo.OrderBookVo;



public class OrderBookDaoTest {

	public static void main(String[] args) {
		//insertTest();
		deleteTest();
		findAllTest();

	}
	
	private static void deleteTest() {
		OrderBookVo vo = new OrderBookVo();
		vo.setBookNo(1L);
		vo.setOrderNo(1L);
		
		new OrderBookDao().delete(vo);
		
	}

	private static void findAllTest() {
		List<OrderBookVo> list = new OrderBookDao().findAll();
		for(OrderBookVo vo : list) {
			System.out.println(vo);
		}
		
	}

	private static void insertTest() {
		OrderBookVo vo = null; 
		OrderBookDao dao = new OrderBookDao();
		
		vo = new OrderBookVo();
		vo.setBookNo(1L);
		vo.setOrderNo(1L);
		vo.setQty(1);
		vo.setPrice(13800);
		dao.insert(vo);

		vo = new OrderBookVo();
		vo.setBookNo(2L);
		vo.setOrderNo(2L);
		vo.setQty(1);
		vo.setPrice(13000);
		dao.insert(vo);
		
	}

}
