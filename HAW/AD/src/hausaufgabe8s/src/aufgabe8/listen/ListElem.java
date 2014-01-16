package hausaufgabe8s.src.aufgabe8.listen;

public class ListElem implements Comparable<ListElem>{
	
	private Object value = null;
	private ListElem next = null;
	
	ListElem(Object value, ListElem next){
		this.value = value;
		this.next = next;
	}
	
	public static ListElem valueOf(){
		  return new ListElem(null, null);
	}
	
	public static ListElem valueOf(Object value, ListElem next){
		return new ListElem(value, next);
	}
	
	public final Object getValue() {
		return value;
	}

	public final void setValue(Object value) {
		this.value = value;
	}

	public final ListElem getNext() {
		return next;
	}

	public final void setNext(ListElem next) {
		this.next = next;
	}

	public int compareTo(ListElem elem) {
		if(this.value instanceof Number && elem.getValue() instanceof Number){
			Number tmp1 = (Number)this.value;
			Number tmp2 = (Number)elem.getValue();
			if (tmp1.doubleValue() < tmp2.doubleValue()) return -1;
			if (tmp1.doubleValue() == tmp2.doubleValue()) return 0;
			if (tmp1.doubleValue() > tmp2.doubleValue()) return 1;
		}
		return 0;
	}
	
}
