package simulator.model;

public abstract class Event implements Comparable<Event> {

	protected int _time;

	Event(int time) {
		if (time < 1)
			throw new IllegalArgumentException("Time must be positive (" + time + ")");
		else
			_time = time;
	}

	int getTime() {
		return _time;
	}

	@Override
	public int compareTo(Event o) {
		// TODO complete the method to compare events according to their _time
		//orden basado en _time. De menor a mayor 
		if(this._time < o._time) return -1;
		else if(this._time < o._time) return 1;
		return 0;
	}

	abstract void execute(RoadMap map) throws Exception; //crea el obj a partir del evento y lo a�ade al mapa de carreteras
}
