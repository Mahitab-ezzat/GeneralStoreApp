import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.By
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

public class CartPage {


	// Method to verify the Cart page is visible
	static void verifyCartPageVisible() {
		String cartPageXPath = "//*[@class = 'android.widget.RelativeLayout' and (@text = '' or . = '')]"
		TestObject cartPageObject = new TestObject()
		cartPageObject.addProperty('xpath', ConditionType.EQUALS, cartPageXPath)
		
		// Verify if the cart page is visible
		Mobile.verifyElementVisible(cartPageObject, 30)
		println "Cart page is visible."
	}

	// Method to get the total price from the cart
	static void getCARTTotalPriceNO() {
		TestObject totalPriceObject = new TestObject()
		totalPriceObject.addProperty('name', ConditionType.EQUALS, 'Object Repository/android.widget.TextView - Total Purchase Amount')
		// Retrieve the total price text from the cart
		//String totalPriceTextinCART = Mobile.getText(totalPriceObject, 0)
		TestObject xx = findTestObject('Object Repository/android.widget.TextView - Total Purchase Amount')
		//String totalPriceTextinCART = Mobile.getText(findTestObject('Object Repository/android.widget.TextView - Total Purchase Amount'), 0)		
		String totalPriceTextinCART= Mobile.getText(xx, 0)
		println "Total Purchase Amount: " + totalPriceTextinCART
		//return totalPriceTextinCART
	}
	
	// Method to get the total price from the cart
	static String getCARTTotalPrice() {
		TestObject totalPriceObject = new TestObject()
		totalPriceObject.addProperty('name', ConditionType.EQUALS, 'Object Repository/android.widget.TextView')
		// Retrieve the total price text from the cart
		//String totalPriceTextinCART = Mobile.getText(totalPriceObject, 0)
		TestObject xx = findTestObject('Object Repository/android.widget.TextView -  280.97')
		//String totalPriceTextinCART = Mobile.getText(findTestObject('Object Repository/android.widget.TextView - Total Purchase Amount'), 0)
		String totalPriceTextinCART= Mobile.getText(xx, 0)
		println "Total Purchase Amount: " + totalPriceTextinCART
		String numericValueinCART = totalPriceTextinCART.replaceAll("[^0-9.]", "")
		
		println "Numeric Value: " + numericValueinCART
		return numericValueinCART
	}
	
	// Method to get the total price from the cart
	static void getCARTTotalPriceNO2() {
		TestObject totalPriceObject = new TestObject()
		totalPriceObject.addProperty('resource-id', ConditionType.EQUALS, 'com.androidsample.generalstore:id/totalAmountLbl')
		// Retrieve the total price text from the cart
		//String totalPriceTextinCART = Mobile.getText(totalPriceObject, 0)
		TestObject xx = findTestObject('com.androidsample.generalstore:id/totalAmountLbl')
		//String totalPriceTextinCART = Mobile.getText(findTestObject('Object Repository/android.widget.TextView - Total Purchase Amount'), 0)
		String totalPriceTextinCART= Mobile.getText(xx, 0)
		println "Total Purchase Amount: " + totalPriceTextinCART
		//return totalPriceTextinCART
	}
	
	
	// Method to retrieve  price of the product in the cart
	static String getCARTTotalPrice11() {
		TestObject totalPriceObject = findTestObject('Object Repository/android.widget.TextView - Total Purchase Amount')
		return Mobile.getText(totalPriceObject, 0)
	}
	
}

