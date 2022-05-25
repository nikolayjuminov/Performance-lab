import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new FileReader(args[0]));
        String [] koordinat = br.readLine().split(" ");
        float x0 = Float.parseFloat(koordinat[0]);
        float y0 = Float.parseFloat(koordinat[1]);
        float radius = Float.parseFloat(br.readLine());
        br.close();
        br = new BufferedReader (new FileReader(args[1]));
        while (br.ready()){
            String [] koordinat1 = br.readLine().split(" ");
            float x1 = Float.parseFloat(koordinat1[0]);
            float y1 = Float.parseFloat(koordinat1[1]);
            float radius1 = (x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0);
            if (radius1 < (radius*radius)){
                System.out.println("1");
            } else if (radius1 > (radius*radius)) {
                System.out.println("2");
            } else System.out.println("0");
        }
        br.close();
    }
}
