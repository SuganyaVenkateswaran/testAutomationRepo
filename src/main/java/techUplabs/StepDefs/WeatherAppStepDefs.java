package techUplabs.StepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import techUplabs.CommonUtil.Assertions.Assertions;
import techUplabs.CommonUtil.BaseUtil.APICall;
import techUplabs.CommonUtil.BaseUtil.BaseClass;
import techUplabs.CommonUtil.ResponseModel.FailureResponse;
import techUplabs.CommonUtil.ResponseModel.WeatherAppResponse;

import static io.restassured.RestAssured.given;

public class WeatherAppStepDefs {

    String queryParams;
    WeatherAppResponse weatherAppResponse;
    FailureResponse failureResponse;
    private BaseClass base;

    public WeatherAppStepDefs(BaseClass base) {
        this.base = base;
    }
    @Given("^Configure RestAssured$")
    public void configure_RestAssured() throws Throwable {
        base.configureRestAssuredFromTestConfiguration();
    }

    @Given("^Query params are q \"([^\"]*)\" and appId \"([^\"]*)\"$")
    public void queryParamsAreQAndAppId(String location, String appID) throws Throwable {
        queryParams = "?q=" + location + "&appid=" + appID;
    }

    @When("^GET WeatherApp API call is made and assert statusCode (\\d+)$")
    public void getWeatherAppAPICallIsMadeAndAssertStatusCode(int statusCode) {
        weatherAppResponse = given().log().all()
                .get(APICall.WeatherAppDetail()+queryParams).then().log().all()
                .statusCode(statusCode).extract().as(WeatherAppResponse.class);
    }

    @Then("^Validate the response lat \"([^\"]*)\", lon \"([^\"]*)\", description \"([^\"]*)\", pressure \"([^\"]*)\", country \"([^\"]*)\" and name \"([^\"]*)\"$")
    public void validateTheResponseLatLonDescriptionPressureCountryAndName(String lat, String lon, String desc, String pressure, String country, String name) throws Throwable {
        Assertions assertions = new Assertions();
        assertions.assertValuesOnSuccess(weatherAppResponse, new Float(lat), new Float(lon), desc, new Float(pressure), country, name);
    }

    @Given("^Query params are q \"([^\"]*)\", q \"([^\"]*)\" and appId \"([^\"]*)\"$")
    public void queryParamsAreQQAndAppId(String location1, String location2, String appId) throws Throwable {
        queryParams = "?q=" + location1 + "," + location2 + "&appid=" + appId;
    }

    @Given("^Query params are id (\\d+) and appId \"([^\"]*)\"$")
    public void queryParamsAreIdAndAppId(int id, String appId) throws Throwable {
        queryParams = "?id=" + id + "&appid=" + appId;
    }

    @Given("^Query params are lat (\\d+), lon (\\d+) and appId \"([^\"]*)\"$")
    public void queryParamsAreLatLonAndAppId(int lat, int lon, String appId) throws Throwable {
        queryParams = "?lat=" + lat + "&lon=" + lon +  "&appid=" + appId;
    }

    @Given("^Query params are zip \"([^\"]*)\", zip \"([^\"]*)\" and app$")
    public void queryParamsAreZipZipAndApp(String zip1, String zip2) throws Throwable {
        queryParams = "?zip=" + zip1 + "," + zip2 + "&ap";
    }

    @When("^GET WeatherApp API call is made and assert error statusCode (\\d+)$")
    public void getWeatherAppAPICallIsMadeAndAssertErrorStatusCode(int statusCode) {
        failureResponse = given().log().all()
                .get(APICall.WeatherAppDetail()+queryParams).then().log().all()
                .statusCode(statusCode).extract().as(FailureResponse.class);
    }

    @Then("^Validate the error response cod (\\d+) and message \"([^\"]*)\"$")
    public void validateTheErrorResponseCodAndMessage(int cod, String message) throws Throwable {
        Assertions assertions = new Assertions();
        assertions.assertValuesOnFailure(failureResponse, cod, message);
    }
}
