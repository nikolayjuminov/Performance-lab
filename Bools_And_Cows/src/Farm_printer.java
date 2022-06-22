public class Farm_printer {
    private static final String [] print_bools = {
        "Быков", "Бык", "Быка", "Быка", "Быка"
    };
    private static final String [] print_cows = {
            "Коров", "Корова", "Коровы", "Коровы", "Коровы"
    };
    public static String print(int bools, int cows){
        return String.format("%d %s %d %s", bools, print_bools[bools], cows, print_cows[cows]);
    }
}

