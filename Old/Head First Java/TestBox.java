import java.util.Date;
import java.util.Calendar;

public class TestBox {

	Integer i;
	int j;
	
	public static final String BLUBB;
	
	static {
	
		BLUBB = "dadadadadada";
	}
	
	public static void main(String[] args) {
	
		TestBox t = new TestBox();
		t.los();
	
	}
	
	public void los() {
	
		System.out.println(Calendar.getInstance().getTimeInMillis());
	
		Date jetzt = new Date();
		
		String date = String.format("%tA, %<td. %<tB %<ty", jetzt);	
		
		System.out.println(date);
	
		//j = i;
		System.out.println(j);
		System.out.println(i);	
		
		System.out.println(Calendar.getInstance().getTimeInMillis());
	}
}