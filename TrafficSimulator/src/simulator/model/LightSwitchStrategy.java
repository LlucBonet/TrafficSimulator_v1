package simulator.model;

public interface LightSwitchStrategy {
	int chooseNextGreen(List<Road> roads, List<List<Vechicle>> qs, 
			int currGreen, int lastSwitchingTime, int currTime);
}
