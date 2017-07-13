package ru.learnjava.chapter15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by belyakovvv1 on 13.07.2017.
 */
public class DailyAdviceClient {
    public void go(){
        try {
            Socket s = new Socket("127.0.0.1", 4242);

            InputStreamReader  streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Today`s advice: " + advice);

            reader.close();

        }
        catch (Exception e)
        {e.printStackTrace();}
    }

    public static void main(String[] args) {
        DailyAdviceClient d = new DailyAdviceClient();
        d.go();
    }
}
