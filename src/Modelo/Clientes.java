
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
public class Clientes implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private long cpf;
    private String email;
    private String telefone;
    
    public Clientes() {
    }

    public Clientes(String nome, long cpf, String email, String telefone) {       
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public Clientes(long id, String nome, long cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
     

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.cpf ^ (this.cpf >>> 32));
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
        final Clientes other = (Clientes) obj;
        if (this.cpf != other.cpf) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " - " + cpf + " - " + email + " - " + telefone;
    }  
    
    
}
