package com.controller;


import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;

import com.common.Constants;
import com.pojo.User;
import com.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

@Controller
public class LoginController {
	private  Logger logger= Logger.getLogger(LoginController.class);
	@Resource
	private UserService userService;

	@RequestMapping("/login.html")
	@ResponseBody
	public Object login(HttpSession session,@RequestParam String user){
		
		System.out.println(user);
		
		if(null==user||"".equals(user)){
			return "nodata";
		}else{
			System.err.println("111111111111111111111111111111111111111111111111111111111111");
			//json对象转换成user对象
			try {System.err.println("sssssssssssssssssssss");
			JSONObject userObject = JSONObject.fromObject(user);
				
			System.out.println("s33333333333333333333111111111111111111111111111");
			User userobj = (User) JSONObject.toBean(userObject,User.class);
			
			System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			
			
			
				if(userService.loginCodeIsExit(userobj)==0){
					System.out.println("s333333fffffffffffffff33333111111111111111111111111111");
					return "nologincode";
				}else {
					User _user = userService.getLoginUser(userobj);
					if (null!=_user) {
						session.setAttribute(Constants.SESSION_USER, _user);
						User updateLoginTimeUser= new User();
						updateLoginTimeUser.setId(_user.getId());
						updateLoginTimeUser.setLastLoginTime(new Date());
						userService.modifyUser(updateLoginTimeUser);
						updateLoginTimeUser=null;
						return "success";
					}else {
						//密码错误
						return "pwderror";
					}
				}
			} catch (Exception e) {
				System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				e.printStackTrace();
				return "failed";
			}
		}
	}
	@RequestMapping("/main.html")
	public ModelAndView main(){
		logger.debug("ddddddddddddddddddddddddddd");
		return  new ModelAndView("main");
	}
}
