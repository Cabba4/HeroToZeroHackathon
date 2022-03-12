package com.example.myroute;

public class listObject {
    private int id;
    private String name;
    private String description;
    private int weight;


    public listObject(int pId, String pName, String pDescription, int pWeight ){
        this.id = pId;
        this.name = pName;
        this.description = pDescription;
        this.weight = pWeight;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
