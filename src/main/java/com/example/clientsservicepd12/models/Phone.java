package com.example.clientsservicepd12.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "phones")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 20, unique = true)
	private String phone;
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Phone phone1 = (Phone) o;
		return Objects.equals(id, phone1.id) && Objects.equals(phone, phone1.phone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, phone);
	}

	@Override
	public String toString() {
		return String.format(
			"Phone{id=%s, phone=%s}",
			id, phone
		);
	}
}
