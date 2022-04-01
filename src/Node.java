/*
Filename:       Node.java
Course:         SENG2200 - Programming Languages and Paradigms
Assignment:     1
Student Name:   Isabella Andrews
Student No.:    C3204936
Program:        Bachelor of Software Engineering (Honours)
*/

public class Node {

    private Polygon data;
    private Node next;
    private Node previous;

    // Default Constructor
    public Node(){}

    public Node(Polygon initialData) { this.data = initialData; }

    // Getter and Setter methods
    public Polygon getData() { return data; }

    public void setData(Polygon d) {
        this.data = d;
    }

    public Node getNext() { return next; }

    public void setNext(Node n) { this.next = n; }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node p) { this.previous = p; }
}
