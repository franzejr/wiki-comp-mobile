package br.ufc.engsoft.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import br.ufc.engsoft.R;
import br.ufc.engsoft.util.JSONFunctions;
import br.ufc.engsoft.util.StringNormalizer;

/*
 * Activity que dado o nome de uma pagina, ele
 * busca essa pagina na wiki. Eh passado o nome
 * dessa pagina por parametro para a proxima Activity.
 * 
 */
public class SearchView extends Activity {
	/*
	 * texto procurado
	 */
	EditText searchText;
	TextView msgBusca;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchview);
		searchText = (EditText) findViewById(R.id.searchText);
		msgBusca = (TextView) findViewById(R.id.msgBusca);
		
		Button bBuscarPagina = (Button) findViewById(R.id.b_buscarPagina);

		bBuscarPagina.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				StringNormalizer m = new StringNormalizer();
				
				String tituloBuscado = String.valueOf(searchText.getText());
				Log.i("tituloBuscado", tituloBuscado);
				
				String tituloNormalizado = "";
				
				tituloNormalizado = m.getName(tituloBuscado);
				
				if (tituloNormalizado == null){					
					msgBusca.setText("Disciplina não encontrada");
				}
				else{
					String tituloRetornado = "";
					
					tituloRetornado = JSONFunctions.getPageTitle(tituloNormalizado);	
				
					if(tituloRetornado.contains("404")){
						msgBusca.setText("Disciplina não encontrada");
					}else{
						//Se a pagina existe, entao inicia a nova intent com o que foi retornado.
						Intent intent = new Intent(SearchView.this, GenericView.class);
						intent.putExtra("title", tituloRetornado);
						startActivity(intent);
					}
				}
			}
		});
	}

}
