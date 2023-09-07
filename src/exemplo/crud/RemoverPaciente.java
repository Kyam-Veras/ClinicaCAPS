/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import javax.persistence.*;
import javax.swing.JOptionPane;
import modelo.Paciente;
import utilitario.JpaUtil;

/**
 *
 * @author kyamv
 */
public class RemoverPaciente {
    
    public static void main(String[] args) {
        
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        
        Paciente p = em.find(Paciente.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id de remoção")));
        em.remove(p);
        
        em.getTransaction().commit();
        JpaUtil.fecharConexao();
        
    }
    
}
