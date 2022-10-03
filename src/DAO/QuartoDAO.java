/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Quartos;
import Modelo.persistencia.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Flávio
 */
public class QuartoDAO {

    private EntityManager gerenciador;

    public QuartoDAO() {
        this.gerenciador = ConnectionFactory.getInstance().getGerenciador();
    }

    public void cadastrar(Quartos quarto) {
        //Objeto que controla um operação no banco de dados
        EntityTransaction transacao = gerenciador.getTransaction();
        //Inicia a transação
        transacao.begin();
        //armazena o objeto no banco
        gerenciador.persist(quarto);
        //Registra definitivamente as operações no banco
        transacao.commit();
    }

    public List<Quartos> listarTodos() {
        //String na linguagem HQL(linguagem que faz buscas em bancos com Hibernate)
        String consultaHql = "select quarto from Quartos as quarto where 1=1";
        //Objeto de consulta
        Query consulta = gerenciador.createQuery(consultaHql);
        //Método getResultList executa consulta no banco
        return consulta.getResultList();
    }

    public boolean verificaNumeroQuarto(Quartos quarto) {
        List<Quartos> listaQuartos = new ArrayList<>();
        listaQuartos.addAll(this.listarTodos());
        for (Quartos qua : listaQuartos) {
            if (qua.getNumero() == quarto.getNumero()) {
                return true;
            }
        }
        return false;
    }
}
