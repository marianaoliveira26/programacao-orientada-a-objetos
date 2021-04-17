package salario;

import java.util.ArrayList;

public class Universidade {
	private ArrayList<Funcionario> funcionarios;
	
	Universidade() {
		funcionarios = new ArrayList<>(); 
	}
	
	public void addFuncionario(Funcionario funcionario) { 
		funcionarios.add(funcionario);
	}
	
	public void removerFuncionario(String nome) {
		for(Funcionario f : funcionarios) {
			if(f.getNome() == null) {
				System.out.println("Funcionario nao existe");
				return;
			}
			else if(f.getNome().equals(nome)){
				funcionarios.remove(f);
				return;
			}
		}
	}
	
	public void distribuirBonus(float valor) {/
		double total = valor/(funcionarios.size()); 

		for(Funcionario f : funcionarios) {
			f.adicionarBonus(total);
		}
	}

	public String toString() {
		String s = "";
		for(Funcionario f: funcionarios) {
			s += f.toString() + "\n";
		}
		return s;
	}
	
	//set e get
	public ArrayList<Funcionario> getFuncionario() {
		return funcionarios;
	}

	public void setFuncionario(ArrayList<Funcionario> funcionario) {
		this.funcionarios = funcionario;
	}
}
