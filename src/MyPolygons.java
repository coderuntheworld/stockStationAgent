/*
Filename:       MyPolygons.java
Course:         SENG2200 - Programming Languages and Paradigms
Assignment:     1
Student Name:   Isabella Andrews
Student No.:    C3204936
Program:        Bachelor of Software Engineering (Honours)
*/

public class MyPolygons {

    private final Node sentinel;
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
        getHead();

        Node tempNode = new Node(data);
        tempNode.setNext(current);
        tempNode.setPrevious(sentinel);

        current.setPrevious(tempNode);
        sentinel.setNext(tempNode);

        // Set current to head
        getHead();
        size++;
    }

    public void append(Polygon data) {
        // Set current to head
        getHead();

        Node tempNode = new Node(data);
        tempNode.setNext(sentinel);
        tempNode.setPrevious(sentinel.getPrevious());
        sentinel.getPrevious().setNext(tempNode);
        sentinel.setPrevious(tempNode);

        // Set current to head
        getHead();
        size++;
    }

    public void insert(Polygon data) {
        Node tempNode = new Node(data);
        tempNode.setNext(current);
        tempNode.setPrevious(current.getPrevious());
        tempNode.getPrevious().setNext(tempNode);
        tempNode.getNext().setPrevious(tempNode);
        size++;
    }

    public Polygon next() {
        current = current.getNext();
        return current.getData();
    }

    public void reset() {
        current = sentinel;
    }

    public Polygon remove(){
        // Set current to head
        getHead();
        if (size > 0){
            Polygon tempPolygon = current.getData();
            current.getNext().setPrevious(sentinel);
            sentinel.setNext(current.getNext());
            current.setNext(null);
            current.setPrevious(null);
            getHead();
            size--;
            return tempPolygon;

        }
        // Return null when list is empty
        return null;
    }

    public void insertInOrder(Polygon data) {
        // Set current to head
        getHead();
        int currSize = this.getSize();

        if(size == 0){
            this.prepend(data);
        }
        else
        {
            for(int i = 0; i < currSize; i++){
                if(data.ComesBefore(current.getData())){
                    insert(data);
                    return;
                }
                current = current.getNext();
            }
            this.append(data);
        }
    }

    private void getHead() {
        current = sentinel.getNext();
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        getHead();
        String myPolyToString = "";
        do{
            myPolyToString += current.getData() + "\n";
            next();
        }while(current.getData() != null);
        return myPolyToString;
    }

}