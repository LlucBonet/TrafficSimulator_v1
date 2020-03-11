package simulator.factories;


import simulator.model.Event;
import simulator.model.NewCityRoadEvent;
import simulator.model.Weather;


public class NewCityRoadEventBuilder extends NewRoadEventBuilder {

	public NewCityRoadEventBuilder(String type) {
		super(type);

	}

	@Override
	protected Event createTheRoad(int time, String id, String src, String dest, int length, int co2limit, int maxspeed,
			Weather weather) {

		return new NewCityRoadEvent(maxspeed, dest, dest, dest, maxspeed, maxspeed, maxspeed, weather);
		
	}

}
