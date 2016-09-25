import org.junit.Test;

import com.retail.model.Item;

public class DataSourceConnectionTest {
	
	@Test
	public void getItemTest(){
		Item item = new Item();
		item.setItemId(100);
		item.setItemDescription("Polo");
		item.setUnitCost(12.00);
		item.setCurrencyCode("USD");
	}

}
