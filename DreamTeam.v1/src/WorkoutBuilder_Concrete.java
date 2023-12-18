import java.util.ArrayList;

public class WorkoutBuilder_Concrete extends WorkoutBuilder{

    @Override
    Workout workoutBuilder(String user, String name, ArrayList<String> exer, ArrayList<String> dur, String com, String date) {
        ArrayList<Integer> durArr = new ArrayList<Integer>();
        for(String s : dur){
            int temp = Integer.parseInt(s);
            durArr.add(temp);
        }
        Workout w = new Workout(user, name, exer, durArr, com, date);
        return w;
    }
}
