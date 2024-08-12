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
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository

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

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')


if (Mobile.verifyElementExist(myElement, 3,FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)
	Mobile.tap(findTestObject('Object Repository/Mobile/Unlimited Gaming/ObjFooter- Hiburan'), 3)
	Mobile.comment('Element found and tapped')
} else {
	// Element is not present
	Mobile.delay(2)
	Mobile.tap(findTestObject('Object Repository/Mobile/Unlimited Gaming/ObjFooter- Hiburan'), 3)
}

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(1)

'Verify Element Hiburan Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Game Token/ObjGetText - Hiburan'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(1)

'Scroll Down'
Mobile.swipe(44,567,44,10)
Mobile.swipe(44,567,44,10)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(1)

'Choose Paket'
// Function to verify and tap on the GameToken option
def verifyAndTapGameTokenOption(String optionPath) {
	def gameTokenOption = ObjectRepository.findTestObject(optionPath)
	def optionText = Mobile.getText(gameTokenOption, 5)
	
	if (optionText.contains("Free Fire") || optionText.contains("Mobile Legends")) {
		Mobile.tap(gameTokenOption, 5)
		return true
	}
	return false
}

// Main script
for (int i = 1; i <= 10; i++) {
	def optionPath = "Object Repository/Mobile/Game Token/GameToken - Option " + i
	if (verifyAndTapGameTokenOption(optionPath)) {
		break
	}
}

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(1)

'Choose Denom'
// Verify the text on the object Mobile/Game Token/ObjGetText - FREE FIRE
String freeFireText = Mobile.getText(findTestObject('Mobile/Game Token/ObjGetText - FREE FIRE'), 10)

if (freeFireText.contains('FREE FIRE')) {
    // If the text FREE FIRE is found, set text on Object Repository/Mobile/Game Token/ObjSetText - Enter User ID FF
    Mobile.setText(findTestObject('Mobile/Game Token/ObjSetText - Masukan User ID FF'), '6710588672', 10)
	// Choose Denom
	Mobile.tap(findTestObject('Mobile/Game Token/ChooseDenomFF - Index 1'), 3)
} else {
    // Verify the text on the object Mobile/Game Token/ObjGetText - MOBILE LEGENDS
    String mobileLegendsText = Mobile.getText(findTestObject('Mobile/Game Token/ObjGetText - MOBILE LEGENDS'), 10)
    
    if (mobileLegendsText.contains('MOBILE LEGENDS')) {
        // If the text MOBILE LEGENDS is found, set text on Object Repository/Mobile/Game Token/ObjSetText - Enter User ID ML
        Mobile.setText(findTestObject('Mobile/Game Token/ObjSetText - Masukkan User ID ML'), '1610340778', 10)
        // Set text on Object Repository/Mobile/Game Token/ObjSetText - Enter Zone ID
        Mobile.setText(findTestObject('Mobile/Game Token/ObjSetText - Masukan Zone ID'), '16791', 10)
		// Choose Denom
		Mobile.tap(findTestObject('Mobile/Game Token/ChooseDenomML - Index 1'), 3)
    }
}

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(1)

'Tap lanjut'
Mobile.tap(findTestObject('Mobile/Game Token/ObjBtn - Lanjut'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(1)

'wait element for confirm section'
def confirm = findTestObject('Mobile/Game Token/ObjGetText - Konfirmasi')
Mobile.waitForElementPresent(confirm, 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(1)

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Game Token/ObjBtn - Aktifkan'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(1)

'Input OTP'
Mobile.tap(findTestObject('Object Repository/Mobile/Game Token/ObjInputOtp'), 0)
Mobile.delay(15)
Mobile.hideKeyboard()
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(1)

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Game Token/ObjBtn - Lanjut (OTP)'), 0)

'Verify Succes Purchase Game Token (Sync Page)'
def syncPage = findTestObject('Mobile/Sync Purchase Paket/ObjGetText- Transaksi kamu sedang diproses')
Mobile.waitForElementPresent(syncPage, 10)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase Game Token')
Mobile.delay(5)

'Verify Get Succes Receipt Purchase Game Token'
def successPage = findTestObject('Mobile/Sync Purchase Paket/ObjGetText - Transaksi Berhasil')

if (Mobile.waitForElementPresent(successPage, 10, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.delay(1)
	Screenshot.takeDynamicScreenshot('Purchase Game Token')
	Mobile.delay(5)
	
	'Tap Button Home if Success get Success Receipt Page'
	Mobile.tap(findTestObject('Mobile/Sync Purchase Paket/ObjBtn - KE HOME'), 3)
	Mobile.delay(2)
	Screenshot.takeDynamicScreenshot('Purchase Game Token')
	Mobile.comment('Element found and tapped')
} else {
	Mobile.delay(1)
}