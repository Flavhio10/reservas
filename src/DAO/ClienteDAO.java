package DAO;

import Modelo.Clientes;
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
public class ClienteDAO {

    private EntityManager gerenciador;

    public ClienteDAO() {
        this.gerenciador = ConnectionFactory.getInstance().getGerenciador();
    }

    public void cadastrar(Clientes cliente) {
        //Objeto que controla um operação no banco de dados
        EntityTransaction transacao = gerenciador.getTransaction();
        //Inicia a transação
        transacao.begin();
        //armazena o objeto no banco
        gerenciador.persist(cliente);
        //Registra definitivamente as operações no banco
        transacao.commit();
    }

    public List<Clientes> listarTodos() {
        //String na linguagem HQL(linguagem que faz buscas em bancos com Hibernate)
        String consultaHql = "select cliente from Clientes as cliente where 1=1";
        //Objeto de consulta
        Query consulta = gerenciador.createQuery(consultaHql);
        //Método getResultList executa consulta no banco
        return consulta.getResultList();
    }

    public boolean verificaCpf(Clientes cliente) {
        List<Clientes> listaClientes = new ArrayList<>();
        listaClientes.addAll(this.listarTodos());
        for (Clientes cli : listaClientes) {
            if (cli.getCpf() == cliente.getCpf()) {
                return true;
            } 
        }
        return false;
    }
}
