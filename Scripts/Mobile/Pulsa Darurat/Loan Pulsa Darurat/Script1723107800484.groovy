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
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Homepage')
Mobile.delay(1)

'Find Quick Menu Donasi Kuota'
boolean isObjectDetected = false
def loanPulsa = findTestObject('Mobile/Pulsa Darurat/ObjQuickMenu - Pulsa Darurat')

while (!isObjectDetected) {
   try {
	   // Detect the object
	   isObjectDetected = Mobile.verifyElementExist(loanPulsa, 3,FailureHandling.OPTIONAL )
	   
	   if (isObjectDetected) {
		   // Tap the object if detected
		   Mobile.tap(loanPulsa, 3)
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

'Swipe'
Mobile.swipe(988, 1006, 205, 1006)

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Pulsa Darurat Information')
Mobile.delay(1)

Mobile.swipe(988, 1006, 205, 1006)

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Pulsa Darurat Information')
Mobile.delay(1)

Mobile.delay(3)

'Tap button Gunakan Pulsa Darurat'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - GUNAKAN PULSA DARURAT'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Tap Button Gunakan')
Mobile.delay(1)

'Tap Button Pinjam'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - PINJAM'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Tap Button Pinjam')
Mobile.delay(1)
Mobile.swipe(443, 1253, 443, 1050)

'Select Pinjaman'
// Define the object paths
String baseObjectPath = 'Object Repository/Mobile/Pulsa Darurat/Pinjam - '

// Loop through the steps
for (int i = 1000; i <= 10000; i += 1000) {
    // Construct the full object path
    String objectPath = baseObjectPath + i
    
    // Check if the object exists
    if (Mobile.verifyElementExist(findTestObject(objectPath), 10,FailureHandling.OPTIONAL )) {
        // Get the text from the object
        String text = Mobile.getText(findTestObject(objectPath), 10)
        
        // Tap the object if it exists
        Mobile.tap(findTestObject(objectPath), 10)
        break
    } else {
        // Log the current step
        Mobile.comment("object not found")
    }
}

/*
// Check and tap on the appropriate object
def option1 = findTestObject('Object Repository/Mobile/Pulsa Darurat/Pinjam - 1000')
def option2 = findTestObject('Object Repository/Mobile/Pulsa Darurat/Pinjam - 2000')
def option3 = findTestObject('Object Repository/Mobile/Pulsa Darurat/Pinjam - 3000')
def option4 = findTestObject('Object Repository/Mobile/Pulsa Darurat/Pinjam - 5000')

if (Mobile.verifyElementExist(option1, 3, FailureHandling.OPTIONAL)) {
    Mobile.tap(option1, 5)
} else if (Mobile.verifyElementExist(option2, 3, FailureHandling.OPTIONAL)) {
    Mobile.tap(option2, 5)
} else if (Mobile.verifyElementExist(option3, 3, FailureHandling.OPTIONAL)) {
    Mobile.tap(option3, 5)
} else if (Mobile.verifyElementExist(option4, 3, FailureHandling.OPTIONAL)) {
    Mobile.tap(option4, 5)
} else {
    Mobile.comment('No objects found to tap')
}

*/

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Select nominal')
Mobile.delay(1)

'Tap lanjut'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - LANJUT'), 3)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Tap Lanjut')
Mobile.delay(1)

'Get Text'
Mobile.getText(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjGetText - Konfirmasi transaksi'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Confirm page')
Mobile.delay(1)

'Check Box in Cofirm page'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjCheckBox'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('CheckBox')
Mobile.delay(1)

'Tap Konfirmasi'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - KONFIRMASI'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Tap Konfirmasi')
Mobile.delay(1)


'verify redirect to progress page'
def progressPage = findTestObject('Mobile/Pulsa Darurat/ObjGetText- Terima Kasih')
Mobile.waitForElementPresent(progressPage, 3, FailureHandling.STOP_ON_FAILURE)
Mobile.delay (5)
Screenshot.takeDynamicScreenshot('Progress page')
Mobile.delay(1)

Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - KE HOME'), 0)
Mobile.delay(3)
Screenshot.takeDynamicScreenshot('Homepage after loan pulsa')
Mobile.delay(3)




