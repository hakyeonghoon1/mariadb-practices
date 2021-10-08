package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;


public class OrderDaoTest {

	public static void main(String[] args) {
		//insertTest();
		deleteTest();
		findAllTest();

	}
	private static void deleteTest() {
		OrderVo vo = new OrderVo();
		vo.setNo(6L);
		
		new OrderDao().delete(vo);
		
	}
	private static void findAllTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
		
	}

	private static void insertTest() {
		OrderVo vo = null; 
		OrderDao dao = new OrderDao();
		
		vo = new OrderVo();
		vo.setOrdNo("A00001");
		vo.setPay(13800);
		vo.setAddr("부산시 금정구");
		vo.setMemberNo(1L);
		dao.insert(vo);

		vo = new OrderVo();
		vo.setOrdNo("A00002");
		vo.setPay(13000);
		vo.setAddr("부산시 부산진구");
		vo.setMemberNo(2L);
		dao.insert(vo);
		
	}

}
