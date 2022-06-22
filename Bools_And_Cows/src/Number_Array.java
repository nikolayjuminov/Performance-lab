import java.util.Random;

public class Number_Array {
    public int[] getNumbers() {
        return numbers;
    }

    private final int [] numbers;
    private boolean is_Number_in_Numbers(int number){
        for (int n:this.numbers) {
            if (n == number)
                return true;
        }
        return false;
    }

    private int getindex(int number){
        for (int i = 0; i < 4; i++) {
            if (this.numbers [i] == number)

                return i;
        }
        return -1;
    }
    private int generate_number(){
        int toret = 0;
        do {
            toret = new Random().nextInt(10);
        } while (is_Number_in_Numbers(toret));
        return toret;
    }
    public Number_Array(){
        this.numbers = new int[4];
        for (int i = 0; i < 4; i++) {
            this.numbers [i] = generate_number();
        }
    }
    public Number_Array(String attempt){
        if (!attempt.matches("\\d{4}")) {
            throw new RuntimeException("Не верный формат строки");
        }
        this.numbers = new int[4];
        for (int i = 0; i < 4; i++) {
            String aChar = attempt.substring(i, i+1);
            this.numbers[i] = Integer.parseInt(aChar);
        }
    }
    public String toString(){
        String toret = "";
        for (int i = 0; i < 4; i++) {
            toret += String.valueOf(this.numbers [i]);
        }
        return toret;
    }
    public String compare(Number_Array attempt){
        int bools=0;
        int cows=0;
        for (int i = 0; i < 4; i++) {
            int elment = attempt.getNumbers()[i];
            if (is_Number_in_Numbers(elment)){
                if (getindex(elment) == i) {
                    bools++;
                } else cows++;
            }
        }

        return Farm_printer.print(bools, cows);
    }
}
