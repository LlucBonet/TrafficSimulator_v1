package simulator.model;

import org.json.JSONObject;


public class Vehicle extends SimulatedObject {
	//private List<Junction> itinerary;
	private int maxVel;
	private int velActual;
	private VehicleStatus estado;
	private Road carretera;
	private int localizacion;
	private int gradoContam;
	private int contamTotal;
	private int distTotal;
	
	Vehicle(String id, int maxSpeed, int contClass/*,List<Junction> itinerary*/) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	//Implements SimulatedObject
	@Override
	void advance(int time) {
		// TODO Auto-generated method stub

	}

	@Override
	public JSONObject report() {
		return null;
		
	}

	void setSpeed(int s) {
		
	}
	
	void setContaminationClass(int c) {
		if(this.estado == VehicleStatus.TRAVELING) {
			/*actualiza su localizacion al valor minimo entre la localizacion
			actual mas la vel actual y la longitud de la carretera por la q 
			esta circulando*/
			//this.localizacion = 
			
			/*calcula la contaminacion c producida utilizando la formula c = (lxf)/10, donde
			f es el factor de contaminacion y l es la distancia recorrida en ese paso de la
			simulacion, es decir, la nueva localización menos la localizacion previa. Despues
			annade c a la contaminacion total del vehiculo y tambien annade c al grado de
			contaminacion de la carretera actual, invocando al metodo correspondiente de
			la clase Road.*/
			
			/* si la localización actual (es decir la nueva) es igual a la longitud de la carretera,
			el vehiculo entra en la cola del cruce correspondiente (llamando a un metodo
			de la clase Junction). Recuerda que debes modificar el estado del vehiculo*/
			
		}
	}
	void moveToNextRoad() {
		
	}
	
}
