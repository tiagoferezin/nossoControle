/**
 * 
 */
package nossoControle.util;

import java.io.Serializable;

/**
 * @author Tiago Ferezin ( Data: 07/10/2015 ); Funcionalidade da Classe:
 *
 */
public class NameValuePair implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String attribute;
	private Object value;

	public NameValuePair() {

	}

	public NameValuePair(String attribute, Object value) {
		super();
		this.attribute = attribute;
		this.value = value;
	}

	/**
	 * @return the atribute
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * @param atribute
	 *            the atribute to set
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}
