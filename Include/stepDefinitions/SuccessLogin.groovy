import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then
import cucumber.api.java.en.And

class SuccessLogin {

    @Given("the application is started")
    def startApplication() {
        Mobile.startApplication(GlobalVariable.AxisAppId, true)
    }

    @And("the Axis Net app is opened")
    def openAxisNet() {
        // Additional steps if needed
    }

    @When("I tap on the {string} button on the login page")
    def tapButton(String button) {
        Mobile.tap(findTestObject("Mobile/Login/Login Page/ObjBtnLoginPage - " + button), 0)
    }

    @And("I enter the MSISDN in the login input field")
    def enterMSISDN() {
        Mobile.setText(findTestObject("Mobile/Login/Login Page/ObjLoginInputMSISDN"), GlobalVariable.firstMSISDN, 0)
    }

    @And("I hide the keyboard")
    def hideKeyboard() {
        Mobile.hideKeyboard()
    }

    @And("I enter the OTP in the OTP input field")
    def enterOTP() {
        Mobile.setText(findTestObject("Mobile/Login/Login Page/ObjInputOTP"), GlobalVariable.ZXCV22, 0)
    }

    @Then("I wait for the success login element to be present")
    def waitForSuccessLogin() {
        Mobile.waitForElementPresent(findTestObject("Mobile/Login/SuccessLogin"), 0)
    }
}
