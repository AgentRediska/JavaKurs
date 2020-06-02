package Windows;

import furniture.GDelete; //Берем из пакета окна для удаления, записи, чтения
import furniture.GRead;
import furniture.GWriter;

import javax.swing.*; //для графики
import javax.swing.event.ListSelectionEvent; //слушатели событий
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class BuildGui {
    JFrame theFrame;   //главный фрейм
    JPanel mainPanel; //главная панель
    JTextArea listModelFurniture;   //список конкретного вида мебели
    JPanel textInfo;  //размещены все виды мебели
    JScrollPane TypeList;  //для пролистывания

    public void buildGUI() {
        theFrame = new JFrame("Склад Мебели");  //создали окно
        String iconPath = "src/lists/house.png";  //иконка
        ImageIcon imgicon = new ImageIcon(iconPath);
        theFrame.setIconImage(imgicon.getImage());
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //возможность закрытия


        mainPanel = new JPanel(new FlowLayout()); //панель для кнопок
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setPreferredSize(new Dimension(200, 50));
        // mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //размещение кнопок на панели

        JButton DeleteF = new JButton("Удалить мебель");  //кнопка
        DeleteF.addActionListener(new BtnDeleteFur());   //и переход в класс
        mainPanel.add(DeleteF);

        JButton ReadO = new JButton("Добавить новую мебель"); //кнопка
        ReadO.addActionListener(new BtnWriteNewFurniture());//и переход в класс
        mainPanel.add(ReadO);

        JButton Instruction = new JButton("Инструкция"); //инструкция
        Font fontText = new Font("SEGOE PRINT",Font.BOLD,11);
        Instruction.setFont(fontText);
        Instruction.setBackground(Color.WHITE);
        Instruction.addActionListener(new BtnInstruction()); //и переход в класс
        mainPanel.add(BorderLayout.SOUTH, Instruction);

        //для вывода списка конкретного типа
        listModelFurniture = new JTextArea(20,50);  //сюда кидаем список конкретной мебели
        // listModelFurniture.setFont(new Font("CAMBRIAT",Font.BOLD,13));
        TypeList= new JScrollPane(listModelFurniture);
        listModelFurniture.setLineWrap(true);

        TypeList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        TypeList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //для вывода списка конкретного типа

        textInfo = new JPanel(new FlowLayout());    //панель на которую выводится список
        textInfo.setLayout(new BoxLayout(textInfo, BoxLayout.Y_AXIS));
        textInfo.setPreferredSize(new Dimension(260, 50));
        JLabel Its= new JLabel("Список мебели");
        Its.setFont(new Font("SEGOE PRINT",Font.BOLD,17));
        textInfo.add(Its);
        textInfo.add(TypeList); //добавили панель
        textInfo.setBackground(Color.WHITE); //цвет

        //Список КЛЮЧЕВАЯ ЧАСТЬ ПРОГРАММЫ
        String[] Kategories ={"Диван Детский","Диван Раскладной","Диван Стандарт"};    //сюда ЗАПИСЫВАЕМ НОВЫЙ ВИД МЕБЕЛИ, он появится по центру
        JList list = new JList(Kategories);

        list.addListSelectionListener(new ListSelectionListener() {   //ВЫБРАЛИ ОДНО ИЗ СПИСКА
            @Override //переопределяем
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (!listSelectionEvent.getValueIsAdjusting())     //если это то, что мы выбрали
                {String selection = list.getSelectedValue().toString();
                    listModelFurniture.setText(""); //очищаем список с информацией каждый раз, когда выбрали другую категорию
                    GRead.ReadFile(selection,listModelFurniture); //передали выбранный вид в метод для чтения
                    GWriter.SetFurnitureType(selection);   //скидываем свой выбор в методы для дальнейшего определения типа мебели и записи новой модели
                    GDelete.SetWeyForDelete(selection); //скинули ссылку для удаления
                }
            }
        });

        JScrollPane scrollerList=new JScrollPane(list);  //всю часть что выше добавляем в панель скроллера
        scrollerList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        list.setVisibleRowCount(7);
        list.setFont(new Font("SEGOE PRINT",Font.BOLD,17));
        list.setPreferredSize(new Dimension(300, 500));

        JPanel ListCategories = new JPanel(new FlowLayout());  //всю часть что выше добавляем в панель
        ListCategories.setBackground(Color.WHITE);
        ListCategories.setPreferredSize(new Dimension(200, 50));
        // ListCategories.setBackground(Color.blue); //цвет
        JLabel Textinfo= new JLabel("Выберите тип мебели");
        Textinfo.setFont(new Font("SEGOE PRINT",Font.BOLD,17));
        ListCategories.add(Textinfo);
        ListCategories.add(scrollerList);
        //Список

        //GIFKA пусть будет
        JFrame GifFrame = new JFrame("Kitty");  //создали
        GifPanel gifPanel= new GifPanel();
        GifFrame.getContentPane().add(BorderLayout.CENTER, gifPanel);
        GifFrame.setBounds(1100, 250, 280, 500); //размер и позиция окна
        //GifFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //возможность закрытия
        GifFrame.setVisible(true);
        gifPanel.repaint();
        //GIFKA

        //Визуализация вкл
        theFrame.add(BorderLayout.CENTER, ListCategories); //добавили панель на окно
        theFrame.add(BorderLayout.WEST, mainPanel); //добавили панель на окно
        theFrame.add(BorderLayout.EAST, textInfo); //добавили панель на окно
        theFrame.setBounds(250, 100, 850, 450); //размер и позиция окна
        theFrame.setVisible(true);
        //Визуализация вкл
    }

}

