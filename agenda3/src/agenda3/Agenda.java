package agenda3;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private HashMap<String, Contact> contacts;
	private HashMap<String, Contact> bookmarks;
	
	public Agenda() {
		this.contacts = new HashMap<String, Contact>();
		this.bookmarks = new HashMap<String, Contact>();
	}
	
	public void addContact(String name, List<Fone> fones) {
		Contact c = contacts.get(name); 
		if(c==null){ 
			c=new Contact(name); 
			c.setFone(fones);
			contacts.put(name, c);
		}
		else {
			System.out.println("o contato: " +name + " já existe");
		}
	}	

	public void addContact(String name, String fone) {
		Contact contato = getContact(name); 
		if(contato == null) {
			contato = new Contact(name);
			contato.addFone(name, fone); 
		}
		else {
			contato.addFone(name, fone);
		}
	}
	
	public boolean rmContact(String name) { 
		Contact contato = getContact(name); 
		if(contato == null) { 
			System.out.println("o contato nao existe");
			return false;
		}else{ 
			contacts.remove(name); 
			if(contato.isStarred()) {
				bookmarks.remove(name); 
			}
			return true;
		}
	}
	
	Contact getContact(String name) { 
		for(String c : contacts.keySet()) { 
			if(c.equals(name)) { 
				return contacts.get(c); 
			}
		}
		return null; 
	}
	
	public void star(String name) { 
	
		Contact contato = contacts.get(name) ; 
		if(contato == null) {
			System.out.println("Fail:  contato " +name + " nao existe"); 
		}
		if(contato.isStarred() == false) { 
			contato.setStarred(true); 
			bookmarks.put(name, contato);
			return;
		}
		return;
	}
	
	public void unstar(String name) { 
		Contact contato = contacts.get(name); 
		if(contato == null) { 
			System.out.println("o contato nao existe");
			return;
		}
		if(contato.isStarred() == true) {
			contato.setStarred(false); 
			bookmarks.remove(name);
		}
	}
	
	public ArrayList<Contact> getStarred() { 
		ArrayList<Contact> l = new ArrayList<Contact>(); 
		for(String s : bookmarks.keySet()) { 
			Contact c = bookmarks.get(s); 
			l.add(c);
		}
		return l;
	}
	
	public HashMap<String, Contact> getContacts() {
		return contacts;
	}

	public void setContacts(HashMap<String, Contact> contacts) {
		this.contacts = contacts;
	}

	public HashMap<String, Contact> getBookmarks() {
		return bookmarks;
	}

	@Override
	public String toString() {
		String s = "\n";
		for(String k : contacts.keySet()){
			Contact c  = contacts.get(k);
			s+= c.toString()+"\n";
		}
		return s+"\n";
	}

}
