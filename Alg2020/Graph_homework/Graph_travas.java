package Algorithm.Alg2020.Graph_homework;

import java.util.ArrayList;
import java.util.Queue;

public class Graph_travas extends Graph {
    
    private Queue<Node> nodeQueue = new java.util.LinkedList<>();

    public void DfsStart(String name){
        LinkedList linkedList = findNode(name);
        if(linkedList != null){
            DFS(linkedList.head);
        }
        else{
            System.out.println("Not found");
        }
    }

    public boolean DFS(Node node){
        if(node == null){
            return false;
        }

        node.printInfo();
        node.linkedList.isVisited = true;
        Node nextNode = node.next;

        while(nextNode != null){
            if(!nextNode.linkedList.isVisited){
                DFS(nextNode.linkedList.head);
            }
            nextNode = nextNode.next;
        }

        return true;
    }

    public void BFS(LinkedList linkedList){
        ArrayList<Node> bfsNodeList = new ArrayList<>();
        bfsNodeList.add(linkedList.head);

        linkedList.isVisited = true;

        nodeQueue.offer(linkedList.head);

        int dist = 0;

        while(dist <= 10){
            Node newNode = nodeQueue.poll();
            newNode.printInfo();
            Node newNode2 = newNode.next;

            while(newNode2 != null){
                if(!newNode2.linkedList.isVisited){
                    newNode2.linkedList.isVisited = true;

                    newNode2.linkedList.distance = newNode.linkedList.distance + 1;
                    nodeQueue.offer(newNode2.linkedList.head);
                    bfsNodeList.add(newNode2);
                }

                newNode2 = newNode2.next;
            }

            dist = newNode.linkedList.distance;
        }

        // 그래프 리셋
        for(Node anArrayList : bfsNodeList){
            anArrayList.linkedList.isVisited = false;
            anArrayList.linkedList.distance = 0;
        }
    }
    
}