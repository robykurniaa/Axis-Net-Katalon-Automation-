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

'Open website\r\n'
WebUI.openBrowser('https://demoqa.com/')

WebUI.delay(2)

'Scroll to element'
WebUI.scrollToElement(findTestObject('Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjElementsPage'), 0)

'Click element'
WebUI.click(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjElementsPage'))

WebUI.delay(2)

'scroll element text box'
WebUI.scrollToElement(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjTextBox'), 0)

'Click text box'
WebUI.click(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjTextBox'))

'input name'
WebUI.setText(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjInputName'), 'Robby')

'input email'
WebUI.setText(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjInputEmail'), 'roby@gmail.com')

'input address'
WebUI.setText(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjInputCurrent Adddres'), 'Bandung')

'input permanent addr'
WebUI.setText(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjInputPermanentAddresss'), 
    'Bandung')

'scroll to submit button'
WebUI.scrollToElement(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjBtnSubmit'), 0)

WebUI.click(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjBtnSubmit'))

WebUI.click(findTestObject('Object Repository/Web/Demo QA/Elements/Check Box/Page_DEMOQA/ObjTextViewSuccessSubmit - Check Box'))

WebUI.closeBrowser()

