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

Mobile.startApplication(GlobalVariable.AppIdTestOps, true)

'Tap Login to Login Page\r\n'
Mobile.tap(findTestObject('null'), 0)

'Input invalid msisdn number'
Mobile.setText(findTestObject('null'), 
    GlobalVariable.firstMSISDN, 0)

Mobile.hideKeyboard()

'Tap button login'
Mobile.tap(findTestObject('null'), 0)

'Input valid OTP Hardcode'
Mobile.setText(findTestObject('null'), GlobalVariable.ZXCV22, 
    0)

Mobile.hideKeyboard()

'Tap lanjut for go to homepage'
Mobile.tap(findTestObject('null'), 0)

'close brand porta pop up'
Mobile.tap(findTestObject('null'), 0)

'close brand porta message'
Mobile.tap(findTestObject('null'), 0)

'close pop up'
Mobile.tap(findTestObject('null'), 0)

'close bonus balloon page'
Mobile.tap(findTestObject('null'), 0)

'get text for assert equal'
Mobile.getText(findTestObject('null'), 0)

'Tap gembok'
Mobile.tap(findTestObject('null'), 0)

'tap checkbox lock unlock'
Mobile.tap(findTestObject('null'), 0)

'tap simpan'
Mobile.tap(findTestObject('null'), 0)

'close message'
Mobile.tap(findTestObject('null'), 0)

'back to home'
Mobile.tap(findTestObject('null'), 0)

Mobile.closeApplication()

