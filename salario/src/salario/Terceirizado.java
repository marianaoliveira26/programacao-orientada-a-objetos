package salario;

public class Terceirizado  extends Funcionario{
	private int horas_trab;
	private boolean insalubre;
	
	Terceirizado(String nome, int horas_trab, boolean insalubre) {
		super(nome, 0);
		this.horas_trab = horas_trab;
		this.insalubre = insalubre;
	}
	
	@Override
	public double calcSalario() {
		this.setSalario(4 * this.getHoras_trab());
		if(this.insalubre == true) {
			this.setSalario(this.getSalario() + 500 + this.getBonus());
		}
		return this.getSalario();
	}
	
	public void adicionarDiaria() {
		System.out.println("\nfail: terceirizado nao pode receber diaria");
	}
	
	public void adicionarBonus(double bonus) {
		this.setSalario(this.getSalario() + bonus );
	}
	
	public String toString() {
		this.salario = calcSalario() + getBonus();
		return "\nTerceirizado " + this.getNome() + ", horas trabalhadas " + this.getHoras_trab() + ", insalubre? "
			+ this.isInsalubre() + ", salario: " + this.getSalario();
	}

	public int getHoras_trab() {
		return horas_trab;
	}
	public void setHoras_trab(int horas_trab) {
		this.horas_trab = horas_trab;
	}
	public boolean isInsalubre() {
		return insalubre;
	}
	public void setInsalubre(boolean insalubre) {
		this.insalubre = insalubre;
	}
}
