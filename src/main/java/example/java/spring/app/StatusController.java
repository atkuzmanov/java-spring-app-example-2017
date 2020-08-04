package example.java.spring.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatusController {
	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	@ResponseBody
	public String status() {
		return "OK!";
	}

}
