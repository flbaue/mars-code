package hausaufgabe8s.src.aufgabe8.listen;

/**
 * Das Interface {@link List} stellt Methoden fuer eine Liste zur Verfuegung.
 */
public interface List {

	/**
	 * Anfuegen eines Elemnts an den Listenanfang.
	 * 
	 * @param x
	 *            Das Listenelement.
	 */
	public void cons(Object x);

	/**
	 * Vorderstes Element entfernen.
	 */
	public void head();

	/**
	 * Gibt die Laenge der List zurueck.
	 * 
	 * @return Die Laenge einer Liste.
	 */
	public int length();

	/**
	 * Prueft ob die Liste leer ist.
	 * 
	 * @return Wahr wenn die Liste leer ist.
	 */
	public boolean isEmpty();

	/**
	 * Ein Element nach n Elementen einfuegen.
	 * 
	 * @param x
	 *            Das Listenelement.
	 * @param n
	 *            Anzahl der Einfuegeposition.
	 * 
	 * @return Wahr wenn einfuegen erfolgreich und n nicht groesser als
	 *         Listenlaenge oder Liste leer.
	 */
	public boolean insert(Object x, int n);
	public boolean insertRec(Object x, int n);
	
	/**
	 * Gibt die Anzahl der Referenzierungen zurueck.
	 * 
	 * @return Anzahl der Dereferenzierungen
	 */
	public int getRefcount();
	
	/**
	 * Setzt die Anzahl der Referenzierungen zurueck.
	 * 
	 */
	public void resetRefcount();
	
	/**
	 * Gebe erstes Element zurueck.
	 * 
	 * @return Erstes Element.
	 */
	public Object getFirst();
	
	/**
	 * Ueberpruefe ob Liste sortiert ist.
	 * 
	 * @return Wahr wenn Liste aufsteigend sortiert oder leer ist, Falsch wenn nicht.
	 */
	public boolean isSorted();
	
	/**
	 * Erzeugt eine Liste mit zufaelligen Elementen der leange n.
	 * 
	 * @param n
	 * 			Laenge der Liste.
	 */
	public void generateList(int n);
	
	/**
	 * Erzeugt eine Liste mit zufaelligen, monoton wachsenden Elementen der laenge n.
	 * 
	 * @param n
	 * 			Laenge der Liste.
	 */
	public void generateSortedList(int n);
	
	/**
	 * Merged diese Liste mit der uebergebenen.
	 * 
	 * @param list
	 * 				Die uebergebene Liste.
	 */
	public List merge(List list);
	
	/**
	 * Liefert das n�chste Element der Liste, ohne diese zu ver�ndern. 
	 * @return das zweite Listen Element
	 * 		
	 */
	public ListElem getNext();
	
	/**
	 * Sortiert die Liste nach dem MergeSort Algorithmus
	 * @return eine neue, sortierte Liste
	 */
	public List mergeSort();
	
}

