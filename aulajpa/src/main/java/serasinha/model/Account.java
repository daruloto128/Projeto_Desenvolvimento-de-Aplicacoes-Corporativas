package serasinha.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author millenacosta
 */
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private Long wallet_id;
    @Column(nullable=false)
    private Long user_id;
    @Transient
    private Long bank_card_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void transferMoney(User destinario, float money) {
       // verifica se usuario tem money que deseja transferir
       // se sim, efetua transacao, se nao, nao efetua
       // insere o dinheiro no wallet do destinario
    }

    public void bankDeposit() {
        // armazena dinheiro na wallet do usuario
    }

    public void requestLoan() {

    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplicacao.Account[ id=" + id + " ]";
    }

}