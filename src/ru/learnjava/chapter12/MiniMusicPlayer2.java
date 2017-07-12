package ru.learnjava.chapter12;

import javax.sound.midi.*;

/**
 * Created by belakovvv on 09.07.17.
 */
public class MiniMusicPlayer2 implements ControllerEventListener{

    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void go() {
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIwant = {127};
            sequencer.addControllerEventListener(this,eventsIwant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for(int i = 5; i < 60; i +=4){
                track.add(makeEvent(144,1,i,100,i));

                track.add(makeEvent(176,1,127,0,i));

                track.add(makeEvent(128,1,i,100,i + 2));

            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void controlChange(ShortMessage event) {
        System.out.println("ля");
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) throws Exception{
        MidiEvent event = null;
        ShortMessage a = new ShortMessage();
        a.setMessage(comd, chan, one, two);
        event = new MidiEvent(a, tick);
        return event;
    }

}
