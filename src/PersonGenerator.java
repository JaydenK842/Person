import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        String[] fields;
        boolean over = false;
        int YOB;
        Scanner sc = new Scanner(System.in);
        String FName, LName, ID, Title, fileName, CSV;

        while (!over) {
            FName = SafeInput.getNonZeroLenString(sc, "Please enter the person's first name (e to exit): ");
            if (FName.equalsIgnoreCase("e")) {
                over = true;
            } else {
                LName = SafeInput.getNonZeroLenString(sc, "Please enter the person's last name: ");
                ID = SafeInput.getNonZeroLenString(sc, "Please enter the person's ID: ");
                Title = SafeInput.getNonZeroLenString(sc, "Please enter the person's title: ");
                YOB = SafeInput.getInt(sc, "Please enter the person's Year of birth: ");

                Person p = new Person(FName, LName, ID, Title, YOB);
                CSV = p.toCSVDataRecord(p.getFirstname(), p.getLastName(), p.getID(), p.getTitle(), p.getYOB());

                data.add(CSV);
            }
        }

        fileName = SafeInput.getNonZeroLenString(sc, "What will be the name of the file?: ");

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName + ".txt");

        try {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : data) {
                fields = rec.split(",");

                if (fields.length == 5) {
                    writer.write(rec, 0, rec.length());
                    writer.newLine();
                }

            }

            writer.close();
            System.out.println("Your file has been wrote!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}