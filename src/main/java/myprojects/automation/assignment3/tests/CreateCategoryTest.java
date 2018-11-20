package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import myprojects.automation.assignment3.GeneralActions;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        String categoryName = "testCategory-" + ((int)(Math.random()*1000));
        WebDriver driver = getConfiguredDriver();

        GeneralActions action = new GeneralActions(driver);

        action.login(Properties.getAdminLogin(), Properties.getAdminPass());
        action.navigateToSubtab("subtab-AdminCatalog", "subtab-AdminCategories");
        action.createCategory(categoryName);
        action.categoryCheck(categoryName);

        // finish script
        driver.quit();
    }
}
