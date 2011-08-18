package sen.ceids.all.ul.sensors;

import sen.ceids.all.ul.Prueba_Sensores;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorMagneticField extends MySensorFather{
	
	//Parámetros del sensor(µT)
	private float lateral;  //X
	private float longitudinal;  //Y
	private float vertical;  //Z
	
	public SensorMagneticField(Context context){
		
		super(context);
		
		super.sensorType = Sensor.TYPE_MAGNETIC_FIELD;
		
		super.mySensorListener = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				
				//Validar si el evento es originado por el sensor de la clase
				
				if(isMySensorType(event.sensor.getType())){
					
					//Obtener los valores
					lateral = event.values[SensorManager.DATA_X];
					longitudinal = event.values[SensorManager.DATA_Y];
					vertical = event.values[SensorManager.DATA_Z];
					
					Prueba_Sensores.tv_magnetic_field.setText(lateral + " / " + longitudinal + " / " + vertical);
					
				}								
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

}
