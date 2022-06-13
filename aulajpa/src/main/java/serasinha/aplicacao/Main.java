package serasinha.aplicacao;

import javax.persistence.*;
import serasinha.model.*;

public class Main {

	public static void main(String[] args) {

		Bank_Card card = new Bank_Card(null,null, null, null, null, null);
		card.registerCreditCard(null, null, "123", 123, "13/06/2022", "001", "00000000");
		
		System.out.println("Cadastrado com sucesso!");
		
	}

}
