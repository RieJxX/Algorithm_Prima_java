package MainWindow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

public class FileInput {
    private HashMap<Integer, ArrayList<Float>> matrix = new HashMap<>();
    String pathname;

    public FileInput(String pathname_input){
        pathname = pathname_input;
        //fillGraph();
    }

    private ArrayList<Float> lineToArray(String line){
        ArrayList<Float> arr = new ArrayList<>();
        String[] str_arr = line.split(" ");
        for(String s: str_arr){
            Float num = Float.valueOf(s);
            arr.add(num);
        }

        return arr;
    }

    private void fillGraph(){
        Integer i = 1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathname));
            String line = reader.readLine();
            while(line != null){
                matrix.put(i,lineToArray(line));
                i++;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public HashMap<Integer, ArrayList<Float>> getMatrix(){
        fillGraph();
        return matrix;
    }

}
