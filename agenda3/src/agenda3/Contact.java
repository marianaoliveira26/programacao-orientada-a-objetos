package agenda3;

import agenda3.Fone;
import java.util.ArrayList;
import java.util.List;

public class Contact {
	private String name;
	private boolean starred;
	private ArrayList<Fone> fones;
	
	[ 
	public Contact(String name) { 
		this.name = name;
		this.starred = false;
		this.fones = new ArrayList<Fone>(); 
	}
	
	public void addFone(String label, String number) { 
		Fone f = new Fone(label, number); 
		if(Fone.validate(number) == false) { 
			System.out.println("numero invalido"); 
		}
		else {
			this.fones.add(f); 
		}
	}
	
	public void rmFone(int index) { 
		for(int i =0; i < fones.size(); i++) { 
			if(i == index) { 
				this.fones.remove(index);
			}
			else {
				System.out.println("esse fone nao exitse"); 
			}
		}
	}
	
	public void setBookmark(boolean value) {
		this.starred = value;
	}
	
	@Override
	public String toString() {
		String resul = ""; 
		if(this.isStarred()) { 
			resul += "@ " +this.name;
		}
		else {// senoa
			resul += "- " + this.name;
		}
		if(fones.size() > 0) {
			for(int i = 0; i < fones.size(); i++) {
				resul += "["+ i + ":" +this.fones.get(i).toString() + "]";
			}
		}
		return resul;
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean isStarred() {
		return starred;
	}
	
	public void setStarred(boolean starred) {
		this.starred = starred;
	}
	
	public ArrayList<Fone> getFone() {
		return fones;
	}
	
	public void setFone(List<Fone> fone) {
		for(Fone f : fone  ){
			this.fones.add(f);
		}
		
	}
}
