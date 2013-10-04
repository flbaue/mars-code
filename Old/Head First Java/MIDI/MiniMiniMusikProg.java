import javax.sound.midi.*;

public class MiniMiniMusikProg {

	public static void main(String[] args) {
	
		MiniMiniMusikProg mini = new MiniMiniMusikProg();
		mini.spielen();
	}
	
	public void spielen() {
		
		try {
		
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 35, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 35, 100);
			MidiEvent noteOff = new MidiEvent(b, 20);
			track.add(noteOff);
			
			a = new ShortMessage();
			a.setMessage(144, 9, 35, 100);
			noteOn = new MidiEvent(a, 15);
			track.add(noteOn);			
			b = new ShortMessage();
			b.setMessage(128, 9, 35, 100);
			noteOff = new MidiEvent(b, 30);
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			Thread.sleep(10000);
			player.close();
			
		} catch(Exception ex) {
		
			ex.printStackTrace();
		}
	}
}