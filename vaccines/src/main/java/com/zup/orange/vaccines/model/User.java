package com.zup.orange.vaccines.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = true, columnDefinition = "TEXT")
	@Size(max = 50)
	private String name;
	
	@Column(name = "email", nullable = true, unique = true, columnDefinition = "TEXT")
	@Size(max = 50)
	private String email;
	
	@Column(name = "cpf", nullable = false, unique = true, columnDefinition = "TEXT")
	@Size(min = 11, max = 14)
	private String cpf;
	
	@Column(name = "birthDate", nullable = true)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;
	
	@JsonIgnoreProperties("user")
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<VaxImmunization> vaxImmunizations;

	public User() {
	}

	public User(String name, String email, String cpf, LocalDate birthDate) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
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
		User other = (User) obj;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<VaxImmunization> getVaxImmunizations() {
		return vaxImmunizations;
	}

	public void setVaxImmunizations(List<VaxImmunization> vaxImmunizations) {
		this.vaxImmunizations = vaxImmunizations;
		for (VaxImmunization v : vaxImmunizations) v.setUser(this);
	}
	
}
