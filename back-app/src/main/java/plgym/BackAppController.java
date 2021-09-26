package plgym;

import java.util.LinkedList;
import java.util.List;

import java.lang.Long;

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
import plgym.domain.UserList;

@RestController
public class BackAppController
{
//    private static final String filePath = "/home/pedro/Documents/2021-1/PI/Trabalho/Implementação/PLGym/back-app/src/main/resources/data/";
    private static final String filePath = "C:/Users/Leonardo/IdeaProjects/PLGym/back-app/src/main/resources/data/";
    public static ExerciseList exerciseDB = new ExerciseList(filePath + "exercises.json");
    public static UserList userDB = new UserList(filePath + "users.json");

    public String printAll()
    {
        String ex = "";
        for(String id : userDB.getMap().keySet()) {
            System.out.println(userDB.getValue(id));
            ex = id;
        }
        return ex;
    }

    // TODO POST para adicionar um exercício na lista de exercícios dinâmica de um usuário, seguido de serialização na mesma função

    // TODO DELETE para remover um exercício na lista de exercícios dinâmica de um usuário, seguido de serialização na mesma função

    // TODO Pensar em uma forma de não modificar json toda hora (botão de salvar na seção "My Workout" enviando a lista modificada)

    // @GetMapping("/exercises")
	// public ExerciseList getExercises(@RequestParam(name = "exer", defaultValue = "") String exer)
    // {
	// 	ExerciseList filteredExercises = new ExerciseList();
	// 	for (Exercise exercise : exerciseDB.getMap().values())
	// 	{
	// 		if (exercise.getName().contains(exer))
	// 			filteredExercises.add(exercise);
	// 	}
	// 	return filteredExercises;
	// }

	// @GetMapping("/exercises/{id}")
	// public Exercise getExercise(@PathVariable(name = "id") long id) {
	// 	if (exerciseDB.getValue(Long.toString(id)) == null)
	// 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercício não encontrado!");
	// 	else
	// 		return exerciseDB.getValue(Long.toString(id));
	// }

	// // Quando um usuário criar sua lista de exercicio existente?
	// @PutMapping("/exercises/{id}")
	// public Exercise setContato(@PathVariable(name = "id") long id, @RequestBody Exercise exercise) {
	// 	if (exerciseDB.getValue(Long.toString(id)) == null)
	// 		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercício não encontrado!");
	// 	exerciseDB.addPair(id, exercise);
	// 	c.setId(id);
	// 	agenda.put(id, c);
	// 	return c;
	// }

	// @DeleteMapping("/exercises/{id}")
	// public void deleteContato(@PathVariable(name = "id") long id) {
	// 	agenda.remove(id);
	// }

	// @PostMapping("/exercises")
	// public Contato postContato(@RequestBody Contato c) {
	// 	c.setId(nextId);
	// 	agenda.put(nextId, c);
	// 	nextId++;
	// 	return c;
	// }
}
