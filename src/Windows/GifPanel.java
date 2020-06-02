package Windows;
import javax.swing.*;
import java.awt.*;

public class GifPanel extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0, this.getWidth(),this.getHeight());
        Graphics2D g2d = (Graphics2D) g;
        Image myPic = new ImageIcon("src/lists/Paw.gif").getImage();
        g.drawImage(myPic, 0, 0, this);
    }
}
