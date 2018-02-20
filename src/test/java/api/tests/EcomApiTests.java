package api.tests;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertTrue;


public class EcomApiTests {

    @Epic("API Tests")
    @Test(description = "Check people's names and them planet")
    public void eComTestApi() {
        JsonPath responseJson = getPersons();
        List<HashMap> persons = responseJson.getList("results");

        assertThat(responseJson.get("count"), is(87));
        assertTrue(personFromPlanetIsPresent(persons, "Luke Skywalker", "Tatooine"));
        assertThat(persons.get(0).get("name"), is("Luke Skywalker"));
        assertThat(persons.get(1).get("name"), is("C-3PO"));
        assertThat(persons.get(2).get("name"), is("R2-D2"));
    }

    @Step("Get list of persons")
    private JsonPath getPersons() {
        return given()
                .when()
                .get("https://swapi.co/api/people")
                .then()
                .statusCode(200)
                .contentType(JSON)
                .extract().response().jsonPath();
    }

    @Step("Check  {personName} from planet {planet} is present")
    private boolean personFromPlanetIsPresent(List<HashMap> persons, String personName, String planet) {
        return persons
                .stream()
                .filter((p) -> (p.get("name").equals(personName)) && (getPlanetName(p.get("homeworld")).equals(planet)))
                .findFirst().isPresent();
    }

    @Step("Resolve planet name by url")
    private String getPlanetName(Object url) {
        return given()
                .when()
                .get(url.toString())
                .then()
                .statusCode(200)
                .contentType(JSON)
                .extract().response().jsonPath().getString("name");
    }
}