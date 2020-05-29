package Algorithm.Alg2020.Graph_homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    public ArrayList<LinkedList> adjArray = new ArrayList<>();

    public LinkedList findNode(String name){
        for(LinkedList anAdjArray : adjArray){
            if(anAdjArray.head.data.equals(name)){
                return anAdjArray;
            }
        }
        return null;
    }

    public void loadGraphFile(String path){
        try{
            Scanner sc = new Scanner(new File(path));
            while(sc.hasNext()){
                String line = sc.nextLine();
                String[] splitArr = line.split("\t");

                AreaInformation areainfo = new AreaInformation(splitArr[0], Double.parseDouble(splitArr[1]), Double.parseDouble(splitArr[2]));
                Node newNode = new Node(areainfo);

                int idx = adjArray.size();
                adjArray.add(new LinkedList(newNode, idx));

                newNode.setLinkedList(adjArray.get(idx));
                newNode.setIdx(idx);
            }
        } 
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void loadRoadFile(String path){
        try{
            Scanner sc = new Scanner(new File(path));

            while(sc.hasNext()){
                String line = sc.nextLine();
                String [] splitArr = line.split("\t");

                String name1 = splitArr[0];
                String name2 = splitArr[1];

                addWeight(name1, name2);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void addWeight(String name1, String name2){
        LinkedList linkedList1 = findNode(name1);
        LinkedList linkedList2 = findNode(name2);

        if(linkedList1 == null || linkedList2 == null){
            return;
        }

        AreaInformation areainfo_name1 = (AreaInformation)linkedList1.head.data;
        AreaInformation areainfo_name2 = (AreaInformation)linkedList2.head.data;

        double weight = distance(areainfo_name1.latitude, areainfo_name1.longitude, areainfo_name2.latitude, areainfo_name2.longitude);

        Node newNode1 = new Node(areainfo_name1);
        newNode1.setWeight(weight);
        newNode1.setLinkedList(linkedList1);
        newNode1.setHeadLinkedList(linkedList2);
        newNode1.setIdx(linkedList1.idx);

        Node newNode2 = new Node(areainfo_name2);
        newNode2.setWeight(weight);
        newNode2.setLinkedList(linkedList2);
        newNode2.setHeadLinkedList(linkedList1);
        newNode2.setIdx(linkedList2.idx);

        linkedList1.addNode(newNode2);
        linkedList2.addNode(newNode1);

        return;
    }

    public double distance(double latitude1, double longitude1, double latitude2, double longitude2){
        double theta, dist;

        theta = longitude1 - longitude2;
        dist = Math.sin(degToRad(latitude1))*Math.sin(degToRad(latitude2)) + Math.cos(degToRad(latitude1)) * Math.cos(degToRad(latitude2)) * Math.cos(degToRad(theta));
        dist = Math.acos(dist);
        dist = radToDeg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1000.0;

        return dist;
    }

    private  double  degToRad(double  deg)  {
        return  (double)(deg  *  Math.PI  /  (double)180);
    }
    private  double  radToDeg(double  rad)  {
        return  (double)(rad  *  (double)180  /  Math.PI);
    }
}