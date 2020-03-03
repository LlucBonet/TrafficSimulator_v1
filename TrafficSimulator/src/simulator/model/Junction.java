package simulator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class Junction extends SimulatedObject {

	private List<Road> _inRoad; //lista de todas las carreteras q entran al cruce. El cruce es su destino
	private Map<Junction,Road> _outRoad;
	private List<List<Vehicle>> _queues;
	private Map<Road,List<Vehicle>> _queueByRoad;
	private int _greenLightIndex;
	private int _lastSwitchingTime;
	private LightSwitchStrategy _lss;
	private DequeuingStrategy _dqs;
	private int _xCoor, _yCoor;
	
	public Junction(String id, LightSwitchStrategy lsStrategy, DequeuingStrategy dqStrategy, 
			int xCoor, int yCoor){
		super(id);

		if(lsStrategy == null) throw new IllegalArgumentException(
				 "Invalid value for the light switching strategy of junction " + _id);
		else _lss = lsStrategy;
		
		if(dqStrategy == null) throw new IllegalArgumentException("Invalid value for the dequeuing strategy of junction" + _id);
		else _dqs = dqStrategy;
		
		if(xCoor < 0 || yCoor < 0) throw new IllegalArgumentException("Invalid value for the coordinates of junction" + _id); 
		
		_greenLightIndex = -1;
		_lastSwitchingTime = 0;
		_inRoad = new ArrayList<>();
		_queues = new ArrayList<>();
		_outRoad = new HashMap<>();
		_queueByRoad = new HashMap<>();
	}

	
	
	void addIncomingRoad(Road r) {
		if(!this.equals(r.getDest())) throw new IllegalArgumentException("addIncomingRoad to junction "+ _id + "...");
		
		List<Vehicle> q = new LinkedList<Vehicle>();
		_inRoad.add(r);
		_queues.add(q);
		_queueByRoad.put(r, q);
	}
	
	void addOutGoingRoad(Road r) {
		
	}
	
	void enter(Vehicle v) {
		Road r = v.getRoad();
		
	}
	
	Road roadTo(Junction j) {
		return null;
	}
	
	//IMPLEMENTS SIMULATED OBJECT//
	@Override
	void advance(int time) {
		// TODO Auto-generated method stub

	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		obj.put("id", _id);
//		obj.put("green", );
//		obj.put("queues", );
		
		return obj;
	}
	
	
	//GETTERS & SETTERS//
	int get_xCoor() {
		return this._xCoor;
	}
	
	int get_yCoor() {
		return this._yCoor;
	}
	

}
