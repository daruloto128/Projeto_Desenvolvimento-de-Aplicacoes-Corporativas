package serasinha.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
*
* @author nicolasbicalho
*/
@Entity
public class Bank_Card implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String card_number;
    @Column(nullable=false)
    private Integer security_code;
    @Column(nullable=false)
    private String date_validity;
    @Column(nullable=false)
    private String agency;
    @Column(nullable=false)
    private String account_number;

    public Bank_Card(Long id, String card_number, Integer security_code, String date_validity, String agency,
			String account_number) {
		super();
		this.id = id;
		this.card_number = card_number;
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
    	Long account_id,
    	Long serasinha_loan_id,
		String card_number,
		Integer security_code,
		String date_validity,
		String agency,
		String account_number
		
	) {
    	Bank_Card bankCard = new Bank_Card(null, card_number, security_code, date_validity, agency, account_number);
    	
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "serasinhadb" );
    	EntityManager entityManager = emfactory.createEntityManager();
    	entityManager.getTransaction().begin();
	   	entityManager.persist(bankCard);
	   	Query query = entityManager.createQuery("Select bc from Bank_Card bc where bc.card_number = :card_number");
    	query.setParameter("card_number", card_number);
    	
    	@SuppressWarnings("unchecked")
		List<Bank_Card> list = query.getResultList();
        Long bank_card_id = list.get(0).getId();
        
        Query updateAccountQuery = entityManager.createQuery(
        	"UPDATE Account a SET a.bank_card_id = :bank_card_id"
        	+ "WHERE a.id = :account_id"
		);
        updateAccountQuery.setParameter("bank_card_id", bank_card_id);
        updateAccountQuery.setParameter("account_id", account_id);
        updateAccountQuery.executeUpdate();
        
        Query updateSerasinhaLoanQuery = entityManager.createQuery(
            	"UPDATE Serasinha_Loan sl SET sl.bank_card_id = :bank_card_id"
            	+ "WHERE sl.id = :serasinha_loan_id"
    		);
        updateSerasinhaLoanQuery.setParameter("bank_card_id", bank_card_id);
        updateSerasinhaLoanQuery.setParameter("serasinha_loan_id", serasinha_loan_id);
        updateSerasinhaLoanQuery.executeUpdate();
	   	entityManager.getTransaction().commit();
 
    }
}