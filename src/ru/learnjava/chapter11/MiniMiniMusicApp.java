package ru.learnjava.chapter11; /**
 * Created by belakovvv on 08.07.17.
 */

import javax.sound.midi.*;

public class MiniMiniMusicApp {
    public static void main(String[] args){
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }
    public void play(){
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();
/*
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);
*/

            fillChannel(track, 1);
            fillChannel(track, 2);
            fillChannel(track, 3);
            fillChannel(track, 4);
            fillChannel(track, 5);
            fillChannel(track, 6);
            fillChannel(track, 7);

            player.setSequence(seq);

            player.start();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void fillChannel(Track track, int channel)throws InvalidMidiDataException{
        int minTickLenght = 3;
        int maxTickLenght = 10;

        for (int i = 1; i<128*maxTickLenght;){

            int note = (int)(Math.random()*127);

            track.add(new MidiEvent(new ShortMessage(192, channel, (int)(Math.random()*127), 0), i));

            track.add(new MidiEvent(new ShortMessage(144, channel, note, 100), i));
            i = i + minTickLenght + (int)(Math.random()*(maxTickLenght - minTickLenght));
            track.add(new MidiEvent(new ShortMessage(128, channel, note, 100), i));
        }
    }

}
