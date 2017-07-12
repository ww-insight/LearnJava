package ru.learnjava.chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by belakovvv on 09.07.17.
 */
public class SimpleAnimation {
    JFrame frame;
    MyInnerPanel panel;
    private int x = 0;
    private int y = 0;

    private int xI = 10;
    private int yI = 10;

    private int ovalWidth = 100;
    private int ovalHeight = 100;

    public static void main(String[] args){
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton goButton = new JButton("Go go go!");
        goButton.addActionListener(new SimpleAnimation.GoListener());

        panel = new SimpleAnimation.MyInnerPanel();

        frame.getContentPane().add(BorderLayout.SOUTH,goButton);
        frame.getContentPane().add(BorderLayout.CENTER,panel);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class GoListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            x = x + xI;
            y = y + yI;

            if (x + ovalWidth >= panel.getWidth()) {xI = xI * (-1); x = panel.getWidth() - ovalWidth;}
            if (x <= 0) xI = xI * (-1);

            if (y + ovalHeight >= panel.getHeight()) {yI = yI * (-1); y = panel.getHeight() - ovalHeight;}
            if (y <= 0) yI = yI * (-1);

            frame.repaint();
        }
    }

    class MyInnerPanel extends JPanel {
        public void paintComponent(Graphics g){
            g.fillRect(0,0, this.getWidth(), this.getHeight());

            Graphics2D g2d = (Graphics2D) g;
            GradientPaint grdient = new GradientPaint(70, 70, new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)), 150, 150, new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
            g2d.setPaint(grdient);
            g.fillOval(x,y,ovalWidth,ovalHeight);
        }
    }

}
