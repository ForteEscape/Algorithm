package Algorithm.Alg2020.Graph_homework;

import java.util.ArrayList;

public class Dijkstra extends Graph{
    
    private ArrayList<LinkedList> list = new ArrayList<>();

    public LinkedList Dijkstra_Graph(String name1, String name2){
        LinkedList startLinkedList = findNode(name1);
        LinkedList finishLinkedList = findNode(name2);

        if(startLinkedList == null || finishLinkedList == null){
            System.out.println("NULL");
        }

        if(startLinkedList != null && finishLinkedList != null){
            startLinkedList.dist = 0;

            list.add(startLinkedList);

            while(true){
                LinkedList min = findMinimumDistance();
                min.isVisited = true;

                if(min.head.equals(finishLinkedList.head)){
                    return finishLinkedList;
                }

                Node temp = min.head.next;

                while(temp != null){
                    if(!temp.linkedList.isVisited){
                        relaxation(temp.linkedList, temp.headLinkedList, temp.weight);
                        list.add(temp.linkedList);
                    }
                    temp = temp.next;
                }
            }
        }

        return finishLinkedList;
    }

    private LinkedList findMinimumDistance(){
        boolean flag = false;
        LinkedList min = null;

        for(LinkedList value : list){
            if(!value.isVisited && !flag){
                min = value;
                flag = true;
                continue;
            }

            if(!value.isVisited && flag && min.dist > value.dist){
                min = value;
            }
        }

        return min;
    }

    public void relaxation(LinkedList v, LinkedList u, double w){
        if(v.dist == -1 || v.dist > u.dist + w){
            v.dist = u.dist + w;
            v.preLinkedList = u;
        }
    }
}