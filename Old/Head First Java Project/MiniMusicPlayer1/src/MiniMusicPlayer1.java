/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 13.08.13
 * Time: 18:51
 */
import javax.sound.midi.*;

public class MiniMusicPlayer1 {

    public static void main(String[] args){

        try{

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            for(int i = 5; i < 61; i += 4){
                track.add(createEvent(144,1,i,100,i));
                track.add(createEvent(128,1,i,100,i+2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
            Thread.sleep(5000);
            sequencer.close();

        } catch (Exception ex) {

        }
    }

    public static MidiEvent createEvent(int comd, int chan, int one, int two, int tick){

        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception ex){

        }
        return event;
    }

}
