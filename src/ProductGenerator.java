import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fields;
        ArrayList<String> items = new ArrayList<>();
        boolean over = false;
        String name, description, ID, fileName, CSV;
        double cost;


        while (!over) {
            name = SafeInput.getNonZeroLenString(sc, "Please enter the product's name (e to exit): ");
            if (name.equalsIgnoreCase("e")) {
                over = true;
            } else {
                description = SafeInput.getNonZeroLenString(sc, "Please enter the product's description: ");
                ID = SafeInput.getNonZeroLenString(sc, "Please enter the product's ID: ");
                cost = SafeInput.getDouble(sc, "Please enter the product's cost: ");

                Product p = new Product(name, description, ID, cost);
                CSV = p.toCSVDataRecord(p.getName(), p.getDescription(), p.getID(), p.getCost());

                items.add(CSV);
            }
        }

        fileName = SafeInput.getNonZeroLenString(sc, "What would you like the file to be named?: ");

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName + ".txt");

        try {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : items) {
                fields = rec.split(",");

                if (fields.length == 4) {
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
