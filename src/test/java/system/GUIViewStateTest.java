package system;

import com.example.exp.travelgogui.main.MainModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GUIViewStateTest {
  @Test
  void testGuestLoginTogglesViews() {
    MainModel model = new MainModel();
    assertTrue(model.LoginSelectedSelectedProperty().get());
    assertFalse(model.DatabaseSelectedSelectedProperty().get());

    model.LoginSelectedSelectedProperty().set(false);
    model.DatabaseSelectedSelectedProperty().set(true);

    assertFalse(model.LoginSelectedSelectedProperty().get());
    assertTrue(model.DatabaseSelectedSelectedProperty().get());
  }
}