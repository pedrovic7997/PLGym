package plgtool;

import static org.junit.Assert.*;

import org.junit.Test;

import plgym.domain.ExerciseList;

public class AppTest
{
    ExerciseList exerciseList = new ExerciseList("/home/pedro/Documents/2021-1/PI/Trabalho/Implementação/PLGym/admin-tool/teste.json");

    @Test
    public void returnsNewId()
    {
        assertFalse( App.getNewId(exerciseList).equals("") );
    }
}
