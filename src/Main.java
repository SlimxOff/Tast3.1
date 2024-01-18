import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    static StringBuilder log = new StringBuilder();

    public static void directoryCreation(String name) {
        File directoryName = new File(name);
        if (directoryName.mkdir()) {
            log.append("Директория создана: " + directoryName + "\n");
        } else {
            log.append("Директория не создана: " + directoryName + "\n");
        }
    }

    public static void fileCreation(String directoryPath, String name) {
        File fileCreation = new File(directoryPath + name);
        try {
            if (fileCreation.createNewFile()) {
                log.append("Файл создан: " + fileCreation + "\n");
            } else {
                log.append("Файл не создан: " + fileCreation + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FileWriter writer = null;


        List<String> listDirectories = List.of(
                "/Users/ivangoyda/Documents/Games/src/",
                "/Users/ivangoyda/Documents/Games/res",
                "/Users/ivangoyda/Documents/Games/saveGames",
                "/Users/ivangoyda/Documents/Games/src/main/",
                "/Users/ivangoyda/Documents/Games/src/test/",
                "/Users/ivangoyda/Documents/Games/temp/",
                "/Users/ivangoyda/Documents/Games/res/drawables",
                "/Users/ivangoyda/Documents/Games/res/vectors",
                "/Users/ivangoyda/Documents/Games/res/icons");
        for (String directory : listDirectories){
            directoryCreation(directory);
        }
        fileCreation("/Users/ivangoyda/Documents/Games/src/main/", "Main.java");
        fileCreation("/Users/ivangoyda/Documents/Games/src/main/", "Utils.java");
        fileCreation("/Users/ivangoyda/Documents/Games/temp/", "temp.txt");
        //Запись логов в файл
        try {
            writer = new FileWriter("/Users/ivangoyda/Documents/Games/temp/temp.txt");
            writer.write(log.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}