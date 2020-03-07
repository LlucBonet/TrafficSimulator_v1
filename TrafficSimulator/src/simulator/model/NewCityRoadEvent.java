package simulator.model;

public class NewCityRoadEvent extends NewRoadEvent { 
	
	protected String _id;
	protected String _srcJ;
	protected String _destJ;
	protected int _lngth;
	protected int _co2L;
	protected int _maxS;
	protected Weather _wther;
	

	public NewCityRoadEvent(int time, String id, String srcJun, String destJunc, int length, int co2Limit, int maxSpeed, Weather weather) {
		super(time);
		// TODO Auto-generated constructor stub
		_id = id;
		_srcJ = srcJun;
		_destJ = destJunc;
		_lngth = length;
		_co2L = co2Limit;
		_maxS = maxSpeed;
		_wther = weather;
	}

	@Override
	Road createRoadObject(RoadMap map) throws Exception {
		// TODO Auto-generated method stub
		return new CityRoad(_id, map.getJunction(_srcJ), map.getJunction(_destJ), _lngth, _co2L, _maxS, _wther);
	}
	
	

}
