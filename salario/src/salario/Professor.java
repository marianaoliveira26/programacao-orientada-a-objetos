package salario;

public class Professor extends Funcionario {
	private char classe;
	
	Professor(String nome, char classe) {/
		super(nome, 2);
		this.classe = classe;
 	}
	
	@Override
	public double calcSalario() {
		double valor = getQtd_diarias() * 100 + getBonus();
		valor += ((classe - 'A') * 2000) + 3000;
		return this.salario = valor;
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
		return "Professor " +this.getNome() + ", classe " + this.classe + ", salario: " + this.getSalario();
	}
	
	public char getClasse() {
		return classe;
	}

	public void setClasse(char classe) {
		this.classe = classe;
	}
}
