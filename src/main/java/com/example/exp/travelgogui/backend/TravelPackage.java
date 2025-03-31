package com.example.exp.travelgogui.backend;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "TravelPackage")
public class TravelPackage {
    private String name;
    private String description;
    private int stock;
    private double price;
    private String location;
    private String travelType;
    private String continent;
    private String imageUrl;

    // Constructors
    public TravelPackage() {}

    public TravelPackage(String name, String description, int stock, double price,String location,String travelType,
                         String continent, String imageUrl) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.location = location;
        this.travelType = travelType;
        this.continent = continent;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and Setter for travelType
    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    // Getter and Setter for continent
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

}