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

Screenshot.takeDynamicScreenshot('Purchase MCCM')
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
Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/ObjBtn - Paket'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase MCCM')
Mobile.delay(1)

'get Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Pilih kategori paket'), 0)

'Tap Internet Promo'
Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/ObjBtn - Internet Promo'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase MCCM')
Mobile.delay(1)

'get Text Kuota Rekomendasi'
Mobile.waitForElementPresent(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Kuota Rekomendasi'), 0)

'choose paket'
// Tap object if exists
if (Mobile.verifyElementExist(findTestObject('Mobile/MCCM/Beli Paket/MccmPaket - Tercucok'), 10, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/MccmPaket - Tercucok'), 10)
} else {
	// Loop through options 1 to 6
	boolean found = false
	for (int i = 1; i <= 6; i++) {
		TestObject option = findTestObject("Mobile/MCCM/Beli Paket/MccmPaket - Option " + i)
		if (Mobile.verifyElementExist(option, 5, FailureHandling.OPTIONAL)) {
			String text = Mobile.getText(option, 5)
			if (text.contains("Masa aktif 1 hari") || text.contains("Masa aktif 2 hari")
				|| text.contains("Masa aktif 3 hari")) {
				Mobile.tap(option, 10)
				found = true
				break
			}
		}
	}
	if (!found) {
		for (int i = 1; i <= 6; i++) {
			TestObject option = findTestObject("Mobile/MCCM/Beli Paket/MccmPaket - Option " + i)
			if (Mobile.verifyElementExist(option, 5, FailureHandling.OPTIONAL)) {
				String text = Mobile.getText(option, 5)
				if (text.contains("Masa aktif 7 hari")) {
					Mobile.tap(option, 10)
					found = true
					break
				}
			}
		}
	}
	// Tap optional object if no valid option found
	if (!found) {
		Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/ObjBtn - Bronet 1 Hr Tab'), 10)
		Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/MccmPaket - Bronet 1Hr (Opsional)'), 10)
	}
}

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase MCCM')
Mobile.delay(1)

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/MCCM/ObjBtn - AKTIFKAN'), 0)

'tap lanjut'
Mobile.tap(findTestObject('Mobile/MCCM/ObjBTN- LANJUT'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase MCCM')
Mobile.delay(1)

'tap konfirmasi'
Mobile.waitForElementPresent(findTestObject('Mobile/MCCM/ObjGetText - Konfirmasi'), 0)
Mobile.tap(findTestObject('Object Repository/Mobile/MCCM/ObjBtn - KONFIRMASI'), 0)

'verify redirect to sync page'
def successSyncPage = findTestObject('Mobile/MCCM/ObjGetText- Transaksi kamu sedang diproses')
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase MCCM')
Mobile.delay(5)

Mobile.waitForElementPresent(successSyncPage, 3, FailureHandling.STOP_ON_FAILURE)

Mobile.delay(20)

'verify success receipt'
def successReceiptPage = findTestObject('Mobile/MCCM/ObjGetText - Transaksi Berhasil')

if (Mobile.waitForElementPresent(successReceiptPage, 3, FailureHandling.OPTIONAL)) {
    // Element is present
	Mobile.delay(1)
	Screenshot.takeDynamicScreenshot('Purchase MCCM')
	Mobile.delay(1)
    Mobile.tap(findTestObject('Mobile/MCCM/ObjBtn - KE HOME'), 3)

    Mobile.comment('Element found and tapped')
} else {
    Mobile.delay(1)
}



