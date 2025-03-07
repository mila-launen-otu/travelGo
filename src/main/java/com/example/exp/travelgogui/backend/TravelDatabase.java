package com.example.exp.travelgogui.backend;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TravelDatabase {
    private static final String FILE_PATH = "travel_packages.xml";
    private XmlMapper xmlMapper;

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
        return xmlMapper.readValue(new File(FILE_PATH), TravelPackageList.class);
    }
}
