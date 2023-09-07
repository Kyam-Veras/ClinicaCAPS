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
import utilitario.DateUtil;
import utilitario.JpaUtil;

/**
 *
 * @author kyamv
 */
public class CadastrarPaciente {
    
    public static void main(String[] args) throws ParseException {
        
//        Paciente p1 = new Paciente("Ricardo", DateUtil.StringToDate("11/11/1999"), TipoGenero.Masculino);
//        Paciente p2 = new Paciente("Sara", DateUtil.StringToDate("25/02/2000"), TipoGenero.Feminino);
//        Paciente p3 = new Paciente("Roberta", DateUtil.StringToDate("10/02/2005"), TipoGenero.Feminino);
//        Paciente p4 = new Paciente("Clarice", DateUtil.StringToDate("22/08/2002"), TipoGenero.Feminino);
//        Paciente p5 = new Paciente("Felipe", DateUtil.StringToDate("20/03/2002"), TipoGenero.Masculino);

        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();

        Paciente p1 = new Paciente();
        p1.setNome(JOptionPane.showInputDialog("Qual o nome do paciente?"));
        p1.setDataNascimento(DateUtil.StringToDate(JOptionPane.showInputDialog("Qual a data de nascimento?")));
        p1.setGenero(TipoGenero.valueOf(JOptionPane.showInputDialog("Qual o genero do paciente?")));
        em.persist(p1);

        em.getTransaction().commit();
        JpaUtil.fecharConexao();
        
    }
    
}
