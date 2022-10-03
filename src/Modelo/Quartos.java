
package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Flávio
 */
@Entity
public class Quartos implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private int numero;
    private String tipo;

    public Quartos() {
    }

    public Quartos(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Quartos(long id, int numero, String tipo) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    

    public int getNumero() {
        return numero;
    }

    public String isTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.numero;
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
        final Quartos other = (Quartos) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numero + ": "+ tipo;
    }
    
}
