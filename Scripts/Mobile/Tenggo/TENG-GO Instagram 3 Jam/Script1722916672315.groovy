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

if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

    Mobile.comment('Element found and tapped') // Element is not present
} else {
    Mobile.delay(1)
}

'Find Quick Menu Tenggo'
boolean isObjectDetected = false
def tenggo = findTestObject('Mobile/Tenggo/ObjQuickMenu- Teng-Go')

while (!isObjectDetected) {
   try {
	   // Detect the object
	   isObjectDetected = Mobile.verifyElementExist(tenggo, 3,FailureHandling.OPTIONAL )
	   
	   if (isObjectDetected) {
		   // Tap the object if detected
		   Mobile.tap(tenggo, 3)
	   } else {
		   // Swipe if the object is not detected
		   Mobile.swipe(952, 972, 304, 972)
	   }
   } catch (Exception e) {
	   // Handle any exceptions
	   println("An error occurred: " + e.message)
   }
}

'Waiting to Tenggo Section'
Mobile.waitForElementPresent(findTestObject('Mobile/Tenggo/ObjGetText - Kuota TENG-GO'), 0)

'Find Tenggo Kuota Utama 3 Jam'
boolean tenggoObjectDetected = false

def tnggoIg3Hrs = findTestObject('Mobile/Tenggo/ObjPackage - TENG-GO Instagram 3 Jam')

while (!(tenggoObjectDetected)) {
	try {
		// Detect the object
		tenggoObjectDetected = Mobile.verifyElementExist(tnggoIg3Hrs, 3, FailureHandling.OPTIONAL)

		if (tenggoObjectDetected) {
			// Tap the object if detected
			Mobile.tap(tnggoIg3Hrs, 3) // Swipe if the object is not detected
		} else {
			Mobile.swipe(887, 1088, 72, 1088)
		}
	}
	catch (Exception e) {
		// Handle any exceptions
		println('An error occurred: ' + e.message)
	}
}

'Choose Paket'
Mobile.tap(findTestObject('Mobile/Tenggo/ObjPackage - TENG-GO Instagram 3 Jam'), 4)

Mobile.delay(2)

'Tenggo Information Handling'
def tenggoInformation = findTestObject('Mobile/Tenggo/ObjGetText - Tenggo Informartion')

if (Mobile.waitForElementPresent(tenggoInformation, 10, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.delay(1)

    Mobile.tap(findTestObject('Mobile/Tenggo/ObjBtn- OK, NGERTI'), 3)

    Mobile.comment('Element found and tapped') // Element is not present
} else {
    Mobile.delay(1)
}

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Tenggo/ObjBtn - AKTIFKAN'), 5)

'tap lanjut'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBTN- LANJUT'), 3)

'tap konfirmasi'
Mobile.delay(5)
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 5)

'verify redirect to sync page'
def successSyncPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText- Transaksi kamu sedang diproses')

Mobile.delay(5)

Mobile.waitForElementPresent(successSyncPage, 3, FailureHandling.STOP_ON_FAILURE)

Mobile.delay(20)

'Pop up Handling'
def popUpSuccess = findTestObject('Mobile/Tenggo/ObjGetText - Yuk, langsung play kuota kamu')

if (Mobile.verifyElementExist(popUpSuccess, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Tenggo/ObjBtn - OKE, MENGERTI'), 3)

    Mobile.comment('Element found and tapped')
} else {
    Mobile.delay(1)
}

'verify success receipt'
def successReceiptPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Transaksi Berhasil')

if (Mobile.waitForElementPresent(successReceiptPage, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/MCCM/ObjBtn - KE HOME'), 3)

    Mobile.comment('Element found and tapped')
} else {
    Mobile.delay(1)
}



