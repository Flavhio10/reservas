package Controle;

import DAO.QuartoDAO;
import Modelo.Quartos;
import javax.swing.JOptionPane;

/**
 *
 * @author Flávio
 */
public class ControleQuartos {

    public void cadastrarQuartos(Quartos quarto) {
        if (new QuartoDAO().verificaNumeroQuarto(quarto)) {
            JOptionPane.showMessageDialog(null, "Número de quarto já existe!");
        } else {
            new QuartoDAO().cadastrar(quarto);
            JOptionPane.showMessageDialog(null, "Cadastro realizado!");
        }
    }
}
