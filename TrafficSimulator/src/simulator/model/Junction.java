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
		else {
			_xCoor = xCoor;
			_yCoor = yCoor;
		}
		
		_greenLightIndex = -1;
		_lastSwitchingTime = 0;
		_inRoad = new ArrayList<>();
		_queues = new ArrayList<>();
		_outRoad = new HashMap<>();
		_queueByRoad = new HashMap<>();
	}

	void addIncomingRoad(Road r) throws IllegalArgumentException {
		if(!this.equals(r.getDest())) throw new IllegalArgumentException("addIncomingRoad to junction "+ _id);
		
		List<Vehicle> q = new ArrayList<Vehicle>(); //puede ser LinkedList
		_inRoad.add(r);
		_queues.add(q);
		_queueByRoad.put(r, q);
	}
	
	void addOutGoingRoad(Road r) throws IllegalArgumentException {
		//TODO mirar la segunda excepcion 
		Junction j = r.getDest();
		for(Map.Entry<Junction, Road> entry : _outRoad.entrySet()) {
			if(entry.getValue().getSrc() == this && entry.getKey() == j) {
				throw new IllegalArgumentException("addOutGoingRoad from junction" + _id + ". This road already exists");
			}
		}
		//if(!(r.getSrc() == this)) throw new IllegalArgumentException("addOutgoingRoad from juction " + _id + " road doesn't belong to this juction");
		_outRoad.put(j, r);
	}
	
	void enter(Vehicle v) {
		Road r = v.getRoad();
		int pos = _queues.size();
		int i = 0;
		boolean found = false;
		while (i < _queues.size() && !found){
			if(r == _queues.get(i)) {
				pos = i;
				found = true;
			}
		}
		_queues.get(pos).add(v);
		
	}
	
	Road roadTo(Junction j) { 
		Road r = null;
		for(Map.Entry<Junction, Road> entry : _outRoad.entrySet()) {
			if(entry.getValue().getSrc() == this && entry.getKey() == j) {
				r = entry.getValue();
				return r;
			}
		}
		return r;
	}
	
	//IMPLEMENTS SIMULATED OBJECT//
	@Override
	void advance(int time) {
		// TODO 
		
		

	}

	@Override
	public JSONObject report() {
		JSONObject obj = new JSONObject();
		JSONObject obj2 = new JSONObject();

		obj.put("id", _id);
		if(_greenLightIndex == -1) {
			obj.put("green", "none");
		}
		else {
			//TODO no se seguro si se usa _inRoad u otra lista
			obj.put("green", _inRoad.get(_greenLightIndex).getId());
		}
		
		for(int i = 0; i < _queues.size(); i++) {
			obj2.put("road", _inRoad.get(i).getId());
			obj2.put("vehicle", _inRoad.get(i).getVehicleList());
		}		
		obj.put("queues", obj2);

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
