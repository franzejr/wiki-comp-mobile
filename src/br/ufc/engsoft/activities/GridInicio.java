package br.ufc.engsoft.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import br.ufc.engsoft.R;
import br.ufc.engsoft.util.ImageAdapter;
import br.ufc.engsoft.util.Network;
/*
 * Tela inicial da aplicação em formato de Grid.
 */
public class GridInicio extends Activity {
	Context context = this;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio);

		GridView gridview = (GridView) findViewById(R.id.gridView);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				if(Network.isNetworkAvailable(context)){						
					//News
					if (position == 0){
							startActivity(new Intent(GridInicio.this,NewsActivity.class));
					}
					//Graduacao
					else if (position == 1) {
						startActivity(new Intent(GridInicio.this,
								MenuGraduacao.class));
					}
					//PosGraduacao
					else if (position == 2) {
						startActivity(new Intent(GridInicio.this,
								MenuPosGraduacao.class));
					}
					//Areas de Atuacao
					else if (position == 3) {
						startActivity(new Intent(GridInicio.this,
								MenuAreasDeAtuacao.class));
					}
					//Grupos de Pesquisa
					else if (position == 4) {
						startActivity(new Intent(GridInicio.this,
								MenuGruposDePesquisa.class));
					}
					//Extensao
					else if (position == 5) {
						startActivity(new Intent(GridInicio.this,
								MenuExtensao.class));
					}
					//Mapa
					else if (position == 6) {
							startActivity(new Intent(GridInicio.this,
									MapDC.class));
					}
					//Mais
					else if (position == 7) {
						startActivity(new Intent(GridInicio.this,
								MenuMais.class));
					}
					//Busca
					else if (position == 8) {						
							startActivity(new Intent(GridInicio.this,
									SearchView.class));
					}
				}
				else{
					Toast.makeText(GridInicio.this, "É necessário ter acesso à internet!",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
