package simulator.model;

import java.util.List;
import java.util.Map;

public class RoadMap {
	private List<Junction> JunctionList;
	private List<Road> RoadList;
	private List<Vehicle> VechicleList;
	private Map<String, Junction> JunctionMap;
	private Map<String, Road> RoadMap;
	private Map<String, Vehicle> VechicleMap;
	
	RoadMap(){
		
	}
	
	void addJunction(Junction j) {
		
	}
	
	void addRoad(Road r) {
		
	}
	
	void addVechicle(Vehicle v) {
		
	}
	
	public Junction getJunction(String id) {
		return null;
	}
	
	public Road getRoad(String id) {
		return null;
	}
	
	public Vehicle getVehicle(String id) {
		return null;
	}
	
	public List<Junction> getJunctions(){
		return JunctionList;
	}
	
	public List<Road> getRoads(){
		return RoadList;
	}
	
	public List<Vehicle> getVehicles(){
		return VechicleList;
	}
	
	void reset() {
		
	}
}
