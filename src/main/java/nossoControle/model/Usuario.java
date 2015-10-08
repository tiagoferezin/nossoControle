/**
 * 
 */
package nossoControle.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import nossoControle.abstracts.ADAO;

/**
 * @author Tiago Ferezin ( Data: 07/10/2015 );
 * Funcionalidade da Classe:
 *
 */
@Entity
public class Usuario extends ADAO<Usuario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	@Column(columnDefinition = "text")
	private String username;
	@Column(columnDefinition = "text")
	private String senha;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "pessoaUsuario", joinColumns = { @JoinColumn(name = "idUsuario", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "idPessoa", referencedColumnName = "id") })
	private Pessoa pessoa;
	
	public Usuario() {
		// super();
	}

	/**
	 * @return the idUsuario
	 */
	@Override
	public Long getId() {
		return idUsuario;
	}

	/**
	 * @param idUsuario
	 *            the idUsuario to set
	 */
	@Override
	public void setId(Long id) {
		this.idUsuario = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa
	 *            the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}

