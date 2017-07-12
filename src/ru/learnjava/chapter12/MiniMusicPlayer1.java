package ru.learnjava.chapter12;

import javax.sound.midi.*;

/**
 * Created by belakovvv on 09.07.17.
 */
public class MiniMusicPlayer1 {
    public static void main(String[] args) {
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            for(int i = 5; i < 61; i +=4){
                track.add(makeEvent(144,1,i,100,i));
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

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) throws Exception{
        MidiEvent event = null;
        ShortMessage a = new ShortMessage();
        a.setMessage(comd, chan, one, two);
        event = new MidiEvent(a, tick);
        return event;
    }

}
