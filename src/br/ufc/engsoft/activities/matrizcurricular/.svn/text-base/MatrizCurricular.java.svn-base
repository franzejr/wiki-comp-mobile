package br.ufc.engsoft.activities.matrizcurricular;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import br.ufc.engsoft.R;

public class MatrizCurricular extends ListActivity {

	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				semestres));
		// setContentView(R.layout.graduacao);

		listView = getListView();
		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (position == 0) {
					startActivity(new Intent(MatrizCurricular.this,
							Semestre1.class));
				}
				else if(position == 1){
					startActivity(new Intent(MatrizCurricular.this,
							Semestre2.class));
				}
				else if(position == 2){
					startActivity(new Intent(MatrizCurricular.this,
							Semestre3.class));
				}
				else if(position == 3){
					startActivity(new Intent(MatrizCurricular.this,
							Semestre4.class));
				}
				else if(position == 4){
					startActivity(new Intent(MatrizCurricular.this,
							Semestre5.class));
				}
				else if(position == 5){
					startActivity(new Intent(MatrizCurricular.this,
							Semestre6.class));
				}
				else if(position == 6){
					startActivity(new Intent(MatrizCurricular.this,
							Semestre7.class));
				}
				// When clicked, show a toast with the TextView text
				 Toast.makeText(getApplicationContext(),
				 ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	static final String semestres[] = new String[] { "Semestre 1",
			"Semestre 2", "Semestre 3", "Semestre 4",
			"Semestre 5", "Semestre 6", "Semestre 7" };

}
