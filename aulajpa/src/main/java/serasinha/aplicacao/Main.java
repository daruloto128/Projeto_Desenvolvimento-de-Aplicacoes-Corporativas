package aulajpa.aplicacao;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import aulajpa.model.Pessoa;

public class Main {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null, "Dan", "dan@dan.com.br");
		Pessoa p2 = new Pessoa(null, "dani", "dani@dani.com.br");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
		
		System.out.println("Cadastrado com sucesso!");
		
		em.close();
		emf.close();
	}

}
