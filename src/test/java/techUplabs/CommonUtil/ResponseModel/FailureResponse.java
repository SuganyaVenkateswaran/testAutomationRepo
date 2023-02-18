package techUplabs.CommonUtil.ResponseModel;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cod",
        "message"
})
public class FailureResponse {
    @JsonProperty("cod")
    public int cod;

    @JsonProperty("message")
    public String message;
}
