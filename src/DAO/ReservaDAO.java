package DAO;

import Modelo.Reserva;
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
public class ReservaDAO {

    private EntityManager gerenciador;

    public ReservaDAO() {
        this.gerenciador = ConnectionFactory.getInstance().getGerenciador();
    }

    public void cadastrar(Reserva reserva) {
        //Objeto que controla um operação no banco de dados
        EntityTransaction transacao = gerenciador.getTransaction();
        //Inicia a transação
        transacao.begin();
        //armazena o objeto no banco
        gerenciador.persist(reserva);
        //Registra definitivamente as operações no banco
        transacao.commit();
    }
    
     public void remover(Reserva reserva) {
        //Objeto que controla um operação no banco de dados
        EntityTransaction transacao = gerenciador.getTransaction();
        //Inicia a transação
        transacao.begin();
        //armazena o objeto no banco
        gerenciador.remove(reserva);
        //Registra definitivamente as operações no banco
        transacao.commit();
    }

    public List<Reserva> listarTodos() {
        //String na linguagem HQL(linguagem que faz buscas em bancos com Hibernate)
        String consultaHql = "select reserva from Reserva as reserva where 1=1";
        //Objeto de consulta
        Query consulta = gerenciador.createQuery(consultaHql);
        //Método getResultList executa consulta no banco
        return consulta.getResultList();
    }
/**
 * 
 * @param reserva traz uma nova reserva
 * @return verdadeiro se as datas não forem iguais
 */
    public boolean comparaReserva(Reserva reserva) {
        List<Reserva> listaReserva = new ArrayList<>();
        listaReserva.addAll(this.listarTodos());

        if (listaReserva.isEmpty()) {
            return true;
        }

        for (Reserva r : listaReserva) {
            if (reserva.getQuarto().getNumero() == r.getQuarto().getNumero()) {
                if (reserva.getDataEntrada().compareTo(r.getDataEntrada()) == 0 || reserva.getDataEntrada().compareTo(r.getDataSaida()) == 0) {
                    return false;
                }
                if (reserva.getDataSaida().compareTo(r.getDataEntrada()) == 0 || reserva.getDataSaida().compareTo(r.getDataSaida()) == 0) {
                    return false;
                }

                if ((reserva.getDataEntrada().compareTo(r.getDataEntrada()) >= 0 || reserva.getDataSaida().compareTo(r.getDataEntrada()) >= 0)
                        && reserva.getDataEntrada().compareTo(r.getDataSaida()) <= 0 || reserva.getDataSaida().compareTo(r.getDataSaida()) <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
