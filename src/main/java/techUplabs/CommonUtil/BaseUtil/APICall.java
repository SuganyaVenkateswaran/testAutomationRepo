package techUplabs.CommonUtil.BaseUtil;

public class APICall {

    private static final String API_VERSION = "2.5";

    public static String WeatherAppDetail() {
        return String.format("/data/%s/weather", API_VERSION);
    }
}
