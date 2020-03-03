package simulator.model;

public class CityRoad extends Road {

	public CityRoad(String id, Junction srcJunc, Junction destJunct, int maxSpeed, int contLimit, int length, Weather weather) throws Exception {
		super(id, srcJunc, destJunct, maxSpeed, contLimit, length, weather);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	void reduceTotalContamination() throws Exception {
		int x;
		
		if(this.getWeatherCond() == Weather.WINDY || this.getWeatherCond() == Weather.STORM)
			x = 10;
		else
			x = 2;
		if(this.getTotalCont() >= x)
			this.setTotalCont(this.getTotalCont() - x);
		else throw new Exception("TotalCont turns negative, CityRoad " + this._id);
	}

	@Override
	int calculateVehicleSpeed(Vehicle c) {
		return(int)(((11-c.getContClass()) / 11) * this.getSpeedLimit());
	}

	@Override
	void updateSpeedLimit() {}

}
