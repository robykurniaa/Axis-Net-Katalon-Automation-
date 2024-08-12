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
import customKeywords.ScreenshotKeywords as Screenshot

'Open Axis Net App'
Mobile.startApplication('kobiton-store:618377', true)

Mobile.delay(4)
'Tap Start'
Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Start'), 0)

'Input MSISDN'
Mobile.setText(findTestObject('Mobile/Login/Login Page/ObjLoginInputMSISDN'), '083110568297', 0)

Mobile.hideKeyboard()
'Tap Login'
Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Number'), 0)
'Input Otp'
Mobile.setText(findTestObject('Mobile/Login/Login Page/ObjInputOTP'), 'DT2022', 0)

Mobile.hideKeyboard()

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnNext - LANJUT'), 0)

'Verfify success Login'
Mobile.waitForElementPresent(findTestObject('Mobile/Login/SuccessLogin'), 0)

//Success Login (Dashboard Page)

Mobile.callTestCase(findTestCase('Test Cases/Mobile/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3,FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)
	Mobile.comment('Element found and tapped')
} else {
	// Element is not present
}
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('1. Cek Aigo')
Mobile.delay(1)
'Find Quick Menu Cek Aigo'
boolean isObjectDetected = false
def cekAigo = findTestObject('Mobile/Cek Aigo/ObjQuickMenu - Cek AIGO')

while (!isObjectDetected) {
   try {
	   // Detect the object
	   isObjectDetected = Mobile.verifyElementExist(cekAigo, 3,FailureHandling.OPTIONAL )
	   
	   if (isObjectDetected) {
		   // Tap the object if detected
		   Mobile.tap(cekAigo, 3)
	   } else {
		   // Swipe if the object is not detected
		   Mobile.swipe(952, 972, 304, 972)
	   }
   } catch (Exception e) {
	   // Handle any exceptions
	   println("An error occurred: " + e.message)
   }
}


'wait element'
Mobile.waitForElementPresent(findTestObject('Mobile/Cek Aigo/ObjGetText - fresh cek kuota'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('1. Cek Aigo')
Mobile.delay(1)

'tap aktifkan voucher'
Mobile.tap(findTestObject('Object Repository/Mobile/Cek Aigo/ObjBtn - Aktifkan Voucher'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('1. Cek Aigo')
Mobile.delay(1)

'pop up handling'
def popUpElement = findTestObject('Object Repository/Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')

if (Mobile.verifyElementExist(popUpElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.pressBack()
	Mobile.delay(2)
} else {
	
}

'input SN Aigo'
Mobile.setText(findTestObject('Object Repository/Mobile/Cek Aigo/ObjSetText - Fill SN Code'), '1086500000462630', 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('1. Cek Aigo')
Mobile.delay(1)

'tap lanjut'
Mobile.tap(findTestObject('Object Repository/Mobile/Cek Aigo/ObjBtn - Lanjut (after input SN)'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('1. Cek Aigo')
Mobile.delay(1)

'verify element'
Mobile.waitForElementPresent(findTestObject('Mobile/Cek Aigo/ObjBtnOk - pop up cek aigo'), 5)
Mobile.delay(5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('1. Cek Aigo')
Mobile.delay(1)

Mobile.tap(findTestObject('Mobile/Cek Aigo/ObjBtnOk - pop up cek aigo'), 0)

Mobile.delay(5)