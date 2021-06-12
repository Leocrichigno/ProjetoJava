package br.com.time.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author leocr
 */
@Entity
public class Time implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idTime;
    private String nome;

    public long getIdTime() {
        return idTime;
    }

    public void setIdTime(long idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
