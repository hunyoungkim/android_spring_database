package android.conn.spring.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import android.conn.spring.VO.BoardVO;




@Repository
public class BoardDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<BoardVO> list() {
		System.out.println("보드다오 진입");
		return sqlSessionTemplate.selectList("mselectAll");
	}
	
	public String numcount() {
		return sqlSessionTemplate.selectOne("mnumcount");
	}
	public void insert(BoardVO VO) {
		sqlSessionTemplate.insert("madd",VO);
	
	}
	public void update(BoardVO VO) {
		sqlSessionTemplate.update("mupdate",VO);
	}
	public void delete(int num) {
	sqlSessionTemplate.delete("mdelete",num);	
	}
}
