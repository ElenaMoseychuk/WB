package Lesson3_4;

import Lesson3_4.Service.Endpoints;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import service.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SpoonacularPostApiTest extends AbstractTest {
    private static RequestSpecification requestPostSpecification;

    @BeforeAll
    static void beforePostTest() {
        requestPostSpecification = new RequestSpecBuilder()
                .addQueryParam("language", "en")
                .setContentType("application/x-www-form-urlencoded")
                .build();
        RestAssured.requestSpecification = requestPostSpecification;
    }

    public static RequestSpecification getRequestPostSpecification() {
        return requestPostSpecification;
    }

    @Test
    void postClassLanguageEnTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "Spaghetti Carbonara")
                .formParam("ingredientList", "1 lb spaghetti")
                .when()
                .post(getBaseUrl() + Endpoints.postClass)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is("Mediterranean"));
    }

    @Test
    void postClassIncludeNutritionSpaghettiTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "Curry")
                .formParam("ingredientList", "14 ounce canned unsweetened coconut milk")
                .when()
                .post(getBaseUrl() + Endpoints.postClass)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is("Indian"));
    }

    @Test
    void postClassifyCuisineMexicanTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "Salsa")
                .formParam("ingredientList", "1 cup papaya")
                .when()
               .post(getBaseUrl() + Endpoints.postClass)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is("Mexican"));
    }

    @Test
    void postClassifyCuisineVietnameseTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "Pho Bo")
                .formParam("ingredientList", "4 handfuls bean sprouts")
                .when()
                .post(getBaseUrl() + Endpoints.postClass)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is("Vietnamese"));
    }

    @Test
    void postClassifyCuisineChineseTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "fried rice")
                .formParam("ingredientList", "6 spring onions")
                .when()
                .post(getBaseUrl() + Endpoints.postClass)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is("Chinese"));
    }
}
