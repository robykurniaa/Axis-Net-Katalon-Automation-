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
	Mobile.tap(findTestObject('Mobile/Lock Unlock/LockUnlck'), 0)
	Mobile.comment('Element found and tapped')
} else {
	// Element is not present
	Mobile.delay(2)
	Mobile.tap(findTestObject('Mobile/Lock Unlock/LockUnlck'), 0)
}

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Lock & Unlock')
Mobile.delay(1)

// Verify the object "BtnSimpan" and wait for 2 seconds
Mobile.verifyElementVisible(findTestObject('Object Repository/Mobile/Lock Unlock/BtnSimpan'), 2, FailureHandling.OPTIONAL)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Lock & Unlock')
Mobile.delay(1)

// Tap the mobile object "CheckBoxTelepon" index 1
Mobile.tap(findTestObject('Mobile/Lock Unlock/ObjCheckBoxTelepon'), 0)
Mobile.delay(2)
Screenshot.takeDynamicScreenshot('Lock & Unlock')
Mobile.delay(1)

// Tap the mobile object "CheckBoxSMS"
Mobile.tap(findTestObject('Mobile/Lock Unlock/ObjCheckBoxSms'), 0)
Mobile.delay(2)
Screenshot.takeDynamicScreenshot('Lock & Unlock')
Mobile.delay(1)
// Tap the mobile object "CheckBoxInet"
Mobile.tap(findTestObject('Mobile/Lock Unlock/ObjCheckBoxInet'), 0)
Mobile.delay(2)
Screenshot.takeDynamicScreenshot('Lock & Unlock')
Mobile.delay(1)
// Tap the button "BtnSimpan"
Mobile.tap(findTestObject('Object Repository/Mobile/Lock Unlock/BtnSimpan'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Lock & Unlock')
def dialogMssgLockUnlock = findTestObject('Mobile/Lock Unlock/ObjGetText- wait 5 minutes') 
Mobile.waitForElementPresent(dialogMssgLockUnlock, 0)
Mobile.delay(5)