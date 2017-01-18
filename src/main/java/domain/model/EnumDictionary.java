package domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@NamedQueries({
	@NamedQuery(name = "enumDictionary.all", query = "Select e from EnumDictionary e"),
	@NamedQuery(name = "enumDictionary.name", query = "Select e from EnumDictionary e where e.enumName = name"),
	@NamedQuery(name = "enumDictionary.id", query = "Select e from EnumDictionary e where e.id = id")
})
public class EnumDictionary implements IHaveId {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int intKey;
	private String stringKey;
	private String value;
	private String enumName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIntKey() {
		return intKey;
	}
	public void setIntKey(int intKey) {
		this.intKey = intKey;
	}
	public String getStringKey() {
		return stringKey;
	}
	public void setStringKey(String stringKey) {
		this.stringKey = stringKey;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getEnumName() {
		return enumName;
	}
	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}
}

	
	


