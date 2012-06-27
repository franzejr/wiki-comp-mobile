package br.ufc.engsoft.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.ufc.engsoft.R;
import br.ufc.engsoft.util.rss.RSSFeed;
import br.ufc.engsoft.util.rss.RSSReader;
import br.ufc.engsoft.util.rss.RSSReaderException;

public class NewsActivity extends ListActivity {
	ListView listView;
	String[] posts;
	String[] urls;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.news);

		RSSReader reader = new RSSReader();
		String uri = "http://www.estudarcomputacao.com/feeds/posts/default?alt=rss";
		try {
			RSSFeed feed = reader.load(uri);
			this.posts = getPostsEstudarComputacao(feed);
			
			// Setando a lista
			setListAdapter(new ArrayAdapter<String>(this, R.layout.news,
					this.posts));
			listView = getListView();
			listView.setTextFilterEnabled(true);

			listView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					String uri = urls[position]; 
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse(uri));
					startActivity(intent);
	
				
				}
			});

			Log.i("post", feed.getItems().toString());
			Log.i("description", feed.getDescription());
			feed.getDescription();
			for (int i = 0; i < feed.getItems().size(); i++) {
				Log.i("conteudo", feed.getItems().get(i).toString());
				Log.i("conteudo", feed.getItems().get(i).getLink().toString());
			}

		} catch (RSSReaderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String[] getPostsEstudarComputacao(RSSFeed feed) {
		String[] namePosts = new String[feed.getItems().size()];
		String[] urlPosts = new String[feed.getItems().size()];
		for (int i = 0; i < feed.getItems().size(); i++) {
			namePosts[i] = feed.getItems().get(i).toString();
			urlPosts[i] = feed.getItems().get(i).getLink().toString();
			Log.i("post it", namePosts[i]);
		}
		
		this.urls = urlPosts;
		
		return namePosts;
	}

}
