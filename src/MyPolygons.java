/*
Filename:       MyPolygons.java
Course:         SENG2200 - Programming Languages and Paradigms
Assignment:     1
Student Name:   Isabella Andrews
Student No.:    C3204936
Program:        Bachelor of Software Engineering (Honours)
*/

public class MyPolygons {

    private Node sentinel;
    private Node current;
    private int size;

    public MyPolygons() {
        sentinel = new Node();
        current = sentinel;
        sentinel.setNext(sentinel);
        sentinel.setPrevious(sentinel);
        size = 0;
    }

    public void prepend(Polygon data){
        // Set current to head
        current = sentinel.getNext();

        Node tempNode = new Node(data);
        tempNode.setNext(current);
        tempNode.setPrevious(sentinel);

        current.setPrevious(tempNode);
        sentinel.setNext(tempNode);

        // Set current to head
        current = sentinel.getNext();

        size++;
    }

    public void append(Polygon data) {
        // Set current to head
        current = sentinel.getNext();

        Node tempNode = new Node(data);
        tempNode.setNext(sentinel);
        tempNode.setPrevious(sentinel.getPrevious());

        sentinel.getPrevious().setNext(tempNode);
        sentinel.setPrevious(tempNode);

        // Set current to head
        current = sentinel.getNext();

        size++;
    }

    public void insert(Polygon data) {
    }

    public Polygon next() {
        return current.getData();
    }

    public void reset(Polygon data) {
        // Set current to head
        current = sentinel.getNext();

        if (current == sentinel){
            prepend(data);
        } else {
            do {
                if (current.getNext() == sentinel){
                    next();
                    append(data);
                    return;
                }
                next();
            } while (data.ComesBefore(current.getData()));
        }
        insert(data);
    }

    public void remove(Polygon data) {
    }

    public int getSize(){
        return size;
    }

}
