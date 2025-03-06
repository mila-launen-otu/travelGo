import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class TravelPackageManager {
  private static final String FILE_PATH = "travel_packages.xml";
  private XmlMapper xmlMapper;

  public TravelPackageManager() {
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