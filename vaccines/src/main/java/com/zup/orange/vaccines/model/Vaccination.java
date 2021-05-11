package com.zup.orange.vaccines.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Vaccination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vaccineName", nullable = false) //columnDefinition = "TEXT")
	@Size(max = 15)
	private String vaccineName;
	@Column(name = "userEmail", nullable = false, unique = true) //columnDefinition = "TEXT"
	@Size(max = 50)
	private String userEmail;
	@Column(name = "vaccinationDate", nullable = false)
	private Timestamp vaccinationDate;
	
	private Long userId;

	public Vaccination() {
	}

	public Vaccination(String vaccineName, String userEmail, Timestamp vaccinationDate, Long userId) {
		this.vaccineName = vaccineName;
		this.userEmail = userEmail;
		this.vaccinationDate = vaccinationDate;
		this.userId = userId;
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
		Vaccination other = (Vaccination) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Timestamp getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Timestamp vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

}
