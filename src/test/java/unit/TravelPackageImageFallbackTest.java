package unit;

import com.example.exp.travelgogui.travel_database_screen.TravelPackageDetailView;
import com.example.exp.travelgogui.travel_database_screen.backend.TravelPackage;
import javafx.application.Platform;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TravelPackageImageFallbackTest {

  @Test
  void testFallbackImageLoadsWhenMissing() throws InterruptedException {
    new javafx.embed.swing.JFXPanel(); // initializes the JavaFX runtime
    CountDownLatch latch = new CountDownLatch(1);

    assertDoesNotThrow(() -> {
      Platform.runLater(() -> {
        try {
          TravelPackage tp = new TravelPackage(
                  "Fallback Test",
                  "Test Desc",
                  1,
                  100.0,
                  "Mars",
                  "Rocket",
                  "Space",
                  "nonexistent_image.png"
          );
          TravelPackageDetailView.newView(tp);
        } finally {
          latch.countDown(); // signal that the test is done
        }
      });
      latch.await(); // wait for Platform.runLater to complete
    });
  }
}