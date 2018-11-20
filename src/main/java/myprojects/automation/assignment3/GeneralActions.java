package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        driver.get(Properties.getBaseAdminUrl());

        /** Authorization*/
        WebElement loginEl = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
        loginEl.sendKeys(login);
        WebElement passEl = driver.findElement(By.id("passwd"));
        passEl.sendKeys(password);
        WebElement submit = driver.findElement(By.name("submitLogin"));
        submit.click();
    }

    public void navigateToSubtab(String idTab, String idSubtab){
        waitForContentLoad();
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id(idTab))).build().perform();
        driver.findElement(By.id(idSubtab)).click();
    }

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        // TODO implement logic for new category creation
        waitForContentLoad();
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("desc-category-new"))).build().perform();
        driver.findElement(By.id("desc-category-new")).click();
        waitForContentLoad();
        driver.findElement(By.id("name_1")).sendKeys(categoryName);
        driver.findElement(By.id("category_form_submit_btn")).click();
        waitForContentLoad();
        driver.findElement(By.name("categoryFilter_name")).sendKeys(categoryName);
        driver.findElement(By.id("submitFilterButtoncategory")).click();

    }

    public void categoryCheck(String categoryName){
        waitForContentLoad();
        try {
            String categoryText = driver.findElement(By.tagName("tbody")).getText();
            assert categoryText.equals(categoryName);
        }
        catch (NullPointerException e){
            System.out.println("Искомая категория не найдена");
        }
    }


    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".icon-refresh icon-spin icon-fw")));
    }

}
