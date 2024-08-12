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
	Mobile.tap(findTestObject('Mobile/Alifetime/Emergency Quota/ObjAndroidAlifetime- Alifetime Page'), 0)
	Mobile.comment('Element found and tapped')
} else {
	// Element is not present
	Mobile.delay(2)
	Mobile.tap(findTestObject('Mobile/Alifetime/Emergency Quota/ObjAndroidAlifetime- Alifetime Page'), 5)
}

'Verify Element Alifetime Information Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Alifetime/Emergency Quota/ObjGetText - Alifetime Information'), 5)
Mobile.pressBack()
Mobile.delay(3)

'pop up handling'
def popUpElement = findTestObject('Object Repository/Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')

if (Mobile.verifyElementExist(popUpElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.pressBack()
	Mobile.delay(5)
} else {
}

'Verify Element Alifetime Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Alifetime/Emergency Quota/ObjGetText - Alifetime Page'), 5)

'Scroll to text'
Mobile.scrollToText('Emergency')

'Select Bonus Emergency'
// Step 1: Check if the object 'ObjEmergency - Mini Logo' is present
if (Mobile.verifyElementExist(findTestObject('Mobile/Alifetime/Emergency Quota/ObjEmergency - Mini Logo'), 10)) {
    // Step 2: Tap on 'Alifetime Bonus - Option 1'
    Mobile.tap(findTestObject('Mobile/Alifetime/Emergency Quota/Alifetime Bonus - Option 1'), 10)
    // Step 3: Tap on 'ObjBtn - Ambil'
    Mobile.tap(findTestObject('Mobile/Alifetime/Emergency Quota/ObjBtn - Ambil'), 10)
    // Step 4: Verify the element 'ObjBtn - KLAIM BONUS'
    Mobile.verifyElementExist(findTestObject('Mobile/Alifetime/Emergency Quota/ObjBtn - KLAIM BONUS'), 10)
} else {
    // Step 5: Tap on 'Alifetime Bonus - Option 1'
    Mobile.tap(findTestObject('Mobile/Alifetime/Emergency Quota/Alifetime Bonus - Option 1'), 10)
    // Step 6: Check if the text 'Klaim Bonus Alifetime' is present
    if (Mobile.getText(findTestObject('Object Repository/Mobile/Alifetime/Emergency Quota/ObjGetText- Klaim Bonus Alifetime'), 10) == 'Klaim Bonus Alifetime') {
        // Step 7: Tap on 'ObjBtn - KLAIM BONUS'
        Mobile.tap(findTestObject('Mobile/Alifetime/Emergency Quota/ObjBtn - KLAIM BONUS'), 10)
    } else {
        // Step 8: Press back and tap on 'Alifetime Bonus - Option 2'
        Mobile.pressBack()
        Mobile.tap(findTestObject('Object Repository/Mobile/Alifetime/Emergency Quota/Alifetime Bonus - Option 2'), 10)
    }
}

