package vn.devpro.BTCK.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.BTCK.model.Category;
import vn.devpro.BTCK.model.User;
import vn.devpro.BTCK.service.CategoryService;
import vn.devpro.BTCK.service.UserService;


@RequestMapping(value="/manager")
@Controller
public class CategoryAdminController  {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	 @RequestMapping(value = "/list-category", method= RequestMethod.GET)
	 
	 public String listCategory(final Model model,
			                    final HttpServletRequest request,
			                    final HttpServletResponse response)throws IOException{
		 List<Category> categories = categoryService.findAll();
		 model.addAttribute("categories", categories);
		 return "admin/list-category";
	 }
	 
	 @RequestMapping(value = "/add-category", method = RequestMethod.GET)
		public String addCategory(final Model model, final HttpServletRequest request,
				final HttpServletResponse response) throws IOException {
			
			model.addAttribute("category", new Category());
			
		    List<User> users = userService.findAll();
			model.addAttribute("users", users);
			
			return "admin/add-category";
		}
	 @RequestMapping(value = "/add-category", method = RequestMethod.POST)
		public String saveCategory(final Model model, final HttpServletRequest request,
				final HttpServletResponse response,
				@ModelAttribute("category") Category category
				) throws IOException {
			
			categoryService.saveOrUpdate(category);
			
			return "redirect:/add-category";
		}

}
