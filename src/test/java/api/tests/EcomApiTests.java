package api.tests;
import io.restassured.path.json.JsonPath;


import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


/**
 * Created by OLEX on 18.02.2018.
 */
public class EcomApiTests {

    @Test
    public void findCount() {
        JsonPath responseJson = given()
                .when()
                .get("https://swapi.co/api/people")
                .then()
                .extract().response().jsonPath();

        List<HashMap> persons = responseJson.getList("results");



        assertThat(responseJson.get("count"), is(87));
        assertThat(personFromPlanetIsPresent(persons, "Luke Skywalker", "Tatooine"));
        assertThat(persons.get(0).get("name"), is("Luke Skywalker"));
        assertThat(persons.get(1).get("name"), is("C-3PO"));
        assertThat(persons.get(2).get("name"), is("R2-D2"));
    }



    private boolean personFromPlanetIsPresent(List<HashMap> persons, String personName, String planet) {
        return persons
                .stream()
                .filter((p) -> (p.get("name").equals(personName)) && (getPlanetName(p.get("homeworld")).equals(planet)))
                .findFirst().isPresent();
    }

    private String getPlanetName(Object url) {

        return given()
                .when()
                .get(url.toString())
                .then()
                .extract().response().jsonPath().getString("name");
    }

}
