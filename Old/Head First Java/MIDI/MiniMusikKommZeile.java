import javax.sound.midi.*;

public class MiniMusikKommZeile {

	public static void main(String[] args) {
	
		MiniMusikKommZeile mini = new MiniMusikKommZeile();
		if(args.length < 2) {
			System.out.println("Vergessen Sie nicht Instrument und Ton-Argument.");
		} else {
			int instrument = Integer.parseInt(args[0]);
			int ton = Integer.parseInt(args[1]);
			mini.spielen(instrument, ton);
		}
	}
	
	public void spielen(final int instrument, final int ton) {
	
		try{
		
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent instrumentWechsel = new MidiEvent(first,1);
			track.add(instrumentWechsel);
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, ton, 100);
			MidiEvent noteOn = new MidiEvent(a,1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, ton, 100);
			MidiEvent noteOff = new MidiEvent(b,16);
			track.add(noteOff);
			
			player.setSequence(seq);
			player.start();
			Thread.sleep(5000);
			player.close();
						
		} catch(Exception ex) {ex.printStackTrace();}
	}
}