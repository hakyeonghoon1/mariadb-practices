package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;



public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();

	}

	private static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
		
	}

	private static void insertTest() {
		BookVo vo = null; 
		BookDao dao = new BookDao();
		
		vo = new BookVo();
		vo.setName("달러구트 꿈 백화점2");
		vo.setPrice(13800);
		vo.setCategoryNo(1L);
		dao.insert(vo);

		vo = new BookVo();
		vo.setName("월든");
		vo.setPrice(13000);
		vo.setCategoryNo(2L);
		dao.insert(vo);	
		
		vo = new BookVo();
		vo.setName("ADsP 데이터 분석 준전문가");
		vo.setPrice(28000);
		vo.setCategoryNo(3L);
		dao.insert(vo);	
		
	}


}
