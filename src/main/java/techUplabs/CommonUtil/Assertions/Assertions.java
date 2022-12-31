package techUplabs.CommonUtil.Assertions;

import org.assertj.core.api.SoftAssertions;
import techUplabs.CommonUtil.ResponseModel.FailureResponse;
import techUplabs.CommonUtil.ResponseModel.WeatherAppResponse;

public class Assertions {

    public void assertValuesOnSuccess(WeatherAppResponse response, float lat, float lon, String desc, float pressure, String country, String name){
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.coord.lat).isEqualTo(lat);
        softAssertions.assertThat(response.coord.lon).isEqualTo(lon);
        softAssertions.assertThat(response.weather.get(0).description).isEqualTo(desc);
        softAssertions.assertThat(response.main.pressure).isEqualTo(pressure);
        softAssertions.assertThat(response.sys.country).isEqualTo(country);
        softAssertions.assertThat(response.name).isEqualTo(name);
        softAssertions.assertAll();

    }

    public void assertValuesOnFailure(FailureResponse response, int cod, String message){
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.cod).isEqualTo(cod);
        softAssertions.assertThat(response.message).isEqualTo(message);
        softAssertions.assertAll();

    }
}
