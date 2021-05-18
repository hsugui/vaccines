package com.zup.orange.vaccines.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vaccineName", nullable = false, unique = true, columnDefinition = "TEXT")
	@Size(max = 15)
	private String vaccineName;
	
	@JsonIgnoreProperties("vaccine")
	@OneToMany(mappedBy = "vaccine", cascade = CascadeType.ALL)
	private List<VaxImmunization> vaxImmunizations;

	public Vaccine() {
	}

	public Vaccine(String vaccineName, List<VaxImmunization> vaxImmunizations) {
		this.vaccineName = vaccineName;
		this.vaxImmunizations = vaxImmunizations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaccine other = (Vaccine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public List<VaxImmunization> getVaxImmunizations() {
		return vaxImmunizations;
	}

	public void setVaxImmunizations(List<VaxImmunization> vaxImmunizations) {
		this.vaxImmunizations = vaxImmunizations;
		for (VaxImmunization v : vaxImmunizations) v.setVaccine(this);
	}

}
