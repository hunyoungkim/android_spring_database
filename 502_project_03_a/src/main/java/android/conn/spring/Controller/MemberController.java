package android.conn.spring.Controller;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import android.conn.spring.Service.MemberService;
import android.conn.spring.VO.MemberVO;


@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/mLogin", method = RequestMethod.POST)
	public @ResponseBody JSONObject mLogin(MemberVO VO) {

		JSONObject response = new JSONObject();
		HashMap<String,Object> additionalDetails = new HashMap<String,Object>();
		System.out.println(VO.getM_id()+"님이 로그인 요청");
		//System.out.println(VO.getM_password());
 		VO = memberService.login(VO);
 		
		if(VO.getLogincheck() == 1 || VO.getLogincheck() == 2) {
			additionalDetails.put("success", false);
			response = new JSONObject(additionalDetails);
			System.out.println("로그인 실패");
		} else if(VO.getLogincheck() == 3){
			System.out.println(VO.getM_id() + " 님 로그인 성공");
			
			additionalDetails.put("success", true);
			additionalDetails.put("m_id", VO.getM_id());
			additionalDetails.put("m_password", VO.getM_password());
			additionalDetails.put("m_name", VO.getM_name());
			additionalDetails.put("m_email", VO.getM_email());
			additionalDetails.put("m_phonenumber", VO.getM_phonenumber());
			additionalDetails.put("m_address", VO.getM_address());
			
			response = new JSONObject(additionalDetails);
			session.setAttribute("m_id", VO.getM_id());
			} 
		System.out.println(session.getAttribute("loginId"));
		System.out.println(VO);
		return response ;
	}


	@RequestMapping(value = "/mminsert", method = RequestMethod.POST)
	public @ResponseBody JSONObject minsert(MemberVO memberVO, Model model) {
		System.out.println(memberVO);
		memberService.insert(memberVO);
		//return "redirect:/";
		JSONObject response = new JSONObject();
			System.out.println("회원가입 완료");
			HashMap<String,Object> additionalDetails = new HashMap<String,Object>();
			additionalDetails.put("success", true);
			additionalDetails.put("memberVO", memberVO);
			
			response = new JSONObject(additionalDetails);
		System.out.println(response);	
		return response;
		
	}

	@RequestMapping(value = "/midcheck", method = RequestMethod.POST)
	public @ResponseBody JSONObject mid_check(Model model) {
		String id= request.getParameter("id");
		System.out.println(id+" - 중복 아이디 체크");

			boolean check_id = memberService.idcheck(id);
			System.out.println(check_id + " ==> 사용가능 true, 중복 id 존재 false");
			model.addAttribute("checkId", id);
			model.addAttribute("check", check_id);
			JSONObject response = new JSONObject();
			HashMap<String,Object> additionalDetails = new HashMap<String,Object>();
			additionalDetails.put("success", check_id);
			
			response = new JSONObject(additionalDetails);
			
			return response;
	
	}

	

	
}
