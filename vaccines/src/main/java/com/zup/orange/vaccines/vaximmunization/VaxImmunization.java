package com.zup.orange.vaccines.vaximmunization;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zup.orange.vaccines.user.User;
import com.zup.orange.vaccines.vaccine.Vaccine;

@Entity
public class VaxImmunization {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(name = "vaccineName", nullable = false, unique = true, columnDefinition = "TEXT")
//	@Size(max = 20)
//	private String vaccineName;
	
	@Column(name = "vaccinationDate", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vaccinationDate;
	
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	  private User user;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "vaccine_name")
    private Vaccine vaccine;

	public VaxImmunization() {
	}
	
	public VaxImmunization(LocalDate vaccinationDate, Vaccine vaccine) { //@Size(max = 15) String vaccineName, 
//		this.vaccineName = vaccineName;
		this.vaccinationDate = vaccinationDate;
//		this.user = user;
		this.vaccine = vaccine;
	}
	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getVaccineName() {
//		return vaccineName;
//	}
//
//	public void setVaccineName(String vaccineName) {
//		this.vaccineName = vaccineName;
//	}

	public LocalDate getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(LocalDate vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VaxImmunization other = (VaxImmunization) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}
