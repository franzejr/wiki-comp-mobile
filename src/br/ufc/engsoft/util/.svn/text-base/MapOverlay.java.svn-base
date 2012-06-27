package br.ufc.engsoft.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import br.ufc.engsoft.R;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class MapOverlay extends Overlay{

   private Context context;
   private GeoPoint p;
   
   @Override
   public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when){
	   super.draw(canvas, mapView, shadow);                   
 
     	//	---translate the GeoPoint to screen pixels---
     	Point screenPts = new Point();
     	mapView.getProjection().toPixels(p, screenPts);
 
        //---add the marker---
     	Bitmap bmp = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ic_franze_map);            
     	canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);         
     	return true;
   }

	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public GeoPoint getP() {
		return p;
	}
	public void setP(GeoPoint p) {
		this.p = p;
	}
}
