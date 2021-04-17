package anotacoes;

import java.util.HashMap;

public class LoginManager {
	private HashMap<String , User> usuarios;
	private User corretUser;
	
	public LoginManager(HashMap<String, User> usuarios, User corretUser) {
		super();
		this.usuarios = usuarios;
		this.corretUser = corretUser;
	}
	
	public void login(String username, String password) throws RuntimeException {
		if(!this.usuarios.containsKey(password)) { 
			throw new SenhaInvalidaException("Senha incorreta");
		}
		else if(!this.usuarios.containsKey(username)) {
			throw new UsuarioNaoLogadoException("Nao tem ninguém");
		} 
		else {
			this.usuarios.put(username, corretUser);
			this.usuarios.put(password, corretUser);
		}
	}
	
	public void logout() throws RuntimeException {
		if(this.getCorretUser() == null) {
			throw new UsuarioNaoLogadoException("Tem ninguem aqui nao");
		}
	}
	
	public HashMap<String, User> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(HashMap<String, User> usuarios) {
		this.usuarios = usuarios;
	}
	public User getCorretUser() {
		return corretUser;
	}
	public void setCorretUser(User corretUser) {
		this.corretUser = corretUser;
	}
}
