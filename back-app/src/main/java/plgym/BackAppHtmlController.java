package plgym;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackAppHtmlController
{
	@GetMapping("/")
	public String getMain()
	{
		
	}
}