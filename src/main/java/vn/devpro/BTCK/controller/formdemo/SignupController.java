package vn.devpro.BTCK.controller.formdemo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.BTCK.dto.Customer;

@Controller

public class SignupController {
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signAccount( final Model model, final HttpServletRequest request, 
			final HttpServletResponse respone)throws IOException{
		return "formdemo/signup";
	}
	
	
	
	@RequestMapping(value = "/customer-list", method = RequestMethod.POST)
	public String save( final Model model, final HttpServletRequest request, 
			final HttpServletResponse respone)throws IOException{
		System.out.println("Account:" + request.getParameter("txtName"));
		// lấy dữ liệu từ form trong view signup
		Customer customer = new Customer(
		        request.getParameter("txtAccount"),
		        request.getParameter("password"),
		        request.getParameter("txtName"),
		        request.getParameter("txtEmail"),
		        Boolean.parseBoolean(request.getParameter("remember")) );
		             //Dua dữ liệu lên view
		
		model.addAttribute("customer", customer);
		
		  return "formdemo/customer-list";
	}
	
	
	@RequestMapping(value = "/customer-edit", method = RequestMethod.GET)
	public String customerEdit( final Model model, final HttpServletRequest request, 
			final HttpServletResponse respone)throws IOException{
		System.out.println("Account:" + request.getParameter("txtName"));
		// lấy dữ liệu từ form singup
		Customer customer = new Customer(
		        "devpro",
		        "123456",
		        "devpro jsc",
		        "ronaldo@gmail.com",
	             false );
		             //Dua dữ liệu lên view customer-edit
		
		  model.addAttribute("customer", customer);
		
		  return "formdemo/customer-edit";
	}
	@RequestMapping(value = "/customer-edit", method = RequestMethod.POST)
	public String saveEdit( final Model model, final HttpServletRequest request, 
			final HttpServletResponse respone)throws IOException{
		System.out.println("Account:" + request.getParameter("txtName"));
		String message = request.getParameter("txtAccount") +" đã được lưu thành công";
		
//		đưa dữ liệu lên view
		model.addAttribute("message", message);
		
		  return "formdemo/customer-edit";
	}
	
	@RequestMapping(value = "/customer-edit-ajax", method = RequestMethod.GET)
	public String editAjax( final Model model, final HttpServletRequest request, 
			final HttpServletResponse respone)throws IOException{
		System.out.println("Account:" + request.getParameter("txtName"));
		// lấy dữ liệu từ form singup
		Customer customer = new Customer(
		        "realmadrid",
		        "123456",
		        "devpro jsc",
		        "ronaldo@gmail.com",
	             false );
		             //Dua dữ liệu lên view customer-edit
		
		  model.addAttribute("customer", customer);
		
		  return "formdemo/customer-edit-ajax";
	}
	@RequestMapping(value = "/customer-edit-ajax", method = RequestMethod.POST)	
	public ResponseEntity<Map<String, Object>> saveAjax(final Model model, 
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody Customer customer
			) throws IOException {
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("message", "Lưu thành công thông tin khách hàng " + customer.getTxtAccount());
		return ResponseEntity.ok(jsonResult);
	}
}
