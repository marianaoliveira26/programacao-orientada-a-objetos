package hospital;

import java.util.HashMap;
import java.util.Collection;

public class Medico implements IMedico {
	
	private String id, especialidade; 
	private HashMap<String, IPaciente> pacientes; 

	Medico(String id, String especialidade) { 
		this.id = id;
		this.especialidade = especialidade;
		pacientes = new HashMap<String, IPaciente>(); 
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void addPaciente(IPaciente paciente) { 
		pacientes.put(paciente.getId(),(IPaciente) paciente); 
	}

	@Override
	public void removerPaciente(String idPaciente) { 
		IPaciente paciente = pacientes.get(idPaciente); 
		if(paciente == null) { 
			System.out.println("Paciente nao existe");
			return;
		}
		else {//senao
			pacientes.remove(idPaciente); 
			pacientes.remove(getId());
			return;
		}
	}

	@Override
	public String getClasse() {
		return null;
	}
	
	public String toString() {
		String s = "";
		s += "Medico: " + this.id + ", epecialidade: " + this.especialidade + ", pacientes: [";
		for(IPaciente paciente : pacientes.values()) {/ pacientes
			s += paciente.getId() +  " ";
		}
		return s + "]";
	}
	
	public Collection<IPaciente> getPacientes() {
		return pacientes.values();
	}
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<String, IPaciente> getPacientes1() {
		return pacientes;
	}

	public void setPacientes(HashMap<String, IPaciente> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public Collection<IPaciente> getPaciente() {
		return pacientes.values();
	}
}
