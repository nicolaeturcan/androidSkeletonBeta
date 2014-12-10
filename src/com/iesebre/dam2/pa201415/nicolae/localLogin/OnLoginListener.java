package com.iesebre.dam2.pa201415.nicolae.localLogin;


/*
Cada control ha de tenir alguns esdeveniments que ens permetin respondre a les accions 
de l'usuari de l'aplicació. Així per exemple, els botons tenen un esdeveniment OnClick, 
les llistes un esdeveniment OnItemSelected, etc. Doncs bé, nosaltres anem a dotar 
el nostre control d'un esdeveniment personalitzat, anomenat OnLogin, que es llanci quan l'usuari 
introdueix les seves credencials d'identificació i prem el botó "Login".

Per a això, el primer que farem és concretar els detalls d'aquest esdeveniment, 
creant una interfície Java per definir el seu listener. Aquesta interfície només 
tindrà un mètode anomenat onLogin() que retornarà les dues dades introduïdes per 
l'usuari (usuari i contrasenya).

*/
public interface OnLoginListener {
	void onLogin(String usuario, String password);
}
