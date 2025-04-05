package com.example.exp.travelgogui.travel_database_screen.backend;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class TravelDatabase {
    private final XmlMapper xmlMapper;
    private final String filePath;

    public TravelDatabase() {
        this("travel_packages.xml"); // default path
    }

    public TravelDatabase(String filePath) {
        this.filePath = filePath;
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void savePackages(TravelPackageList packageList) throws IOException {
        xmlMapper.writeValue(new File(filePath), packageList);
    }

    public TravelPackageList loadPackages() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new TravelPackageList();
        }
        return xmlMapper.readValue(file, TravelPackageList.class);
    }
}

