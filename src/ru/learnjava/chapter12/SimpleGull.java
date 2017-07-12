package ru.learnjava.chapter12; /**
 * Created by belakovvv on 09.07.17.
 */

import  javax.swing.*;

public class SimpleGull {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JButton button = new JButton("Click me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new MyDrawPanel());

        frame.setSize(300, 300);

        frame.setVisible(true);
    }
}
