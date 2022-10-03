/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Flávio
 */
public class ConnectionFactory {
    private static ConnectionFactory conexao;
    private EntityManager gerenciador;
    
    private ConnectionFactory(){
        //A String passada como parâmetro é o nome que você utilizou na Unidade
        //de persistência
        EntityManagerFactory em = Persistence.createEntityManagerFactory("Reserva_de_HotelPU");
        gerenciador = em.createEntityManager();
    }
    
    public static ConnectionFactory getInstance(){
        if(conexao==null){
            conexao = new ConnectionFactory();
        }
        return conexao;
    }
    
    public EntityManager getGerenciador(){
        return gerenciador;
    }
}
