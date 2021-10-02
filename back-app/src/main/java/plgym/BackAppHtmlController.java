package plgym;

import java.security.Principal;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import plgym.domain.Exercise;
import plgym.domain.ExerciseList;
import plgym.domain.User;

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
    public String myWorkout(Model model, Principal principal)
	{
		User user = BackAppController.userDB.getValue(principal.getName());
		String[] userExercisesId = user.getExercisesId().toArray(new String[0]);
		ExerciseList userExercises = new ExerciseList(
				userExercisesId,
				BackAppController.exerciseDB,
				new TypeToken<Map<String, Exercise>>(){}
		);
		model.addAttribute("exercises", userExercises);
        return "myworkout";
    }

	@RequestMapping("/signup")
	public String signup()
	{
		return "signup";
	}

	@RequestMapping("/discover")
	public String discover(Model model)
	{
		model.addAttribute("exerciseDB", BackAppController.exerciseDB);
		return "discover";
	}

	@RequestMapping("/suggestions")
	public String suggestions()
	{
		return "suggestions";
	}

	@RequestMapping("/profile")
	public String profile(Model model, Principal principal)
	{
		model.addAttribute("user", BackAppController.userDB.getValue(principal.getName()));
		return "profile";
	}
}