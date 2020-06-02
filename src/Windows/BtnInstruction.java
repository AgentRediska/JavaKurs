package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnInstruction  implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JFrame ShowInstruction = new JFrame("Инструкция");  //создали окно
        JTextArea textArea= new JTextArea(3,30);
        textArea.setLineWrap(true);
        textArea.setFont(new Font("SEGOE PRINT",Font.BOLD,13));
        JScrollPane scrollerList=new JScrollPane(textArea);
        scrollerList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setText("1. Выберите вид мебели из списка, который находится посередине окна.\r\n" +
                "2. После выбора в правой стороне окна появится список с единицами мебели этого вида;\r\n" +
                "3. Чтобы УДАЛИТЬ одну единицу этого вида мебели нажмите на кнопку 'Удалить мебель';\r\n"+
                "4. Чтобы ДОБАВИТЬ одну единицу этого вида мебели нажмите на кнопку 'Добавить новую мебель';\r\n"+
                "Если необходимо посмотреть список мебели, добавить её или удалить - повторите пункт 1.");
        ShowInstruction.add(BorderLayout.CENTER, scrollerList);
        ShowInstruction.setBounds(400, 460, 750, 200); //размер и позиция окна
        ShowInstruction.setVisible(true);
    }
}
