package flbaue.playground.collection.linkedlist;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 13.06.13
 * Time: 19:08
 */
class Node {

    private Node next;
    private Node previous;
    private Object data;

    Node(Node next, Node previous, Object data){
        this.next = next;
        this.previous = previous;
        this.data = data;
    }


    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    Node getPrevious() {
        return previous;
    }

    void setPrevious(Node previous) {
        this.previous = previous;
    }

    Object getData() {
        return data;
    }

    void setData(Object data) {
        this.data = data;
    }

    public String toString(){
        return data.toString();
    }
}
