package Lesson3_4;

import Lesson3_4.Service.Endpoints;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import service.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class SpoonacularGetApiTest extends AbstractTest {
    private static ResponseSpecification responseGetSpecification;

    @BeforeAll
    static void beforeGetTest() {
        responseGetSpecification = new ResponseSpecBuilder()
                .expectBody("totalResults", notNullValue())
                .expectBody("results[0]", hasKey("id"))
                .expectBody("results[0]", hasKey("title"))
                .build();
        RestAssured.responseSpecification = responseGetSpecification;
    }

    public static ResponseSpecification getResponseGetSpecification() {
        return responseGetSpecification;
    }

    @Test
    void getSearchCuisineTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("pasta", "italian")
                .when()
                .get(getBaseUrl() + Endpoints.getSearch)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchExcludeCuisineTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("salad", "greek")
                .when()
                .get(getBaseUrl() + Endpoints.getSearch)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }
    @Test
    void getSearchDietTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("vegan", false)
                .queryParam("Gluten Free", true)
                .when()
                .get(getBaseUrl() + Endpoints.getSearch)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchIntolerancesTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("Breakfast", "Egg")
                .when()
                .get(getBaseUrl() + Endpoints.getSearch)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchEquipmentTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("Breakfast", "pan")
                .when()
                .get(getBaseUrl() + Endpoints.getSearch)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }
}
