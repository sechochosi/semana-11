class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class MyQueue {
    private Node front; 
    private Node rear;  
    private int size;   

    public MyQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode; 
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode; 
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía. No se puede desencolar.");
        }
        int data = front.data;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía. No se puede hacer peek.");
        }
        return front.data;
    }

    public void printQueue() {
        Node current = front;
        System.out.print("Cola: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue(); 

        System.out.println("Elemento desencolado: " + queue.dequeue()); 
        System.out.println("Elemento del frente: " + queue.peek()); 

        queue.printQueue();
    }
}
