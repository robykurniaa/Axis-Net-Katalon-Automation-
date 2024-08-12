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

WebUI.callTestCase(findTestCase('Web/Heroku App/Login/TC 002 Success Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

// Import packages
// Define variables (optional, replace with your credentials)
int facility = 1

int program = 2

// Select Facility
WebUI.click(findTestObject('Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/Facility'))

WebUI.selectOptionByIndex(findTestObject('Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/Facility'), facility)

// Select Healthcare Program
WebUI.click(findTestObject('Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/Program'))

//WebUI.inputOptionByIndex(findTestObject('Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/Program'), program)
// Set Visit Date (replace with desired date format)
String visitDate = '2024-08-01' // Change to your preferred format

WebUI.click(findTestObject('Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/Visit Date'))

WebUI.setText(findTestObject('Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/Visit Date'), visitDate)

// Add comment (optional)
String comment = 'This is an automated appointment booking test.'

WebUI.setText(findTestObject('Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/Comment'), comment)

// Click "Book Appointment" button
WebUI.click(findTestObject('Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/ObjButtonAppoinments'))

// Verify successful booking (replace with your verification steps)
String successMessage = 'Object Repository/Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/Confirm Appointment'

WebUI.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Web/Heroku App/Make Appointment/Page_CURA Healthcare Service/Confirm Appointment'), 
    0)

/*
boolean isBookingConfirmed = WebUI.verifyTextPresent(successMessage, false)

// Assertion (optional)
if (isBookingConfirmed) {
    WebUI.logInfo('Appointment Confirmation!')
} else {
    WebUI.verifyFail('Appointment booking failed!')
}
*/
// Close browser (optional)
WebUI.closeBrowser()

