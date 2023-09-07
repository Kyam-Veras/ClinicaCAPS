/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilitario;

import javax.persistence.EntityManager;
import javax.persistence.*;

/**
 *
 * @author kyamv
 */
public class JpaUtil {
    
    private static EntityManagerFactory emf;
    
    static{
        emf = Persistence.createEntityManagerFactory("ClinicaPU");
    }
    
    public static EntityManager conexao(){
        return emf.createEntityManager();
    }
    
    public static void fecharConexao(){
        emf.close();
    }
    
}
