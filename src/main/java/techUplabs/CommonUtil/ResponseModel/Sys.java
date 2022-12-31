package techUplabs.CommonUtil.ResponseModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "id",
        "message",
        "country",
        "sunrise",
        "sunset"
})

public class Sys {
    @JsonProperty("type")
    public int type;

    @JsonProperty("id")
    public int id;

    @JsonProperty("message")
    public float message;

    @JsonProperty("country")
    public String country;

    @JsonProperty("sunrise")
    public String sunrise;

    @JsonProperty("sunset")
    public String sunset;
}
