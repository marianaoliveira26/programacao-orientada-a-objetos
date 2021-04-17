package salario;

public abstract class Funcionario {
	protected String nome;
	protected int max_diarias; 
	protected int qtd_diarias; 
	protected double bonus; 
	protected double salario;
	
	Funcionario(String nome, int max_diarias) { 
		this.nome = nome;
		this.max_diarias = max_diarias;
		this.qtd_diarias = 0;
		this.bonus = 0;
		this.salario = 0;
	}

	public void adicionarDiaria() { 
		if(this.getQtd_diarias() <= this.getMax_diarias()) { 
			this.setSalario(this.getSalario() + 100); 
			qtd_diarias++; 
		}
		else {
			System.out.println("Limite de diarias atigindas");
		}
	}
	
	public void adicionarBonus(double bonus) {
		this.setSalario(this.getSalario() + bonus ); 
	}
	
	abstract double calcSalario();

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMax_diarias() {
		return max_diarias;
	}
	public void setMax_diarias(int max_diarias) {
		this.max_diarias = max_diarias;
	}
	public int getQtd_diarias() {
		return qtd_diarias;
	}
	public void setQtd_diarias(int qtd_diarias) {
		this.qtd_diarias = qtd_diarias;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
