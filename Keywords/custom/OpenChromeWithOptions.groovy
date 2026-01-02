package custom

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.chrome.ChromeOptions

class OpenChromeWithOptions {

    @Keyword
    def openBrowser() {

        Map<String, Object> prefs = new HashMap<>()
        prefs.put("credentials_enable_service", false)
        prefs.put("profile.password_manager_enabled", false)
        prefs.put("profile.default_content_setting_values.notifications", 2)

        ChromeOptions options = new ChromeOptions()
        options.setExperimentalOption("prefs", prefs)

        // 🔽 ADD IT HERE
        options.addArguments("--disable-features=PasswordManagerOnboarding")
        options.addArguments("--incognito")

        DriverFactory.openWebDriver(options)
        WebUI.maximizeWindow()
    }
}
