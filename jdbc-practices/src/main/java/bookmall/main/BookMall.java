package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderBookDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
		/*
		new CategoryDao().insert(vo);
		new CategoryDao().insert(vo);
		new CategoryDao().insert(vo);
		
		new CategoryDao().findAll();
		*/
		// member 데이터 생성 및 조회
		MemberVo mVo = null; 
		mVo = new MemberVo();
		mVo.setName("하경훈");
		mVo.setTel("010-0000-0000");
		mVo.setEmail("abcd@gmail.com");
		mVo.setPassword("a1234");		
		
		new MemberDao().insert(mVo);
		
		mVo = new MemberVo();
		mVo.setName("김대한");
		mVo.setTel("010-1111-2222");
		mVo.setEmail("sdfewf@naver.com");
		mVo.setPassword("b9876");

		new MemberDao().insert(mVo);
		
		System.out.println("==== Member 리스트 ====");
		
		List<MemberVo> list1 = new MemberDao().findAll();
		for(MemberVo vo1 : list1) {
			System.out.println(vo1);
		}
		
		// category 데이터 생성 및 조회
		CategoryVo cVo = null;
		cVo = new CategoryVo();
		cVo.setName("소설");
		
		new CategoryDao().insert(cVo);
		
		cVo = new CategoryVo();
		cVo.setName("시/에세이");
		
		new CategoryDao().insert(cVo);
		
		cVo = new CategoryVo();
		cVo.setName("컴퓨터IT");
		
		new CategoryDao().insert(cVo);
		
		System.out.println("==== Category 리스트 ====");
		
		List<CategoryVo> list2 = new CategoryDao().findAll();
		for(CategoryVo vo2 : list2) {
			System.out.println(vo2);
		}
		
		// Book 데이터 생성 및 조회
		BookVo bVo = null;
		bVo = new BookVo();
		bVo.setName("달러구트 꿈 백화점2");
		bVo.setPrice(13800);
		bVo.setCategoryNo(1L);
		new BookDao().insert(bVo);
		
		bVo = new BookVo();
		bVo.setName("월든");
		bVo.setPrice(13000);
		bVo.setCategoryNo(2L);
		new BookDao().insert(bVo);
		
		bVo = new BookVo();
		bVo.setName("ADsP 데이터 분석 준전문가");
		bVo.setPrice(28000);
		bVo.setCategoryNo(3L);
		new BookDao().insert(bVo);
		
		System.out.println("==== Book 리스트 ====");
		
		List<BookVo> list3 = new BookDao().findAll();
		for(BookVo vo3 : list3) {
			System.out.println(vo3);
		}
		
		// Cart 데이터 생성 및 조회
		CartVo CartVo = null;
		CartVo = new CartVo();
		CartVo.setBookNo(1L);
		CartVo.setMemberNo(2L);
		CartVo.setQty(30);
		new CartDao().insert(CartVo);
		
		CartVo = new CartVo();
		CartVo.setBookNo(3L);
		CartVo.setMemberNo(1L);
		CartVo.setQty(60);
		new CartDao().insert(CartVo);
		
		System.out.println("==== Cart 리스트 ====");
		
		List<CartVo> list4 = new CartDao().findAll();
		for(CartVo vo4 : list4) {
			System.out.println(vo4);
		}
		
		// Order 데이터 생성 및 조회
		OrderVo ordVo = null; 
		
		ordVo = new OrderVo();
		ordVo.setOrdNo("A00001");
		ordVo.setPay(13800);
		ordVo.setAddr("부산시 금정구");
		ordVo.setMemberNo(1L);
		new OrderDao().insert(ordVo);

		ordVo = new OrderVo();
		ordVo.setOrdNo("A00002");
		ordVo.setPay(13000);
		ordVo.setAddr("부산시 부산진구");
		ordVo.setMemberNo(2L);
		new OrderDao().insert(ordVo);
		
		System.out.println("==== Order 리스트 ====");
		
		List<OrderVo> list5 = new OrderDao().findAll();
		for(OrderVo vo5 : list5) {
			System.out.println(vo5);
		}
		
		// OrderBook 
		
		OrderBookVo obVo = null; 
		
		obVo = new OrderBookVo();
		obVo.setBookNo(1L);
		obVo.setOrderNo(1L);
		obVo.setQty(1);
		obVo.setPrice(13800);
		new OrderBookDao().insert(obVo);

		obVo = new OrderBookVo();
		obVo.setBookNo(2L);
		obVo.setOrderNo(2L);
		obVo.setQty(1);
		obVo.setPrice(13000);
		new OrderBookDao().insert(obVo);
		
		System.out.println("==== OrderBook 리스트 ====");
		
		List<OrderBookVo> list6 = new OrderBookDao().findAll();
		for(OrderBookVo vo6 : list6) {
			System.out.println(vo6);
		}
	}

}
