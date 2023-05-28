package api.tests;

import api.requests.CorrectRequest;
import api.requests.CorrectResponse;
import api.specifications.Specification;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

public class ClearuriTest extends BaseTest{

    @Test
    public void CleanUrl() {
        Specification.installSpecification(Specification.requestSpecification(URL));
        CorrectRequest request = new CorrectRequest(urlToClean);
        CorrectResponse successClean = given()
                .body(request)
                .when()
                .post(recoursePartOfURI)
                .then().log().all()
                .statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(ResponseSchema)))
                .extract().as(CorrectResponse.class);
        Assertions.assertTrue(successClean.getResult_url().startsWith("https://cleanuri.com/"));

    }

    @Test
    public void BrokenURL() {
        Specification.installSpecification(Specification.requestSpecification(URL));
        CorrectRequest request = new CorrectRequest(urlToClean.replace("321", "123"));
        request = new CorrectRequest(urlToClean);
        given()
                .when()
                .get(recoursePartOfURI)
                .then().log().all()
                .statusCode(405);
    }


    @Test
    public void GetSend() {
        Specification.installSpecification(Specification.requestSpecification(URL));
        CorrectRequest request = new CorrectRequest(urlToClean);
        given()
                .when()
                .get(recoursePartOfURI)
                .then().log().all()
                .statusCode(405);
    }

    @Test
    public void DeleteSend() {
        Specification.installSpecification(Specification.requestSpecification(URL));
        CorrectRequest request = new CorrectRequest(urlToClean);
        given()
                .body(request)
                .when()
                .delete(recoursePartOfURI)
                .then().log().all()
                .statusCode(405);
    }

    @Test
    public void PutSend() {
        Specification.installSpecification(Specification.requestSpecification(URL));
        CorrectRequest request = new CorrectRequest(urlToClean);
        given()
                .body(request)
                .when()
                .put(recoursePartOfURI)
                .then().log().all()
                .statusCode(405);
    }


}
