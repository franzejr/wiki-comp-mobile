package br.ufc.engsoft.activities;

import com.googlecode.androidannotations.annotations.Background;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import br.ufc.engsoft.R;
import br.ufc.engsoft.beans.Post;
import br.ufc.engsoft.util.JSONFunctions;

/*
 * Activity Generica que pega basicamente um post da
 * wiki. Ela eh simples. Tem apenas o titulo do post
 * e o seu respectivo texto.
 */
public class GenericView extends Activity {
	MenuItem searchView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.genericview);
		// Pegando os elementos da tela
		TextView text_title = (TextView) findViewById(R.id.title);
		TextView text_text = (TextView) findViewById(R.id.text);

		String passado = getIntent().getStringExtra("title");

		Log.i("titulo passado: ", passado);

		String url = JSONFunctions.setURLPost(passado);
		
		Post p = new Post(url);
		p.getPost();

		// Setando elementos na tela
		text_title.setText(Html.fromHtml(p.getTitle()));
		text_text.setText(Html.fromHtml(p.getText()));

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		searchView= menu.add("Buscar");
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if(item == searchView){
			startActivity(new Intent(GenericView.this,SearchView.class));
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
