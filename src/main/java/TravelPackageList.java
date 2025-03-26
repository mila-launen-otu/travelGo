import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;
import java.util.Properties;

@JacksonXmlRootElement(localName = "TravelPackages")
public class TravelPackageList {
  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "TravelPackage")
  private List<TravelPackage> packages;

  public TravelPackageList() {}

  public TravelPackageList(List<TravelPackage> packages) {
    this.packages = packages;
  }

  public List<TravelPackage> getPackages() {
    return packages;
  }

  public TravelPackage getPackage(int idx) {
    return packages.get(idx);
  }

  public void setPackages(List<TravelPackage> packages) {
    this.packages = packages;
  }

}

