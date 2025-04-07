package com.example.exp.travelgogui.travel_database_screen.backend;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "TravelPackages")
public class TravelPackageList {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "TravelPackage")
    private List<TravelPackage> packages = new ArrayList<>();

    /**
     * Default constructor for TravelPackageList.
     * Initializes an empty list of travel packages.
     */
    public TravelPackageList() {}

    /**
     * Constructor to initialize the TravelPackageList with a given list of packages.
     *
     * @param packages The list of travel packages to initialize with.
     */
    public TravelPackageList(List<TravelPackage> packages) {
        this.packages = packages;
    }

    /**
     * Gets the list of travel packages.
     *
     * @return The list of travel packages.
     */
    public List<TravelPackage> getPackages() {
        return packages;
    }

    /**
     * Sets the list of travel packages.
     *
     * @param packages The list of travel packages to set.
     */
    public void setPackages(List<TravelPackage> packages) {
        this.packages = packages;
    }
}