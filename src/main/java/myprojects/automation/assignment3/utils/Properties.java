package myprojects.automation.assignment3.utils;

import org.openqa.selenium.remote.BrowserType;

/**
 * Help class to get passed parameters from environment for further usage in the automation project
 */
public class Properties {
    private static final String DEFAULT_BASE_URL = "http://prestashop-automation.qatestlab.com.ua/";
    private static final String DEFAULT_BASE_ADMIN_URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private static final String DEFAULT_BROWSER = BrowserType.CHROME;
    private static final String DEFAULT_ADMIN_LOGIN = "webinar.test@gmail.com";
    private static final String DEFAULT_ADMIN_PASS = "Xcg7299bnSmMuRLp9ITw";

    /**
     *
     * @return Website frontend.
     */
    public static String getBaseUrl() {
        return System.getProperty(EnvironmentVariables.BASE_URL.toString(), DEFAULT_BASE_URL);
    }

    /**
     *
     * @return Website backend (ULR of the Admin Panel.)
     */
    public static String getBaseAdminUrl() {
        return System.getProperty(EnvironmentVariables.BASE_ADMIN_URL.toString(), DEFAULT_BASE_ADMIN_URL);
    }

    /**
     *
     * @return The name of the browser that need to be used for execution.
     */
    public static String getBrowser() {
        return System.getProperty(EnvironmentVariables.BROWSER.toString(), DEFAULT_BROWSER);
    }

    public static String getAdminLogin(){
        return System.getProperty(EnvironmentVariables.ADMIN_LOGIN.toString(), DEFAULT_ADMIN_LOGIN);
    }

    public static String getAdminPass(){
        return System.getProperty(EnvironmentVariables.ADMIN_PASS.toString(), DEFAULT_ADMIN_PASS);
    }

}

/**
 * All parameters that are passed to automation project
 */
enum EnvironmentVariables {
    BASE_URL("env.url"),
    BASE_ADMIN_URL("env.admin.url"),
    BROWSER("browser"),
    ADMIN_LOGIN("admin.login"),
    ADMIN_PASS("admin.pass");

    private String value;
    EnvironmentVariables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}