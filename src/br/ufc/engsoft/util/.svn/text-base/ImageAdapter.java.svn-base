package br.ufc.engsoft.util;

import br.ufc.engsoft.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

	private Integer[] icones = { R.drawable.icon8, R.drawable.icon13,
			R.drawable.icon9, R.drawable.icon1, R.drawable.icon5,
			R.drawable.icon11, R.drawable.icon7, R.drawable.icon3,
			R.drawable.icon10 };
	//Menu que aparece assim que a pessoa inicia
	private String[] menu = { "News", "Graduação", "Pós-graduação",
			"Áreas de Atuação", "Grupos de Pesquisa", "Extensão", "Estrutura",
			"Mais", "Buscar" };

	private Context context;

	private LayoutInflater layoutInflater;

	public ImageAdapter(Context c) {
		context = c;
		layoutInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return icones.length;
	}

	public Object getItem(int position) {
		return icones[position];
	}

	public long getItemId(int position) {
		return position;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		View grid;
		ImageView imageView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			grid = new View(context);
			grid = layoutInflater.inflate(R.layout.gridlayout, null);
			imageView = (ImageView) grid.findViewById(R.id.image);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setImageResource(icones[position]);
			TextView textView = (TextView) grid.findViewById(R.id.text);
			textView.setText(String.valueOf(menu[position]));
		} else {
			grid = convertView;
		}

		return grid;

	}

}
