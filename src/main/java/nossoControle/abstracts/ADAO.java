/**
 * 
 */
package nossoControle.abstracts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nossoControle.control.EntityManagerControl;
import nossoControle.interfaces.IDAO;
import nossoControle.util.NameValuePair;

/**
 * @author Tiago Ferezin ( Data: 07/10/2015 ); Funcionalidade da Classe:
 *
 */
public abstract class ADAO<T> implements IDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	public void inserir() throws Exception {

		try {

			EntityManagerControl.transactionBegin(entityManager);
			entityManager.persist(this);
			EntityManagerControl.transactionCommit(entityManager);

		} catch (Exception e) {
			// TODO: handle exception
			EntityManagerControl.transactionRollback(entityManager);
			e.printStackTrace();
		} finally {

		}

	}

	public void alterar() throws Exception {

		T encontrada = (T) entityManager.find(this.getClass(), this.getId());

		try {

			EntityManagerControl.transactionBegin(entityManager);
			entityManager.merge(this);
			EntityManagerControl.transactionCommit(entityManager);

		} catch (Exception e) {
			// TODO: handle exception
			EntityManagerControl.transactionRollback(entityManager);
			e.printStackTrace();
		} finally {
			// manager.close();
		}

	}

	public void desativar() throws Exception {

		try {

			EntityManagerControl.transactionBegin(entityManager);
			entityManager.remove(entityManager.getReference(this.getClass(),
					this.getId()));
			EntityManagerControl.transactionCommit(entityManager);

		} catch (Exception e) {
			// TODO: handle exception
			EntityManagerControl.transactionRollback(entityManager);
			e.printStackTrace();
		} finally {

		}

	}

	public List<T> getLista() {
		List<T> lista = this.getLista("", null, 0, 999999, "", "");
		return (List<T>) lista;
	}

	public List<T> getLista(String where, List<NameValuePair> whereParameters,
			Integer initialRecord, Integer amountRecord, String orderColumn,
			String orderDirection) {
		List<T> list = new ArrayList<T>();

		try {
			EntityManagerControl.transactionBegin(entityManager);

			String hQl = "from " + this.getClass().getSimpleName() + " t ";

			if ((where != null) && (!where.trim().isEmpty())) {
				hQl += " where " + where;
			}

			String order = "";

			if ((orderColumn != null) && (!orderColumn.trim().isEmpty())) {
				order = " order by t." + orderColumn;

				if ((orderDirection != null)
						&& (!orderDirection.trim().isEmpty())) {
					order += " " + orderDirection;
				} else {
					order += " desc";
				}
			}

			hQl += order;

			System.out.println("HQL: ");
			System.out.println(hQl);

			Query query = entityManager.createQuery(hQl);

			if ((where != null) && (!where.trim().isEmpty())) {
				if (whereParameters != null) {
					for (NameValuePair par : whereParameters) {

						System.out.println("Set attribute: "
								+ par.getAttribute());
						query.setParameter(par.getAttribute(), par.getValue());
					}
				}
			}

			if (initialRecord > 0) {
				query.setFirstResult(initialRecord - 1);
			}

			if (amountRecord > 0) {
				query.setMaxResults(amountRecord);
			}

			list = query.getResultList();
			EntityManagerControl.transactionCommit(entityManager);

		} catch (Exception e) {
			// TODO: handle exception
			EntityManagerControl.transactionRollback(entityManager);
			throw e;

		} finally {

		}

		return list;

	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}