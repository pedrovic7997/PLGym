package plgym;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import plgym.domain.Exercise;

@Controller
public class BackAppHtmlController
{
	@GetMapping("/")
	public String index()
	{
		return "index";
	}

	@RequestMapping("/login")
    public String login()
	{
        return "login";
    }

	@RequestMapping("/myworkout")
    public String myWorkout(Model model)
	{
		model.addAttribute("exerciseDB", BackAppController.exerciseDB);
        return "myworkout";
    }

	@RequestMapping("/signup")
	public String signup()
	{
		return "signup";
	}

	@RequestMapping("/discover")
	public String discover()
	{
		return "discover";
	}

	@RequestMapping("/suggestions")
	public String suggestions()
	{
		return "suggestions";
	}

	@RequestMapping("/profile")
	public String profile()
	{
		return "profile";
	}
}