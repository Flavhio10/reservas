/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.OcupacaoDAO;
import Modelo.Ocupacao;
import javax.swing.JOptionPane;

/**
 *
 * @author Flávio
 */
public class ControleOcupacao {

    public void cadastrarOcupacao(Ocupacao ocupacao) {

        if (new OcupacaoDAO().verificaOcupacao(ocupacao)) {
            new OcupacaoDAO().cadastrar(ocupacao);
            JOptionPane.showMessageDialog(null, "Cadastro realizado!");

        } else {
            JOptionPane.showMessageDialog(null, "Existe reserva para essa data!");
        }

    }

    public void cadastrarOcupacaoPassante(Ocupacao ocupacao) {
        if (new OcupacaoDAO().verificaPassante(ocupacao)) {
            new OcupacaoDAO().cadastrar(ocupacao);
             JOptionPane.showMessageDialog(null, "Cadastro realizado!");
        }else {
            JOptionPane.showMessageDialog(null, "Existe reserva para essa data!");
        }
    }

    public void cadastrarSaida(Ocupacao ocupacao) {
        new OcupacaoDAO().cadastrarSaida(ocupacao);
    }
}
