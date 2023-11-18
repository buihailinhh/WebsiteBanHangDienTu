package vn.devpro.BTCK.controller.formdemo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.devpro.BTCK.dto.Constants;
import vn.devpro.BTCK.dto.Customer;

@Controller
public class SignupSfController implements Constants {
	@RequestMapping(value = "/signup-sf", method = RequestMethod.GET)
	
	public String signupAccount(final Model model, 
			final HttpServletRequest request, 
			HttpServletResponse
			response) throws IOException{
		
		model.addAttribute("customer", new Customer());
		return "formdemo/signup-sf";
	}
	
@RequestMapping(value = "/customer-list-sf", method = RequestMethod.POST)
	
	public String saveCustomer(final Model model, 
			final HttpServletRequest request, 
			HttpServletResponse
			response,
			@ModelAttribute("customer") Customer customer, // Hứng dữ liệu từ spring form từ view signup-sf
		
			/*  @RequestParam("uploadFile") MultipartFile file : upload 1 file  */
			
			 @RequestParam("uploadFile") MultipartFile[] files
			
	) throws IOException {
	
	// Kiểm tra người dùng có chọn file để upload hay không ?
	/*
		if(file != null && !file.getOriginalFilename().isEmpty()) { //Người dùng có upload
			//lưu file vào thư mục FileUplaod /CustomerFile
			String path = FOLDER_UPLOAD + "CustomerFile/"+ file.getOriginalFilename();
		file.transferTo(new File(path));
			//TODO:lưu đường dẫn của file vào database
			
		}
		
		*/
	// Upload nhiều file
	if(files.length > 0) {
		for( MultipartFile file : files) {
			String path = FOLDER_UPLOAD + "CustomerFile/"+ file.getOriginalFilename();
			file.transferTo(new File(path));
			
		}
	}
		model.addAttribute("customer", customer);// đẩy lên view customer-list-sf
		return "formdemo/customer-list-sf";
		
	}
	

@RequestMapping(value = "/customer-edit-sf", method = RequestMethod.GET)

public String customerEditSf(final Model model, 
		final HttpServletRequest request, 
		HttpServletResponse
		response) {
	Customer customer = new Customer("Ronaldo", "1234", "CR7","ronaldo@gmail.com", true);
	
	model.addAttribute("customer", customer);
	return "formdemo/customer-edit-sf";
}
@RequestMapping(value = "/customer-edit-ajax-sf", method = RequestMethod.POST)	
public ResponseEntity<Map<String, Object>> saveEditAjax(final Model model, 
		final HttpServletRequest request,
		final HttpServletResponse response,
		final @RequestBody Customer customer
		) throws IOException {
	
	Map<String, Object> jsonResult = new HashMap<String, Object>();
	jsonResult.put("code", 200);
	jsonResult.put("message", "Thay đổi đã được lưu thành công với: " + customer.getTxtAccount());
	return ResponseEntity.ok(jsonResult);
}
	
	

}
