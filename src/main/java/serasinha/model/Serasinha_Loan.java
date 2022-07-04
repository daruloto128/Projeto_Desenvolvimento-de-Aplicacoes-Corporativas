package serasinha.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
*
* @author nicolasbicalho
*/
@Entity
public class Serasinha_Loan implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private Long user_id;
    @Column(nullable=false)
    private Long bank_card_id;
    @Column(nullable=false)
    private Float value;
    @Column(nullable=false)
    private Float loan_rate;
    @Temporal(TemporalType.DATE)
    private Date date;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Serasinha_Loan(Long user_id, Long bank_card_id, Float value, Float loan_rate, Date date) {
		super();
		this.user_id = user_id;
		this.bank_card_id = bank_card_id;
		this.value = value;
		this.loan_rate = loan_rate;
		this.date = date;
	}

    private User getUser(Long user_id) {
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "serasinhadb" );

    	EntityManager entitymanager = emfactory.createEntityManager();
    	Query query = entitymanager.createQuery("FIND User by id");
    	query.setParameter("id", user_id);
    	
    	@SuppressWarnings("unchecked")
		List<User> list = query.getResultList();
        return list.get(0);
    }
    
    public String verifyCredit(
		Long user_id
	) {
    	User user = getUser(user_id);
    	Float score = user.getScore();
    	
    	if (score > 500) {
    		return "Crédito aprovado!" + "Você ganhou" + 50 + "reais de credito.";
    	}
        	
    	return "Crédito negado! Infelizmente você não tem creditos disponíveis.";
    }

}
