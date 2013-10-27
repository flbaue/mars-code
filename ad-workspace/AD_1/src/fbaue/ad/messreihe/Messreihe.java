/**
 * Messreihe.java
 * Florian Bauer
 * flbaue@posteo.de
 * 26.10.2013
 */
package fbaue.ad.messreihe;

/**
 * Messreihe
 * Interface für ein Messreihenkonstrukt.
 * 
 * @author Florian Bauer
 * 
 */
public interface Messreihe {
    /**
     * @return der mittelwert als double
     */
    double mittelwert();

    /**
     * @return die varianz als double
     */
    double varianz();

    /**
     * @param w den nächste Messwert hinzufügen.
     */
    void addWert(double w);
}
