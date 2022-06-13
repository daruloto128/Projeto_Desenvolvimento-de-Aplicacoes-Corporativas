package serasinha.model;

import java.io.Serializable;
import javax.persistence.*;

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
    private String date_validity;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Transaction(Long buyer_account_id, Long seller_account_id, Float value, String date_validity) {
		super();
		this.buyer_account_id = buyer_account_id;
		this.seller_account_id = seller_account_id;
		this.value = value;
		this.date_validity = date_validity;
	}

	public void createTransaction(
            Long user_id,
            Long wallet_id, 
            String name, 
            String phone, 
            String email, 
            Long password,
            Long account_id, 
            Float score
    ) {
        //instancio a classe e persisto o user
    }
    
}
