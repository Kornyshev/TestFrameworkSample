package tests;

import org.testng.annotations.Test;
import pages.TrainingRuMainPage;

import static org.testng.Assert.assertEquals;

public class TrainingRuVisibilityTest extends AbstractTest {

    @Test(priority = 0)
    public void testHeroBannerText() {
        String expectedText = "Jumpstart & Develop\n" +
                "Your Career with Us";
        String actual = new TrainingRuMainPage(driver)
                .openPage()
                .heroBannerHeaderText();
        assertEquals(actual, expectedText);
    }

    @Test(priority = 10)
    public void testNewsImagesCount() {
        int actual = new TrainingRuMainPage(driver)
                .openPage()
                .newsImagesCount();
        assertEquals(actual, 8);
    }
}