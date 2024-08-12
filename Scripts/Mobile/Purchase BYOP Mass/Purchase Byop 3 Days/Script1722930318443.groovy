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

if (Mobile.verifyElementExist(myElement, 3,FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)
	Mobile.comment('Element found and tapped')
} else {
	// Element is not present
	Mobile.delay(1)
}

'Find Quick Menu Suka - Suka'
boolean isObjectDetected = false
def sukaSuka = findTestObject('Mobile/Byop/OnjQuickMenu - BYOP')

while (!isObjectDetected) {
   try {
	   // Detect the object
	   isObjectDetected = Mobile.verifyElementExist(sukaSuka, 3,FailureHandling.OPTIONAL )
	   
	   if (isObjectDetected) {
		   // Tap the object if detected
		   Mobile.tap(sukaSuka, 3)
	   } else {
		   // Swipe if the object is not detected
		   Mobile.swipe(952, 972, 304, 972)
	   }
   } catch (Exception e) {
	   // Handle any exceptions
	   println("An error occurred: " + e.message)
   }
}

Mobile.delay(3)

'Tap Buat Paket'
Mobile.tap(findTestObject('Mobile/Byop/ObjBtn - Coba Buat paket'), 5)

'Tap Lewati'
Mobile.tap(findTestObject('Mobile/Byop/ObjBtn - Lewati'), 5)

'Check Byop page'
Mobile.waitForElementPresent(findTestObject('Mobile/Byop/ObjGetText - Byop Page'), 0)
//Mobile.verifyElementExist('Mobile/Byop/ObjGetText - Byop Page')
Mobile.delay(3)

'Choose Byop 3 Hari'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/ObjBtn - 3 Hari'), 5)

'Choose paket index 1'
Mobile.tap(findTestObject('Mobile/Byop/ObjChoosePaket - Byop Index 1'), 5)

'Scroll to Tambah'
Mobile.scrollToText('Tambah')

'Tap Tambah'
Mobile.tap(findTestObject('Mobile/Byop/ObjBtn- Tambah Kuota Pelengkap'), 5)

'Tap Pilih'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/ObjBtnVideo - PILIH (3 hari)'), 5)

'Choose Add on Index 1'
Mobile.tap(findTestObject('Mobile/Byop/ObjChooseAddOn - Index 1'), 5)

Mobile.scrollToText('Tambahkan')

'Tap Tambahkan'
Mobile.tap(findTestObject('Mobile/Byop/ObjBtn - Tambahkan'), 5)

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Byop/ObjBtn - Lanjut'), 5)

'Check Confirm page'
Mobile.waitForElementPresent(findTestObject('Mobile/Byop/ObjGetText - Konfirmasi (Process)'), 5)
//Mobile.verifyElementExist('Mobile/Byop/ObjGetText - Byop Page')
Mobile.delay(5)

'Scroll Aktivasi'
Mobile.scrollToText('SEKARANG')

'Tap Aktivasi'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/ObjBtn - AKTIVASI SEKARANG'), 0)
Mobile.delay(5)

'Verify Receipt Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Byop/ObjGetText - Receipt Page'), 0)

'Tap Home'
Mobile.tap(findTestObject('Mobile/Byop/ObjBtn- KE HOME'), 0)
