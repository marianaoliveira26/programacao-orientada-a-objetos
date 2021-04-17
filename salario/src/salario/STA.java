package salario;

public class STA extends Funcionario {
private int nivel;
	
	STA(String nome, int nivel) {
		super(nome, 1);
		this.nivel = nivel;
	}
	
	@Override
	public double calcSalario() {
		double valor = getQtd_diarias() * 100 + getBonus();
		valor += (3000 + (300 * nivel)); 
		return valor;
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
	
	@Override
	public String toString() {
		this.salario = calcSalario() + getBonus(); 
		return "\nSTA " + this.getNome() + ", nivel " + this.getNivel() + ", salario: " + this.getSalario();
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
