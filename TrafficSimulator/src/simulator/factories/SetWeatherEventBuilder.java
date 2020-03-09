package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Pair;
import simulator.model.Event;
import simulator.model.SetWeatherEvent;
import simulator.model.Weather;

public class SetWeatherEventBuilder extends Builder<Event> {

	SetWeatherEventBuilder(String type) {
		super(type);
	}

	@Override
	protected Event createTheInstance(JSONObject data) {
		int time = data.getInt("time");
		List<Pair<String, Weather>> ws = new ArrayList<>();
		JSONArray infoArray = new JSONArray(data.getJSONArray("info"));
		String w;
		for(int i = 0; i < infoArray.length(); i++) {
			w = infoArray.getJSONObject(i).getString("weather").toUpperCase();
			Weather weather = Weather.valueOf(w);
			String r = infoArray.getJSONObject(i).getString("road");
			Pair<String, Weather> p = new Pair<String, Weather>(r, weather);
			ws.add(p);
		}
		
		return new SetWeatherEvent(time, ws);
	}

}
