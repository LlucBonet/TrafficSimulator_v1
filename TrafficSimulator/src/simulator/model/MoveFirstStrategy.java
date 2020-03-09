package simulator.model;

import java.util.ArrayList;
import java.util.List;

public class MoveFirstStrategy implements DequeuingStrategy {

	public MoveFirstStrategy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Vehicle> dequeue(List<Vehicle> q) {
		List<Vehicle> vl = new ArrayList<Vehicle>();
		vl.add(q.get(0));
		return vl;
	}

}
