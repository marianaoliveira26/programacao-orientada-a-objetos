package hospital;

import java.util.Collection;

public interface IPaciente {
	String getId();
	void addMedico(IMedico medico);
	void removerMedico(String idMedico);
	String getDiagnostico();
	Collection<IMedico> getMedicos();
}
