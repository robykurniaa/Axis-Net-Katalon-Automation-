import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



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

	@And("I tap on the Next button")
	def tapNextButton() {
		Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnNext - LANJUT'), 0)
	}

	@Then("I wait for the success login element to be present")
	def waitForSuccessLogin() {
		Mobile.waitForElementPresent(findTestObject("Mobile/Login/SuccessLogin"), 0)
	}
}
