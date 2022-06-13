package serasinha.model;

import javax.persistence.*;

@Entity
public class Wallet {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private Long account_id;
    @Column(nullable=false)
    private Float amount;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Wallet(Long account_id, Float amount) {
		super();
		this.account_id = account_id;
		this.amount = amount;
	}
	
	public void createWallet() {
		Wallet wallet = new Wallet(null, 0F);
    	
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "serasinhadb" );
    	EntityManager entityManager = emfactory.createEntityManager();
    	entityManager.getTransaction().begin();
	   	entityManager.persist(wallet);
	   	entityManager.getTransaction().commit();
	}
    
    
}