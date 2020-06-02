package Windows;

import furniture.GDelete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnDeleteFur implements ActionListener {   //класс удаление
    private JFrame ShowMaterial;
    private JTextField NameFurniture;
    public void actionPerformed(ActionEvent e) {  //слушатель кнопки
        ShowMaterial = new JFrame("Выбор типа мебели");  //создали окно для удаления

        JPanel TypeFurniture = new JPanel(); //панель с типамы материалов
        TypeFurniture.setLayout(new BoxLayout(TypeFurniture, BoxLayout.Y_AXIS)); //размещение кнопок на панели
        ShowMaterial.add(BorderLayout.CENTER, TypeFurniture); //добавили панель на окно

        JLabel inputName= new JLabel("Введите название мебели");
        inputName.setFont(new Font("SEGOE PRINT",Font.BOLD,12));
        ShowMaterial.add(BorderLayout.NORTH, inputName);

        JPanel MainButtons = new JPanel();   //Назад или выдать список
        MainButtons.setBackground(Color.GRAY); //цвет
        ShowMaterial.add(BorderLayout.SOUTH, MainButtons); //добавили панель на окно


        NameFurniture = new JTextField(13);  //сюда впишем название модели, чтобы удалить
        TypeFurniture.add(NameFurniture); //добавили в панель

        JButton Ok = new JButton("OK");
        Ok.addActionListener(new ForPanelReadMatOK());
        MainButtons.add(BorderLayout.WEST,Ok);

        JButton Back = new JButton("BACK");
        Back.addActionListener(new ForPanelReadMatBACK());
        MainButtons.add(BorderLayout.EAST,Back);

        ShowMaterial.setVisible(true);
        ShowMaterial.setBounds(20, 200, 300, 150); //размер и позиция окна
    }



    public class ForPanelReadMatBACK implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Закрываю окно");
            ShowMaterial.setVisible(false);
        }
    }

    public class ForPanelReadMatOK implements ActionListener {   //если нажали ок
        public void actionPerformed(ActionEvent e) {
            GDelete.DeleteOneFurniture(NameFurniture); //переходим в класс для удаления и передаем туда то, что ввели
            //System.out.println("OK. I'm Delete you this material");
            // System.out.println("Вывел, закрыл окно");
            ShowMaterial.setVisible(false);
        }
    }


}



