/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import java.util.List;
import javax.persistence.*;
import modelo.Paciente;
import utilitario.JpaUtil;

/**
 *
 * @author kyamv
 */
public class ConsultarPaciente {
    
    public static void main(String[] args) {
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        
        String consulta = "select p from Paciente p";
        List<Paciente> pacientes = em.createQuery(consulta).getResultList();
        System.out.println(pacientes);
        
        em.getTransaction().commit();
        JpaUtil.fecharConexao();
    }
    
}
