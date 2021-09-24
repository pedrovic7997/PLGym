package plgym;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import plgym.domain.ExerciseList;
import plgym.domain.UserList;

@RestController
public class BackAppController
{
    public static ExerciseList exerciseDB = new ExerciseList();
    public static UserList userDB = new UserList();

}
