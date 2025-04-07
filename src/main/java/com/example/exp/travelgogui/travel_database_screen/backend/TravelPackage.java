package com.example.exp.travelgogui.travel_database_screen.backend;

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

    // Default constructor
    public TravelPackage() {}

    /**
     * Constructor to initialize the TravelPackage with the given parameters.
     *
     * @param name The name of the travel package.
     * @param description The description of the travel package.
     * @param stock The stock quantity of the travel package.
     * @param price The price of the travel package.
     * @param location The location of the travel package.
     * @param travelType The type of travel (e.g., adventure, leisure).
     * @param continent The continent where the travel package is located.
     * @param imageUrl The URL of the image representing the travel package.
     */
    public TravelPackage(String name, String description, int stock, double price, String location, String travelType,
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

    /**
     * Gets the name of the travel package.
     *
     * @return The name of the travel package.
     */
    public String getName() { return name; }

    /**
     * Sets the name of the travel package.
     *
     * @param name The name to set.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the description of the travel package.
     *
     * @return The description of the travel package.
     */
    public String getDescription() { return description; }

    /**
     * Sets the description of the travel package.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets the stock quantity of the travel package.
     *
     * @return The stock quantity of the travel package.
     */
    public int getStock() { return stock; }

    /**
     * Sets the stock quantity of the travel package.
     *
     * @param stock The stock quantity to set.
     */
    public void setStock(int stock) { this.stock = stock; }

    /**
     * Gets the price of the travel package.
     *
     * @return The price of the travel package.
     */
    public double getPrice() { return price; }

    /**
     * Sets the price of the travel package.
     *
     * @param price The price to set.
     */
    public void setPrice(double price) { this.price = price; }

    /**
     * Gets the location of the travel package.
     *
     * @return The location of the travel package.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the travel package.
     *
     * @param location The location to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the type of travel.
     *
     * @return The type of travel.
     */
    public String getTravelType() {
        return travelType;
    }

    /**
     * Sets the type of travel.
     *
     * @param travelType The type of travel to set.
     */
    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    /**
     * Gets the continent where the travel package is located.
     *
     * @return The continent where the travel package is located.
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets the continent where the travel package is located.
     *
     * @param continent The continent to set.
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets the URL of the image representing the travel package.
     *
     * @return The URL of the image representing the travel package.
     */
    public String getImageUrl() { return imageUrl; }

    /**
     * Sets the URL of the image representing the travel package.
     *
     * @param imageUrl The URL to set.
     */
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}