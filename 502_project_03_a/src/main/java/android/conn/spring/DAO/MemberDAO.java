package android.conn.spring.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import android.conn.spring.VO.MemberVO;



@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public MemberVO login(String m_id) {
		try {
			return sqlSessionTemplate.selectOne("login", m_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Transactional
	public void insert(MemberVO memberVO) {
		sqlSessionTemplate.insert("minsert", memberVO);
	}


	public  List<MemberVO> adminmember() {
		System.out.println("어드민 멤버 다오");
		return sqlSessionTemplate.selectList("memberall");
	}

}
