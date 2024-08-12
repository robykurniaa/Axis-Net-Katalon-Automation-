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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords

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
Mobile.waitForElementPresent(findTestObject('Mobile/Login/SuccessLogin'), 0)

//Success Login (Dashboard Page)

Mobile.callTestCase(findTestCase('Test Cases/Mobile/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')
'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3,FailureHandling.OPTIONAL)) {
	// Element is present
	 Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 0)
	 Mobile.tap(findTestObject('Mobile/Homepage/Footer/Playground Tab - V2'), 0)
	Mobile.comment('Element found and tapped')
} else {
	// Element is not present
	Mobile.delay(2)
	Mobile.tap(findTestObject('Mobile/Homepage/Footer/Playground Tab - V2'), 0)
}
// Pause the execution for 2 seconds
Mobile.delay(2)
Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')

'Tap Top Up Sureprize'
Mobile.tap(findTestObject('Mobile/Playground/Top Up Surpz/TopUpSurpzPage'), 3)
Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')

//Mobile.delay(2)
'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Playground/Top Up Surpz/BtnLanjut - Top Up Sureprize'), 5)
Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')

//Mobile.delay(5)
'Claim Bonus'
Mobile.tap(findTestObject('Mobile/Playground/Top Up Surpz/ClaimBonus - Top Up Surpz'), 5)
Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')

Mobile.delay(3)

Mobile.swipe(988,1006,205,950)
Mobile.delay(1)
Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')
Mobile.swipe(988,1006,205,950)
Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')

Mobile.delay(3)

'Btn Lanjut'
Mobile.tap(findTestObject('Mobile/Playground/Top Up Surpz/BtnAmbilBonus - Top Up Sureprize'), 0)
Mobile.delay(3)
Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')


