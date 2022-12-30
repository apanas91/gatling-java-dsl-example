package gatling;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.http.HttpDsl;

import static io.gatling.javaapi.core.CoreDsl.StringBody;

public class Steps {

    public static ChainBuilder authReq = CoreDsl.exec(
            HttpDsl.http("authentication")
                    .post("/api/v1/authenticate")
                    .header("Content-Type", "application/json")
                    .body(StringBody("{ \"username\": \"admin\" , \"password\": \"admin\"}"))
                    .check(HttpDsl.status().is(200))
    );
}
