package simulator.model;

import org.json.JSONObject;

public abstract class Road extends SimulatedObject {
	private Junction origen;
	private Junction destino;
	private int longitud;
	private int maxVel;
	private int limActualVel;
	private int contExcesiva;
	private Weather condAmbientales;
	private int contTotal;
	private List<Vehicle> vehiculos;

	public Road(String id, Junction srcJunc, Junction destJunct, int maxSpeed, int contLimit, int length, Weather weather) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	void advance(int time) {
		// TODO Auto-generated method stub

	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}
	
	void enter(Vehicle v) {
		
	}
	
	void exit(Vehicle v) {
		
	}
	
	void setWeather(Weather w) {
		
	}
	
	void addContamination(int c) {
		
	}
	
	abstract void reduceTotalContamination();
	abstract int calculateVehicleSpeed(Vehicle c);
	

}
