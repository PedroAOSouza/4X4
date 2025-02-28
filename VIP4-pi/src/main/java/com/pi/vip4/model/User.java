package com.pi.vip4.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;


@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Column(name = "nome", nullable = false)
  private String nome;

  @NotNull
  @Column(name = "cpf", nullable = false, unique = true)
  @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos")
  private String cpf;

  @NotNull
  @Email
  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @NotNull
  @Column(name = "senha", nullable = false)
  private String senha;

  public enum Tipo {
    ADMIN,
    ESTOQUISTA;
  }

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo", nullable = false)
  private Tipo tipo; // Alterado para Tipo (enum) em vez de String

  @Column(name = "status", nullable = false)
  private boolean status; // Ativo ou inativo

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "criadoEm", nullable = false)
  private Date criadoEm;

  // Getters and Setters
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Tipo getTipo() {
    return tipo; // Retorna o Tipo (enum)
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo; // Agora aceita um Tipo (enum) diretamente
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Date getCriadoEm() {
    return criadoEm;
  }

  public void setCriadoEm(Date criadoEm) {
    this.criadoEm = criadoEm;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", cpf='" + cpf + '\'' +
        ", email='" + email + '\'' +
        ", tipo=" + tipo +
        ", status=" + status +
        ", criadoEm=" + criadoEm +
        '}';
  }
}
