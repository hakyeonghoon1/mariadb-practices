package bookmall.dao.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		//insertTest();
		//deleteTest();
		updateTest();
		findAllTest();
		
	}

	private static void updateTest() {
		MemberVo vo = new MemberVo();
		vo.setNo(12L);
		vo.setName("수정222");
		
		System.out.println(vo);
		new MemberDao().update(vo);
	}

	private static void deleteTest() {
		MemberVo vo = new MemberVo();
		vo.setNo(10L);
		
		new MemberDao().delete(vo);
		
	}

	private static void findAllTest() {
		List<MemberVo> list = new MemberDao().findAll();
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
		
	}

	private static void insertTest() {
		MemberVo vo = null; 
		MemberDao dao = new MemberDao();
		
		vo = new MemberVo();
		vo.setName("하경훈");
		vo.setTel("010-0000-0000");
		vo.setEmail("abcd@gmail.com");
		vo.setPassword("a1234");		
		dao.insert(vo);

		vo = new MemberVo();
		vo.setName("김대한");
		vo.setTel("010-1111-2222");
		vo.setEmail("sdfewf@naver.com");
		vo.setPassword("b9876");
		dao.insert(vo);	
		
	}
}
