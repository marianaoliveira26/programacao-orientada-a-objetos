package anotacoes;

import java.util.HashMap;

public class System {
	
	private  HashMap<String, User> usuario;
	private HashMap<String, Note> notas;
	private LoginManager loginManager;
	
	public System() {
		usuario = new HashMap<String, User>();
		notas = new HashMap<String, Note>();

	}
	
	public void addNote(String title, String content) {
		Note nota = new Note(title, content);
		notas.put(title, nota);
		notas.put(content, nota);

	}
	
	public void addUser(String username, String password) throws Exception{
		User user = new User(username, password);
		if(this.usuario.containsKey(username)) {
			throw new Exception("Ja trm alhuém com esse nome");
		}
		this.usuario.put(username, user);
		this.usuario.put(password, user);

	}
	
	public String getUsername() { 
		String s = "";
		for(User u : usuario.values()) { 
			s += u.toString() + "\n";
		}
		for(Note n : notas.values()) {
			s +=n.toString();
		}
		return s;
	}
	
	public HashMap<String, User> getUsuario() {
		return usuario;
	}
	public void setUsuario(HashMap<String, User> usuario) {
		this.usuario = usuario;
	}
	public LoginManager getLoginManager() {
		return loginManager;
	}
	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}
}
