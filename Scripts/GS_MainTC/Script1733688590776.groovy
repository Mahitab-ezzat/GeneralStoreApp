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
		120.0f,
		110.0f
	]
	
	// Access and print the first price
	// Initialize total price
	Float TotalPrice = productPrices[0]
	println "The Total Price for first added product is: $TotalPrice"
	
	// Loop through each product and interact with its corresponding "ADD TO CART" button using .each
	productNames.each { productName ->
	
	// Locate the product name using a dynamic XPath
	String productXPath = "//*[@class='android.widget.TextView' and (@text='${productName}' or .='${productName}') and @resource-id='com.androidsample.generalstore:id/productName']"
	
	TestObject productObject = new TestObject('dynamicProduct')
	productObject.addProperty('xpath', ConditionType.EQUALS, productXPath)
	
	// Verify the product is visible
	if (Mobile.verifyElementVisible(productObject, 5, FailureHandling.CONTINUE_ON_FAILURE)) {
		println "Product '${productName}' is visible."
		
		// Locate the corresponding "ADD TO CART" button using a relative XPath
		String addToCartXPath = "${productXPath}/following-sibling::android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']"
		println "Generated XPath for 'ADD TO CART': ${addToCartXPath}"
			
		TestObject addToCartObject = new TestObject('dynamicAddToCart')
		addToCartObject.addProperty('xpath', ConditionType.EQUALS, addToCartXPath)
		// Tap on the "Add to Cart" button for this product
		Mobile.tap(findTestObject('Object Repository/android.widget.TextView - ADD TO CART'), 0)
		println "Product '${productName}' added to cart."
		
	}
		}
		
	
	
	/*
		productNames.each { productName ->
			ProductPage.addProductToCart(productName)
		}
	*/
		
	TotalPrice= productPrices[0]+productPrices[1]
	println "Total price of all products in the cart= " + TotalPrice
	// Go to Cart and verify the items added
	ProductPage.goToCart()
	
	CartPage.verifyCartPageVisible()
	
	String totalPriceText = CartPage.getCARTTotalPrice()
	
	// Convert the float value to a string (make sure to format it as needed, e.g., to 2 decimal places)
	String TotalPriceString = String.format("%.2f", TotalPrice)  // Formats to two decimal places
	println TotalPriceString
	
	assert totalPriceText == TotalPriceString : "Expected '$totalPriceText' but found '$TotalPriceString'"
	println "Assertion passed. Both values are the same: '$totalPriceText'"	
	
	// Close the application
	Mobile.closeApplication()
