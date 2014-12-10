package com.iesebre.dam2.pa201415.nicolae.localLogin;

import com.iesebre.dam2.pa201415.nicolae.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Local_Login_Activity extends ActionBarActivity {
	
	private ControlLogin ctlLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local_login);

		ctlLogin = (ControlLogin) findViewById(R.id.CtlLogin);

		ctlLogin.setOnLoginListener(new OnLoginListener() {
			@Override
			public void onLogin(String user, String password) {
				// Validem l'usuari i la contrasenya.
				if (user.equals("nicolae") && password.equals("nicolae"))
					ctlLogin.setMessage("Usuari i contrasenya correcte!");
				else
					ctlLogin.setMessage("Error! Usuari o contrasenya erroni/s.");
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
