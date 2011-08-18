package sen.ceids.all.ul.sensors;

import sen.ceids.all.ul.Prueba_Sensores;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorProximity extends MySensorFather{
	
	//Parámetros del sensor(meter)
	private float distance; 
	
	public SensorProximity(Context context){
		
		super(context);
		
		super.sensorType = Sensor.TYPE_PROXIMITY;
		
		super.mySensorListener = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				
				//Validar si el evento es originado por el sensor de la clase
				
				if(isMySensorType(event.sensor.getType())){
					
					//Obtener los valores
					distance = event.values[SensorManager.DATA_X];
					
					Prueba_Sensores.tv_proximity.setText(""+distance);

				}								
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

}
