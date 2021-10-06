package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;

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
	}

}
