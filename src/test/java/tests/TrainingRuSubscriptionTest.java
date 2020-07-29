package tests;

import org.testng.annotations.Test;
import pages.TrainingRuMainPage;

import static org.testng.Assert.assertEquals;

public class TrainingRuSubscriptionTest extends AbstractTest{

    @Test(priority = 0)
    public void testPopupHeaderText() {
        String expectedText = "НЕ НАШЛИ ПОДХОДЯЩИЙ ТРЕНИНГ?";
        String actual = new TrainingRuMainPage(driver)
                .openPage()
                .clickOnSubscribeButton()
                .popupBannerHeaderText();
        assertEquals(actual, expectedText);
    }
}