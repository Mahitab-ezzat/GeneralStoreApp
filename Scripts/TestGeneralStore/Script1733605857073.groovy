import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable as GlobalVariable
import ProductPage
import CartPage
import HomePage

// Start the application

	try {
		Mobile.startApplication('D:\\AndroidTesting\\FlairTech\\General-Store.apk', true)
		println "Application started successfully."
		boolean isAppInstalled = Mobile.verifyAppInstalled('General-Store.apk', 30)
		assert isAppInstalled : "App installation failed!"
		println "App installation verified successfully."
	} catch (Exception e) {
		println "Error occurred: " + e.message
}
	// Home Page Actions
	HomePage.tapMaleRadioButton()
	HomePage.tapFemaleRadioButton()
	HomePage.selectCountry('Egypt')
	HomePage.enterName('Mahi')
	HomePage.tapLetsShop()

	// Product Page Actions
	
	List<String> productNames = [
		"Air Jordan 4 Retro",
		"Air Jordan 1 Mid SE"
	]
	//String addToCartRESID= "com.androidsample.generalstore:id/productAddCart"
	
	//list of product prices
	List<Float> productPrices = [
		160.97f,
		120.0f
	]
	
	// need to add Product1 to the cart
	TestObject dynamicAddToCart = new TestObject()
	// Add the resource-id property
	String addToCartRESID = 'com.androidsample.generalstore:id/productAddCart'
	dynamicAddToCart.addProperty('resource-id', ConditionType.EQUALS, addToCartRESID)
	Mobile.tap(findTestObject('Object Repository/android.widget.TextView - ADD TO CART'), 0)
	println "Air Jordan 4 Retro added to the cart"
	// Loop through each product and interact with its corresponding "ADD TO CART" button
	// Add products to cart		//String addToCartRESID = 'com.androidsample.generalstore:id/productAddCart'
	for (int i=1; i <= productNames.size(); i++) {
			String productName = productNames[i]
			ProductPage.addProductToCart(productName)
			}
		
			productNames.each { productName ->
				ProductPage.addProductToCart(productName)
			}
			
		// Go to Cart and verify the items added
		CartPage.goToCart()
		//CartPage.verifyCartPageVisible()
		
		// Retrieve the total price and print
		//String totalPrice = CartPage.getTotalPrice()
		//println "Price in the cart: " + totalPrice
		
	// Retrieve and verify total price
	//String totalPrice = ProductPage.getTotalPrice(i)
	//println "Total Purchase Amount: " + totalPrice

	// Add assertions if necessary
	//assert totalPrice == 'expected_value' : "Total price mismatch."
	// Close the application
	//Mobile.closeApplication()
	