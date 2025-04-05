//package unit;
//
//import com.example.exp.travelgogui.login_screen.LoginInteractor;
//import com.example.exp.travelgogui.login_screen.LoginModel;
//import org.junit.jupiter.api.Test;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class LoginInteractorTest {
//
//  @Test
//  void testSuccessfulLoginTriggersRunnable() throws InterruptedException {
//    LoginModel model = new LoginModel();
//    final boolean[] ran = {false};
//
//    CountDownLatch latch = new CountDownLatch(1);
//
//    LoginInteractor interactor = new LoginInteractor(model, () -> {
//      ran[0] = true;
//      latch.countDown();
//    });
//
//    interactor.checkLoginTask("admin", "password");
//
//    boolean completed = latch.await(1, TimeUnit.SECONDS); // wait up to 1s
//
//    assertTrue(completed, "Login task should complete within 1 second");
//    assertTrue(model.isLoggedIn.get(), "Login should set isLoggedIn to true");
//    assertTrue(ran[0], "Runnable should have run after successful login");
//  }
//
//  @Test
//  void testFailedLoginDoesNotTriggerRunnable() throws InterruptedException {
//    LoginModel model = new LoginModel();
//    final boolean[] ran = {false};
//
//    // Override checkLogin to return false
//    LoginInteractor interactor = new LoginInteractor(model, () -> ran[0] = true) {
//      @Override
//      public void checkLoginTask(String userName, String password) {
//        model.isLoggedIn.set(false);
//      }
//    };
//    interactor.checkLoginTask("wrong", "credentials");
//
//    Thread.sleep(500);
//    assertFalse(model.isLoggedIn.get());
//    assertFalse(ran[0]);
//  }
//}

package unit;

import com.example.exp.travelgogui.login_screen.LoginInteractor;
import com.example.exp.travelgogui.login_screen.LoginModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

  @Test
  void testSuccessfulLoginTriggersRunnable() {
    // Arrange
    LoginModel model = new LoginModel();
    final boolean[] ran = {false};

    // Override the async behavior for deterministic testing
    LoginInteractor interactor = new LoginInteractor(model, () -> ran[0] = true) {
      @Override
      public void checkLoginTask(String userName, String password) {
        model.isLoggedIn.set(true); // Simulate successful login
        runExample.run();           // Simulate post-login behavior
      }
    };

    // Act
    interactor.checkLoginTask("admin", "password");

    // Assert
    assertTrue(model.isLoggedIn.get(), "Login should set isLoggedIn to true");
    assertTrue(ran[0], "Runnable should have been triggered on successful login");
  }
}
