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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// load test data
def testData = TestDataFactory.findTestData('Data Files/verificationForm')

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseUrl)

for (def row = 1; row <= testData.getRowNumbers(); row++) {
	String firstname = testData.getValue('firstname', row)
	String lastname  = testData.getValue('lastname', row)
	String email     = testData.getValue('email', row)
	String gender    = testData.getValue('gender', row)
	String mobile    = testData.getValue('mobile', row)
	String address   = testData.getValue('address', row)
	String expected  = testData.getValue('expectedResult', row)
	
	if (firstname) WebUI.setText(findTestObject('Object Repository/SubmitForm/input_Name_firstName'), firstname)
	
	if (lastname) WebUI.setText(findTestObject('Object Repository/SubmitForm/input_Name_lastName'), lastname)
	
	if (email) WebUI.setText(findTestObject('Object Repository/SubmitForm/input_Email_userEmail'), email)
	
	if (gender) {
		if (gender == 'Male') WebUI.click(findTestObject('Object Repository/SubmitForm/label_gender_male'))
		else if (gender == 'Female') WebUI.click(findTestObject('Object Repository/SubmitForm/label_gender_female'))
	}
	
	if (mobile) WebUI.setText(findTestObject('Object Repository/SubmitForm/input_(10 Digits)_userNumber'), mobile)
	
	WebUI.setText(findTestObject('Object Repository/SubmitForm/input_Date of Birth_dateOfBirthInput'), '08 Nov 2025')
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/input_Date of Birth_dateOfBirthInput'))
	
	WebUI.selectOptionByValue(findTestObject('Object Repository/SubmitForm/select_dob'), '2001', true)
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/div_Sa_react-datepicker__day react-datepick_2f4fc6'))
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/div_Subjects_subjects-auto-complete__value-_d244cf'))
	
	WebUI.setText(findTestObject('Object Repository/SubmitForm/input_Subjects_subjectsInput'), 'Ma')
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/div_Ma_react-select-2-option-0'))
	
	WebUI.setText(findTestObject('Object Repository/SubmitForm/input_Subjects_subjectsInput'), 'Com')
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/div_Com_react-select-2-option-0'))
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/label_Sports_custom-control-label'))
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/label_music'))
	
	WebUI.uploadFile(findTestObject('Object Repository/SubmitForm/input_upload_picture'), GlobalVariable.imagePath)
	
	if (address) WebUI.setText(findTestObject('Object Repository/SubmitForm/textarea_Current Address_currentAddress'), address)
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/div_Select State'))
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/div_NCR_css-1wa3eu0-placeholder'))
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/div_Select City'))
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/button_Delhi_submit'))
	
	WebUI.click(findTestObject('Object Repository/SubmitForm/button_submit'))
	
	//Assertion
	
	if(expected == 'success') {
		WebUI.verifyElementPresent(findTestObject('Object Repository/SubmitForm/modal_body'), 6)
		
		WebUI.verifyElementText(findTestObject('Object Repository/SubmitForm/success_text'), GlobalVariable.success)
		
		WebUI.verifyElementText(findTestObject('Object Repository/SubmitForm/student_name'), 'Dwiana Kamila')
		
		WebUI.verifyElementText(findTestObject('Object Repository/SubmitForm/student_email'), email)
		
		WebUI.verifyElementText(findTestObject('Object Repository/SubmitForm/subjects'), 'Maths, Computer Science')
		
		WebUI.navigateToUrl(GlobalVariable.baseUrl)
	} else if (expected == 'fail') {
		
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/SubmitForm/modal_body'), 6)
		
		WebUI.navigateToUrl(GlobalVariable.baseUrl)
		
    }
	
}

WebUI.closeBrowser()

