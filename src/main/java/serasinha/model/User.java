package serasinha.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author millenacosta
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length=50)
    private String name;
    @Column(length=50)
    private String email;
    @Column(length=50)
    private String phone;
    @Column(nullable=false)
    private Long password;
    @Column(nullable=false)
    private Long account_id;
    @Transient
    private Float score;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String name, String email, String phone, Long password, Long account_id, Float score) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.account_id = account_id;
		this.score = score;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplicacao.User[ id=" + id + " ]";
    }

	public Long getPassword() {
		return password;
	}

	public void setPassword(Long password) {
		this.password = password;
	}

	public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
    
    public void createUser(String name, String email, String phone, Long password, Long account_id, Float score) {
        User user = new User(name, phone,email, password, account_id, score);
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("serasinhadb");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

    }
}