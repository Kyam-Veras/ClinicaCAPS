/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author kyamv
 */
@Entity
@Table(name = "tab_consulta")
public class Consulta implements Serializable {

    //ATRIBUTOS
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta", initialValue = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataConsulta;
    @Column
    private String descricao;
    @Column
    private String Resultados;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Prescricao> prescricoes;
    
    //CONSTRUTORES
    public Consulta() {
        this.dataConsulta = new Date();
    }

    public Consulta(Long id, Date dataConsulta, String descricao, String Resultados, List<Prescricao> prescricoes) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.descricao = descricao;
        this.Resultados = Resultados;
        this.prescricoes = prescricoes;
    }

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResultados() {
        return Resultados;
    }

    public void setResultados(String Resultados) {
        this.Resultados = Resultados;
    }

    public List<Prescricao> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(List<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }
    
    //EQUALS AND HASHCODES
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.dataConsulta);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.Resultados);
        hash = 79 * hash + Objects.hashCode(this.prescricoes);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.Resultados, other.Resultados)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataConsulta, other.dataConsulta)) {
            return false;
        }
        return Objects.equals(this.prescricoes, other.prescricoes);
    }
    

    //TO STRING
    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", dataConsulta=" + dataConsulta + ", descricao=" + descricao + ", Resultados=" + Resultados + ", prescricoes=" + prescricoes + '}';
    }
    
    
}
