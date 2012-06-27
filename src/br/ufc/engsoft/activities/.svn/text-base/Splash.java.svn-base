package br.ufc.engsoft.activities;

import br.ufc.engsoft.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
/*
 * Activity de carregamento, isto e, de Splash para o carregamento do inicio da aplicacao.
 * Nao estamos mais utilizando tela de splash, visto que a maior parte das aplicacoes de
 * hoje em dia nao mais a utilizam.
 */
public class Splash extends Activity {
	/** Called when the activity is first created. */

	public int time = 3000;
	public boolean ativa = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Thread splash = new Thread() {

			public void run() {

				try {

					int espera = 0;
					while (ativa && (espera < time)) {
						sleep(100);
						if (ativa) {
							espera += 100;
						}
					}
				} catch (InterruptedException e) {
					// TODO: handle exception
				} finally {

					startActivity(new Intent(Splash.this,
							MenuGraduacao.class));
					finish();

				}

			}

		};

		splash.start();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		// return super.onTouchEvent(event);
		if (event.getAction() == MotionEvent.ACTION_DOWN) {

			ativa = false;

		}
		return true;

	}

}
