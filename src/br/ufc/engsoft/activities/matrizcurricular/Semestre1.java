package br.ufc.engsoft.activities.matrizcurricular;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import br.ufc.engsoft.R;
import br.ufc.engsoft.activities.GenericView;

public class Semestre1 extends ListActivity {

	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				disciplinas));
		// setContentView(R.layout.graduacao);

		listView = getListView();
		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//Escolhendo quais disciplinas foram clicadas e chamando a generic view
				if (position == 0) {
					Intent intent = new Intent(Semestre1.this,GenericView.class);
					intent.putExtra("title", disciplinas[0]);
					startActivity(intent);
				}
				else if (position == 1) {
					Intent intent = new Intent(Semestre1.this,GenericView.class);
					intent.putExtra("title", disciplinas[1]);
					startActivity(intent);
				}
				else if (position == 2) {
					Intent intent = new Intent(Semestre1.this,GenericView.class);
					intent.putExtra("title", disciplinas[2]);
					startActivity(intent);
				}
				else if (position == 3) {
					Intent intent = new Intent(Semestre1.this,GenericView.class);
					intent.putExtra("title", disciplinas[3]);
					startActivity(intent);
				}
				else if (position == 4) {
					Intent intent = new Intent(Semestre1.this,GenericView.class);
					intent.putExtra("title", disciplinas[4]);
					startActivity(intent);
				}
				else if (position == 5) {
					Intent intent = new Intent(Semestre1.this,GenericView.class);
					intent.putExtra("title", disciplinas[5]);
					startActivity(intent);
				}
				// When clicked, show a toast with the TextView text
				 Toast.makeText(getApplicationContext(),
				 ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	static final String disciplinas[] = new String[] { "Matemática Discreta",
			"Álgebra Linear", "Cálculo I", "Circuitos Digitais",
			"Fudamentos de Programação" };

}
