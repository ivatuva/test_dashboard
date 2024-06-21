import Utils.ApiManager;
import Utils.Response;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticationTest {

    ApiManager _api;

    public AuthenticationTest(){
        _api = new ApiManager();
    }

    @Test
    public void loginPositive(){
        // Arrange
        String username = "test";
        String password = "test1234";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginNegative(){
        // Arrange
        String username = "test";
        String password = "test";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(401, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginEmptyUsername(){
        // Arrange
        String username = "";
        String password = "test1234";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(400, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginEmptyPassword(){
        // Arrange
        String username = "test";
        String password = "";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(400, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginNonexistentUsername(){
        // Arrange
        String username = "nonexistent";
        String password = "test1234";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(404, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginInvalidPasswordFormat(){
        // Arrange
        String username = "test";
        String password = "short";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(400, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginSqlInjection(){
        // Arrange
        String username = "test";
        String password = "' OR '1'='1";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(401, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginSpecialCharactersUsername(){
        // Arrange
        String username = "test!@#";
        String password = "test1234";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(400, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginMaxLengthCredentials(){
        // Arrange
        String username = "a".repeat(255);
        String password = "a".repeat(255);

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginAccountLocked(){
        // Arrange
        String username = "lockedUser";
        String password = "test1234";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(403, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void loginCaseSensitiveUsername(){
        // Arrange
        String username = "Test"; // Different case
        String password = "test1234";

        // Action
        Response response = _api.login(username, password);

        // Assert
        assertEquals(401, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
