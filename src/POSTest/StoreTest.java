package POSTest;

import java.util.Map.Entry;
import POSPD.Cashier;
import POSPD.Item;
import POSPD.Person;
import POSPD.Price;
import POSPD.Register;
import POSPD.Sale;
import POSPD.SaleLineItem;
import POSPD.Session;
import POSPD.Store;
import POSPD.TaxCategory;
import POSPD.UPC;

public class StoreTest {
	public static void main(String args[]) {
		
	}
	public static void printStore(Store store) {
			System.out.println(store);
			System.out.println("==============");
			System.out.println("Cashiers");
			System.out.println("==============");
	
			for(Cashier cashier : store.getCashiers().values())
			{
				System.out.println(cashier.getPerson().getName());
			}
			
			System.out.println("==============");
			System.out.println("Registers");
			System.out.println("==============");
			for(Entry<String, Register> entry : store.getRegisters().entrySet())
			{
				System.out.println(entry.getValue().getNumber());
			}
			
			System.out.println("==============");
			System.out.println("Items");
			System.out.println("==============");
			for(Entry<String, Item> entry : store.getItems().entrySet())
			{
				System.out.println(entry.getValue().toString());
			}
			
			System.out.println("==============");
			System.out.println("Sessions");
			System.out.println("==============");
			for(Session session : store.getSessions())
			{
				System.out.println(session.toString());
			}
	}
	
	public static void ac2Test(Store store) {
		System.out.println("==============");
		System.out.println("Cashiers: ");
		System.out.println("==============");
		
		Person person1 = new Person("Mason", "Somewhere", "Somewhere", "Somewhere", "Something", "Something", "Something");
		Cashier cashier1 = new Cashier("11111", person1, "11111");
		store.addCashier(cashier1);
		
		Person person2 = new Person("Sydney", "Somewhere", "Somewhere", "Somewhere", "Something", "Something", "Something");
		Cashier cashier2 = new Cashier("22222", person2, "22222");
		store.addCashier(cashier2);
		
		Person person3 = new Person("Terry", "Somewhere", "Somewhere", "Somewhere", "Something", "Something", "Something");
		Cashier cashier3 = new Cashier("33333", person3, "33333");
		store.addCashier(cashier3);
		
		System.out.println(cashier1.toString());
		System.out.println(cashier2.toString());
		System.out.println(cashier3.toString());
	}
	
	public static void ac3Test(Store store) {
		System.out.println("==============");
		System.out.println("Registers: ");
		System.out.println("==============");
		
		Register register1 = new Register("1");
		store.addRegister(register1);
		
		Register register2 = new Register("2");
		store.addRegister(register2);
		
		System.out.println(register1.toString());
		System.out.println(register2.toString());
	}
	
	public static void ac4Test(Store store) {
		System.out.println("==============");
		System.out.println("Session: ");
		System.out.println("==============");
		
		Register register1 = new Register("1");
		Person person1 = new Person("JTerry", "Somewhere", "Somewhere", "Somewhere", "Something", "Something", "Something");
		Cashier cashier1 = new Cashier("11111", person1, "11111");
		Item item1 = new Item(store, "0001", "Banana Bread", "Food");
		UPC upc1 = new UPC("11111", item1);
		Price price1 = new Price(item1, "2.99", "04/18/2001");
		Item item2 = new Item(store, "0002", "Ham Sandwich", "Food");
		UPC upc2 = new UPC("22222", item2);
		Price price2 = new Price(item2, "4.99", "03/22/1970");
		
		Session session = new Session(cashier1, register1);
		Sale sale = new Sale("False");
		session.addSale(sale);
		SaleLineItem sli1 = new SaleLineItem(sale, item1, "4");
		SaleLineItem sli2 = new SaleLineItem(sale, item2, "2");
		
		System.out.println(session.toString());
		
	}


	public static void ac1Test(Store store) {
		// TODO Auto-generated method stub
		System.out.println("==============");
		System.out.println("Items");
		System.out.println("==============");
		TaxCategory taxCat = new TaxCategory("Food", "01/01/2016", "0.07");
		store.addTaxCategory(taxCat);
		
		Item item1 = new Item(store, "1001","Turkey Sandwch", "Food");
		UPC upc1 = new UPC("11111", item1);
		store.addUPC(upc1);
		Price price1 = new Price(item1, "2.29", "01/01/2012");
		
		Item item2 = new Item(store, "1002", "Ham Sandwich", "Food");
		UPC upc2 = new UPC("22222", item2);
		store.addUPC(upc2);
		Price price2 = new Price(item2, "2.59", "01/01/2022");
		
		Item item3 = new Item(store, "1003", "Coke", "Food");
		UPC upc3 = new UPC("33333", item3);
		store.addUPC(upc3);
		Price price3 = new Price(item3, "0.97", "01/01/2022");
		
		Item item4 = new Item(store, "1004", "Dr.Pepper", "Food");
		UPC upc4 = new UPC("44444", item4);
		store.addUPC(upc4);
		Price price4 = new Price(item4, "0.79", "01/01/2022");
		
		System.out.println(item1.toString());
		System.out.println(item2.toString());
		System.out.println(item3.toString());
		System.out.println(item4.toString());
	}
}
	

	

	