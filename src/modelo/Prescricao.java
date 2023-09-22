/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author kyamv
 */
@Entity
@Table(name = "tab_prescricao")
public class Prescricao implements Serializable {

    //ATRIBUTOS
    @Id
    @SequenceGenerator(name = "seq_prescricao", sequenceName = "seq_prescricao")
    @GeneratedValue(generator = "seq_prescricao", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column
    private String medicamento;
    @Column
    private String dosagem;
    @Column
    private String instrucaoDeUso;
    @Temporal(TemporalType.DATE)
    private Date dataPrescricao;
    
    //CONSTRUTORES
    public Prescricao() {
        this.dataPrescricao = new Date();
    }

    public Prescricao(Long id, String medicamento, String dosagem, String instrucaoDeUso, Date dataPrescricao) {
        this.id = id;
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.instrucaoDeUso = instrucaoDeUso;
        this.dataPrescricao = dataPrescricao;
    }

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getInstrucaoDeUso() {
        return instrucaoDeUso;
    }

    public void setInstrucaoDeUso(String instrucaoDeUso) {
        this.instrucaoDeUso = instrucaoDeUso;
    }

    public Date getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(Date dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }
    
    //EQUALS AND HASCODES
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.medicamento);
        hash = 97 * hash + Objects.hashCode(this.dosagem);
        hash = 97 * hash + Objects.hashCode(this.instrucaoDeUso);
        hash = 97 * hash + Objects.hashCode(this.dataPrescricao);
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
        final Prescricao other = (Prescricao) obj;
        if (!Objects.equals(this.medicamento, other.medicamento)) {
            return false;
        }
        if (!Objects.equals(this.dosagem, other.dosagem)) {
            return false;
        }
        if (!Objects.equals(this.instrucaoDeUso, other.instrucaoDeUso)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.dataPrescricao, other.dataPrescricao);
    }
    
    //TO STRING
    @Override
    public String toString() {
        return "Prescricao{" + "id=" + id + ", medicamento=" + medicamento + ", dosagem=" + dosagem + ", instrucaoDeUso=" + instrucaoDeUso + ", dataPrescricao=" + dataPrescricao + '}';
    }
    
    
}
