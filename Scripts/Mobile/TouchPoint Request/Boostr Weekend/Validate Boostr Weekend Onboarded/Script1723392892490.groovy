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
Mobile.setText(findTestObject('Mobile/Login/Login Page/ObjLoginInputMSISDN'), '083891411051', 0)

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

Screenshot.takeDynamicScreenshot('Purchase Boostr Weekend')
'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

	Mobile.comment('Element found and tapped') // Element is not present
} else {
	Mobile.delay(1)
}

'Tap Paket'
Mobile.tap(findTestObject('Mobile/TPR/Boostr Weekend/ObjBtn - Paket'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Boostr Weekend')
Mobile.delay(1)

'get Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Pilih kategori paket'), 0)

'Tap Internet Promo'
Mobile.tap(findTestObject('Mobile/TPR/Boostr Weekend/ObjBtn - Paket'), 0)

'Verify Boostr Weekend Tab'
Mobile.waitForElementPresent(findTestObject('Mobile/TPR/Boostr Weekend/ObjGetText- BOOSTR WEEKEND'), 0)

'Swipe'
Mobile.swipe(100,645,10,845)