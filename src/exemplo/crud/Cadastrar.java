/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.crud;

import enums.TipoGenero;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
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
public class Cadastrar {
    public static void main(String[] args) throws ParseException {
        
        EntityManager em = JpaUtil.conexao();
        em.getTransaction().begin();
        
        int peso;
        peso = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Paciente, 2 - Cadastrar Consulta, 3 - Cadastrar Prescricao"));
        
        switch (peso) {
            //PACIENTE
            case 1 -> {
                
                Paciente p1 = new Paciente();
                p1.setNome(JOptionPane.showInputDialog("Qual o nome do paciente?"));
                p1.setDataNascimento(DateUtil.StringToDate(JOptionPane.showInputDialog("Qual a data de nascimento?")));
                p1.setGenero(TipoGenero.valueOf(JOptionPane.showInputDialog("Qual o genero do paciente?")));
                p1.setEndereco(JOptionPane.showInputDialog("Qual o endereço do paciente?"));
                p1.setNumeroTelefone(JOptionPane.showInputDialog("Qual o número de telefone do paciente?"));
                p1.setEmail(JOptionPane.showInputDialog("Qual o email do paciente?"));
                //CONSULTA DO PACIENTE
                int peso2 = Integer.parseInt(JOptionPane.showInputDialog("1 - Paciente não tem uma consulta cadastrada, 2 - Paciente já tem uma consulta cadastrada no sistema"));
                switch (peso2) {
                    case 1 -> {
                        Consulta c1 = new Consulta();
                        c1.setDataConsulta(new Date());
                        c1.setDescricao(JOptionPane.showInputDialog("Qual a descrição da consulta?"));
                        c1.setResultados(JOptionPane.showInputDialog("Quais os resultados desta consulta?"));
                        //PRESCRIÇÕES DA CONSULTA DO PACIENTE
                        int peso3 = Integer.parseInt(JOptionPane.showInputDialog("1 - Consulta não tem prescrições cadastradas, 2 - Consulta já tem prescrições cadastradas no sistema"));
                        List<Prescricao> prescricoes;
                        prescricoes = new ArrayList<>();
                        switch (peso3) {
                            case 1 -> {
                                Prescricao prescricao = new Prescricao();
                                prescricao.setDataPrescricao(new Date());
                                prescricao.setMedicamento(JOptionPane.showInputDialog("Qual o medicamento utilizado?"));
                                prescricao.setDosagem(JOptionPane.showInputDialog("Qual a dosagem do medicamento?"));
                                prescricao.setInstrucaoDeUso(JOptionPane.showInputDialog("Quais as instruções de uso do medicamento?"));
                                prescricoes.add(prescricao);
                                int peso4 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                                while(peso4 == 1){
                                    Prescricao prescricao2 = new Prescricao();
                                    prescricao2.setDataPrescricao(new Date());
                                    prescricao2.setMedicamento(JOptionPane.showInputDialog("Qual o medicamento utilizado?"));
                                    prescricao2.setDosagem(JOptionPane.showInputDialog("Qual a dosagem do medicamento?"));
                                    prescricao2.setInstrucaoDeUso(JOptionPane.showInputDialog("Quais as instruções de uso do medicamento?"));
                                    prescricoes.add(prescricao2);
                                    em.persist(prescricao2);
                                    peso4 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                                }
                                c1.setPrescricoes(prescricoes);
                                p1.setConsulta(c1);
                                em.persist(c1);
                                em.persist(p1);
                                em.persist(prescricao);
                                //em.persist(prescricoes);
                            }

                            case 2 -> {
                                Prescricao prescricao3 = em.find(Prescricao.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da prescrição existente")));
                                prescricoes.add(prescricao3);
                                int peso5 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                                while(peso5 == 1){
                                    Prescricao prescricao4 = em.find(Prescricao.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da prescrição existente")));
                                    prescricoes.add(prescricao4);
                                    peso5 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                                }
                                c1.setPrescricoes(prescricoes);
                                p1.setConsulta(c1);
                                em.persist(p1);
                                em.persist(c1);
                            }
                            default -> JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1 ou 2)*");
                        }
                }
                case 2 -> {
                    Consulta c2 = em.find(Consulta.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da consulta existente")));
                    p1.setConsulta(c2);
                    em.persist(p1);
                }
                default -> JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1 ou 2)*");
            }
            em.persist(p1);
        }
            //CONSULTA
            case 2 -> {
                    
                Consulta c1 = new Consulta();
                c1.setDataConsulta(new Date());
                c1.setDescricao(JOptionPane.showInputDialog("Qual a descrição da consulta??"));
                c1.setResultados(JOptionPane.showInputDialog("Qual os resultados desta consulta?"));
                //PRESCRIÇÕES DA CONSULTA
                int peso2 = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar uma prescrição, 2 - Adicionar uma prescrição já cadastrada no sistema"));
                List<Prescricao> prescricoes;
                prescricoes = new ArrayList<>();
                switch (peso2) {
                    case 1 -> {

                        Prescricao prescricao = new Prescricao();
                        prescricao.setDataPrescricao(new Date());
                        prescricao.setMedicamento(JOptionPane.showInputDialog("Qual o medicamento utilizado?"));
                        prescricao.setDosagem(JOptionPane.showInputDialog("Qual a dosagem do medicamento?"));
                        prescricao.setInstrucaoDeUso(JOptionPane.showInputDialog("Quais as instruções de uso do medicamento?"));
                        prescricoes.add(prescricao);
                        int peso4 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                        while(peso4 == 1){
                            Prescricao prescricao2 = new Prescricao();
                            prescricao2.setDataPrescricao(new Date());
                            prescricao2.setMedicamento(JOptionPane.showInputDialog("Qual o medicamento utilizado?"));
                            prescricao2.setDosagem(JOptionPane.showInputDialog("Qual a dosagem do medicamento?"));
                            prescricao2.setInstrucaoDeUso(JOptionPane.showInputDialog("Quais as instruções de uso do medicamento?"));
                            prescricoes.add(prescricao2);
                            em.persist(prescricao2);
                            peso4 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                        }
                        c1.setPrescricoes(prescricoes);
                        em.persist(prescricao);
                        em.persist(c1);

                    }

                    case 2 -> {

                        Prescricao prescricao3 = em.find(Prescricao.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da prescrição existente")));
                        prescricoes.add(prescricao3);
                        int peso5 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                        while(peso5 == 1){
                            Prescricao prescricao4 = em.find(Prescricao.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da prescrição existente")));
                            prescricoes.add(prescricao4);
                            peso5 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                        }
                        c1.setPrescricoes(prescricoes);
                        em.persist(c1);

                    }
                    default -> JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1 ou 2)*");
                }
            }
            //PRESCRIÇÃO
            case 3 -> {
                
                List<Prescricao> prescricoes = new ArrayList<>();
                Prescricao prescricao = new Prescricao();
                prescricao.setDataPrescricao(new Date());
                prescricao.setMedicamento(JOptionPane.showInputDialog("Qual o medicamento utilizado?"));
                prescricao.setDosagem(JOptionPane.showInputDialog("Qual a dosagem do medicamento?"));
                prescricao.setInstrucaoDeUso(JOptionPane.showInputDialog("Quais as instruções de uso do medicamento?"));
                prescricoes.add(prescricao);
                em.persist(prescricao);
                int peso4 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                while(peso4 == 1){
                    Prescricao prescricao2 = new Prescricao();
                    prescricao2.setDataPrescricao(new Date());
                    prescricao2.setMedicamento(JOptionPane.showInputDialog("Qual o medicamento utilizado?"));
                    prescricao2.setDosagem(JOptionPane.showInputDialog("Qual a dosagem do medicamento?"));
                    prescricao2.setInstrucaoDeUso(JOptionPane.showInputDialog("Quais as instruções de uso do medicamento?"));
                    prescricoes.add(prescricao2);
                    em.persist(prescricao2);
                    peso4 = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar outra prescrição, 2 - Não adicionar outra prescrição"));
                }
                int peso5 = Integer.parseInt(JOptionPane.showInputDialog("1 - Criar uma consulta para as prescrições, 2 - Adicionar as prescrições em uma consulta já cadastrada"));
                switch (peso5) {
                    case 1 -> {
                        
                        Consulta c1 = new Consulta();
                        c1.setDataConsulta(new Date());
                        c1.setDescricao(JOptionPane.showInputDialog("Qual a descrição da consulta??"));
                        c1.setResultados(JOptionPane.showInputDialog("Qual os resultados desta consulta?"));
                        c1.setPrescricoes(prescricoes);
                        em.persist(c1);
                        JOptionPane.showMessageDialog(null, "Prescrições criadas adicionadas à consulta criada");
                        
                    }

                    case 2 -> {
                        
                        Consulta c2 = em.find(Consulta.class, Long.valueOf(JOptionPane.showInputDialog("Digite o id da consulta existente")));
                        c2.setPrescricoes(prescricoes);
                        em.merge(c2);
                        
                    }
                    default -> JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1 ou 2)*");
                }
                
            }
            default -> {
                JOptionPane.showMessageDialog(null, "ERRO: VOCÊ NÃO COLOCOU UM DOS NÚMEROS POSSÍVEIS *(1, 2, 3, 4)*");
            }
        }
        
        em.getTransaction().commit();
        JpaUtil.fecharConexao();
        
    }
}
