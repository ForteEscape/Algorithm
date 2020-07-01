package Algorithm.Alg2020.Graph_homework;

public class LinkedList {
    public Node head;
    public int size = 0;
    public boolean isVisited = false;
    public int distance = 0;
    public int distance_print = 0;
    public int idx;

    public double dist = -1;
    public LinkedList preLinkedList = null;

    public LinkedList(Node headNode, int idx){
        head = headNode;
        this.idx = idx;
        size++;
    }

    public void addNode(Node newNode){
        Node tmpNode = head.next;
        head.next = newNode;
        newNode.next = tmpNode;
        size++;
    }

    public void printInfo(){
        Node temp = head;
        while(temp != null){
            temp.printInfo();
            temp = temp.next;
        }
        System.out.println();
    }
}