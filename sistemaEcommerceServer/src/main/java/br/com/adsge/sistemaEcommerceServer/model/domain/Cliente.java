/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adsge.sistemaEcommerceServer.model.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.adsge.sistemaEcommerceServer.util.exception.ValidacaoCampoException;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 12/03/2016
 *
 */
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7594025804225612015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_CLIENTE")
	private Integer codigo;

	@Column(name = "NM_CLIENTE", length = 255, nullable = false)
	private String nome;

	@Column(name = "EMAIL_CLIENTE", length = 255, nullable = false)
	private String email;

	public Cliente() {
		super();
	}

	public void validar() throws ValidacaoCampoException {
		if (nome == null || nome.equals("")) {
			throw new ValidacaoCampoException("Campo nome deve ser preenchido");
		}

		if (email == null || email.equals("")) {
			throw new ValidacaoCampoException("Campo e-mail deve ser preenchido");
		}

	}

	public Cliente(Integer codigo, String nome, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 97 * hash + Objects.hashCode(this.codigo);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Cliente other = (Cliente) obj;
		if (!Objects.equals(this.codigo, other.codigo)) {
			return false;
		}
		return true;
	}

}
