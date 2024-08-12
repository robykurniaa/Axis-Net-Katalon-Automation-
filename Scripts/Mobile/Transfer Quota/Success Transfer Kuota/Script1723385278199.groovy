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
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
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

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Tf Kuota')
Mobile.delay(1)
'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')
if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

	Mobile.comment('Element found and tapped')
} else {
}
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Homepage')
Mobile.delay(1)

'Find Quick Menu Transfer Kuota'
boolean isObjectDetected = false
def tfKuota = findTestObject('Mobile/Quick Menu/ObjQuickMenu - Transfer Quota')

while (!isObjectDetected) {
   try {
	   // Detect the object
	   isObjectDetected = Mobile.verifyElementExist(tfKuota, 3,FailureHandling.OPTIONAL )
	   
	   if (isObjectDetected) {
		   // Tap the object if detected
		   Mobile.tap(tfKuota, 3)
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
Screenshot.takeDynamicScreenshot('Homepage')
Mobile.delay(1)

'Verify Kuota'
Mobile.verifyElementExist(findTestObject('Mobile/Transfer Kuota/ObjListKuota - Index 1'), 0)

'Tap Check Box'
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjCheckBox - Choose Kuota'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Homepage')
Mobile.delay(1)

'Choose Transfer Amount'
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjTransferAmount - 300.00 MB'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Homepage')
Mobile.delay(1)

'Input MSISDN'
def msisdnForTransfer = '083125750052'
Mobile.setText(findTestObject('Mobile/Transfer Kuota/ObjSetText- Nomor Handphone'), msisdnForTransfer, 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Homepage')
Mobile.delay(1)

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjBtn - LANJUT'), 0)


'Verify Confirm Page'
Mobile.verifyElementExist(findTestObject('Mobile/Transfer Kuota/ObjBtn - KONFIRMASI'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Homepage')
Mobile.delay(1)

'Tap Konfirmasi'
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjBtn - KONFIRMASI'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Tf Kuota')
Mobile.delay(1)

'Input OTP'
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjInputOtp'), 0)
Mobile.delay(15)
Mobile.hideKeyboard()
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjBtn - LANJUT (OTP)'), 0)

'Wait For Receipt Success Page'
def receiptSuccess = findTestObject('Object Repository/Mobile/Transfer Kuota/ObjGetText - Transaksi Berhasil')
Mobile.waitForElementPresent(receiptSuccess,0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Tf Kuota')
Mobile.delay(10)
