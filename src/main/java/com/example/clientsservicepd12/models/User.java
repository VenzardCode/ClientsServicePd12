package com.example.clientsservicepd12.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "users")
public class User {
	public enum Status {
		BLOCKED, ACTIVE, DELETED
	}

	public enum Role implements GrantedAuthority {
		USER, ADMIN;

		@Override
		public String getAuthority() {
			return name();
		}

		public static Collection<GrantedAuthority> authorities() {
			return List.of(values());
		}
	}

	{
		status = Status.ACTIVE;
		role = Role.USER;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 32, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, length = 64, unique = true)
	private String mail;
	@Column(nullable = false)
	private Status status;
	@Column(nullable = false)
	private Role role;

	{
		//status = Status.BLOCKED;
		status = Status.ACTIVE;
		role = Role.USER;
	}
}
