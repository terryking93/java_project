package POSHI;

import POSPD.Store;
import POSTest.StoreTest;

public class POSSStart {

	public static void main(String[] args) {
		Store store;
		store = new Store();
		System.out.println("Ready to open store");
		store.openStore();
		new StoreTest();
		StoreTest.printStore(store);
		StoreTest.ac2Test(store);
		StoreTest.ac1Test(store);
		StoreTest.ac3Test(store);
		StoreTest.ac4Test(store);
		/*StoreTest storeTest = new StoreTest();
		StoreTest.printStore(store);*/
		
		
	}

}