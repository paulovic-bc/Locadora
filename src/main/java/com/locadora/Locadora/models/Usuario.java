package com.locadora.Locadora.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "TB_Usuario")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public long id;

	@Column(name = "CPF", nullable = false)
	@NotBlank
	@NotEmpty
	public String cpf_usuario;

	@Column(name = "Telefone", nullable = false)
	@NotBlank
	@NotEmpty
	public String telefone_usuario;

	@Column(name = "email", nullable = false)
	@NotBlank
	@NotEmpty
	public String email;

	@Column(name = "Senha", nullable = false)
	@NotBlank
	@NotEmpty
	public String senha_usuario;

	@Column(name = "Perfil", nullable = false)
	@NotBlank
	@NotEmpty
	public String perfil_usuario;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();

	@ManyToOne
	public Idioma idioma;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.perfis;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha_usuario;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
