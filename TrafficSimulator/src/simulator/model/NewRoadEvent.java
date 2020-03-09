package simulator.model;

public abstract class NewRoadEvent extends Event {

	public NewRoadEvent(int time) {
		super(time);
		// TODO Auto-generated constructor stub
	}

	@Override
	void execute(RoadMap map) throws Exception {
		// TODO Auto-generated method stub
		Road r = createRoadObject(map);
		map.addRoad(r);
	}
	
	abstract Road createRoadObject(RoadMap map) throws Exception; //he añadido RoadMap map 

}
