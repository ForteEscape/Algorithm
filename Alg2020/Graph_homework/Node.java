package Algorithm.Alg2020.Graph_homework;

public class Node implements Comparable<Node>{
    public Object data;
    public Node next;
    public LinkedList linkedList = null;
    public LinkedList headLinkedList = null;
    public int idx;

    public double weight = 0;
    public double dist = -1;

    public Node(Object data){
        this.data = data;
        this.next = null;
    }

    public void setIdx(int i){
        idx = i;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setLinkedList(LinkedList linkedList){
        this.linkedList = linkedList;
    }

    public void setHeadLinkedList(LinkedList headLinkedList){
        this.headLinkedList = headLinkedList;
    }

    public void printInfo(){
        AreaInformation areaInfo = (AreaInformation)data;
        System.out.println(areaInfo.name  + " longitude : " + areaInfo.latitude + "  latitude : " + areaInfo.latitude + " index : " + idx);
    }

    public int compareTo(Node other){
        return (int)(weight-other.weight);
    }
}