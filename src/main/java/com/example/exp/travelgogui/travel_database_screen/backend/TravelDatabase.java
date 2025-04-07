package com.example.exp.travelgogui.travel_database_screen.backend;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class TravelDatabase {
    private final XmlMapper xmlMapper;
    private final String filePath;

    /**
     * Default constructor that initializes the TravelDatabase with the default file path.
     */
    public TravelDatabase() {
        this("travel_packages.xml"); // default path
    }

    /**
     * Constructor that initializes the TravelDatabase with the specified file path.
     *
     * @param filePath The file path where the travel packages will be saved and loaded from.
     */
    public TravelDatabase(String filePath) {
        this.filePath = filePath;
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Method to save the list of travel packages to the XML file.
     *
     * @param packageList The list of travel packages to be saved.
     * @throws IOException If an I/O error occurs during saving.
     */
    public void savePackages(TravelPackageList packageList) throws IOException {
        xmlMapper.writeValue(new File(filePath), packageList);
    }

    /**
     * Method to load the list of travel packages from the XML file.
     *
     * @return The list of travel packages loaded from the file.
     * @throws IOException If an I/O error occurs during loading.
     */
    public TravelPackageList loadPackages() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new TravelPackageList();
        }
        return xmlMapper.readValue(file, TravelPackageList.class);
    }
}