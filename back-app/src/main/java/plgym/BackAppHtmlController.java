package plgym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import plgym.domain.Exercise;
import plgym.domain.subdomain.Category;
import plgym.domain.subdomain.Difficulty;

@Controller
public class BackAppHtmlController
{
	@GetMapping("/")
	public String getMain(Model model)
	{
		// Exercise exercise = new Exercise("nome", (float) 1.4, Difficulty.values()[0], Category.values()[0], "link");
		// model.addAttribute("exercise", exercise);
		return "startbootstrap-simple-sidebar-gh-pages/index";
	}

	// TODO: FAZER UMA DIRETORIO PRA ESCOLHER: LOGIN -> RAIZ OU SIGNUP -> LOGIN -> RAIZ

	@RequestMapping("/login")
    public String login() {
        return "login";
    }
}