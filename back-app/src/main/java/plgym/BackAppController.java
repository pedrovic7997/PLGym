package plgym;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.Long;
import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import plgym.domain.Exercise;
import plgym.domain.ExerciseList;
import plgym.domain.User;
import plgym.domain.UserList;
import plgym.util.Persistence;

@RestController
public class BackAppController
{
//  	private static final String filePath = "/home/pedro/IdeaProjects/PLGym/back-app/src/main/resources/data/";
	private static final String filePath = "C:/Users/Leonardo/IdeaProjects/PLGym/back-app/src/main/resources/data/";
	private static final String userDbFileName = "users.json";
	private static final String exerciseDbFileName = "exercises.json";
    public static ExerciseList exerciseDB = new ExerciseList(filePath + exerciseDbFileName);
    public static UserList userDB = new UserList(filePath + userDbFileName);

    @GetMapping("/exercises")
	public ExerciseList getExercises(@RequestParam(name = "exer", defaultValue = "") String exer, Principal principal)
    {
		System.out.println(principal.getName());
		ExerciseList filteredExercises = new ExerciseList();
		for (String id : exerciseDB.getMap().keySet())
		{
			Exercise exercise = exerciseDB.getValue(id);
			if (exercise.getName().contains(exer)) {
				filteredExercises.addPair(id, exercise);
			}
		}
		return filteredExercises;
	}

	@GetMapping("/exercises/{id}")
	public Exercise getExercise(@PathVariable(name = "id") long id)
	{
		if (exerciseDB.getValue(Long.toString(id)) == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercício não encontrado");
		else
			return exerciseDB.getValue(Long.toString(id));
	}

	@GetMapping("/user")
	public User getUser(Principal principal)
	{
		User user = userDB.getValue(principal.getName());
		if(user != null) {
			return user;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
	}

	@PostMapping("/user")
	public void postUser(@RequestBody User newUser)
	{
//		String newId = userDB.getNewId();
//		System.out.println(newId + " " + newUser.getEmail() + " " + newUser.getPassword());
		userDB.addPair(newUser.getEmail(), newUser);
		System.out.println(userDB.getValue(newUser.getEmail()));
		serializeJson(userDB.toJson(), userDbFileName);
		throw new ResponseStatusException(HttpStatus.OK, "Usuário cadastrado");
	}

	@PutMapping("/user")
	public User putUser(@RequestBody User modifiedUser, Principal principal)
	{
		User user = userDB.getValue(principal.getName());
		if(user != null){
			userDB.removePair(principal.getName());
			user = (User) Persistence.partialUpdate(user, modifiedUser);
			userDB.addPair(user.getEmail(), user);
			serializeJson(userDB.toJson(), userDbFileName);
			return user;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
	}

	@PutMapping("/user/exercises")
	public void putExercise(@RequestBody String exerciseId, Principal principal)
	{
		User user = userDB.getValue(principal.getName());
		if(user != null) {
			user.addExerciseId(exerciseId.replace("\"", ""));
			serializeJson(userDB.toJson(), userDbFileName);
			throw new ResponseStatusException(HttpStatus.OK, "Exercício adicionado");
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
	}

	@DeleteMapping("/user/exercises")
	public void deleteExercise(@RequestBody String exerciseId, Principal principal)
	{
		User user = userDB.getValue(principal.getName());
		if(user != null) {
			user.removeExerciseId(exerciseId.replace("\"", ""));
			serializeJson(userDB.toJson(), userDbFileName);
			throw new ResponseStatusException(HttpStatus.OK, "Exercício removido");
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
	}

	public static String printAll()
	{
		String ex = "";
		for(String id : userDB.getMap().keySet()) {
			System.out.println(userDB.getValue(id));
			ex = id;
		}
		return ex;
	}

	public void serializeJson(String json, String fileName)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + fileName));
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
