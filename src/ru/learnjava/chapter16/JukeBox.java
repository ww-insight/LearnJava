package ru.learnjava.chapter16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by belyakovvv1 on 14.07.2017.
 */
public class JukeBox {
    ArrayList<Song> songList = new ArrayList<Song>();


    public static void main(String[] args) {
        new JukeBox().go();
    }

    public void go(){
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }

    public void getSongs(){
        try {
            File f = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String str = null;
            while ((str = reader.readLine()) != null){
                addSong(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSong(String str){
        String[] tokens = str.split("/");
        songList.add(new Song(tokens[0], tokens[1], tokens[2], tokens[3]));
    }

}
