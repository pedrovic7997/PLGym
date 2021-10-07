package plgym;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import plgym.domain.ExerciseList;
import plgym.domain.User;
import plgym.domain.UserList;
import plgym.util.Persistence;

/**
 * Handles most HTTP requests.
 * @author leodeorce
 * @author pedrovic7997
 */
@RestController
public class BackAppController
{
	// filePath needs to be a full path to back-app/src/main/resources/data folder
	// to access our already built examples of user and exercises files
	// or point it to wherever you would like your JSON database to be
	private static final String filePath = "/full/path/to/resources/data";
	private static final String userDbFileName = "users.json";
	private static final String exerciseDbFileName = "exercises.json";
	public static ExerciseList exerciseDB = new ExerciseList(filePath + exerciseDbFileName);
	public static UserList userDB = new UserList(filePath + userDbFileName);
	
	/**
	 * Retrieves all user info on the user responsible for the request.
	 * @param principal Object housing relevant logged in user's info from the session
	 * @return Object with the logged in user's info from the database
	 */
	@GetMapping("/user")
	public User getUser(Principal principal)
	{
		User user = userDB.getValue(principal.getName());
		if(user != null) {
			return user;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
	}
	
	/**
	 * Creates and stores a user using the specified object.
	 * @param newUser 'User' object with the new user's info
	 */
	@PostMapping("/user")
	public void postUser(@RequestBody User newUser)
	{
		userDB.addPair(newUser.getEmail(), newUser);
		serializeJson(userDB.toJson(), userDbFileName);
		throw new ResponseStatusException(HttpStatus.OK, "Usuário cadastrado");
	}

	/**
	 * Receive the modifications to be made on the user currently requesting them.
	 * @param modifiedUser Object housing modifications in user's info from the session
	 * @param principal Object housing relevant logged in user's info from the session
	 * @return Object with the logged in user's info from the database
	 */
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
	
	/**
	 * Adds an exercise to the exercise list of the user responsible for the request.
	 * @param exerciseId A string with the ID of the exercise to be added to the user's list
	 * @param principal Object housing relevant logged in user's info from the session
	 */
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
	
	/**
	 * Deletes an exercise from the exercise list of the user responsible for the request.
	 * @param exerciseId A string with the ID of the exercise to be deleted from the user's list
	 * @param principal Object housing relevant logged in user's info from the session
	 */
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
	
	/**
	 * Auxiliary function for debugging purposes.
	 */
	public static String printAll()
	{
		String ex = "";
		for(String id : userDB.getMap().keySet()) {
			System.out.println(userDB.getValue(id));
			ex = id;
		}
		return ex;
	}
	
	/**
	 * Serializes a string to a file, overwriting it.
	 * @param json JSON as string to be serialized
	 * @param fileName Filename to be completely overwritten by the string
	 */
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
