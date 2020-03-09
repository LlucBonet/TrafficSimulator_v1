package simulator.factories;

import org.json.JSONObject;

import simulator.model.Event;
import simulator.model.NewCityRoadEvent;
import simulator.model.NewInterCityRoadEvent;

public class NewCityRoadEventBuilder extends NewRoadEventBuilder {

	public NewCityRoadEventBuilder(String type) {
		super(type);

	}

	@Override
	protected Event createTheRoad() {
//		if(this._type == "new_city_road")
//			return new NewCityRoadEvent();
//		else return new NewInterCityRoadEvent();
		return null;
	}

}
