package techUplabs.CommonUtil.ResponseModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coord",
        "weather",
        "base",
        "main",
        "visibility",
        "wind",
        "clouds",
        "dt",
        "sys",
        "id",
        "name",
        "cod"
})
public class WeatherAppResponse {

    @JsonProperty("coord")
    public Coord coord;

    @JsonProperty("weather")
    public List<Weather> weather;

    @JsonProperty("base")
    public String base;

    @JsonProperty("main")
    public Main main;

    @JsonProperty("visibility")
    public int visibility;

    @JsonProperty("wind")
    public Wind wind;

    @JsonProperty("clouds")
    public Clouds clouds;

    @JsonProperty("dt")
    public long dt;

    @JsonProperty("sys")
    public Sys sys;

    @JsonProperty("id")
    public int id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("cod")
    public int cod;

}
