package simulator.control;

import java.io.InputStream;
import java.io.OutputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Event;
import simulator.model.TrafficSimulator;

public class Controller {

	private TrafficSimulator _trafficSimulator;
	private Factory<Event> _eventsFactory;
	
	public Controller(TrafficSimulator sim, Factory<Event> eventFactory) {
		
	}

	public void loadEvents(InputStream in) {
		JSONObject jo = new JSONObject(new JSONTokener(in));
		JSONArray events = jo.getJSONArray("events");
		
		for(int i = 0; i < events.length(); i++) {
			_trafficSimulator.addEvent(_eventsFactory.createInstance(events.getJSONObject(i)));
		}
	}
	
	public void run(int n, OutputStream out) {
		
	}
	
	public void reset() {
		_trafficSimulator.reset();
	}
}
