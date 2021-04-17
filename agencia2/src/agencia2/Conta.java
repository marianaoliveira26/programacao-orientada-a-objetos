package agencia2;

public class Conta {
	protected int id; //num de conta
	protected float saldo;
	protected String idCliente;//nome do caba 
	protected String type; //tipo de conta
	
	public Conta(int id, String idCliente) {
		this.id = id;
		this.saldo = 0;
		this.idCliente = idCliente;
		this.type = "";
	}	
	
	public void sacar(float value) {
		if(this.type.equals("CP")) {
			if((this.saldo-value) > 0) {
				this.setSaldo(getSaldo() - value); 
			} 
			else {
				System.out.println("Saldo insuficiante \n");
			}
		}
		else if(this.type.equals("CC")) {
			this.setSaldo(this.getSaldo() - value);
		}
	}
	
	public void depositar(float value) {
		if(this.type.equals("CP")) {
			this.setSaldo(this.getSaldo() + value);
		}
		else if(this.type.equals("CC")) { 
			this.setSaldo(this.getSaldo() + value);
		}
	}
	
	public void transferir(Conta other, float value) { 
		other.setSaldo(this.getSaldo() + value);
	}
	
	public void atualizacaomensal() { 
		if(this.type.equals("CC")) { 
			this.setSaldo(getSaldo() - 20); 
		} 
		else if(this.type.equals("CP")){
			float novosaldo = (this.saldo * 1)/100;
			this.setSaldo(this.getSaldo() + novosaldo);
		}
	}
	
	@Override
	public String toString() {
		return "[" + this.getId() + ":" + this.getIdCliente() + ":" + this.getSaldo() + ":" + this.getType() + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
