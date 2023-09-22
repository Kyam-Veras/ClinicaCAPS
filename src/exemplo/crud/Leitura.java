/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modelo.Consulta;
import modelo.Paciente;
import modelo.Prescricao;
import utilitario.JpaUtil;

/**
 *
 * @author kyamv
 */
public class Leitura {
    public static void main(String[] args) {
        
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        
        int peso;
        peso = Integer.parseInt(JOptionPane.showInputDialog("""
                Digite um dos números à seguir:
                1 - Listar Paciente
                2 - Listar Consulta
                3 - Listar Prescricao
            """));
        
        switch (peso) {
            //PACIENTE
            case 1 -> {
                
                String leitura = "select p from Paciente p";
                List<Paciente> pacientes = em.createQuery(leitura).getResultList();
                System.out.println(pacientes);
                
            }
            //CONSULTA
            case 2 -> {
                
                String leitura = "select c from Consulta c";
                List<Consulta> consultas = em.createQuery(leitura).getResultList();
                System.out.println(consultas);
                
            }
            //PRESCRIÇÃO
            case 3 -> {
                
                String leitura = "select prescricao from Prescricao prescricao";
                List<Prescricao> prescricoes = em.createQuery(leitura).getResultList();
                System.out.println(prescricoes);
                
            }
            default -> {
                JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1, 2, 3)*");
            }
        }
        
        em.getTransaction().commit();
        JpaUtil.fecharConexao();
        
    }
}
