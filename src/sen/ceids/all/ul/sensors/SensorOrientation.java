package sen.ceids.all.ul.sensors;

import sen.ceids.all.ul.Prueba_Sensores;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorOrientation extends MySensorFather{
	
	//Par�metros del sensor (grados)
	private float azimuth;  //X
	private float pitch;  //Y
	private float roll;  //Z
	
	public SensorOrientation(Context context){
		
		super(context);
		
		super.sensorType = Sensor.TYPE_ORIENTATION;
		
		super.mySensorListener = new SensorEventListener() {
			
			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				
				//Validar si el evento es originado por el sensor de la clase
				
				if(isMySensorType(event.sensor.getType())){
					
					//Obtener los valores
					azimuth = event.values[SensorManager.DATA_X];
					pitch = event.values[SensorManager.DATA_Y];
					roll = event.values[SensorManager.DATA_Z];
					
					Prueba_Sensores.tv_orientation.setText(azimuth + " / " + pitch + " / " + roll);
					
				}								
				
			}
			
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

}
