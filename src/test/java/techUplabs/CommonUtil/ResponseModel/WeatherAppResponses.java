package techUplabs.CommonUtil.ResponseModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import techUplabs.CommonUtil.BaseUtil.BaseClass;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message",
        "cod",
        "city_id",
        "calctime",
        "cnt",
        "list"
})
public class WeatherAppResponses {

    public static WeatherAppResponses givenRequestCreatedFrom(String resourcePath) throws Exception {
        return BaseClass.createUsingResource(resourcePath, WeatherAppResponses.class);
    }

    @JsonProperty("calctime")
    public float calctime;

    @JsonProperty("city_id")
    public int city_id;

    @JsonProperty("cnt")
    public int cnt;

    @JsonProperty("cod")
    public String cod;

    @JsonProperty("list")
    public List<WeatherAppResponse> list;

    @JsonProperty("message")
    public String message;


}
