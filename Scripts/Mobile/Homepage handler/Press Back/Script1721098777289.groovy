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

// Wait for 3 seconds
Mobile.delay(5)

// Press back on Android mobile
Mobile.pressBack()

Mobile.delay(3)
Mobile.pressBack()

// Wait for 3 seconds
Mobile.delay(3)

// Press back on Android mobile
Mobile.pressBack()

// Wait for 3 seconds
Mobile.delay(3)

// Press back on Android mobile
Mobile.pressBack()

// Wait for 3 seconds
Mobile.delay(3)

// Press back on Android mobile
Mobile.pressBack()


Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Homepage')
Mobile.delay(1)

/*

// Function to verify and press back if the pop-up appears
def verifyAndPressBack() {
    if (Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/Pop Up Promo/ObjPopUp - Pop Up Promo'), 5, FailureHandling.OPTIONAL)) {
        Mobile.pressBack()
        return true
    }
    return false
}

// Repeat the verification and press back steps until the pop-up does not appear within 5 seconds
while (verifyAndPressBack()) {
    // Wait a moment before re-verifying
    Mobile.delay(1)
}

println('Done')
*/




/*
// Wait for 3 seconds


// Press back on Android mobile


// Wait for 3 seconds
Mobile.delay(3)

// Press back on Android mobile
Mobile.pressBack()

*/

