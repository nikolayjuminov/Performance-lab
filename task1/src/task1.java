public class task1 {
    public task1() {
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]) - 1;
        int[] array = new int[n];

        int idx;
        for(idx = 0; idx < n; ++idx) {
            array[idx] = idx + 1;
        }

        idx = 0;

        do {
            System.out.print(array[idx]);
            idx = (idx + m) % n;
        } while(idx != 0);

    }
}
