package com.example.exp.travelgogui.backend;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class TravelPackage {
    public String name;
    public String description;
    public int stock;
    public double price;
    //Default Constructor for Jackson do not use or make private
    public TravelPackage(){
    }
    //constructor you're supposed to use
    public TravelPackage(String name, String description, int stock, double price) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description + ", Stock: " + stock + ", Price: $" + price;
    }
}