import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {
    private String hamletData;
    private Pattern pattern;
    private Matcher matcher;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String changeHamlet(String changeTo){
        String result = hamletData.replaceAll("(?i)Hamlet", changeTo);
        return result;

    }

    public String changeHoratio(String changeTo){
        String result = hamletData.replaceAll("(?i)Horatio", changeTo);
        return result;

    }

    public Integer countHamlet(String toCheck){
        pattern = Pattern.compile("(?i)Hamlet");
        matcher = pattern.matcher(toCheck);
        Integer counter = 0;
        while(matcher.find()){
            counter++;
        }
        return counter;
    }

    public Integer countHortatio(String toCheck){
        pattern = Pattern.compile("(?i)Horatio");
        matcher = pattern.matcher(toCheck);
        Integer counter = 0;
        while(matcher.find()){
            counter++;
        }
        return counter;

    }

}
