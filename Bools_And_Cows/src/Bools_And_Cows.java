

public class Bools_And_Cows {
    public static void main(String[] args) {
        Farm_Reader reader = new Farm_Reader("gamelog.txt");
        Game game = reader.get_last_game();
        game.run();

    }

}
