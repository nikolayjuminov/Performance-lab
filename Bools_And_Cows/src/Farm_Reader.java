import java.io.*;

import org.apache.commons.io.input.ReversedLinesFileReader;
public class Farm_Reader {
    private String filename;

    public Farm_Reader(String filename) {
        this.filename = filename;
    }

    public Game get_last_game() {
        String line = "";
        boolean isgameover = false;
        int i = 0;
        int lastgame = 0;
        String lastnumbers = "";
        try {
            ReversedLinesFileReader reader = new ReversedLinesFileReader(new File(this.filename));
            while ((line = reader.readLine()) != null){
                if (line.startsWith("  Строка")) {
                    isgameover = true;
                } else if (line.startsWith("  Запрос")){
                    i++;
                } else if (line.startsWith("Game №")){
                    lastgame = Integer.parseInt(line.substring(6,line.indexOf(" ",6)));
                    lastnumbers = line.substring(line.length()-4);
                    return isgameover?new Game (lastgame+1):new Game (lastgame, lastnumbers, i);
                }

            }

        } catch (FileNotFoundException e) {
            return new Game (lastgame+1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Game (lastgame+1);
    }
}
