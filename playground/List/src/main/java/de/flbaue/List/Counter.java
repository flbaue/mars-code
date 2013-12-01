package de.flbaue.list;

/**
 * User: flbaue
 * Date: 27.11.13
 * Time: 10:00
 */
public class Counter {

    private long ticks = 0;

    public void tick(){
        ticks++;
    }

    public long ticks(){
        return ticks;
    }
}
