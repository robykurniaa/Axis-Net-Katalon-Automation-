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

Mobile.startApplication(GlobalVariable.AxisAppId, true)

//Mobile.startExistingApplication(GlobalVariable.AppIdTestOps, FailureHandling.OPTIONAL)
'Open Axis Net via id\r\n'
Mobile.takeScreenshot('C://Axis Net Automation//ScreenShoot//Mobile//Login//TC 004//1.png')

'Tap Button Login'
Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Start'), 0)

Mobile.takeScreenshot('C://Axis Net Automation//ScreenShoot//Mobile//Login//TC 004//2.png')

'Input <10 Char MSISDN'
Mobile.setText(findTestObject('Mobile/Login/Login Page/ObjLoginInputMSISDN'), GlobalVariable.AxisInvalidNumber, 0)

Mobile.hideKeyboard()

Mobile.takeScreenshot('C://Axis Net Automation//ScreenShoot//Mobile//Login//TC 004//3.png')
Mobile.takeScreenshotAsCheckpoint('Axis Net Login Journey - Robby')
Mobile.closeApplication()

