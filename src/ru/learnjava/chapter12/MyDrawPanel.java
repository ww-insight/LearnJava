package ru.learnjava.chapter12;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

/**
 * Created by belakovvv on 09.07.17.
 */
public class MyDrawPanel extends JPanel implements ControllerEventListener {

    boolean msg = false;

    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }

    public void paintComponent(Graphics g){
        if (msg){
            /*Graphics2D g2d = (Graphics2D) g;
            GradientPaint grdient = new GradientPaint(70, 70, new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)), 150, 150, new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
            g2d.setPaint(grdient);
*/
            g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));

            int width = 50 + (int) (Math.random() * 50);
            int height = 50 + (int) (Math.random() * 50);
            int x = 10 + (int) (Math.random() * (this.getHeight() - 20 - width));
            int y = 10 + (int) (Math.random() * (this.getWidth() - 20 - height));

            g.fillOval(x, y, width, height);
        }
        /*else {
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            Graphics2D g2d = (Graphics2D) g;
            GradientPaint grdient = new GradientPaint(70, 70, new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)), 150, 150, new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
            g2d.setPaint(grdient);
            g2d.fillOval(20, 50, 100, 100);
        }*/
    }
}
