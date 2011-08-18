package sen.ceids.all.ul.sensors;

import java.util.List;

import sen.ceids.all.ul.Prueba_Sensores;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;

public class MySensorController {
	
	private final String TAG = getClass().getSimpleName();
	
	//Estados de cada sensores
	private boolean stateAccelerometer=false;
	private boolean stateGyroscope=false;
	private boolean stateLight=false;
	private boolean stateMagneticField=false;
	private boolean stateOrientation=false;
	private boolean statePressure=false;
	private boolean stateProximity=false;
	private boolean stateTemperature=false;
	

	
	//Clase manejadora de sensores
	private SensorAcceleration sAcceleration;
	private SensorGyroscope sGyroscope;
	private SensorLight sLight;
	private SensorMagneticField sMagneticField;
	private SensorOrientation sOrientation;
	private SensorPressure sPressure;
	private SensorProximity sProxmity;
	private SensorTemperature sTemperature;
	
	public MySensorController(Context context){
		
		this.sAcceleration = new SensorAcceleration(context);
		this.sGyroscope = new SensorGyroscope(context);
		this.sLight = new SensorLight(context);
		this.sMagneticField = new SensorMagneticField(context);
		this.sOrientation = new SensorOrientation(context);
		this.sPressure = new SensorPressure(context);
		this.sProxmity = new SensorProximity(context);
		this.sTemperature = new SensorTemperature(context);
		
		this.checkSensorsOnDevice(context);
		
	}
	
//	public MySensorController(boolean accelerometer
//			, boolean gyroscope, boolean light
//			, boolean magneticField, boolean
//			orientation, boolean pressure,
//			boolean proximity, boolean temperature){
//		stateAccelerometer = accelerometer;
//		stateGyroscope = gyroscope;
//		stateLight = light;
//		stateMagneticField = magneticField;
//		stateOrientation = orientation;
//		statePressure = pressure;
//		stateProximity = proximity;
//		stateTemperature = temperature;
//	}
	
	public void checkSensorsOnDevice(Context context){
		//Determinar que sensores tiene el equipo
		
		Log.v(TAG, "Estoy en "+TAG+": checkSensorsOnDevice");
		
		SensorManager sm = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> sensorList = sm.getSensorList(Sensor.TYPE_ALL);

		for(Sensor temp:sensorList){
			if(temp.getType() == Sensor.TYPE_ACCELEROMETER)
				stateAccelerometer = true;
			else
				Prueba_Sensores.tv_acceleration.setText("El sensor no está disponible o no tiene.");
			
			if(temp.getType() == Sensor.TYPE_GYROSCOPE)
				stateGyroscope = true;
			else
				Prueba_Sensores.tv_gyroscope.setText("El sensor no está disponible o no tiene.");
			if(temp.getType() == Sensor.TYPE_LIGHT)
				stateLight = true;
			else
				Prueba_Sensores.tv_light.setText("El sensor no está disponible o no tiene.");			
			if(temp.getType() == Sensor.TYPE_MAGNETIC_FIELD)
				stateMagneticField = true;
			else
				Prueba_Sensores.tv_magnetic_field.setText("El sensor no está disponible o no tiene.");			
			if(temp.getType() == Sensor.TYPE_ORIENTATION)
				stateOrientation = true;
			else
				Prueba_Sensores.tv_orientation.setText("El sensor no está disponible o no tiene.");
			if(temp.getType() == Sensor.TYPE_PRESSURE)
				statePressure = true;
			else
				Prueba_Sensores.tv_pressure.setText("El sensor no está disponible o no tiene.");	
			if(temp.getType() == Sensor.TYPE_PROXIMITY)
				stateProximity = true;
			else
				Prueba_Sensores.tv_proximity.setText("El sensor no está disponible o no tiene.");			
			if(temp.getType() == Sensor.TYPE_TEMPERATURE)
				stateTemperature = true;		
			else
				Prueba_Sensores.tv_temperature.setText("El sensor no está disponible o no tiene.");
		}	
	
		
	}
		
	public void registerAllSensors(){
		
		if(stateAccelerometer)			
			sAcceleration.registerMyListener();
		if(stateGyroscope)
			sGyroscope.registerMyListener();
		if(stateLight)
			sLight.registerMyListener();
		if(stateMagneticField)
			sMagneticField.registerMyListener();
		if(stateOrientation)
			sOrientation.registerMyListener();
		if(statePressure)
			sPressure.registerMyListener();
		if(stateProximity)
			sProxmity.registerMyListener();
		if(stateTemperature)
			sTemperature.registerMyListener();
		
	}
	
	public void unregisterSensors(){
		
		if(stateAccelerometer)			
			sAcceleration.unregisterMyListener();
		if(stateGyroscope)
			sGyroscope.unregisterMyListener();
		if(stateLight)
			sLight.unregisterMyListener();
		if(stateMagneticField)
			sMagneticField.unregisterMyListener();
		if(stateOrientation)
			sOrientation.unregisterMyListener();
		if(statePressure)
			sPressure.unregisterMyListener();
		if(stateProximity)
			sProxmity.unregisterMyListener();
		if(stateTemperature)
			sTemperature.unregisterMyListener();
		
	}

	public boolean isStateAccelerometer() {
		return stateAccelerometer;
	}

	public boolean isStateGyroscope() {
		return stateGyroscope;
	}

	public boolean isStateLight() {
		return stateLight;
	}

	public boolean isStateMagneticField() {
		return stateMagneticField;
	}

	public boolean isStateOrientation() {
		return stateOrientation;
	}

	public boolean isStatePressure() {
		return statePressure;
	}

	public boolean isStateProximity() {
		return stateProximity;
	}

	public boolean isStateTemperature() {
		return stateTemperature;
	}


	public SensorAcceleration getsAcceleration() {
		return sAcceleration;
	}

	public SensorLight getsLight() {
		return sLight;
	}

			

}
