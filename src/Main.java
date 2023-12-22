import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder log = new StringBuilder();

    public static void directoryCreation(String name1, String name2) {
        File directoryName = new File("/Users/ivangoyda/Documents/" + name1 + "/" + name2);
        if (directoryName.mkdir()) {
            log.append("Папка " + name2 + " создана: " + directoryName + "\n");
        } else {
            log.append("Папка " + name2 + " не создана: " + directoryName + "\n");
        }
    }

    public static void fileCreation(String directoryPath, String name) {
        File fileCreation = new File(directoryPath + name);
        try {
            if (fileCreation.createNewFile()) {
                log.append("Файл " + name +  " создан: " + fileCreation + "\n");
            } else {
                log.append("Файл " + name +  " не создан: " + fileCreation + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FileWriter writer = null;

        //1
        directoryCreation("Games", "src");
        directoryCreation("Games", "res");
        directoryCreation("Games", "savegames");
        directoryCreation("Games", "temp");
        //2
        directoryCreation("Games/src", "main");
        directoryCreation("Games/src", "test");
        //3
        fileCreation("/Users/ivangoyda/Documents/Games/src/main/", "Main.java");
        fileCreation("/Users/ivangoyda/Documents/Games/src/main/", "Utils.java");
        //4
        directoryCreation("Games/res", "drawables");
        directoryCreation("Games/res", "vectors");
        directoryCreation("Games/res", "icons");
        //5
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