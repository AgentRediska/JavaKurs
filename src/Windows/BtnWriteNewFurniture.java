package Windows;

import furniture.GWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnWriteNewFurniture implements ActionListener {
    private JFrame ShowMaterial;
    private JTextField NameNewMaterial;   //Параметры, которые вводим и на основании их будет создана мебель
    private JTextField SizeNewMaterial;
    private JTextField CountNewMaterial;
    private JTextField PriceNewMaterial;
    private JTextField DescriptionNewMaterial;
    private JTextField DepthNewMaterial;
    private JTextField FullLengthNewMaterial;

    public void actionPerformed(ActionEvent e) {
        ShowMaterial = new JFrame("Добавить новую модель");  //создали окно

        JPanel TypeFurniture = new JPanel(); //панель с типамы материалов
        TypeFurniture.setLayout(new BoxLayout(TypeFurniture, BoxLayout.Y_AXIS)); //размещение кнопок на панели
        //ShowMaterial.add(BorderLayout.CENTER, TypeFurniture); //добавили панель на окно

        JScrollPane scrollerList=new JScrollPane(TypeFurniture);     //пролистывание
        scrollerList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        TypeFurniture.setPreferredSize(new Dimension(300, 300));
        ShowMaterial.add(BorderLayout.CENTER, scrollerList); //добавили панель на окно


        JPanel MainButtons = new JPanel();   //Назад или выдать список
        MainButtons.setBackground(Color.GRAY); //цвет
        ShowMaterial.add(BorderLayout.SOUTH, MainButtons); //добавили панель на окно

        JLabel inf= new JLabel("(Подсказка: Изменяйте лишь необходимые поля)");
        Font fontText = new Font("SEGOE PRINT",Font.BOLD,10);
        inf.setFont(fontText);
        TypeFurniture.add(inf); //добавили панель

        JLabel name= new JLabel("Модель мебели:");
        TypeFurniture.add(name); //добавили панель
        NameNewMaterial = new JTextField(13);
        NameNewMaterial.setText("null");
        TypeFurniture.add(NameNewMaterial); //добавили панель

        JLabel size= new JLabel("Размер(длинна/ширина/высота)(см.):");
        TypeFurniture.add(size); //добавили панель
        SizeNewMaterial = new JTextField(13);
        SizeNewMaterial.setText("0x0x0");
        TypeFurniture.add(SizeNewMaterial); //добавили панель

        JLabel count= new JLabel("Количество(шт.):");
        TypeFurniture.add(count); //добавили панель
        CountNewMaterial = new JTextField(13);
        CountNewMaterial.setText("0");
        TypeFurniture.add(CountNewMaterial); //добавили панель

        JLabel price= new JLabel("Цена(руб.):");
        TypeFurniture.add(price); //добавили панель
        PriceNewMaterial = new JTextField(13);
        PriceNewMaterial.setText("0");
        TypeFurniture.add(PriceNewMaterial); //добавили панель

        JLabel description= new JLabel("Описание товара:");
        TypeFurniture.add(description); //добавили панель
        DescriptionNewMaterial = new JTextField(13);
        DescriptionNewMaterial.setText("null");
        TypeFurniture.add(DescriptionNewMaterial); //добавили панель

        JLabel depth= new JLabel("Глубина посадки(см.):");
        TypeFurniture.add(depth); //добавили панель
        DepthNewMaterial = new JTextField(13);
        DepthNewMaterial.setText("0");
        TypeFurniture.add(DepthNewMaterial); //добавили панель

        JLabel fullLength= new JLabel("Длинна в разложенном виде(см.):");
        TypeFurniture.add(fullLength); //добавили панель
        FullLengthNewMaterial = new JTextField(13);
        FullLengthNewMaterial.setText("0");
        TypeFurniture.add(FullLengthNewMaterial); //добавили панель


        JButton Ok = new JButton("OK");
        Ok.addActionListener(new ForPanelReadMatOK());
        MainButtons.add(BorderLayout.WEST, Ok);

        JButton Back = new JButton("BACK");
        Back.addActionListener(new ForPanelReadMatBACK());
        MainButtons.add(BorderLayout.EAST, Back);

        ShowMaterial.setBounds(30, 200, 400, 400); //размер и позиция окна
        ShowMaterial.setVisible(true);
    }


    public class ForPanelReadMatBACK implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Закрываю окно");
            ShowMaterial.setVisible(false);
        }
    }

    public class ForPanelReadMatOK implements ActionListener  {  //если нажали ок, считыааем введенные данные
        public void actionPerformed(ActionEvent e) {

            String nameNewF=NameNewMaterial.getText();

            String sizeNewF=SizeNewMaterial.getText();

            int countNewF=Integer.parseInt(CountNewMaterial.getText());

            int  priceNewF=Integer.parseInt(PriceNewMaterial.getText());

            String descriptionNewF=DescriptionNewMaterial.getText();

            int depthNewF=Integer.parseInt(DepthNewMaterial.getText());

            int fullLengthNewF=Integer.parseInt(FullLengthNewMaterial.getText());


            GWriter.SetParameters(nameNewF,sizeNewF,countNewF,
                    priceNewF,descriptionNewF,depthNewF,fullLengthNewF);     //и передаем эти параметры в класс для записи

            ShowMaterial.setVisible(false);
        }
    }
}
