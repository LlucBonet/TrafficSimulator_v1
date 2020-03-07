package simulator.model;

public class NewInterCityRoadEvent extends NewRoadEvent {

	protected String _id;
	protected String _srcJ;
	protected String _destJ;
	protected int _lngth;
	protected int _co2L;
	protected int _maxS;
	protected Weather _wther;
	
	public NewInterCityRoadEvent(int time, String id, String srcJun, String
			destJunc, int length, int co2Limit, int maxSpeed, Weather weather) {
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
		//String id, Junction srcJunc, Junction destJunct, int maxSpeed, int contLimit, Weather weather, int length
		return new InterCityRoad(_id, map.getJunction(_srcJ), map.getJunction(_destJ), _maxS, _co2L, _wther, _lngth);
	}
}
