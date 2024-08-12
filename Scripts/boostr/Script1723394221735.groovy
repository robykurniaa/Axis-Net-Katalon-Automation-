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

Mobile.tap(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjBtnKtgri - Internet'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjGetText- BOOSTR WEEKEND'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ChoosePaket - Boostr Weekend Index 1'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjBtn - AKTIFKAN'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjMethod - Payment Method'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjPaymentMethod - GOPAY'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjPaymentMethod - ShopeePay'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjPaymentMethod - DANA'), 0)

Mobile.getText(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjGetText - Insufficient Balance'), 0)

Mobile.getText(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjCreateOrder - Selesaikan Pembayaran'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/TPR/Boostr Weekend/ObjChoosePaket - Masa Aktif 30 hari'), 0)

Mobile.closeApplication()

