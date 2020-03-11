package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Pair;
import simulator.model.Event;
import simulator.model.SetContClassEvent;

public class SetContClassEventBuilder extends Builder<Event> {

	public SetContClassEventBuilder(String type) {
		super(type);
	}

	@Override
	protected Event createTheInstance(JSONObject data) {
		int time = data.getInt("time");
		List<Pair<String, Integer>> cs = new ArrayList<>();
		JSONArray infoArray = new JSONArray(data.getJSONArray("info"));
		int c;
		String r;
		for(int i = 0; i < infoArray.length(); i++) {
			c = infoArray.getJSONObject(i).getInt("class");
			r = infoArray.getJSONObject(i).getString("vehicle");
			Pair<String, Integer> p = new Pair<String, Integer>(r, c);
			cs.add(p);
		}
		
		return new SetContClassEvent(time, cs);
	}

}
