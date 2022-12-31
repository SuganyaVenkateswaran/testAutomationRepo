package techUplabs.StepDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import techUplabs.CommonUtil.BaseUtil.BaseClass;
import techUplabs.CommonUtil.ResponseModel.WeatherAppResponses;

public class ParseJsonFilesStepDefs {
    private BaseClass base;

    public ParseJsonFilesStepDefs(BaseClass base) {
        this.base = base;
    }
    WeatherAppResponses weatherAppResponses;

    @When("^Read JSON file from resources and Map JSON to POJO objects$")
    public void read_JSON_file_from_resources_and_Map_JSON_to_POJO_objects() throws Throwable {
        weatherAppResponses = WeatherAppResponses.givenRequestCreatedFrom("/JSONFiles/WeatherAppResponse.json");
        base.log.info("@@@@" + System.getProperty("user.dir"));
    }

    @Then("^Parse the response fields$")
    public void parse_the_response_fields() throws Throwable {
        base.log.info("CalcTime is " + weatherAppResponses.calctime);
        base.log.info("Weather Description is " +weatherAppResponses.list.get(0).weather.get(0).description);
        base.log.info("City ID is " +weatherAppResponses.city_id);
    }


}
