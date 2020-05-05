package PageObjects;

import org.testng.annotations.DataProvider;

public class dataProviderObjects {
	@DataProvider(name="InputData")
	public Object[][] getDataforWorkOrder()
	{
		Object[][] data=new Object[1][9];
		data[0][0]="radhika.muvvala@gmail.com";
		data[0][1]="9963524480";
		data[0][2]="65 inch TV ";
		data[0][3]="Aiwa 50 inches 4K Ultra";
		data[0][4]="Add to Cart";
		data[0][5]="Anusha";
		data[0][6]="5105 1051 0510 5100";
		data[0][7]="Thank you, your order has been placed.";
		data[0][8]="Thank you, your order has been placed.";
		return data;

	}

}
