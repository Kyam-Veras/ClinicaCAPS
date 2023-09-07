/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import enums.TipoGenero;
import java.text.ParseException;
import javax.persistence.*;
import javax.swing.JOptionPane;
import modelo.Paciente;
import utilitario.JpaUtil;
import utilitario.DateUtil;

/**
 *
 * @author kyamv
 */
public class AtualizarPaciente {
    
    public static void main(String[] args) throws ParseException, InstantiationException {
        
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        
        int peso;
        peso = Integer.parseInt(JOptionPane.showInputDialog("1 - Atualizar o nome do paciente, 2 - Atualizar a data de nascimento do paciente, 3 - Atualizar o genero do paciente"));
        
        switch (peso) {
            case 1 ->                 {
                    Paciente p = em.find(Paciente.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id para a atualização")));
                    p.setNome(JOptionPane.showInputDialog("Digite o nome atualizado"));
                    em.merge(p);
                }
            case 2 -> {
                    Paciente p = em.find(Paciente.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id para a atualização")));
                    p.setDataNascimento(DateUtil.StringToDate(JOptionPane.showInputDialog("Digite a data de nascimento atualizada")));
                    em.merge(p);
            }
            case 3 ->                 {
                    Paciente p = em.find(Paciente.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id para a atualização")));
                    p.setGenero(TipoGenero.valueOf(JOptionPane.showInputDialog("Digite o genero atualizado")));
                    em.merge(p);
                }
            default -> {
                JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1, 2, 3, 4)*");
            }
        }
        
        em.getTransaction().commit();
        JpaUtil.fecharConexao();
        
    }
    
}
