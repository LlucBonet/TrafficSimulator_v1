package simulator.model;

public class NewCityRoadEvent extends NewRoadEvent { 

	public NewCityRoadEvent(int time, String id, String srcJun, String destJunc, int length, int co2Limit, int maxSpeed, Weather weather) {
		super(time);
		// TODO Auto-generated constructor stub
	}

	@Override
	Road createRoadObject() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
