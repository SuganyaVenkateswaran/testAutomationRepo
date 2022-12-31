package techUplabs.CommonUtil.ResponseModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "temp",
        "pressure",
        "humidity",
        "temp_min",
        "temp_max",
        "sea_level",
        "grnd_level"
})
public class Main {
    @JsonProperty("temp")
    public float temp;

    @JsonProperty("pressure")
    public float pressure;

    @JsonProperty("humidity")
    public float humidity;

    @JsonProperty("temp_min")
    public float temp_min;

    @JsonProperty("temp_max")
    public float temp_max;

    @JsonProperty("sea_level")
    public float sea_level;

    @JsonProperty("grnd_level")
    public float grnd_level;

}
