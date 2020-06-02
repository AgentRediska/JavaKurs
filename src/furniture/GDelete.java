package furniture;

import javax.swing.*;
import java.io.*;
import java.util.HashSet;

public abstract class GDelete {
    private static File file;
    private static String vubor="NULL";
    private static HashSet<String> ReadAndWrite= new HashSet<String>();   //временный контейнер для перезаписи


    public static void SetWeyForDelete(String selection) { vubor=selection;}  //в зависимости от выбора

    public static void DeleteOneFurniture(JTextField NameFurniture){   //считали имя введенной модели
        String Name= NameFurniture.getText();
        switch (vubor) {
            case "Диван Раскладной": {
                try {
                    file = new File("src/lists/DivanWithLayoutFile.json");   //сначала прочли, и пропустили строку, где встретили имя
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        if (!line.contains('"' + Name + '"')) {
                            ReadAndWrite.add(line);
                        }
                    }
                    bufferedReader.close();

                    FileWriter fileWriter = new FileWriter(file);               //записали без нее
                    BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
                    for(String str : ReadAndWrite) {
                        bufferedWriter.write(str+"\r\n");
                    }

                    ReadAndWrite.clear();
                    bufferedWriter.close();
                }catch (Exception e){e.printStackTrace();}
            }
            break;

            //аналогично
            case "Диван Детский": {
                try {
                    file = new File("src/lists/DivanForKidsFile.json");
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        if (!line.contains('"' + Name + '"')) {
                            ReadAndWrite.add(line);
                        }
                    }
                    bufferedReader.close();

                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
                    for(String str : ReadAndWrite) {
                        bufferedWriter.write(str+"\r\n");
                    }
                    ReadAndWrite.clear();
                    bufferedWriter.close();
                }catch (Exception e){e.printStackTrace();}
            }
            break;

            case "Диван Стандарт": {
                try {
                    file = new File("src/lists/DivanStandartFile.json");
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        if (!line.contains('"' + Name + '"')) {
                            ReadAndWrite.add(line);
                        }
                    }
                    bufferedReader.close();

                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
                    for(String str : ReadAndWrite) {
                        bufferedWriter.write(str+"\r\n");
                    }
                    ReadAndWrite.clear();
                    bufferedWriter.close();
                }catch (Exception e){e.printStackTrace();}
            }
            break;
        }
    }
}

