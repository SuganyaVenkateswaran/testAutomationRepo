package techUplabs.CommonUtil.ResponseModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lat",
        "lon"
})

public class Coord {

    @JsonProperty("lat")
    public float lat;

    @JsonProperty("lon")
    public float lon;

}
