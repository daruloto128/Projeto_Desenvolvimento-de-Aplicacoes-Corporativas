package serasinha.model;

import java.io.Serializable;
import javax.persistence.*;
import serasinha.model.*;

@Entity
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private Long buyer_account_id;
    @Column(nullable=false)
    private Long seller_account_id;
    @Column(nullable=false)
    private Float value;
    @Column(nullable=false)
    private String date;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Transaction(Long buyer_account_id, Long seller_account_id, Float value, String date) {
		super();
		this.buyer_account_id = buyer_account_id;
		this.seller_account_id = seller_account_id;
		this.value = value;
		this.date = date;
	}

	public void createTransaction(
            Long buyer_account_id, 
            Long seller_account_id, 
            Float value, 
            String date 
    ) {
        Transaction transaction = new Transaction(buyer_account_id, seller_account_id, value, date);
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "serasinhadb" );
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        entityManager.getTransaction().commit();
    }
	
	public void transferMoney(Long seller_account_id, Float value, String date) {
		Transaction transaction = new Transaction(this.getId(), seller_account_id, value, date);
		transaction.createTransaction(seller_account_id, buyer_account_id, value, date);
	}
    
}
