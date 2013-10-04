package flbaue.playground;

import java.util.Iterator;
import java.util.List;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 08.07.13
 * Time: 20:28
 */
public class ContainerSchiff implements Iterable<Container> {

    List<Container> container;

    public ContainerSchiff(List<Container> c) {
        container = c;
    }

    public Iterator<Container> iterator() {
        return new Iterator<Container>();
    }


    private class Iterator<Container> implements java.util.Iterator<Container>{

        private int i = -1;

        @Override
        public boolean hasNext() {


            return i < (container.size() - 1);
        }

        @Override
        public Container next() {
            if(hasNext() == true)
                return (Container)container.get(++i);
            else
                return null;
        }

        @Override
        public void remove() {
            if(i >= 0)
                container.remove(i--);
        }
    }
}
