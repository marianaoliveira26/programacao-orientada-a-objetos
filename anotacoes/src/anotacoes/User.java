package anotacoes;

import java.util.HashMap;

public class User {
	private String username, password;
	private HashMap<String, Note> notas;
	
	User(String username, String password) {
		this.username = username;
		this.password = password;
		notas = new HashMap<String, Note>();
	}
	
	public void addNote(String title, String content) { 
		Note nota = new Note(title, content);
		notas.put(title, nota);
		notas.put(content, nota);
	}
	
	public void rmNote(int index) {
		for(int i =0; i <= notas.size(); i++) {
			if(i == index) {
				this.notas.remove(index);
			}
		}
	}

	public String toString() { 
		return "Usuario: " + this.getUsername() + " " + this.getPassword();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<String, Note> getNotas() {
		return notas;
	}

	public void setNotas(HashMap<String, Note> notas) {
		this.notas = notas;
	}
}
