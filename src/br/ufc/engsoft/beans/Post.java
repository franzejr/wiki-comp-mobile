package br.ufc.engsoft.beans;

import org.json.JSONObject;

import com.googlecode.androidannotations.annotations.Background;

import br.ufc.engsoft.util.JSONFunctions;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/*
 * Classe que representa um post da Wiki.
 * Basicamete um post eh definido pela sua
 * url, titulo e texto. Pegamos o texto em 
 * formato html e renderizamos este na pagina.
 * 
 */
public class Post {

	private String url;

	private String title;
	private String text;

	/*
	 * Construtor passando apenas titulo e texto
	 * 
	 * @param title
	 * 
	 * @param text
	 */
	public Post(String title, String text) {
		this.title = title;
		this.text = text;
	}

	/*
	 * Construtor passando apenas string
	 * 
	 * @param url
	 */
	public Post(String url) {
		this.url = url;
	}

	/*
	 * Dada a url que eh um atributo, esse metodo seta o titulo e o texto de um
	 * post.
	 */
	@Background
	public void getPost() {
		String json = JSONFunctions.getJSONfromURL(getUrl());
		String title = "";
		String text = "";
		try {
			JSONObject json1 = new JSONObject(json);
			title = (String) json1.getJSONObject("parse").getString("title");
			text = (String) json1.getJSONObject("parse").getJSONObject("text")
					.getString("*");
			// Setando os valores que foram buscados
			this.title = title;
			this.text = text;

		} catch (Exception e) {
			Log.i("Erro na hora de parsear: ", e.getMessage());
		}

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
