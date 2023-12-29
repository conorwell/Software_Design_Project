import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class statsControllerTest {

    @Test
    void getData() {


        statsController sc = new statsController();
        ArrayList<String> e1 = new ArrayList<>(Arrays.asList("Climb","Run","Bike"));
        ArrayList<String> e2 = new ArrayList<>(Arrays.asList("Juggle","Game","Bike"));
        ArrayList<Integer> d1 = new ArrayList<>(Arrays.asList(60,180,45));
        ArrayList<Integer> d2 = new ArrayList<>(Arrays.asList(90,15,15));

        Workout w1 = new Workout("testCase3","w1",e1,d1,"comment","10/27/12");
        Workout w2 = new Workout("testCase3","w2",e2,d2,"comment","10/27/12");

        Workout_Model wm = Workout_Model.getInstance();
        wm.createWorkoutsList("testCase3");
        wm.addWorkouts(w1);
        wm.addWorkouts(w2);

        ArrayList<ArrayList<String>> data = sc.getData(wm.getWorkouts("testcase3"));
        assertEquals(data.get(2).get(0), "Run");
        assertEquals(data.get(3).get(0), "Hike");
        assertEquals(data.get(4).get(0), "Ski");
        assertEquals(data.get(5).get(0), "Climb");
        assertEquals(data.get(6).get(0), "Bike");
        assertEquals(data.get(7).get(0), "Weight Train");
        assertEquals(data.get(8).get(0), "Juggle");
        assertEquals(data.get(9).get(0), "Game");

        System.out.println(data.get(2));
        assertEquals(data.get(2).get(1),"1");
        assertEquals(data.get(3).get(1),"0");
        assertEquals(data.get(4).get(1),"0");
        assertEquals(data.get(5).get(1),"1");
        assertEquals(data.get(6).get(1),"2");
        assertEquals(data.get(7).get(1),"0");
        assertEquals(data.get(8).get(1),"1");
        assertEquals(data.get(9).get(1),"1");

        assertEquals(data.get(2).get(2),"180");
        assertEquals(data.get(3).get(2),"0");
        assertEquals(data.get(4).get(2),"0");
        assertEquals(data.get(5).get(2),"60");
        assertEquals(data.get(6).get(2),"60");
        assertEquals(data.get(7).get(2),"0");
        assertEquals(data.get(8).get(2),"90");
        assertEquals(data.get(9).get(2),"15");
    }
}