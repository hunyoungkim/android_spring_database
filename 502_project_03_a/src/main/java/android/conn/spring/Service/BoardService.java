package android.conn.spring.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import android.conn.spring.DAO.BoardDAO;
import android.conn.spring.VO.BoardVO;




@Service
public class BoardService {

	@Autowired
	private BoardDAO boaedDAO;


	public List<BoardVO> listAll(){
		System.out.println("보드서비스 진입");
		return boaedDAO.list();
	}
	public void add(BoardVO VO) {
		String num = boaedDAO.numcount();
		int num1;
		if (num == null) {
			num1 = 1;
		}else {
			num1 = Integer.parseInt(num) + 1;
		}
		VO.setNum(num1);
		System.out.println(num1);
		boaedDAO.insert(VO);
	}
	public void update(BoardVO VO) {
		boaedDAO.update(VO);
		}
	public void delete(int num) {
		boaedDAO.delete(num);
	}
	
}
