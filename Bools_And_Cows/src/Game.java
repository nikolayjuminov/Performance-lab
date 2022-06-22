import java.util.Scanner;

public class Game {
    public final Number_Array numbersobject;
    public final int game_number;
    private int attemptcnt;

    public Game(int game_number){
        this.numbersobject = new Number_Array();
        this.game_number = game_number;
        this.attemptcnt = 0;
    }
    public Game(int game_number, String lastnumbers, int lastgameattemptcnt){
        this.numbersobject = new Number_Array(lastnumbers);
        this.game_number = game_number;
        this.attemptcnt = lastgameattemptcnt;
    }

    public void run(){
        Farm_Logger logger = new Farm_Logger("gamelog.txt");
        logger.log_game(this);
        String result = "";
        while (!result.startsWith("4")) {
            Scanner scanner = new Scanner(System.in);
            String attempt = scanner.next();

            try {
                Number_Array attempt_player = new Number_Array(attempt);
                result = this.numbersobject.compare(attempt_player);
                logger.log_attempt(attempt_player, result);
                this.attemptcnt++;
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
                continue;
            }

            System.out.println(result);
        }
        logger.log_win(this.attemptcnt);
    }

}
