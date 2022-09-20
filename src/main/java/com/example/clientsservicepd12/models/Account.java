package com.example.clientsservicepd12.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int amount;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
	private Set<Client> clients;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return amount == account.amount && Objects.equals(id, account.id) && Objects.equals(clients,
			account.clients);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, amount, clients);
	}

	@Override
	public String toString() {
		return String.format(
			"Account{id=%s, amount=%s}",
			id, amount
		);
	}
}
