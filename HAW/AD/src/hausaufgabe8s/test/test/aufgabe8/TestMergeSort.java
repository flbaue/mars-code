package hausaufgabe8s.test.test.aufgabe8;


import hausaufgabe8s.src.aufgabe8.listen.List;
import hausaufgabe8s.src.aufgabe8.listen.ListImpl;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMergeSort {

	@Test
	public void isSorted() {
		System.out.println("Test: isSorted()");
		List test = ListImpl.valueOf();
		for(int i = 0; i < 10; i++){
			test.insertRec(i, test.length());
		}
		assertTrue(test.isSorted());
		
		System.out.println(test);
	}
	
	@Test
	public void generateList(){
		System.out.println("Test: generateList(int n)");
		List test = ListImpl.valueOf();
		int n = 50;
		test.generateList(n);
		assertFalse(test.isSorted());
		
		System.out.println(test);
	}
	
	@Test
	public void generateSortedList(){
		System.out.println("Test: generateSortedList(int n)");
		List test = ListImpl.valueOf();
		int n = 50;
		test.generateSortedList(n);
		assertTrue(test.isSorted());
		
		System.out.println(test);
	}
	
	@Test
	public void merge(){
		System.out.println("Test: merge(List list)");
		List test1 = null;
		List test2 = null;
		List test = null;
		Random rand = new Random();
		int n = 10;
		for(int i = 0; i < n; i++){
			test1 = ListImpl.valueOf();
			test2 = ListImpl.valueOf();
			test1.generateSortedList(rand.nextInt(n)+1);
			test2.generateSortedList(rand.nextInt(n)+1);
			test = test1.merge(test2);
			assertTrue(test.isSorted());
		}
		
		System.out.println(test);
	}
	
	@Test
	public void mergeSort(){
		System.out.println("Test: mergeSort()");
		List test = null;
		int n = 10;
		Random rand = new Random();
		for(int i = 0; i < n; i++){
			test = ListImpl.valueOf();
			test.generateList(rand.nextInt(n)+1);
			test = test.mergeSort();
			assertTrue(test.isSorted());
		}
		System.out.println(test);
	}

}
