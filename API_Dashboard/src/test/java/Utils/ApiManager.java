package Utils;
import java.util.concurrent.ThreadLocalRandom;

public class ApiManager {

    public Response login(String username, String password) {
        return Response.builder()
                .statusCode(generateStatusCode())
                .body("token")
                .build();
    }

    private int generateStatusCode() {
        int [] statusCodes = new int[]{ 200, 400, 401, 403, 404 };
        return statusCodes[generateRandomInt(0, statusCodes.length-1)];
    }

    private int generateRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}

