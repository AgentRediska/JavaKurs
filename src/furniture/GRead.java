package furniture;

import Divan_pack.*;
import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class GRead {    //читаем всё из вида

    public static String vubor="NULL";  //это контейнер, в который ниже мы запишем строку с выбранным типом(то, что клацнули по центру)
    private static JTextArea list;
    public static void ReadFile(String selection, JTextArea listModelFurniture) {    //это то что выбрали и сслыка на панель справа с текстом
        list=listModelFurniture;
        vubor=selection;
        switch (vubor) {             //сравниваем и в зависимости от выбора выполняем (потому что нет БД)
            case "Диван Раскладной":
            {
                ReadDivanWithLayoutFile();
            }break;

            case "Диван Детский":
            {
                ReadDivanForKidsFile();
            }break;

            case "Диван Стандарт":
            {
                ReadDivanStandartFile();
            }break;
        }
    }

    public static void ReadDivanWithLayoutFile() {
        try {
            File file = new File("src/lists/DivanWithLayoutFile.json");
            DivanWithLayout DivanWL;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            Gson gson = new Gson();  //для записи
            while ((line = bufferedReader.readLine()) != null) {              //считывалка с файла
                DivanWL = gson.fromJson(line, DivanWithLayout.class);
                list.append("\r\n");
                list.append("Тип: " + DivanWL.getType()+"\r\n");
                list.append("Название: " + DivanWL.getName()+"\r\n");
                list.append("Размеры: " + DivanWL.getSize()+"\r\n");
                list.append("Глубина: " + DivanWL.getDepth()+"\r\n");
                list.append("Длинна в разложенном положении: " + DivanWL.getFullLength()+"\r\n");
                list.append("Цена: " + DivanWL.getPrice()+"\r\n");
                list.append("Количество: " + DivanWL.getCount()+"\r\n");
                list.append("Описание: " + DivanWL.getDescription()+"\r\n");
                list.append("\r\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //два класса ниже такие как и первый
    public static void ReadDivanForKidsFile() {
        try {
            File file = new File("src/lists/DivanForKidsFile.json");
            DivanForKids DivanFK;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            Gson gson = new Gson();  //для записи
            while ((line = bufferedReader.readLine()) != null) {
                DivanFK = gson.fromJson(line, DivanForKids.class);
                list.append("\r\n");
                list.append("Тип: " + DivanFK.getType()+"\r\n");
                list.append("Название: " + DivanFK.getName()+"\r\n");
                list.append("Размеры: " + DivanFK.getSize()+"\r\n");
                list.append("Глубина: " + DivanFK.getDepth()+"\r\n");
                list.append("Цена: " + DivanFK.getPrice()+"\r\n");
                list.append("Количество: " + DivanFK.getCount()+"\r\n");
                list.append("Описание: " + DivanFK.getDescription()+"\r\n");
                list.append("\r\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ReadDivanStandartFile() {
        try {
            File file = new File("src/lists/DivanStandartFile.json");
            DivanStandart DivanSt;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            Gson gson = new Gson();  //для записи
            while ((line = bufferedReader.readLine()) != null) {
                DivanSt = gson.fromJson(line, DivanStandart.class);
                list.append("\r\n");
                list.append("Тип: " + DivanSt.getType()+"\r\n");
                list.append("Название: " + DivanSt.getName()+"\r\n");
                list.append("Размеры: " + DivanSt.getSize()+"\r\n");
                list.append("Глубина: " + DivanSt.getDepth()+"\r\n");
                list.append("Цена: " + DivanSt.getPrice()+"\r\n");
                list.append("Количество: " + DivanSt.getCount()+"\r\n");
                list.append("Описание: " + DivanSt.getDescription()+"\r\n");
                list.append("\r\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
