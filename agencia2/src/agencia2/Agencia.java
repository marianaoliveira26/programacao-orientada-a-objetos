package agencia2;

import java.util.HashMap;

public class Agencia {
	protected HashMap <String, Cliente> clientes;
	protected HashMap <Integer, Conta> contas;
	protected int nextid; 
	
	public Agencia() {
		clientes = new HashMap<String, Cliente>();
		contas = new HashMap<Integer, Conta>();
		this.nextid = 0;
	}

	public void adicionarCliente(String id) {
		if(clientes.get(id) == null) { 
			Cliente cliente = new Cliente(id);
			Conta corrente = new ContaCorrente(nextid++, id); 
			Conta poupanca = new ContaPoupanca(nextid++, id); 

			clientes.put(id, cliente);
			contas.put(corrente.id, corrente);
			contas.put(poupanca.id, poupanca); 
		}
	}
	
	public void depositar(int indice, float value) { 
		if(contas.containsKey(indice)) { 
			Conta conta = contas.get(indice); 
			conta.depositar(value);
		}
		else {
			System.out.println("A conta nao foi encontrada/naoexiste");
		}
	}
	
	public void sacar(int indice, float value) {
		if(contas.containsKey(indice)) {
			Conta conta = contas.get(indice);
			conta.sacar(value);
		}
		else {
			System.out.println("a conta nao foi encontrada/nao existe");
		}
	}
	
	public void transferir(int indice1, int indice2, float value) { 
		if(contas.containsKey(indice1) && contas.containsKey(indice2)) {
			Conta c1 = contas.get(indice1);
			Conta c2 = contas.get(indice2);
			c1.sacar(value);
			c1.transferir(c2, value);
		}
		else {
			System.out.println("A conta nao existe");
		}
	}
	
	public void atualizar() {
		for(Conta c : contas.values()) { 
			if(c.equals("CC")) {
				ContaCorrente corrente = (ContaCorrente) contas.get(c.id);
				corrente.atualizacaomensal();
			} 
			else if(c.equals("CP")) {
				ContaPoupanca poupanca = (ContaPoupanca) contas.get(c.id);
				poupanca.atualizacaomensal();
			}
		}
	}
	
	@Override
	public String toString() {
		String resul = "";
		for(Conta c : contas.values()) {
			resul += c + "\n";
		}
		return resul;
	}
	public HashMap<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashMap<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	public HashMap<Integer, Conta> getContas() {
		return contas;
	}

	public void setContas(HashMap<Integer, Conta> contas) {
		this.contas = contas;
	}

	public int getNextid() {
		return nextid;
	}

	public void setNextid(int nextid) {
		this.nextid = nextid;
	}
	public Conta getConta(int id) {
		return contas.get(id);
	}
}
