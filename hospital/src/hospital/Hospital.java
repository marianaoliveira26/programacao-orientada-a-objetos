package hospital;

import java.util.HashMap;

public class Hospital {
	private HashMap<String, IPaciente> pacientes;
	private HashMap<String, IMedico> medicos;
	
	Hospital(){
		pacientes = new HashMap<String, IPaciente>();
		medicos = new HashMap<String, IMedico>();
	}
	
	public void removerPaciente(String id) {
		IPaciente paciente = pacientes.get(id);
		if(paciente == null) {
			System.out.println("Paciente nao existe");
			return;
		}
		for(IMedico medico : paciente.getMedicos()) {
			pacientes.remove(id);
			medico.removerPaciente(id);
			return;
		}
	}
	
	public void removerMedico(String id) {
		IMedico medico = medicos.get(id);
		if(medico == null) {
			System.out.println("Esse medico nao existe");
			return;
		}
		for(IPaciente paciente : medico.getPaciente()) {
			paciente.removerMedico(id);
			medicos.remove(id);
			return;
		}
	}
	
	public void addPaciente(Paciente paciente) {
		pacientes.put(paciente.getId(), (IPaciente) paciente);
	}
	
	public void addMedico(Medico medico) {
		medicos.put(medico.getId(), (IMedico) medico);
	}
	
	public void vincular(String nomeMedico, String nomePaciente) { 
		IMedico medico = medicos.get(nomeMedico);
		IPaciente paciente = pacientes.get(nomePaciente);
		
		if(medico == null) {
			System.out.println("Esse medico nao existe");
			return;
		}
		else if(paciente == null) {
			System.out.println("Esse paciente nao existe \n");
			return;
		}
		else {
			pacientes.get(nomePaciente).addMedico(medico);
			medicos.get(nomeMedico).addPaciente(paciente);
		}
	}
	
	public void showAll() {
		for(IMedico medico : medicos.values()) {
			System.out.println(medico.toString());
		for(IPaciente paciente : pacientes.values()) {
			System.out.println(paciente.toString());
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for(IPaciente paciente : pacientes.values()) {
			s += paciente.toString() + " \n";
		}
		for(IMedico medico : medicos.values()) {
			s += medico.toString() + " \n";
		}
		
		return s;
	}

	public HashMap<String, IPaciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(HashMap<String, IPaciente> pacientes) {
		this.pacientes = pacientes;
	}
	public HashMap<String, IMedico> getMedicos() {
		return medicos;
	}
	public void setMedicos(HashMap<String, IMedico> medicos) {
		this.medicos = medicos;
	}
}
