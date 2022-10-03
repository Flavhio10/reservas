package DAO;

import Modelo.Ocupacao;
import Modelo.Reserva;
import Modelo.persistencia.ConnectionFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Flávio
 */
public class OcupacaoDAO {

    private EntityManager gerenciador;

    public OcupacaoDAO() {
        this.gerenciador = ConnectionFactory.getInstance().getGerenciador();
    }

    public void cadastrar(Ocupacao ocupacao) {
        //Objeto que controla um operação no banco de dados
        EntityTransaction transacao = gerenciador.getTransaction();
        //Inicia a transação
        transacao.begin();
        //armazena o objeto no banco
        gerenciador.persist(ocupacao);
        //Registra definitivamente as operações no banco
        transacao.commit();
    }

    public List<Ocupacao> listarTodos() {
        //String na linguagem HQL(linguagem que faz buscas em bancos com Hibernate)
        String consultaHql = "select ocupacao from Ocupacao as ocupacao where 1=1";
        //Objeto de consulta
        Query consulta = gerenciador.createQuery(consultaHql);
        //Método getResultList executa consulta no banco
        return consulta.getResultList();
    }

    public void cadastrarSaida(Ocupacao ocupacao) {
        //Objeto que controla um operação no banco de dados
        EntityTransaction transacao = gerenciador.getTransaction();
        //Inicia a transação
        transacao.begin();
        //armazena o objeto no banco
        gerenciador.merge(ocupacao);
        //Registra definitivamente as operações no banco
        transacao.commit();
    }

    public boolean verificaOcupacao(Ocupacao ocupacao) {
        List<Ocupacao> listaOcupacao = new ArrayList<>();
        listaOcupacao.addAll(new OcupacaoDAO().listarTodos());

        if (listaOcupacao.isEmpty()) {
            return true;
        }

        for (Ocupacao o : listaOcupacao) {
            if (o.getQuarto().getNumero() == ocupacao.getQuarto().getNumero()) {
                if (o.getDataEntrada().compareTo(ocupacao.getDataEntrada()) >= 0 && o.getDataSaida() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public Ocupacao converteReserva(Reserva reserva) {
        return new Ocupacao(reserva.getCliente(), reserva.getQuarto(), new Date());
    }

    public boolean verificaPassante(Ocupacao ocupacao) {
        List<Reserva> listaReserva = new ArrayList<>();
        listaReserva.addAll(new ReservaDAO().listarTodos());
        int count = 0;

        for (Reserva r : listaReserva) {
            if (ocupacao.getDataEntrada().compareTo(r.getDataEntrada()) >= 0 && ocupacao.getDataEntrada().compareTo(r.getDataSaida()) <= 0) {
                count++;
            }
            if (ocupacao.getDataSaida().compareTo(r.getDataSaida()) <= 0 || ocupacao.getDataSaida().compareTo(r.getDataSaida()) <= 0) {
                count++;
            }
        }
        if (count == 0 && this.verificaOcupacao(ocupacao)) {
            return true;
        }
        return false;
    }

}
