package simulator.factories;

import org.json.JSONObject;

import simulator.model.Event;
import simulator.model.NewCityRoadEvent;
import simulator.model.NewInterCityRoadEvent;
import simulator.model.Weather;

public abstract class NewRoadEventBuilder extends Builder<Event> {

	NewRoadEventBuilder(String type) {
		super(type);
	}

	@Override
	protected Event createTheInstance(JSONObject data) {
		int time = data.getInt("time");
		String id = data.getString("id");
		String src = data.getString("src");
		String dest = data.getString("dest");
		int length = data.getInt("length");
		int co2limit = data.getInt("co2limit");		
		if(data.has("maxspeed")) {
			int maxspeed = data.getInt("maxspeed");
			String w = data.getString("weather").toUpperCase();
			Weather weather = Weather.valueOf(w);
			return new NewCityRoadEvent(time, id, src, dest, length, co2limit, maxspeed, weather);
		}
		//return new NewInterCityRoadEvent(time, id, src, dest, length, co2limit);
		return null; // esto esta mal
	}
	
	
	abstract protected Event createTheRoad();

}
