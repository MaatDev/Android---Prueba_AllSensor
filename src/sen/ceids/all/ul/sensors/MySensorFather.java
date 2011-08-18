package sen.ceids.all.ul.sensors;



import android.content.Context;


import android.hardware.SensorEventListener;

import android.hardware.SensorManager;
import android.util.Log;
//http://webraidmobile.wordpress.com/2010/10/21/how-long-is-sensor_delay_game/
public class MySensorFather {
	
	protected final String TAG = getClass().getSimpleName();
		
	protected SensorManager myManager;
	
	//Tiempo de cambio
	
	protected double now = 0;
    protected double timeDiff = 0;
    protected double lastUpdate = 0;
    protected int sensorType;
    
    //El tiempo que demora en obtener el listener
    
    private int delay = SensorManager.SENSOR_DELAY_NORMAL;
    
    protected SensorEventListener mySensorListener;
	
	public MySensorFather(Context contexto) {
		
		this.myManager = (SensorManager) contexto.getSystemService(Context.SENSOR_SERVICE);
		
	}	
	
	
	
	public boolean isSupported(Context context){
		if(myManager.getDefaultSensor(sensorType)== null)
			return false;
		
		return true;
		
	}
	
	
	public boolean isMySensorType(int sensorType) {
		// TODO Auto-generated method stub
		if(sensorType == this.sensorType){
			return true;
		}
		return false;
	}
	
	
	public void registerMyListener(){
		
		Log.v(TAG, "Estoy en "+TAG+": registerMyListener");
		
		//Registrar el sensor que corresponde
		
		this.myManager.registerListener(this.mySensorListener, this.myManager.getDefaultSensor(this.sensorType), delay);
	}	
	
	public void unregisterMyListener(){
		
		Log.v(TAG, "Estoy en "+TAG+": unregisterMyListener");
		
	   	this.myManager.unregisterListener(mySensorListener);
	   	
	}
	

}
