package agencia2;

public class ContaCorrente extends Conta {
	protected float tarifamensal = 20;
	
	public ContaCorrente(int id, String idCliente) {
		super(id, idCliente);
		this.type = "CC";
	}
	
	@Override
	public void atualizacaomensal() {
		this.setSaldo(this.getSaldo() - tarifamensal);
	}
	
	public float getTarifamensal() {
		return tarifamensal;
	}

	public void setTarifamensal(float tarifamensal) {
		this.tarifamensal = tarifamensal;
	}
	
	
}
