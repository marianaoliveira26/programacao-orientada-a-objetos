package agencia2;

import java.util.HashMap;

public class Cliente {
	
	protected String id;
	protected HashMap <Integer, Conta> contas;
	
	public Cliente(String id) {
		this.id = id;
		contas = new HashMap<Integer, Conta>();
	}
}

