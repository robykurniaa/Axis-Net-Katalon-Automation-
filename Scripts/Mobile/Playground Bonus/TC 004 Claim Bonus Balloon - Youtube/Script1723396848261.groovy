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
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import customKeywords.ScreenshotKeywords as Screenshot

'Open Axis Net App'
Mobile.startApplication(GlobalVariable.AxisAppId, true)

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

Screenshot.takeDynamicScreenshot('Bonus Balloon')

if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 0)

    Mobile.comment('Element found and tapped') // Element is not present
} else {
    Mobile.delay(2)
}

'Find Quick Menu Donasi Kuota'
boolean isObjectDetected = false
def bonusBalloon = findTestObject('Mobile/Quick Menu/ObjQuickMenu - Bonus Nonstop')

while (!isObjectDetected) {
   try {
	   // Detect the object
	   isObjectDetected = Mobile.verifyElementExist(bonusBalloon, 3,FailureHandling.OPTIONAL )
	   
	   if (isObjectDetected) {
		   // Tap the object if detected
		   Mobile.tap(bonusBalloon, 3)
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
Screenshot.takeDynamicScreenshot('Bonus Balloon')
Mobile.delay(1)

// Define the objects
def yt4Jam = findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjGetText - Unlimited YouTube Shorts 4 Jam')
def yt1Jam = findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjGetText- Unlimited YouTube Shorts 1 Jam')
def objButton = findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjBtnBonusYt - Ambil')

// Verify if either object is present
if (Mobile.verifyElementExist(yt4Jam, 10, FailureHandling.OPTIONAL) || Mobile.verifyElementExist(yt1Jam, 10, FailureHandling.OPTIONAL)) {
    // Tap the button if one of the objects is detected
    Mobile.tap(objButton, 10)
}


Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Bonus Balloon')
Mobile.delay(1)

'Scroll to AMBIL BONUS'
Mobile.scrollToText('Setuju')

'Checkist TnC'
Mobile.tap(findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjBtn - Check Box'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Bonus Balloon')
Mobile.delay(1)

'Tap Ambil Bonus'
Mobile.tap(findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjBtn - AMBIL BONUS'), 0)

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Bonus Balloon')
Mobile.delay(1)

'Claim Bonus'
Mobile.tap(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjBtnAmbil- Claim'), 0)

'Verify Success Claim Bonus'
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjGetText - Bonus kamu dapat dicek'), 
    0)

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Bonus Balloon')
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjBtn - OKE'), 0)



