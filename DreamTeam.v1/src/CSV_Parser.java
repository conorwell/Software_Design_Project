


    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileReader;
    import java.sql.Array;
    import java.util.ArrayList;


    public class CSV_Parser {

        public ArrayList<ArrayList<String>> readCSV(File file){

            int n = 0;
            ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
            BufferedReader read;

            try{
                read = new BufferedReader(new FileReader(file));
                String line = read.readLine();

                while(line != null){
                    ArrayList<String> lineData = new ArrayList<String>();
                    String[] words = line.split(",");
                    for(String s : words){
                        lineData.add(s);
                    }
                    data.add(lineData);
                    line = read.readLine();
                }

            }catch(Exception e){
                System.out.println("Error reading CSV");
            }
            return data;
        }

        public static void main(String[] args) {
            ArrayList<ArrayList<String>> data;
            File workouts = new File("users.csv");
            try{

                CSV_Parser read = new CSV_Parser();
                data = read.readCSV(workouts);

                for(int i = 0; i<data.size(); i++){
                    for(int j = 0; j<data.get(i).size(); j++){
                        System.out.println(data.get(i).get(j)+"");
                    }

                }

            }catch(Exception e){
                System.out.println("Error in CSV file");
            }
        }
    }

