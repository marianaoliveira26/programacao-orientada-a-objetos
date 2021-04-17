package hospital;

import java.util.Collection;
import java.util.HashMap;

public class Paciente implements IPaciente{
	
	private String id, diagnostico; 
	private HashMap<String, IMedico> medicos;
	
	Paciente(String id, String diagnostico) {
		this.id = id;
		this.diagnostico = diagnostico;
		medicos = new HashMap<String, IMedico>();
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void addMedico(IMedico medico) {
		medicos.put(medico.getId(), medico);
	}

	@Override
	public void removerMedico(String idMedico) {
		IMedico medico = medicos.get(idMedico);
		if(medico == null) {
			System.out.println("Esse medico nao existe");
			return;	
		}
		else {
			medicos.remove(idMedico);
			medico.removerPaciente(getId()); 
			return;
		}
	}
	
	public String toString() {
		String s = "";
		s += "Paciente: " + this.id + ", doenca: " + this.diagnostico + ", medicos: [";
		for(IMedico medico : medicos.values()) {
			s += medico.getId() + " ";
		}
		return s +"]";
	}

	@Override
	public String getDiagnostico() {
		return diagnostico;
	}

	@Override
	public Collection<IMedico> getMedicos() {
		return medicos.values();
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

}
