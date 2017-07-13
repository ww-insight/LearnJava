package ru.learnjava.chapter15;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by belyakovvv1 on 13.07.2017.
 */
public class DailyAdviceServer {
    String[] adviceList = {"Ешьте меньшими порциями", "Купите облегающие джинсы. Нет, они не делают вас полнее." , "Два слова: не годится",
            "Будьте честны, хотя бы сегодня.", "Возможно, вам стоит подобрать другую прическу."};

    public void go(){
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true){
                Socket socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();

                writer.println(advice);
                writer.close();

                System.out.println(advice);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getAdvice(){
        return adviceList[(int) (Math.random() * adviceList.length)];
    }

    public static void main(String[] args) {
        DailyAdviceServer srv = new DailyAdviceServer();
        srv.go();
    }

}
