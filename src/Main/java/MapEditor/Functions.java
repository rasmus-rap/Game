package MapEditor;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {

    public void New(int width, int height) {
        try {
            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (!currentJar.getName().endsWith(".jar"))
                return;
            ArrayList<String> command = new ArrayList<>();
            command.add(javaBin);
            command.add("-jar");
            command.add("-Djava.library.path=lib/");
            command.add(currentJar.getPath());
            command.add(Integer.toString(width));
            command.add(Integer.toString(height));

            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Import() {
        try {
            String width = "", height = "";

            Scanner reader = new Scanner(new File("map.txt"));

            if (reader.hasNextLine()) {
                String[] wh = reader.nextLine().split(" ");
                width = wh[0];
                height = wh[1];
            }

            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (!currentJar.getName().endsWith(".jar"))
                return;
            ArrayList<String> command = new ArrayList<>();
            command.add(javaBin);
            command.add("-jar");
            command.add("-Djava.library.path=lib/");
            command.add(currentJar.getPath());
            command.add("-Import");
            command.add(width);
            command.add(height);

            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Export() {

    }

}