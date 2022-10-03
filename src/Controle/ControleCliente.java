package Controle;

import DAO.ClienteDAO;
import Modelo.Clientes;
import javax.swing.JOptionPane;

/**
 *
 * @author Flávio
 */
public class ControleCliente {

    public void cadastraClientes(Clientes cliente) {
        if (new ClienteDAO().verificaCpf(cliente)) {
            JOptionPane.showMessageDialog(null, "CPF já existe no cadastro!");            
        } else {
            new ClienteDAO().cadastrar(cliente);
            JOptionPane.showMessageDialog(null, "Cadastro realizado!");
        }
    }
}
