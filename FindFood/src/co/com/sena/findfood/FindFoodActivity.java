package co.com.sena.findfood;

import java.util.List;

import co.com.sena.findfood.drawLocation.OverlayMapa;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import android.os.Bundle;
import android.view.View;

public class FindFoodActivity extends MapActivity {
	
    private MapView mapa = null;
    private MapController controlMapa = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
        //Obtenemos una referencia al control MapView
        mapa = (MapView)findViewById(R.id.mapa);
 
        //Mostramos los controles de zoom sobre el mapa
        mapa.setBuiltInZoomControls(true);
        //localización 12-05 20:46:40.933: I/System.out(1245): Latitud: 6212428Longitud: -75559351Zoom: 14

        Double latitud = 6.212428*1E6;
        Double longitud = -75.559351*1E6;
 
        GeoPoint loc = new GeoPoint(latitud.intValue(), longitud.intValue());
 
        controlMapa = mapa.getController();
        controlMapa.setCenter(loc);
        controlMapa.setZoom(14);
        
        //Añadimos las capas
        List<Overlay> capas = mapa.getOverlays();
        OverlayMapa om = new OverlayMapa();
        capas.add(om);
        mapa.postInvalidate();
    }

	@Override
	protected boolean isRouteDisplayed() {
		return true;
	}
	public void printLatitud(View v){
        //Obtenemos el centro del mapa
        GeoPoint loc = mapa.getMapCenter();
         
        //Latitud y Longitud (en microgrados)
        int lat = loc.getLatitudeE6();
        int lon = loc.getLongitudeE6();
//        12-05 20:33:50.603: I/System.out(1053): Latitud: 6218691 Longitud: -75559005 Zoom: 14

        //Nivel de zoom actual
        int zoom = mapa.getZoomLevel();
        System.out.println("Latitud: " + lat + "Longitud: " + lon+"Zoom: " + zoom);
	}
}