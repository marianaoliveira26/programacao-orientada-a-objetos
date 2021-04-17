package agenda2;

public class Fone {
	public String label, number;
	
	public static boolean validate(String number) { 
		String validacao = "0123456789"; 
		for(int v = 0; v < number.length(); v++) { 
			char c = number.charAt(v); 
			if(validacao.indexOf(c) == -1) {  
				System.out.println("fail: fone invalido"); 
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return this.label + ":" + this.number;
	}

	public Fone(String label, String number) {
		this.label = label;
		this.number = number;
	}
	public Fone(String label, int number) {
		this.label = label;
		this.number = Integer.toString(number);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
