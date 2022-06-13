package serasinha.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.ws.rs.*;
import serasinha.model.*;

@Path("transaction")
@Produces({"application/json", "application/xml"})
@Consumes({"application/json", "application/xml"})
public class TransactionService {
	
	@POST
	@Consumes
	public String createTransaction(
            @FormParam("buyer_account_id") Long buyer_account_id, 
            @FormParam("seller_account_id") Long seller_account_id, 
            @FormParam("value") Float value
    ) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String data = formato.format(new Date());
		
		Transaction transaction = new Transaction(null, null, null, null);
		transaction.createTransaction(buyer_account_id, seller_account_id, value, data);

		return "Transacao feita com sucesso!";
	}
}
