package POSDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import POSPD.Cash;
import POSPD.Cashier;
import POSPD.Check;
import POSPD.Credit;
import POSPD.Item;
import POSPD.Payment;
import POSPD.Person;
import POSPD.Price;
import POSPD.PromoPrice;
import POSPD.Register;
import POSPD.Sale;
import POSPD.SaleLineItem;
import POSPD.Session;
import POSPD.Store;
import POSPD.TaxCategory;
import POSPD.UPC;

public class StoreDM {

	public static void loadStore(Store store) {
		String fileName = "StoreData_v2022.csv";
		String line = null;
		String[] token;
		String dataType;
		TaxCategory taxCat = null;
		Cashier cashier = null;
		Person person = null;
		Session session = null;
		Sale sale = null;
		Register register = null;
		Item item = null;
		UPC upc	= null;
		Price price = null;
		PromoPrice promo = null;
		SaleLineItem sli = null;
		Cash cash = null;
		Credit credit = null;
		Check check = null;
		
		try {
			FileReader fileReader = new FileReader(fileName);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null)
			{
				token = line.split(",");
				dataType = token[0];
				
				if(dataType.equals("Store"))
				{
					store.setName(token[1]);
				}
				else if(dataType.equals("Session"))
				{
					session = new Session(store.findCashierForNumber(token[1]), store.findRegisterByNumber(token[2]));
					store.addSession(session);
					session.setStartDateTime(LocalDateTime.now());
					
					store.findCashierForNumber(token[1]).addSession(session);
				}
				else if(dataType.equals("Sale"))
				{
					sale = new Sale(token[1]);
						
					session.addSale(sale);
				}
				else if(dataType.equals("TaxCategory"))
				{
					taxCat = new TaxCategory(token[1], token[3], token[2]);
					
					store.addTaxCategory(taxCat);
				}
				else if(dataType.equals("Cashier"))
				{
					cashier = new Cashier();
					cashier.setNumber(token[1]);
					person = new Person();
					person.setName(token[2]);
					person.setSSN(token[3]);
					person.setAddress(token[4]);
					person.setCity(token[5]);
					person.setState(token[6]);
					person.setZip(token[7]);
					person.setPhone(token[8]);
					cashier.setPassword(token[9]);
					
					cashier.setPerson(person);
					store.addCashier(cashier);
				}
				else if(dataType.equals("Register"))
				{
					register = new Register(token[1]);
					
					store.addRegister(register);
				}
				else if(dataType.equals("Item"))
				{
					item = new Item();
					item.setNumber(token[1]);
					item.setDescription(token[3]);
					item.setTaxCategory(store.findTaxCategoryByName(token[4]));
					upc = new UPC(token[2], item);
					item.addUPC(upc);
					store.addUPC(upc);
					
					price = new Price();
					price.setPrice(new BigDecimal(token[5]));
					LocalDate ef;
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
					ef = LocalDate.parse(token[6], formatter);
					price.setEffectiveDate(ef);
					price.setItem(item);
					item.addPrice(price);
					
					if(token.length > 7)
					{
						promo = new PromoPrice(token[7], token[8], token[9]);
						promo.setItem(item);
						item.addPrice(promo);
					}
					store.addItem(item);
				}
				else if(dataType.equals("SaleLineItem"))
				{
					sli = new SaleLineItem();
					sli.setItem(store.findItemForNumber(token[1]));
					sli.setQuantity(Integer.valueOf(token[2]));
					sale.addSaleLineItem(sli);
				}
				else if(dataType.equals("Payment"))
				{
					if(token[1].equals("Cash"))
					{
						cash = new Cash(token[2], new BigDecimal(token[3]));
						cash.countsAsCash();
						sale.addPayment(cash);
					}
					else if(token[1].equals("Credit"))
					{
						credit = new Credit(token[4], token[5], token[6]);
						credit.setAmount(new BigDecimal(token[2]));
						credit.setAmtTendered(new BigDecimal(token[3]));
						sale.addPayment(credit);
					}
					else if(token[1].equals("Check"))
					{
						check = new Check(token[4], token[5], token[6]);
						check.setAmount(new BigDecimal(token[2]));
						check.setAmtTendered(new BigDecimal(token[3]));
						sale.addPayment(check);
					}
				}
			}
		}	
		catch(FileNotFoundException ex)
		{
			System.out.println("The file could not be found.");
		}
		catch (IOException ex)
		{
			System.out.println("Error");
		}
	}

}