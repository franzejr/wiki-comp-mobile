package br.ufc.engsoft.activities;

import br.ufc.engsoft.R;
import br.ufc.engsoft.activities.matrizcurricular.MatrizCurricular;
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

/*
 * Menu da Pós-Graduação, lista os dados que tem no wiki
 */
public class MenuPosGraduacao extends ListActivity {

	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				posGraduacaoMenu));

		listView = getListView();
		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (position == 0) {
					Intent intent = new Intent(MenuPosGraduacao.this,
							GenericView.class);
					intent.putExtra("title", posGraduacaoMenu[0]);
					startActivity(intent);

				} else if (position == 1) {
					Intent intent = new Intent(MenuPosGraduacao.this,
							GenericView.class);
					intent.putExtra("title", posGraduacaoMenu[2]);
					startActivity(intent);
					
				} else if (position == 2) {
					Intent intent = new Intent(MenuPosGraduacao.this,
							GenericView.class);
					intent.putExtra("title", posGraduacaoMenu[3]);
					startActivity(intent);
				}
				

				// When clicked, show a toast with the TextView text
				// Toast.makeText(getApplicationContext(),
				// ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	static final String posGraduacaoMenu[] = new String[] { "Corpo Docente",
			"Mestrado e Doutorado", "Especialização" };
}
