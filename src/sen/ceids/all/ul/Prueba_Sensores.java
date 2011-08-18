package sen.ceids.all.ul;

import sen.ceids.all.ul.sensors.MySensorController;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Prueba_Sensores extends Activity {
    /** Called when the activity is first created. */
	
	public static TextView tv_acceleration;
	public static TextView tv_gyroscope;
	public static TextView tv_light;
	public static TextView tv_magnetic_field;
	public static TextView tv_orientation;
	public static TextView tv_pressure;
	public static TextView tv_proximity;
	public static TextView tv_temperature;
	
	//Clase controladora de sensores
	
	MySensorController controller;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Inicializar componentes
        
        Prueba_Sensores.tv_acceleration = (TextView) findViewById(R.id.tv_accelerometer);
        Prueba_Sensores.tv_gyroscope = (TextView) findViewById(R.id.tv_gyroscope);
        Prueba_Sensores.tv_light = (TextView) findViewById(R.id.tv_light);
        Prueba_Sensores.tv_magnetic_field = (TextView) findViewById(R.id.tv_magnetic_field);
        Prueba_Sensores.tv_orientation = (TextView) findViewById(R.id.tv_orientation);
        Prueba_Sensores.tv_pressure = (TextView) findViewById(R.id.tv_pressure);
        Prueba_Sensores.tv_proximity = (TextView) findViewById(R.id.tv_proximity);
        Prueba_Sensores.tv_temperature = (TextView) findViewById(R.id.tv_temperature);
        
        //Inicializar controlador
        this.controller = new MySensorController(this.getApplicationContext());
        
    }
    
    public void start(View v){
    	
    	this.controller.registerAllSensors();
    	
    }
    
    public void stop(View v){
    	
    	this.controller.unregisterSensors();
    	
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	
    	this.controller.unregisterSensors();
    	
    	super.onPause();    	
    	    	
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	
    	this.controller.unregisterSensors();
    	
    	super.onStop();   	
    	    	
    }

}