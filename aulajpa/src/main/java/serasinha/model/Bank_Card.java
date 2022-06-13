package serasinha.model;

import javax.persistence.*;

@Entity
public class Bank_Card {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String cardNumber;
    @Column(nullable=false)
    private Integer security_code;
    @Column(nullable=false)
    private String date_validity;
    @Column(nullable=false)
    private String agency;
    @Column(nullable=false)
    private String account_number;

    public Bank_Card(String cardNumber, Integer security_code, String date_validity, String agency,
			String account_number) {
		super();
		this.cardNumber = cardNumber;
		this.security_code = security_code;
		this.date_validity = date_validity;
		this.agency = agency;
		this.account_number = account_number;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void registerCreditCard(
		String cardNumber,
		Integer security_code,
		String date_validity,
		String agency,
		String account_number
	) {
    	Bank_Card bankCard = new Bank_Card(cardNumber, security_code, date_validity, agency, account_number);
    	
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "serasinhadb" );
    	EntityManager entityManager = emfactory.createEntityManager();
    	entityManager.getTransaction().begin();
	   	entityManager.persist(bankCard);
	   	entityManager.getTransaction().commit();
 
    }
}