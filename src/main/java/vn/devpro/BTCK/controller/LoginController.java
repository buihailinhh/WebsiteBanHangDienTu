package vn.devpro.BTCK.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller

public class LoginController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			
			throws IOException {
		
		return "login";
	}
	
//	@RequestMapping(value = "/signup", method = RequestMethod.GET)
//	public String signup(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response)
//			
//			throws IOException {
//		
//		return "signup";
//	}
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public String register(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response)
//			
//			throws IOException {
//		
//		User user = new User();
//		user.setUsername(request.getParameter("username"));
//		user.setPassword(new BCryptPasswordEncoder(4).encode(request.getParameter("password")));
//		user.setEmail(request.getParameter("email"));
//		user.setMobile(request.getParameter("mobile"));
//		
//		// Set role cho user mới- mặc định role là 'customer'
//		// Lấy cái role có name là 'customer' trong DB
//		
//		Role role =roleService.getRoleByName("CUSTOMER");
//		user.addRole(role);// Luu rang buoc voi role -> tbl_user_role
//		userService.saveOrUpdate(user);
//		
//
//		
//		return "redirect:/signup";
//	}
//	
//	
// 
}
