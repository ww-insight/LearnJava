package ru.learnjava.chapter12;

import javax.sound.midi.*;
import javax.swing.*;

/**
 * Created by belakovvv on 09.07.17.
 */
public class MiniMusicPlayer3{

    static JFrame f = new JFrame("Мой первый музыкальный клип");
    static MyDrawPanel m1;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui(){
        m1 = new MyDrawPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(m1);
        f.setBounds(30,30,300,300);
        f.setVisible(true);
    }

    public void go() {

        setUpGui();

        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIwant = {127};
            sequencer.addControllerEventListener(m1,eventsIwant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;

            for(int i = 5; i < 60; i +=4){

                r = (int) (Math.random() * 50) + 1;

                track.add(makeEvent(144,1,r,100,i));

                track.add(makeEvent(176,1,127,0,i));

                track.add(makeEvent(128,1,r,100,i + 2));

            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) throws Exception{
        MidiEvent event = null;
        ShortMessage a = new ShortMessage();
        a.setMessage(comd, chan, one, two);
        event = new MidiEvent(a, tick);
        return event;
    }

}
