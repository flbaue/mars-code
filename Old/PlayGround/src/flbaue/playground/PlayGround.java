package flbaue.playground;

import flbaue.playground.collection.linkedlist.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: florianbauer
 * Date: 28.05.13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public class PlayGround {

    public static void main(String[] args) {



        String a = "a";
        String b = null;

        a.compareTo(b);

        LinkedList<String> list = new LinkedList<>();

        list.addElement("0");
        list.addElement("1");
        list.addElement("2");
        list.addElement("3");
        list.addElement("4");
        list.addElement("5");

//        System.out.println(list.getElementAtIndex(0));
//        System.out.println(list.getElementAtIndex(1));
//        System.out.println(list.getElementAtIndex(2));
//        System.out.println(list.getElementAtIndex(3));
//        System.out.println(list.getElementAtIndex(4));
//        System.out.println(list.getElementAtIndex(5));

        for(int i = 0; i < list.getSize(); i++){
            System.out.println(list.getElementAtIndex(i));
        }

        System.out.println("\n-----\n");

        list.addElementAtIndex(5, "Vor 5");
        list.addElementAtIndex(4, "Vor 4");
        list.addElementAtIndex(3, "Vor 3");
        list.addElementAtIndex(2, "Vor 2");
        list.addElementAtIndex(1, "Vor 1");
        list.addElementAtIndex(0, "Vor 0");

        for(int i = 0; i < list.getSize(); i++){
            System.out.println(list.getElementAtIndex(i));
        }

    }
}
