package simulator.model;

import java.util.List;

public class MostCrowdedStrategy implements LightSwitchStrategy {
	private int timeSlot;
	public MostCrowdedStrategy(int timeSlot) {
		// TODO Auto-generated constructor stub
		this.timeSlot = timeSlot;
	}

	@Override
	public int chooseNextGreen(List<Road> roads, List<List<Vehicle>> qs, int currGreen, int lastSwitchingTime,
			int currTime) {
		// TODO Auto-generated method stub
		if(roads.isEmpty()) return -1;
		if(currGreen == -1) {
			int max = 0;

			for (int i = 0; i < qs.size(); i++) {
				if(qs.get(i).size() > max) {
					max = qs.get(i).size();
				}
			}
			for(int i = 0; i < qs.size(); i++) {
				if(qs.get(i).size() == max) return i;
			}
		}
		if(currTime - lastSwitchingTime < timeSlot) return currGreen;
		// falta punto 4
		for(int j = (currGreen + 1) % qs.size(); j < qs.size(); j++) {
			
		}
		return 0;
	}

}
