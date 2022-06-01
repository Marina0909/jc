package Lesson5;

import java.io.*;

public class InputOutput {
    public static void save(AppData data){
        // header
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("temp.csv"));

            for (int i = 0; i < data.getHeader().length; i++){
                out.write(data.getHeader()[i]);

                if ( i < data.getHeader().length - 1) {
                    out.write(";");
                } else out.write("\n");
            }
            //data
            for (int i = 0; i < data.getData().length; i++){
                for (int j = 0; j < data.getData()[i].length; j++){
                    out.write(String.valueOf(data.getData()[i][j]));

                    if ( j < data.getData()[i].length - 1) {
                        out.write(";");
                    } else out.write("\n");
                }
            }
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args)  {
        String[] header = {"Value1","Value2","Value3","Value4"};
        int data[][] = {{101, 102, 103, 104},{201, 202, 203, 204}, {301, 302, 303, 304}};
        AppData dataA = new AppData(header, data);

        save(dataA);

        try (BufferedReader in = new BufferedReader(new FileReader("temp.csv"))) {
            String csv;
            while ((csv = in.readLine()) != null) {
                System.out.println(csv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
