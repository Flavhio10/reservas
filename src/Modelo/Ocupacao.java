/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Flávio
 */
@Entity
public class Ocupacao {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Clientes cliente;
    @OneToOne
    private Quartos quarto;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrada;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSaida;

    public Ocupacao(long id, Clientes cliente, Quartos quarto, Date dataEntrada, Date dataSaida) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Ocupacao() {
    }
    
    

    public Ocupacao(Clientes cliente, Quartos quarto, Date dataEntrada, Date dataSaida) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Ocupacao(Clientes cliente, Quartos quarto, Date dataEntrada) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Quartos getQuarto() {
        return quarto;
    }

    public void setQuarto(Quartos quarto) {
        this.quarto = quarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.cliente);
        hash = 97 * hash + Objects.hashCode(this.quarto);
        hash = 97 * hash + Objects.hashCode(this.dataEntrada);
        hash = 97 * hash + Objects.hashCode(this.dataSaida);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ocupacao other = (Ocupacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.quarto, other.quarto)) {
            return false;
        }
        if (!Objects.equals(this.dataEntrada, other.dataEntrada)) {
            return false;
        }
        if (!Objects.equals(this.dataSaida, other.dataSaida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " - " + cliente + " - " + quarto + " - " + dataEntrada + " - " + dataSaida;
    }

}
