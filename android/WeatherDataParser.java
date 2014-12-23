import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

	/**
	 * Given a string of the form returned by the api call:
	 * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7 
	 * retrieve the maximum temperature for the day indicated by dayIndex
	 * (Note: 0-indexed, so 0 would refer to the first day).
	 */
	public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
		throws JSONException {
		// TODO: add parsing code here
       
       JSONObject j_o_main = new JSONObject(weatherJsonStr);
       JSONArray j_a_list = j_o_main.getJSONArray("list");
        
       JSONObject jDay = j_a_list.getJSONObject(dayIndex);
       JSONObject jTemp = jDay.getJSONObject("temp");
        
        double max = jTemp.getDouble("max");
		return max;
	}

}
