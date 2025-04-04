package com.example.exp.travelgogui.travel_database_screen.backend;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class TravelDatabase {
    private static final String FILE_PATH = "travel_packages.xml";
    private final XmlMapper xmlMapper;

    public TravelDatabase() {
        xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); // Enable pretty-printing
    }

    // Save list of travel packages to XML
    public void savePackages(TravelPackageList packageList) throws IOException {
        xmlMapper.writeValue(new File(FILE_PATH), packageList);
    }

    // Load travel packages from XML
    public TravelPackageList loadPackages() throws IOException {
        if (!new File(FILE_PATH).exists()) {
            return new TravelPackageList();
        }
        return xmlMapper.readValue(new File(FILE_PATH), TravelPackageList.class);
    }
}
