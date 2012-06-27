package br.ufc.engsoft.activities.matrizcurricular;

import br.ufc.engsoft.R;
import br.ufc.engsoft.activities.GenericView;
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

public class Semestre6 extends ListActivity {

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
				if (position == 0) {
					Intent intent = new Intent(Semestre6.this,GenericView.class);
					intent.putExtra("title", disciplinas[0]);
					startActivity(intent);
				}
				else if (position == 1) {
					Intent intent = new Intent(Semestre6.this,GenericView.class);
					intent.putExtra("title", disciplinas[1]);
					startActivity(intent);
				}
				else if (position == 2) {
					Intent intent = new Intent(Semestre6.this,GenericView.class);
					intent.putExtra("title", disciplinas[2]);
					startActivity(intent);
				}
				else if (position == 3) {
					Intent intent = new Intent(Semestre6.this,GenericView.class);
					intent.putExtra("title", disciplinas[3]);
					startActivity(intent);
				}
				// When clicked, show a toast with the TextView text
				 Toast.makeText(getApplicationContext(),
				 ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	static final String disciplinas[] = new String[] { "Autômatos e Linguagens Formais",
			"Inteligência Artificial", "Análise de Projeto de Sistemas", "Sistemas Operacionais" };

}
