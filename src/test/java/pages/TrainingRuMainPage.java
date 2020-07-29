package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TrainingRuMainPage extends Page{

    public static final String HOMEPAGE_URL = "https://training.ru/#!/Home?lang=ru";

    public TrainingRuMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".hero-banner__heading")
    WebElement heroBannerHeader;

    @FindBy(css = ".news__item-image")
    List<WebElement> newsImages;

    @FindBy(css = ".footer-modal__action")
    WebElement footerButtonCookieAcceptance;

    public TrainingRuMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public String heroBannerHeaderText() {
        return heroBannerHeader.getText();
    }

    public int newsImagesCount() {
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".news__item-image")));
        return newsImages.size();
    }

    public TrainingRuMainPage clickOnSubscribeButton() {
        footerButtonCookieAcceptance.click();
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".training-list__subscribe-btn.ng-binding")))
                .click();
        return this;
    }

    public String popupBannerHeaderText() {
        return new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".popup__container-subscribe-find.ng-binding")))
                .getText();
    }
}
