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

Mobile.startApplication('C:\\Users\\Robby_118308\\Katalon Studio\\Axis Net Automation Mobile\\Material\\com.axis.net9.12.0.apk', 
    true)

Mobile.tap(findTestObject('null'), 
    0)

Mobile.tap(findTestObject('null'), 
    0)

Mobile.tap(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjBtnAmbil - AMBIL'), 0)

Mobile.scrollToText('Setuju')

Mobile.tap(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjBtn - Check Box'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjBtn - AMBIL BONUS'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjBtnAmbil- Claim'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjGetText - Bonus kamu dapat dicek'), 
    0)

Mobile.tap(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjBtn - OKE'), 0)

Mobile.closeApplication()

