package bookmall.dao.test;

import java.util.List;


import bookmall.dao.CategoryDao;

import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		updateTest();
		deleteTest();
		//insertTest();
		findAllTest();

	}
	private static void updateTest() {
		CategoryVo vo = new CategoryVo();
		vo.setNo(12L);
		vo.setName("수정222");

		new CategoryDao().update(vo);
	}

	private static void deleteTest() {
		CategoryVo vo = new CategoryVo();
		vo.setNo(10L);
		
		new CategoryDao().delete(vo);
		
	}
	private static void findAllTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
		
	}

	private static void insertTest() {
		CategoryVo vo = null; 
		CategoryDao dao = new CategoryDao();
		
		vo = new CategoryVo();
		vo.setName("소설");	
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setName("시/에세이");
		dao.insert(vo);	
		
		vo = new CategoryVo();
		vo.setName("컴퓨터IT");
		dao.insert(vo);	
		
	}

}
