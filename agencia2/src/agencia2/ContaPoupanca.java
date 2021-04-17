package agencia2;

public class ContaPoupanca extends Conta {
	protected float rendimento;

	public ContaPoupanca(int id, String idCliente) {
		super(id, idCliente);
		this.type = "CP"; 
	}
	
	@Override
	public void atualizacaomensal() {
		float novosaldo = (this.saldo * 1)/100;
		this.setSaldo(this.getSaldo() + novosaldo);	}
	
	//set e get

	public float getRendimento() {
		return rendimento;
	}

	public void setRendimento(float rendimento) {
		this.rendimento = rendimento;
	}
}
