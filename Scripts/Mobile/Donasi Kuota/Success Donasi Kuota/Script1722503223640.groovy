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
Mobile.startApplication(GlobalVariable.AxisAppId, true)
Mobile.delay(4)

'Tap Start'
Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Start'), 0)

'Input MSISDN'
Mobile.setText(findTestObject('Mobile/Login/Login Page/ObjLoginInputMSISDN'), '083827389321', 0)

Mobile.hideKeyboard()
'Tap Login'
Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Number'), 0)
'Input Otp'
Mobile.setText(findTestObject('Mobile/Login/Login Page/ObjInputOTP'), 'ZXCV22', 0)

Mobile.hideKeyboard()

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnNext - LANJUT'), 0)

'Verfify success Login'
Mobile.waitForElementPresent(findTestObject('Mobile/Login/SuccessLogin'), 4)
//Success Login (Dashboard Page)
'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')
if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

    Mobile.comment('Element found and tapped')
} else {
}
Mobile.delay(3)
Screenshot.takeDynamicScreenshot('Homepage')

'Find Quick Menu Donasi Kuota'
boolean isObjectDetected = false
def donationKuota = findTestObject('Mobile/Donasi Kuota/ObjQuickMenu - Donasi Quota')

while (!isObjectDetected) {
   try {
	   // Detect the object
	   isObjectDetected = Mobile.verifyElementExist(donationKuota, 3,FailureHandling.OPTIONAL )
	   
	   if (isObjectDetected) {
		   // Tap the object if detected
		   Mobile.tap(donationKuota, 3)
	   } else {
		   // Swipe if the object is not detected
		   Mobile.swipe(952, 972, 304, 972)
	   }
   } catch (Exception e) {
	   // Handle any exceptions
	   println("An error occurred: " + e.message)
   }
}

'Scroll Text'
Mobile.delay(2)
Mobile.scrollToText('Sekarang')
Mobile.delay(3)
Screenshot.takeDynamicScreenshot('Donasi Section')

'Tap Donasi'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/Btn - DONASI'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('tap donasi')
Mobile.delay(1)

'get text'
//Mobile.waitForElementPresent(findTestObject('Mobile/Donasi Kuota/ObjGetText - Text Donasi Kuota'), 5)

Mobile.delay(4)

'Tap Donasi Sekarang'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjBtn - Donasi Sekarang'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('donasi sekarang')
Mobile.delay(1)

'Choose Kuota'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjRadioButton V2 - Choose Kuota'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('pilih kuota')
Mobile.delay(2)

'Btn Pilih Nominal Donasi'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjBtn V2 - PILIH NOMINAL DONASI'), 3)

'Choose Denom'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjChooseDenom - 150MB Denom'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('pilih nominal')
Mobile.delay(2)

'Wait Element'
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/Donasi Kuota/ObjGetText - Konfirmasi'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Konfirmasi Page')
Mobile.delay(2)

'Konfirmasi'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjBtn - KONFIRMASI'), 3)

Mobile.delay(5)

'get text success donasi kuota'
Mobile.waitForElementPresent(findTestObject('Mobile/Donasi Kuota/ObjGetText - Success Donasi Kuota'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('success donasi ')
Mobile.delay(2)
