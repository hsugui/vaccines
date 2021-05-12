package com.zup.orange.vaccines.vaccination;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.zup.orange.vaccines.user.User;

@Entity
public class Vaccination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vaccineName", nullable = false, columnDefinition = "TEXT")
	@Size(max = 15)
	private String vaccineName;
	@Column(name = "userEmail", nullable = false, columnDefinition = "TEXT")
	@Size(max = 50)
	private String userEmail;
	@Column(name = "vaccinationDate", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vaccinationDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false) //LAZY for better performance
	@JoinColumn(name = "user_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private User user;

	public Vaccination() {
	}

	public Vaccination(String vaccineName, String userEmail, LocalDate vaccinationDate) {
		this.vaccineName = vaccineName;
		this.userEmail = userEmail;
		this.vaccinationDate = vaccinationDate;
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

	public LocalDate getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(LocalDate vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
