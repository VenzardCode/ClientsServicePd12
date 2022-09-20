package com.example.clientsservicepd12.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "clients")
public class Client {
	public enum Gender {
		NONE, MALE, FEMALE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 50)
	private String surname;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false, length = 50)
	private String patronymic;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private LocalDate birthDate;
	@Column
	private Gender gender;
	@Column(nullable = false, length = 50, unique = true)
	private String email;
	//@Column(nullable = false, length = 50, unique = true)
	//private String phone;
	@OneToMany(mappedBy = "client",
		fetch = FetchType.EAGER
	)
	private Set<Phone> phones;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "clients_accounts",
		joinColumns = @JoinColumn(
			name = "client_id",
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "clientKey", value = ConstraintMode.CONSTRAINT)
		),
		inverseJoinColumns = @JoinColumn(
			name = "account_id",
			referencedColumnName = "id"
		)
	)
	private Set<Account> accounts;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Client client = (Client) o;
		return Objects.equals(id, client.id) && Objects.equals(surname, client.surname) && Objects.equals(name, client.name) && Objects.equals(patronymic, client.patronymic) && Objects.equals(birthDate, client.birthDate) && gender == client.gender && Objects.equals(email, client.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, surname, name, patronymic, birthDate, gender, email);
	}

	@Override
	public String toString() {
		return String.format(
			"Client{id=%s, surname=%s, name=%s, patronymic=%s, birthDate=%s, gender=%s, email=%s}",
			id, surname, name, patronymic, birthDate, gender, email
		);
	}
}

