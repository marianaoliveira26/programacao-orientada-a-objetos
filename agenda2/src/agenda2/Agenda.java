package agenda2;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private ArrayList<Contact> contatos;
	
	public Agenda() {
		contatos = new ArrayList<Contact>(); 
	}

	@Override
	public String toString() {
		String s = "\n";
		for(int i = 0; i < contatos.size(); i++) {
			Contact c = contatos.get(i);
			s += c.toString();
		}
		return s;
	}

	public void addContact(String name, List<Fone> fones) {
		Contact cont = getContato(name);
		if(cont == null) { 
			cont = new Contact(name); 
			for(Fone f : fones){ 
				cont.addFone(f.getLabel(),f.getNumber()); 
			}
			contatos.add(cont); 
		} else { 
			for(Fone f : fones) { 
				cont.addFone(f.getLabel(), f.getNumber()); 
			}
		}
	}

	public boolean rmContact(String name) { 
		Contact contat = getContato(name); 
		if(contat == null) {
			System.out.println("o contato nao existe"); 
			return false;
		} 
		contatos.remove(contat);
		return true;
	}
	
	private int findContact(String name) {
		for(int i = 0 ; i < contatos.size(); i++){ 
			Contact c = contatos.get(i); 
			if(c.getName().equals(name)){
				return i;
			}
		}
		return -1;
	}
	
    public ArrayList<Contact> search(String label){ 
        ArrayList<Contact> pesquisar = new ArrayList<Contact>();
        for(Contact cont : contatos){
            if(cont.toString().indexOf(label) != -1) 
                pesquisar.add(cont); 
        }
		if(pesquisar.size() > 0)
			return pesquisar; 
        else
			return null; 
    }
    

	public Contact getContato(String nome) { 
		for(Contact c : contatos){ 
			if(nome.equals(c.getName())){ 
				return c;
			}
		}
		return null;
	}

	public void setContato(ArrayList<Contact> contato) {
		this.contatos = contato;
	}

	public void rmFone(String name, int index) { 
		Contact c = getContato(name); 
		if(c != null) 
			c.rmFone(name, index);
		else
			System.out.println("Contato não existente");
	}
}
