package Algorithm.Alg2020.Graph_homework;

import java.util.Scanner;

public class Problem {
    public static void main(String[] args){
        new Problem();
    }

    Problem(){
        Command();
    }

    public void Command(){

        Graph graph = new Graph();
        Graph_travas DFS = new Graph_travas();
        Dijkstra dij = new Dijkstra();

        label:
        while(true){
            System.out.print("$ ");
            Scanner sc = new Scanner(System.in);

            String command = sc.next();

            switch(command){

                case "exit":
                    break label;
                
                case "read":
                    graph.loadGraphFile("C:\\Users\\sehunkim\\Desktop\\WorkSpace\\Algorithm-JAVA\\Algorithm\\Alg2020\\Graph_homework\\alabama.txt");
                    graph.loadRoadFile("C:\\Users\\sehunkim\\Desktop\\WorkSpace\\Algorithm-JAVA\\Algorithm\\Alg2020\\Graph_homework\\roadList2.txt");
                    DFS.loadGraphFile("C:\\Users\\sehunkim\\Desktop\\WorkSpace\\Algorithm-JAVA\\Algorithm\\Alg2020\\Graph_homework\\alabama.txt");
                    DFS.loadRoadFile("C:\\Users\\sehunkim\\Desktop\\WorkSpace\\Algorithm-JAVA\\Algorithm\\Alg2020\\Graph_homework\\roadList2.txt");
                    dij.loadGraphFile("C:\\Users\\sehunkim\\Desktop\\WorkSpace\\Algorithm-JAVA\\Algorithm\\Alg2020\\Graph_homework\\alabama.txt");
                    dij.loadRoadFile("C:\\Users\\sehunkim\\Desktop\\WorkSpace\\Algorithm-JAVA\\Algorithm\\Alg2020\\Graph_homework\\roadList2.txt");
                    System.out.println("read success");
                    break;
                
                case "dijkstra":
                    sc.nextLine();
                    System.out.print("$ name1 : ");
                    String name1 = sc.nextLine();
                    System.out.print("$ name2 : ");
                    String name2 = sc.nextLine();

                    LinkedList linkedList_d = dij.Dijkstra_Graph(name1, name2);
                    printInfo(linkedList_d);
                    break;

                case "DFS":
                    sc.nextLine();
                    System.out.print("$ name : ");
                    String name = sc.nextLine();
                    DFS.DfsStart(name);
                    break;

                case "BFS":
                    sc.nextLine();
                    System.out.print("$ name : ");
                    String target = sc.nextLine();

                    DFS.BFS(graph.findNode(target));
                    break;
            }
        }
    }

    private void printInfo(LinkedList linkedList_d){
        LinkedList temp = linkedList_d;

        while(temp != null){
            temp.head.printInfo();
            temp = temp.preLinkedList;
        }
    }
}