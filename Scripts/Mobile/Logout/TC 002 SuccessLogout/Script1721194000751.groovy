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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


Mobile.callTestCase(findTestCase('Mobile/Login/TC 005 Login with valid AXIS number and otp'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.callTestCase(findTestCase('Mobile/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3,FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 0)
	Mobile.tap(findTestObject('Mobile/Alifetime/BtnAlifetime'), 0)
	Mobile.comment('Element found and tapped')
} else {
	// Element is not present
	Mobile.delay(2)
	Mobile.tap(findTestObject('Mobile/Alifetime/BtnAlifetime'), 0)
}

Mobile.delay(2)

Mobile.delay(2)

//back to alifetime page
Mobile.pressBack()

// Tap the mobile object "BtnSetting"
Mobile.tap(findTestObject('Mobile/Login/Logout/BtnSetting'), 0)

Mobile.delay(2)

// Scroll down to the mobile object "BtnKeluar"
Mobile.scrollToText('Keluar')

Mobile.delay(2)

// Tap the mobile object "BtnKeluar"
Mobile.tap(findTestObject('Mobile/Login/Logout/BtnKeluar'), 0)

Mobile.delay(2)

// Tap the mobile object with the locator "Object Repository/Mobile/Login/Logout/BtnTidak - Keluar"
Mobile.tap(findTestObject('Mobile/Login/Logout/BtnYa - Keluar'), 0)