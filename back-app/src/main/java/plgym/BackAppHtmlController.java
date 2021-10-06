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
public class BackAppHtmlController {
	/**
	 * Returns index page as HTTP response.
	 * 
	 * @return Name of HTML file located in back-app/src/main/resources/templates
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * Returns login page as HTTP response.
	 * 
	 * @return Name of HTML file located in back-app/src/main/resources/templates
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * Filters exercises the user has added from the exercise database and uses it to
	 * return user-specific page as HTTP response.
	 * 
	 * @param model Object necessary for adding attributes to be handled by Thymeleaf
	 *              on the HTML page
	 * @param principal Object housing relevant logged in user's info from the session
	 * @return Name of HTML file located in back-app/src/main/resources/templates
	 */
	@RequestMapping("/myworkout")
	public String myWorkout(Model model, Principal principal) {
		User user = BackAppController.userDB.getValue(principal.getName());
		String[] userExercisesId = user.getExercisesId().toArray(new String[0]);
		ExerciseList userExercises = new ExerciseList(userExercisesId, BackAppController.exerciseDB,
				new TypeToken<Map<String, Exercise>>() { });
		model.addAttribute("exercises", userExercises);
		return "myworkout";
	}

	/**
	 * Returns signup page as HTTP response.
	 * 
	 * @return Name of HTML file located in back-app/src/main/resources/templates
	 */
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}

	/**
	 * Returns discover page as HTTP response.
	 * 
	 * @param model Object necessary for adding attributes to be handled by Thymeleaf
	 * 				on the HTML page
	 * @return Name of HTML file located in back-app/src/main/resources/templates
	 */
	@RequestMapping("/discover")
	public String discover(Model model) {
		model.addAttribute("exerciseDB", BackAppController.exerciseDB);
		return "discover";
	}

	/**
	 * Returns profile page as HTTP response.
	 * 
	 * @param model Object necessary for adding attributes to be handled by Thymeleaf
	 * 				on the HTML page
	 * @param principal Object housing relevant logged in user's info from the session
	 * @return Name of HTML file located in back-app/src/main/resources/templates
	 */
	@RequestMapping("/profile")
	public String profile(Model model, Principal principal) {
		model.addAttribute("user", BackAppController.userDB.getValue(principal.getName()));
		return "profile";
	}
}