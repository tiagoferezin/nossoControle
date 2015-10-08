/**
 * 
 */
package nossoControle.factory;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.EntityManager;

import nossoControle.enumerator.ETipoAuditoria;
import nossoControle.model.Auditoria;

/**
 * @author Tiago Ferezin ( Data: 07/10/2015 ); Funcionalidade da Classe:
 *
 */
public class AuditoriaFactory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Auditoria getAuditoria(EntityManager entityManager) {

		Auditoria auditoria = new Auditoria();
		auditoria.setEntityManager(entityManager);
		auditoria.setDataOcorrencia(Calendar.getInstance());
		auditoria.setTipoAuditoria(ETipoAuditoria.Processo);
		return auditoria;

	}

}
