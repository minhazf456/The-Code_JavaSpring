package com.codingdojo.TheCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping ("/")
	public String index() {
		return "index.jsp";
	}
	
	@Controller
	public class SuccessCtrl {
		@RequestMapping(value="/code", method=RequestMethod.POST)
		public String success(@RequestParam(value="code") String code, RedirectAttributes errormessage) {
			if(code.equals("bushido")) {
				return "code.jsp";			
			}
			else {
		        errormessage.addFlashAttribute("error", "You must train harder!");
		        return "redirect:/";
			}
		}	
	}

}
