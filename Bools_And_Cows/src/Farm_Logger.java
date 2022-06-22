import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Farm_Logger {
    private String filename;

    public Farm_Logger(String filename) {
        this.filename = filename;
    }
    private void log(String message){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename, true));
            bw.write(message);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void log_game (Game game) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm").
                withZone(ZoneId.systemDefault());

        String message = String.format("Game №%d %s загаданная строка %s",
                game.game_number, formatter.format(Instant.now()),game.numbersobject.toString());
        this.log(message);
    }
    public void log_attempt (Number_Array attempt, String result){
        String message = String.format("  Запрос: %s, Ответ: %s", attempt.toString(), result);
        this.log(message);
    }
    public void log_win (int attempt_cnt) {
        String message = String.format("  Строка была угадана за %d попыток", attempt_cnt);
        this.log(message);
    }
}
