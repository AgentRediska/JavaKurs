package furniture;

import Divan_pack.DivanForKids;
import Divan_pack.DivanStandart;
import Divan_pack.DivanWithLayout;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public abstract class GWriter {


    private static Gson gson= new Gson();  //для записи+
    private static String json;
    public static void GsonWriterFurniture(Furniture FurClass, File Way)  //получаем класс и путь к файлу
    {
        try{
            json=gson.toJson(FurClass); //консервация
            FileWriter fileWriter= new FileWriter(Way,true);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
            bufferedWriter.write(json+"\r\n");
            bufferedWriter.close();
        }catch (Exception e){e.printStackTrace();}}



    private static String vubor="NULL";  //в зависимости от выбора действие
    private static File file;

    public static void SetFurnitureType(String selection) { vubor=selection;}

    public static void SetParameters(String name, String size, int count, int price, String description, int depth, int fullLength) {  //принимаемые параметры для создания

        switch (vubor) {
            case "Диван Раскладной": {
                try {
                    file = new File("src/lists/DivanWithLayoutFile.json");
                    DivanWithLayout divanWithLayout = new DivanWithLayout(name, size, count, price, description, depth, fullLength);
                    GsonWriterFurniture(divanWithLayout,file);
                }catch (Exception e){e.printStackTrace();}
            }
            break;

            case "Диван Детский": {
                try {
                    file = new File("src/lists/DivanForKidsFile.json");
                    DivanForKids divanForKids= new DivanForKids(name,size,count,price,description,depth);
                    GsonWriterFurniture(divanForKids,file);
                }catch (Exception e){e.printStackTrace();}
            }
            break;

            case "Диван Стандарт": {
                try {
                    file = new File("src/lists/DivanStandartFile.json");
                    DivanStandart divanStandart= new DivanStandart(name,size,count,price,description,depth);
                    GsonWriterFurniture(divanStandart,file);
                }catch (Exception e){e.printStackTrace();}
            }
            break;
        }
    }


}
