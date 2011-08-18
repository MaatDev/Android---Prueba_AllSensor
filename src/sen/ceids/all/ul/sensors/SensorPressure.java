package sen.ceids.all.ul.sensors;

import sen.ceids.all.ul.Prueba_Sensores;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorPressure extends MySensorFather{
	
	//Parámetros del sensor(KP)
	private float pressure; 
	
	public SensorPressure(Context context){
		
		super(context);
		
		super.sensorType = Sensor.TYPE_PRESSURE;
		
		super.mySensorListener = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				
				//Validar si el evento es originado por el sensor de la clase
				
				if(isMySensorType(event.sensor.getType())){
					
					//Obtener los valores
					pressure = event.values[SensorManager.DATA_X];
					
					Prueba_Sensores.tv_pressure.setText(""+pressure);

				}								
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

}
