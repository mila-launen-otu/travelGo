package unit;

import com.example.exp.travelgogui.login_screen.backend.LoginCredentials;
import com.example.exp.travelgogui.login_screen.backend.LoginCredentialsDatabase;
import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginCredentialsDatabaseTest {
  private static final String TEST_FILE = "login_credentials.xml";
  private LoginCredentialsDatabase db;

  @BeforeEach
  void setup() {
    db = new LoginCredentialsDatabase();
    new File(TEST_FILE).delete();
  }

  @Test
  void testLoadCreatesDefaultWhenFileMissing() throws IOException {
    LoginCredentials creds = db.loadLoginCredential();
    assertEquals("AdminUser", creds.getUsername());
  }

  @Test
  void testSaveAndLoadCredentials() throws IOException {
    LoginCredentials expected = new LoginCredentials("tester", "1234");
    db.saveLoginCredentials(expected);
    LoginCredentials actual = db.loadLoginCredential();
    assertEquals(expected.getUsername(), actual.getUsername());
    assertEquals(expected.getPassword(), actual.getPassword());
  }

  @AfterEach
  void tearDown() {
    new File(TEST_FILE).delete();
  }
}
