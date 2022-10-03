package Controle;

import DAO.ReservaDAO;
import Modelo.Reserva;
import javax.swing.JOptionPane;

/**
 *
 * @author Flávio
 */
public class ControleReservas {

    public void cadastrarReserva(Reserva reserva) {
        if(reserva.getDataEntrada() == null || reserva.getDataSaida() == null){
            JOptionPane.showMessageDialog(null, "Preencher campos de datas!");
        }
        try {
            if (new ReservaDAO().comparaReserva(reserva)) {
                new ReservaDAO().cadastrar(reserva);
                JOptionPane.showMessageDialog(null, "Cadastro realizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Já existe uma reserva para essas datas!");
            }

        }//fim do método cadastrar reserva
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void removeReserva(Reserva reserva){
        new ReservaDAO().remover(reserva);
    }
    
    
}
