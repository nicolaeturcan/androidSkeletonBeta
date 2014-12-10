package com.iesebre.dam2.pa201415.nicolae.localLogin;

import com.iesebre.dam2.pa201415.nicolae.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 	Creaiem la classe java ControlLogin que l'associarem al layout on haguessim definit
 	tota la funcionalitat del nostre control.
 	
 	Com que ens hem basat en un LinearLayout per construir el control, 
 	aquesta nova classe haurà d'heredar també de la classe java LinearLayout d'Android.   
 */

public class ControlLogin extends LinearLayout {
	private EditText txtUser;
	private EditText txtPassword;
	private Button btnLogin;
	private TextView lblMessage;
	
	private OnLoginListener listener;
	
	// Constructor bàsic 1.
	public ControlLogin(Context context) {
		super(context);
		inicializar();
	}
	
	// Constructor bàsic 2.
	public ControlLogin(Context context, AttributeSet attrs) {
		super(context, attrs);
		inicializar();
		
		// Procesem els atributs XML personalitzats.
		TypedArray a = 
			getContext().obtainStyledAttributes(attrs,
				R.styleable.ControlLogin);

		String textoBoton = a.getString(
				R.styleable.ControlLogin_login_text);
		
		btnLogin.setText(textoBoton);

		a.recycle();
	}

	
/* 	
 	El mètode principal del control que s'encarrega d'umflar el layout XML que hem definit anteriorment. 
	D'aquesta forma obtindrem les referències a tots els controls i assignarem els esdeveniments necessaris. 	
*/
	private void inicializar(){
		//Utilitzarem el layout 'control_login' com a interficie del control.
		String infService = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater li = 
			(LayoutInflater)getContext().getSystemService(infService);
		li.inflate(R.layout.control_login, this, true);
		
		//Obtenim les referencies als diferents controls.
		txtUser = (EditText)findViewById(R.id.TxtUsuario);
		txtPassword = (EditText)findViewById(R.id.TxtPassword);
		btnLogin = (Button)findViewById(R.id.BtnAceptar);
		lblMessage = (TextView)findViewById(R.id.LblMensaje);
		
		//Associem els events necessaris.
		pushEvent();
/*
 		Amb això ja tenim definida la interfície i la funcionalitat bàsica 
 		del nou control pel que ja podem utilitzar-lo d'una altra activitat 
 		com si es tractés de qualsevol altre control predefinit.
  
*/	
		
	}
	
	
	// afegir un nou OnLoginListener a la classe ControlLogin, 
	// i un mètode públic que permeti subscriure al nou esdeveniment.
	public void setOnLoginListener(OnLoginListener l){
		listener = l;
	}
	
/*
	Aprofitant l'esdeveniment OnClick() del botó Login que és un esdeveniment 
	intern del control, per llançar-lo cap a l'exterior a l'esdeveniment OnLogin() 
	que serà el que ha de capturar i tractar l'aplicació que faci ús del control.
*/
	private void pushEvent()	{
		btnLogin.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				listener.onLogin(txtUser.getText().toString(), 
						         txtPassword.getText().toString());
			}
		});
	}
	
/*
	Afegim un mètode que permeti modificar el text de l'etiqueta del 
	resultat de la connexió.
*/
	public void setMessage(String msg)	{
		lblMessage.setText(msg);
	}
}
