package android.conn.spring.Controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import android.conn.spring.Service.BoardService;
import android.conn.spring.VO.BoardVO;




@Controller
public class BoardController {
	@Autowired
	private BoardService	boardService;
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/boardlist")
	public @ResponseBody JSONObject listAll() {
		System.out.println("보드리스트 진입");
		 JSONArray jArray = new JSONArray();
		 List<BoardVO> list = new ArrayList<BoardVO>();
		 JSONObject response = new JSONObject();
		 
				list = boardService.listAll();
				
				for (int i = 0; i < list.size(); i++) {
					BoardVO VO = list.get(i);
					HashMap<String,Object> data = new HashMap<String,Object>();
					
					data.put("num", VO.getNum());
					data.put("subject", VO.getSubject());
					data.put("m_id", VO.getM_id());
					data.put("content", VO.getContent());
					data.put("write_date", VO.getWrite_date());
					jArray.add(i, data);
				}
				response.put("data", jArray);
				System.out.println(list);
		return response;
	}
	
	@RequestMapping(value = "/mWrite", method = RequestMethod.POST)
	public @ResponseBody JSONObject  add(BoardVO VO) throws Exception {
	JSONObject response = new JSONObject();
	HashMap<String,Object> additionalDetails = new HashMap<String,Object>();
	//String m_id = (String) session.getAttribute("m_id");
	//VO.setM_id(m_id);
	System.out.println("아이디가 들어와야 하는데" + VO.getM_id());
	boardService.add(VO);
	additionalDetails.put("success", true);
	response = new JSONObject(additionalDetails);
	return response ;
	
	}
	@RequestMapping(value = "/mUpdate", method = RequestMethod.POST)
	public @ResponseBody JSONObject Update(BoardVO VO)throws Exception {
		JSONObject response = new JSONObject();
		HashMap<String,Object> additionalDetails = new HashMap<String,Object>();
		System.out.println("안보이네 -----------------------------------------------"+VO);
		boardService.update(VO);
		additionalDetails.put("success", true);
		response = new JSONObject(additionalDetails);
		return response ;

	}
	@RequestMapping(value = "/mDelete", method = RequestMethod.POST)
	public @ResponseBody JSONObject  delete(BoardVO VO) throws Exception {
		JSONObject response = new JSONObject();
		HashMap<String,Object> additionalDetails = new HashMap<String,Object>();
		System.out.println("들어오나?======삭제"+VO.getNum());
		boardService.delete(VO.getNum());
		
		additionalDetails.put("success", true);
		response = new JSONObject(additionalDetails);
		return response ;
		
		}

	}
	

