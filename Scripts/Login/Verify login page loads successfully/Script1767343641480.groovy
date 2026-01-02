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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver

Map<String, Object> prefs = new HashMap<>()

prefs.put("credentials_enable_service", false)
prefs.put("profile.password_manager_enabled", false)

prefs.put("profile.default_content_setting_values.notifications", 2)

ChromeOptions options = new ChromeOptions()
options.setExperimentalOption("prefs", prefs)

options.addArguments("--disable-save-password-bubble")
options.addArguments("--disable-features=PasswordLeakDetection")
options.addArguments("--disable-features=AutofillServerCommunication")
options.addArguments("--disable-notifications")

options.addArguments("--incognito")

WebUI.openBrowser('')
DriverFactory.changeWebDriver(new ChromeDriver(options))

WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), 'standard_user')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), 'qcu24s4901FyWDTwXGr6XA==')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'))

WebUI.verifyMatch(WebUI.getUrl(),'https://www.saucedemo.com/inventory.html', false)