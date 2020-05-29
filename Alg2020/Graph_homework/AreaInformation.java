package Algorithm.Alg2020.Graph_homework;

public class AreaInformation {
    
    public double longitude;
    public double latitude;
    public String name;

    public AreaInformation(String name, double longitude, double latitude){
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }

    @Override
    public boolean equals(Object other){
        return other.equals(name);
    }
}