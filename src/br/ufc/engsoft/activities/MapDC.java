package br.ufc.engsoft.activities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.ufc.engsoft.R;
import br.ufc.engsoft.util.MapOverlay;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MapDC extends MapActivity{
	
	private MapView map;
	private GeoPoint p = new GeoPoint((int) (-3.74596 * 1E6), (int) (-38.574192 * 1E6));
	private Button btOk, btCancelar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_map_dc);

		btOk = (Button) findViewById(R.id.layout_map_dc_ok);
		btCancelar = (Button) findViewById(R.id.layout_map_dc_cancel);
		
		try{
			map = (MapView) findViewById(R.id.layout_map_dc_mapa);
			map.setClickable(true);
			map.setBuiltInZoomControls(true);
			map.getController().animateTo(p);
			map.getController().setZoom(19);
			map.setSatellite(true);
			
			MapOverlay over = new MapOverlay();
			over.setContext(this);
			over.setP(p);
			map.getOverlays().clear();
			map.getOverlays().add(over);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		btOk.setOnClickListener(listenerOk);
		btCancelar.setOnClickListener(listenerCancelar);
	}
	
	
	private OnClickListener listenerCancelar = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
	};
	
	private OnClickListener listenerOk = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
	};

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
