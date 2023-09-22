/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import enums.TipoGenero;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author kyamv
 */
@Entity
@Table(name = "tab_paciente")
public class Paciente implements Serializable{
    
    //ATRIBUTOS
    @Id
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", initialValue = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(length = 200, nullable = true)
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Enumerated(EnumType.STRING)
    private TipoGenero genero;
    @Column
    private String endereco;
    @Column
    private String numeroTelefone;
    @Column
    private String email;
    @OneToOne
    private Consulta consulta;
    
    //CONSTRUTORES

    public Paciente() {
    }

    public Paciente(Long id, String nome, Date dataNascimento, TipoGenero genero, String endereco, String numeroTelefone, String email, Consulta consulta) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
        this.consulta = consulta;
    }
    
    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoGenero getGenero() {
        return genero;
    }

    public void setGenero(TipoGenero genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    //EQUALS AND HASCHODES
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.dataNascimento);
        hash = 83 * hash + Objects.hashCode(this.genero);
        hash = 83 * hash + Objects.hashCode(this.endereco);
        hash = 83 * hash + Objects.hashCode(this.numeroTelefone);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.consulta);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.numeroTelefone, other.numeroTelefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.consulta, other.consulta)) {
            return false;
        }
        return this.genero == other.genero;
    }
    
    //TO STRING
    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", genero=" + genero + ", endereco=" + endereco + ", numeroTelefone=" + numeroTelefone + ", email=" + email + ", consulta=" + consulta + '}';
    }

}
