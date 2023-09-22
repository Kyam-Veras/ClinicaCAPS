/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import enums.TipoGenero;
import java.text.ParseException;
import javax.persistence.*;
import javax.swing.JOptionPane;
import modelo.Consulta;
import modelo.Paciente;
import modelo.Prescricao;
import utilitario.DateUtil;
import utilitario.JpaUtil;

/**
 *
 * @author kyamv
 */
public class Atualizar {
    public static void main(String[] args) throws ParseException {
        
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        
        int peso;
        peso = Integer.parseInt(JOptionPane.showInputDialog("""
                Digite um dos números à seguir:
                1 - Atualizar Paciente
                2 - Atualizar Consulta
                3 - Atualizar Prescricao
            """));
        
        switch (peso) {
            //PACIENTE
            case 1 -> {
                
                int peso2;
                peso2 = Integer.parseInt(JOptionPane.showInputDialog("""
                    Digite um dos números à seguir
                    1 - Atualizar o nome do paciente
                    2 - Atualizar a data de nascimento do paciente 
                    3 - Atualizar o genero do paciente
                    4 - Atualizar endereço
                    5 - Atualizar número de telefone
                    6 - Atualizar o e-mail
                    7 - Atualizar consulta do paciente
                """));
                Paciente p = em.find(Paciente.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id para a atualização")));

                switch (peso2) {
                    case 1 ->                 {
                            p.setNome(JOptionPane.showInputDialog("Digite o nome atualizado"));
                            em.merge(p);
                        }
                    case 2 -> {
                            p.setDataNascimento(DateUtil.StringToDate(JOptionPane.showInputDialog("Digite a data de nascimento atualizada (EXEMPLO: dd/mm/YYYY)")));
                            em.merge(p);
                    }
                    case 3 ->                 {
                            p.setGenero(TipoGenero.valueOf(JOptionPane.showInputDialog("Digite o genero atualizado")));
                            em.merge(p);
                        }
                    case 4 ->                 {
                            p.setEndereco(JOptionPane.showInputDialog("Digite o endereço atualizado"));
                            em.merge(p);
                        }
                    case 5 ->                 {
                            p.setNumeroTelefone(JOptionPane.showInputDialog("Digite o número de telefone atualizado"));
                            em.merge(p);
                        }
                    case 6 ->                 {
                            p.setEmail(JOptionPane.showInputDialog("Digite o e-mail atualizado"));
                            em.merge(p);
                        }
                    case 7 ->                 {
                            Consulta c = em.find(Consulta.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da consulta atualizada do paciente")));
                            p.setConsulta(c);
                            em.merge(p);
                        }
                    default -> {
                        JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1, 2, 3, 4, 5, 6, 7)*");
                    }
                }
                
            }
            //CONSULTA
            case 2 -> {
                    
                int peso2;
                peso2 = Integer.parseInt(JOptionPane.showInputDialog("""
                    Digite um dos números à seguir
                    1 - Atualizar a data da consulta
                    2 - Atualizar a descrição da consulta 
                    3 - Atualizar os resultados da consulta
                    4 - Atualizar a lista de prescrições da consulta
                """));
                Consulta c = em.find(Consulta.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id para a atualização")));

                switch (peso2) {
                    case 1 ->                 {
                            c.setDataConsulta(DateUtil.StringToDate(JOptionPane.showInputDialog("Digite a data da consulta atualizada (EXEMPLO: dd/mm/YYYY)")));
                            em.merge(c);
                        }
                    case 2 -> {
                            c.setDescricao(JOptionPane.showInputDialog("Digite a descrição atualizada"));
                            em.merge(c);
                    }
                    case 3 ->                 {
                            c.setResultados(JOptionPane.showInputDialog("Digite os resultados da consulta atualizados"));
                            em.merge(c);
                        }
                    case 4 ->                 {
                            int peso3 = Integer.parseInt(JOptionPane.showInputDialog("""
                                Digite um dos números à seguir
                                1 - Adicionar nova prescrição
                                2 - Remover prescrição
                            """));
                            switch (peso3) {
                                case 1 ->                 {
                                    Prescricao prescricao = em.find(Prescricao.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da prescrição para ser adicionada")));
                                    c.getPrescricoes().add(prescricao);
                                    em.merge(c);
                                    }
                                case 2 -> {
                                    Prescricao prescricao = em.find(Prescricao.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da prescrição para remoção")));
                                    c.getPrescricoes().remove(prescricao);
                                    em.merge(c);
                                }
                                default -> {
                                    JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1 ou 2)*");
                                }
                            }
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1, 2, 3, 4)*");
                    }
                }
                
            }
            //PRESCRIÇÃO
            case 3 -> {
                
                int peso2;
                peso2 = Integer.parseInt(JOptionPane.showInputDialog("""
                    Digite um dos números à seguir
                    1 - Atualizar a data da prescrição
                    2 - Atualizar o medicamento da prescrição
                    3 - Atualizar a dosagem do medicamento
                    4 - Atualizar a instrução de uso
                """));
                
                Prescricao prescricao = em.find(Prescricao.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da prescrição para ser adicionada")));
                
                switch (peso2) {
                    case 1 ->                 {
                        prescricao.setDataPrescricao(DateUtil.StringToDate(JOptionPane.showInputDialog("Digite a data da prescrição atualizada (EXEMPLO: dd/mm/YYYY)")));
                        em.merge(prescricao);
                        }
                    case 2 -> {
                        prescricao.setMedicamento(JOptionPane.showInputDialog("Digite o medicamento atualizado"));
                        em.merge(prescricao);
                    }
                    case 3 -> {
                        prescricao.setDosagem(JOptionPane.showInputDialog("Digite a dosagem do medicamento atualizada"));
                        em.merge(prescricao);
                    }
                    case 4 -> {
                        prescricao.setInstrucaoDeUso(JOptionPane.showInputDialog("Digite a instrução de uso atualizada"));
                        em.merge(prescricao);
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1 ou 2)*");
                    }
                }
                
            }
            default -> {
                JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1, 2, 3)*");
            }
        }
        
        em.getTransaction().commit();
        JpaUtil.fecharConexao();
        
    }
}
