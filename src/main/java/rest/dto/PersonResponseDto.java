package rest.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonResponseDto {

	private List<PersonDto> result;

	
	
	public PersonResponseDto(List<PersonDto> result) {
		super();
		this.result = result;
	}

	public List<PersonDto> getResult() {
		return result;
	}

	public void setResult(List<PersonDto> result) {
		this.result = result;
	}

	
	
	
}
