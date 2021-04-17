package agenda3;

import agenda3.Fone;

public class Fone {
	private String label, number;
	
	public Fone(String label, int number) {
		this.label = label; 
		this.number = Integer.toString(number);
	}

	public Fone(String label, String number) {
		this.label = label; 
		this.number = number;
	}
	
	public static boolean  validate(String number) { 
		String validacao = "0123456789"; 
		for(int v = 0; v < number.length(); v++) { 
			char c = number.charAt(v); 
			if(validacao.indexOf(c) == -1) {  
				System.out.println("Fone invalido"); 
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return this.label + ":" + this.number;
	}

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
}
