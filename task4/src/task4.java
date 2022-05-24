import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new FileReader(args[0]));
        ArrayList<Integer> massiv = new ArrayList<>();
        while (br.ready()){
            massiv.add(Integer.parseInt(br.readLine()));

        }
        int min = Integer.MAX_VALUE;
        for (int i = Collections.min(massiv); i <=Collections.max(massiv) ; i++) {
            int sum = 0;
            for (Integer j: massiv) {
                sum += Math.abs(j-i);

            }
            min = Math.min(sum,min);
        }

        System.out.println(min);
    }
}
