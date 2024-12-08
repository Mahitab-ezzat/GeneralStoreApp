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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.By
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject


public class ProductPage {
	// Method to add a product to the cart
	static void addProductToCart(String productName) {
		
	// Locate the product name using a dynamic XPath
	String productXPath = "//*[@class='android.widget.TextView' and (@text='${productName}' or .='${productName}') and @resource-id='com.androidsample.generalstore:id/productName']"
	
	TestObject productObject = new TestObject('dynamicProduct')
	productObject.addProperty('xpath', ConditionType.EQUALS, productXPath)
	
		// Verify the product is visible
		if (Mobile.verifyElementVisible(productObject, 5, FailureHandling.CONTINUE_ON_FAILURE)) {
			String addToCartXPath = "${productXPath}/following-sibling::android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']"
			TestObject addToCartObject = new TestObject('dynamicAddToCart')
			addToCartObject.addProperty('xpath', ConditionType.EQUALS, addToCartXPath)
			Mobile.tap(addToCartObject, 0)
			Mobile.tap(findTestObject('Object Repository/android.widget.TextView - ADD TO CART'), 0)
			println "Product '${productName}' added to the cart."
		} else {
			println "Product '${productName}' is not visible."
		}
	}
	
	// Method to tap on the cart button
	static void goToCart() {
		TestObject cartButton = new TestObject()
		cartButton.addProperty('resource-id', ConditionType.EQUALS, 'com.androidsample.generalstore:id/appbar_btn_cart')
		Mobile.tap(findTestObject('Object Repository/android.widget.ImageButton'), 0)
		//Mobile.tap(cartButton, 0)
		println "Tapped on the cart button."
	}
	
	
}
