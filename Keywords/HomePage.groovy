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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.By



public class HomePage {
	// Dynamic method to verify and tap on the 'Male' Radio Button
	static void tapMaleRadioButton() {
		TestObject maleRadioButton = findTestObject('Object Repository/android.widget.RadioButton - Male')
		Mobile.tap(maleRadioButton, 0)
	}
	// Dynamic method to tap on 'Female' Radio Button
	static void tapFemaleRadioButton() {
		TestObject femaleRadioButton = new TestObject('dynamicFemaleRadioButton')
		femaleRadioButton.addProperty('resource-id', ConditionType.EQUALS, 'com.androidsample.generalstore:id/radioFemale')
		Mobile.tap(femaleRadioButton, 0)
	}
	// Method to select a country from dropdown
	static void selectCountry(String countryName) {
		TestObject spinner = findTestObject('android.widget.Spinner')
		Mobile.tap(spinner, 0)
		Mobile.scrollToText(countryName)
		TestObject countryOption = new TestObject()
		countryOption.addProperty('text', ConditionType.EQUALS, countryName)
		Mobile.tap(countryOption, 0)
	}
	// Method to enter name in the text field
	static void enterName(String name) {
		TestObject nameField = new TestObject()
		nameField.addProperty('resource-id', ConditionType.EQUALS, 'com.androidsample.generalstore:id/nameField')
		Mobile.tap(nameField, 0)
		Mobile.setText(nameField, name, 0)
	}
	// Method to tap the 'Let's Shop' button
	static void tapLetsShop() {
		TestObject letsShopButton = findTestObject('android.widget.Button - Lets  Shop')
		Mobile.tap(letsShopButton, 0)
	}
}

