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

Mobile.callTestCase(findTestCase('Mobile/Login/TC 005 Login with valid AXIS number and otp'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.callTestCase(findTestCase('Test Cases/Mobile/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)
Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3,FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

    Mobile.comment('Element found and tapped')
} else {
}

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('1. Isi Aigo')
Mobile.delay(1)

'Find Quick Menu Isi Aigo'
boolean isObjectDetected = false
def isiAigo = findTestObject('Mobile/Quick Menu/ObjQuickMenu - Isi Aigo')

while (!isObjectDetected) {
   try {
	   // Detect the object
	   isObjectDetected = Mobile.verifyElementExist(isiAigo, 3,FailureHandling.OPTIONAL )
	   
	   if (isObjectDetected) {
		   // Tap the object if detected
		   Mobile.tap(isiAigo, 3)
	   } else {
		   // Swipe if the object is not detected
		   Mobile.swipe(952, 972, 304, 972)
	   }
   } catch (Exception e) {
	   // Handle any exceptions
	   println("An error occurred: " + e.message)
   }
}

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('2. Isi Aigo')
Mobile.delay(1)

// Tap the mobile object 'Mobile/Redeem Aigo/ObjBtnAktifVoucher'
Mobile.tap(findTestObject('Mobile/Redeem Aigo/ObjBtnAktifVoucher'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('3. Isi Aigo')
Mobile.delay(1)

'pop up handling'
def popUpElement = findTestObject('Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')

if (Mobile.verifyElementExist(popUpElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.pressBack()
	Mobile.delay(5)
	Mobile.setText(findTestObject('Mobile/Redeem Aigo/ObjFillAigoNumber'), GlobalVariable.AigoCode, 5)
} else {
	Mobile.setText(findTestObject('Mobile/Redeem Aigo/ObjFillAigoNumber'), GlobalVariable.AigoCode, 5)
}

//Mobile.setText(findTestObject('Mobile/Login/Login Page/ObjLoginInputMSISDN'), GlobalVariable.firstMSISDN, 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('4. Isi Aigo')
Mobile.delay(1)
Mobile.hideKeyboard()

// Tap the mobile object 'Mobile/Redeem Aigo/ObjBtnAigoNext'
Mobile.tap(findTestObject('Mobile/Redeem Aigo/ObjBtnAigoNext'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('5. Isi Aigo')
Mobile.delay(1)

'Tap button redeem aigo'
Mobile.tap(findTestObject('Mobile/Redeem Aigo/ObjBtnConfirmRedeem'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('6. Isi Aigo')
Mobile.delay(1)

'check receipt'
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('7. Isi Aigo')
Mobile.delay(5)