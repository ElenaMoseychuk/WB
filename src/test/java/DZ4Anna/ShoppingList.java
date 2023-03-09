package DZ4Anna;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;


public class ShoppingList extends AbstractClass {

    @Test
    void AddToShoppingListBakingTest() {
        given()
                .spec(getRequestSpec())
                .body("{\"item\": \"1 package baking powder\",\n" +
                        "\t\"aisle\": \"Baking\",\n" +
                        "\t\"parse\": true}")
                .log()
                .all()
                .when()
                .post("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items", username)
                .prettyPeek()
                .then()
                .spec(responseSpec);
    }

    @Test
    void AddToShoppingListGarlikTest() {
        given()
                .spec(getRequestSpec())
                .body("{\"item\": \"garlic powder\",\n" +
                        "\t\"parse\": true}")
                .log()
                .all()
                .when()
                .post("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items", username)
                .prettyPeek()
                .then()
                .spec(responseSpec);
    }

    @Test
    void AddToShoppingListYogurtTest() {
        given()
                .spec(getRequestSpec())
                .body("{\"item\": \"greek yogurt\",\n" +
                        "\t\"parse\": true}")
                .log()
                .all()
                .when()
                .post("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items", username)
                .prettyPeek()
                .then()
                .spec(responseSpec);
    }

    @Test
    void GetShoppingListTest() {
        given()
                .spec(getRequestSpec())
                .log()
                .all()
                .when()
                .get("https://api.spoonacular.com/mealplanner/{username}/shopping-list", username)
                .prettyPeek()
                .then()
                .spec(responseSpec);
    }

    @Test
    void DeleteFromShoppingListBakingTest() {
        given()
                .spec(getRequestSpec())
                .log()
                .all()
                .when()
                .delete("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items/1464811", username)
                .prettyPeek()
                .then()
                .spec(responseSpec);
    }
}
