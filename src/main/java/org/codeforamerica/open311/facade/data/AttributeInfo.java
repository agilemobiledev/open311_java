package org.codeforamerica.open311.facade.data;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Represents a single attribute of a service definition.
 * 
 * @author Santiago Munín <santimunin@gmail.com>
 * 
 */
public class AttributeInfo implements Serializable {

	private static final long serialVersionUID = -6704474615491645869L;
	private boolean variable;
	private String code;
	private Datatype datatype;
	private boolean required;
	private String datatypeDescription;
	private int order;
	private String description;
	/**
	 * Pair key, name. Check the attribute section of the <a
	 * href="http://wiki.open311.org/GeoReport_v2#GET_Service_Definition"
	 * >Service Definition</a>.
	 */
	private Map<String, String> values;

	/**
	 * Creates an attribute object using the given parameters.
	 * 
	 * @param variable
	 * @param code
	 * @param datatype
	 * @param required
	 * @param datatypeDescription
	 * @param order
	 * @param description
	 * @param values
	 */
	public AttributeInfo(boolean variable, String code, Datatype datatype,
			boolean required, String datatypeDescription, int order,
			String description, Map<String, String> values) {
		super();
		this.variable = variable;
		this.code = code;
		this.datatype = datatype;
		this.required = required;
		this.datatypeDescription = datatypeDescription;
		this.order = order;
		this.description = description;
		this.values = values;
	}

	public boolean isVariable() {
		return variable;
	}

	public String getCode() {
		return code;
	}

	public Datatype getDatatype() {
		return datatype;
	}

	public int getOrder() {
		return order;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, String> getValues() {
		return values;
	}

	public boolean isRequired() {
		return required;
	}

	public String getDatatypeDescription() {
		return datatypeDescription;
	}

	/**
	 * Returns a string of the form <code>ATTRIBUTE[key1][key2]...[keyN]=value1,
	 * value2,...valueN</code>.
	 */
	public String toString() {
		StringBuilder strBuilder = new StringBuilder("code: " + code + "\n");
		strBuilder.append("values: ");
		for (Entry<String, String> pair : values.entrySet()) {
			strBuilder.append("\n");
			strBuilder.append("\t" + pair.getKey() + " -> " + pair.getValue());
		}
		return strBuilder.toString();
	}

	public static enum Datatype {
		STRING, NUMBER, DATETIME, TEXT, SINGLEVALUELIST, MULTIVALUELIST;

		/**
		 * Returns an instance of this class from a given string.
		 * 
		 * @param datatype
		 *            String representation of the datatype.
		 * @return <code>null</code> if the string is not one of the contained
		 *         types.
		 */
		public static Datatype getFromString(String datatype) {
			if (datatype.toLowerCase().equals("string")) {
				return STRING;
			}
			if (datatype.toLowerCase().equals("number")) {
				return NUMBER;
			}
			if (datatype.toLowerCase().equals("datetime")) {
				return DATETIME;
			}
			if (datatype.toLowerCase().equals("text")) {
				return TEXT;
			}
			if (datatype.toLowerCase().equals("singlevaluelist")) {
				return SINGLEVALUELIST;
			}
			if (datatype.toLowerCase().equals("multivaluelist")) {
				return MULTIVALUELIST;
			}
			return null;
		}
	}
}
