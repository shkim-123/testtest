package com.sohee.erp.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sohee.erp.Info;
import com.sohee.erp.Util;
import com.sohee.erp.dao.LoginDAO;

@Controller
public class LoginController {

	@Autowired
	private LoginDAO loginDAO;
	
	// jsp 파일 경로
	private String path = Info.soheePath + "login/";
	
	@RequestMapping(value="/login_form.do")
	public String goLoginForm() {	
		return path+"loginForm.jsp";
	}
	
	@RequestMapping( 
			value="/loginProc.do" 
			,method=RequestMethod.POST
			,produces="application/json;charset=UTF-8"
	)
	@ResponseBody
	public int loginProc(
			@RequestParam(value="login_id") String login_id
			, @RequestParam(value="pwd") String pwd
			, @RequestParam(value="is_login", required=false) String is_login
			, HttpSession session
			, HttpServletResponse response		
	) {
		
		Map<String, String> id_pwd_map = new HashMap<String, String>();
		id_pwd_map.put("login_id", login_id);
		id_pwd_map.put("pwd", pwd);
		
		int login_idCnt = this.loginDAO.getLogin_idCnt(id_pwd_map);
		
		if(login_idCnt == 1) {
			session.setAttribute("login_id", login_id);
			
			if(is_login == null) {
				Util.addCookie(
						"login_id"		// 쿠키명
						, null			// 쿠키값
						, 0				// 생명 주기
						, response		// HttpServletResponse 객체
				);
				Util.addCookie("pwd", null, 0, response);
				
			} 
			else {
				Util.addCookie("login_id", login_id, 60*60*24, response);
				Util.addCookie("pwd", pwd, 60*60*24, response);
			}
			session.setAttribute("msg", "좋은 하루 ╰(*°▽°*)╯");
		}
		return login_idCnt;
	}
	
	@RequestMapping( value="/logout.do" )
	public String logout(HttpSession session) {
		session.removeAttribute("login_id");
		return path+"logout.jsp";
	}
	
	@RequestMapping( value="/login_alert.do" )
	public String login_alert() {
		return path+"login_alert.jsp";
	}
	
}
