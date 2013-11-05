/**
 *
 */
package hausaufgabe1.liste;

import counter.StepCounter;
import hausaufgabe1.messreihe.Messreihe;
import hausaufgabe1.messreihe.MessreiheB;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author florianbauer
 */
public class DefaultAdListTest {

    AdList<Integer> liste;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        liste = new DefaultAdList<>();
    }

    @Test
    public void consTest() {
        liste.cons(1);
        liste.cons(2);
        liste.cons(3);

        assertTrue(liste.length() == 3);
        assertTrue(liste.head() == 3);
        assertTrue(liste.head() == 2);
        assertTrue(liste.head() == 1);
    }

    @Test
    public void headTest() {
        assertTrue(liste.length() == 0);
        assertTrue(liste.head() == null);
        assertTrue(liste.length() == 0);
        liste.cons(1);
        assertTrue(liste.length() == 1);
        assertTrue(liste.head() == 1);
        assertTrue(liste.length() == 0);

    }

    @Test
    public void lengthTest() {
        assertTrue(liste.isEmpty());
        assertTrue(liste.length() == 0);
        liste.cons(1);
        assertTrue(liste.length() == 1);
        liste.insert(2, 100);
        assertTrue(liste.length() == 2);
        liste.head();
        assertTrue(liste.length() == 1);
    }

    @Test
    public void isEmptyTest() {
        assertTrue(liste.isEmpty());
        liste.cons(1);
        assertFalse(liste.isEmpty());
        liste.head();
        assertTrue(liste.isEmpty());
    }

    @Test
    public void insertTest() {
        liste.insert(1, 0);
        liste.insert(3, 2);
        liste.insert(2, 1);
        assertTrue(liste.length() == 3);
        assertTrue(liste.head() == 1);
        assertTrue(liste.head() == 2);
        assertTrue(liste.head() == 3);
        assertTrue(liste.isEmpty());
    }

    @Test
    public void getTest() {
        liste.insert(1, 0);
        liste.insert(3, 2);
        liste.insert(2, 1);
        assertTrue(liste.get(0) == 1);
        assertTrue(liste.get(1) == 2);
        assertTrue(liste.get(2) == 3);

        boolean exception = false;
        try {
            liste.get(3);
        } catch (IndexOutOfBoundsException e) {
            exception = true;
        }
        assertTrue(exception);
    }

    @Test
    public void Aufgabe6() {

        StepCounter counter = ((DefaultAdList<Integer>) liste).refCounter();

        int n = 10000;
        for (int i = 1; i <= n; i++) {
            liste.cons(i);
        }

        System.out.println("Test 6: Adding " + n
                + " elements to the head took " + counter.getSteps()
                + " steps.");
    }

    @Test
    public void Aufgabe7() {

        StepCounter counter = ((DefaultAdList<Integer>) liste).refCounter();

        int n = 10000;
        for (int i = 1; i <= n; i++) {
            liste.insert(i, i);
        }

        System.out.println("Test 7: Adding " + n + " elements to the end took "
                + counter.getSteps() + " steps.");
    }

    @Test
    public void Aufgabe8() {

        Messreihe m = new MessreiheB();

        int t = 10;
        int n = 10000;
        for (int j = 1; j <= t; j++) {

            liste = new DefaultAdList<>();
            StepCounter counter = ((DefaultAdList<Integer>) liste).refCounter();

            for (int i = 1; i <= n; i++) {
                int pos = (int) (Math.random() * i);
                liste.insert(i, pos);
            }
            m.addWert(counter.getSteps());
        }

        System.out.println("Test 8: Parameter t=" + t + " n=" + n
                + " result in an average=" + m.mittelwert() + " and variance="
                + m.varianz());
    }

}
