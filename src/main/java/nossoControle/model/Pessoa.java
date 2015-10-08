/**
 * 
 */
package nossoControle.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Tiago Ferezin ( Data: 07/10/2015 ); Funcionalidade da Classe:
 *
 */
@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;

	@Column(nullable = false, columnDefinition = "text")
	private String nomeCompleto;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "pessoaUsuario", joinColumns = { @JoinColumn(name = "idPessoa", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "idUsuario", referencedColumnName = "id") })
	private Usuario usuario;

	@Column(nullable = false)
	private Integer cotasAtivas;

	@Column(nullable = false)
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataNascimento;

	@Column(columnDefinition = "text")
	private String endereco;// AQUI JA VEM O LOGRADOURO, NUMERO E BAIRRO E
							// COMPLEMENTOS

	private String cep;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

}
