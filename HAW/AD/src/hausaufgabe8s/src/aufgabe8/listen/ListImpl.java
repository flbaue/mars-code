package hausaufgabe8s.src.aufgabe8.listen;

import hausaufgabe8s.src.aufgabe8.listen.List;
import hausaufgabe8s.src.aufgabe8.listen.ListElem;

import java.util.Random;

public class ListImpl implements List {
	
	private ListElem nlist = ListElem.valueOf(null, null);
	private ListElem nextElem = nlist;
	private int counter = 0;
	private int refCount = 0;
		
	private ListImpl(){}
	
	public static List valueOf(){
		return new ListImpl();
	}

	@Override
	public void cons(Object x) {
		counter++;
		refCount++;
		if(nextElem == nlist){
			nextElem = ListElem.valueOf(x, null);
		}else{
		ListElem buffer = ListElem.valueOf(nextElem.getValue(), nextElem.getNext());
		nextElem = ListElem.valueOf(x, buffer);
		}
    }
	
	@Override
	public boolean insert(Object x, int n) {
		if (n < length()) {
			counter++;
			ListElem elem = nextElem;

			for (int i = 0; i < n; i++) {
				ListElem buffer = elem.getNext();
				elem = buffer;
				refCount++;
			}
			refCount++;
			
			elem.setNext(ListElem.valueOf(elem.getValue(), elem.getNext()));
			elem.setValue(x);
			return true;
		}
		return false;
	}

	@Override
	public boolean insertRec(Object x, int n){
		_insertRecursive(x, n, nextElem);
		counter++;
		return true;
	}
	
	private void _insertRecursive(Object x, int n, ListElem listElem){
		if(n == 0){
			ListElem newElem = ListElem.valueOf(listElem.getValue(), listElem.getNext());
			listElem.setValue(x);
			listElem.setNext(newElem);
		}else{
			if(listElem.getNext() == null){
				listElem.setNext(ListElem.valueOf(null,null));
			}
			_insertRecursive(x, n-1, listElem.getNext());
		}
	}
	
	@Override
	public void head() {
		nextElem = nextElem.getNext();	
		counter--;
		refCount++;
	}

	@Override
	public int length() {
		return counter;
	}

	@Override
	public boolean isEmpty() {
		return counter==0;
	}
	
	@Override
	public Object getFirst() {
		return nextElem.getValue();
	}
	
	@Override
	public int getRefcount() {
		return refCount;
	}

	@Override
	public void resetRefcount() {
		refCount = 0;
	}
/*
	public static void main(String[] args) {
		long startTime = 0;
		long stopTime = 0;
		List list = ListImpl.valueOf();
		
		
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			list.cons(i);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Zeit ben�tigt: " + ((stopTime - startTime)) + " Millisekunden f�r: " + list.length() + " Elemente.");
		
		list = ListImpl.valueOf();
		list.cons(0);
		startTime = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			list.insert(i,i);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Zeit ben�tigt: " + ((stopTime - startTime)) + " Millisekunden f�r: " + list.length() + " Elemente.");
	}
*/
	@Override
	public boolean isSorted() {
		if(this.isEmpty()) return true;
		else{
			int tmpcount = this.counter;
			ListElem currentElem = this.nextElem;
			ListElem nextElem = this.nextElem.getNext();
			while(tmpcount > 1){
				if(currentElem.getValue() instanceof Number && nextElem.getValue() instanceof Number){
					if(currentElem.compareTo(nextElem) > 0) return false;
					else{
						currentElem = ListElem.valueOf(nextElem.getValue(), null);
						nextElem = nextElem.getNext();
					}
				}
				tmpcount--;
			}
			return true;
		}
	}
	
	@Override
	public String toString(){
		String result = "[";
		int tmpnum = this.counter;
		if(this.counter > 0)
			result+=this.nextElem.getValue().toString();
		ListElem buffer = this.nextElem;
		tmpnum--;
		while(tmpnum > 0){
			buffer = buffer.getNext();
			result+=",";
			result+=buffer.getValue().toString();
			tmpnum--;
		}
		result+="]";
		return result;
	}

	@Override
	public void generateList(int n) {
		Random rand = new Random();		
		int randnum = rand.nextInt(n*100);	
		this.cons(randnum);
		for(int i = 1; i < n; i++){
			randnum = rand.nextInt(n*100);
			this.cons(randnum);		
		}
	}
	
	@Override
	public void generateSortedList(int n) {
		Random rand = new Random();		
		int randnum = rand.nextInt(n*100);
		while(randnum < n-this.counter)
			randnum = rand.nextInt(n*100);
	
		this.cons(randnum);
		for(int i = 1; i < n; i++){
			Number num = (Number) this.nextElem.getValue();
			randnum = rand.nextInt(n*100);
			while(randnum < n-this.counter || randnum > num.intValue() )
				randnum = rand.nextInt(n*100);
			this.cons(randnum);		
		}
	}
	
	@Override public List merge(List list){
		List merged = this.valueOf();
		while(!this.isEmpty() || !list.isEmpty()){
			Number elem1 = null;
			Number elem2 = null; 
			if(!this.isEmpty()){
				elem1 = (Number)this.getFirst();
			}
			if(!list.isEmpty()){
				elem2 = (Number)list.getFirst();
			}
			if(elem1 != null && elem2 != null){
				if(elem1.doubleValue() < elem2.doubleValue()){
					merged.insertRec(elem1, merged.length());
					this.head();
				}
				else{
					merged.insertRec(elem2, merged.length());
					list.head();
				}
			}
			else if ( !this.isEmpty()){
				merged.insertRec(elem1, merged.length());
				this.head();
			}
			else {
				merged.insertRec(elem2, merged.length());
				list.head();
			}
		}
		//System.out.println(merged);
		//this.nextElem = ListElem.valueOf(merged.getFirst(),merged.getNext());
		//this.counter = merged.length();
		return merged;
	}
	
	@Override public List mergeSort(){
		
		if(this.length() <= 1) return this;
		else{
			List list1 = this.valueOf();
			List list2 = this.valueOf();
			int tmp = this.counter/2;
			for(int i = 0; i < tmp; i++){
				list1.insertRec(this.getFirst(), list1.length());
				this.head();
			}
			while(this.counter > 0){
				list2.insertRec(this.getFirst(), list2.length());
				this.head();
			}
			list1 = list1.mergeSort();
			list2 = list2.mergeSort();
			return list1.merge(list2);	
		}
		
	}
	
	@Override
	public ListElem getNext(){
		return this.nextElem.getNext();
	}

}
