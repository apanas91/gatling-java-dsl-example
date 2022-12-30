package gatling;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class GatlingTest extends Simulation {

    HttpProtocolBuilder httpProtocol = HttpDsl.http.baseUrl("http://localhost:8081");

    public GatlingTest() {
        this.setUp(
                Scenario.authScen.injectOpen(
                        CoreDsl.constantUsersPerSec(30).during(10)
                )
        ).protocols(httpProtocol);
    }
}
