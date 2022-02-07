package com.pawaPay.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({TextReportExtension.class})
public class apiDocsPage extends TestBase {

    /**
     *This test checks the search function at the API Docs page,
     *
     * Note:There is no need to use, Thread.sleep,  I just used to show click action gets related part to view
     */
    @Test
    @DisplayName("Search Box test at API Docs page")
    public void searchBoxTest() throws InterruptedException {
        open("/");
        $(withText("API Docs")).click();
        $(By.xpath("//input[@type='text']")).setValue("collection");
        $(withText("Deposit (")).click();
        Thread.sleep(1000);
        $(".sc-iBPRYJ.eYIHFZ").shouldBe(Condition.visible);

    }



    /**
     * This test checks all dropdowns are working properly, first loop iterates tables which includes dropdowns
     * the second loop iterates all dropdowns inside the table
     * (all table does not have same amount of dropdown,so I used if statement to filter)
     *
     * Note: There is no need to use, Thread.sleep, I just used to show dropdown's opening/closing actions
     *
     */
    @Test
    @DisplayName("Response part dropdown arrow tests")
    public void responseCodeArrowTest() throws InterruptedException {
        open("/");
        $(withText("API Docs")).click();

        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 6; j++) {
                if ($(By.xpath("(//h3[@class='sc-gVgnHT dJYToW']/..)[" + i + "]/div[" + j + "]")).is(Condition.visible)) {

                    $(By.xpath("(//h3[@class='sc-gVgnHT dJYToW']/..)[" + i + "]/div[" + j + "]")).click();
                    Thread.sleep(1000);
                    $(By.xpath("(//h3[@class='sc-gVgnHT dJYToW']/..)[" + i + "]/div[" + j + "]")).click();
                }
            }
        }
    }

    /**
     * This test checks function of API Reference dropdowns.
     * If user clicks on Payout title,
     * expects to see HTTP commands and  Payout related text on the right side.
     * And of course; If user clicks on Deposits title,
     * expects to see HTTP commands and  Deposits related text on the right sid
     *
     * Note: There is no need to use Thread.sleep, I just used it to show opened dropdown
     */
    @Test
    @DisplayName("API References Dropdowns Test")
    public void APIReferencesDropdownsExplanations() throws InterruptedException {

        open("/");
        $(withText("API Docs")).click();
        $(By.xpath("(//label[@type='tag'])[1]")).click();
        Thread.sleep(1000);
        assertTrue($(By.xpath("(//ul[@class='sc-XhUPp hYgdYI'])[3]")).isDisplayed());
        Thread.sleep(1000);
        $(By.xpath("(//label[@type='tag'])[2]")).click();
        Thread.sleep(1000);
        assertTrue($(By.xpath("(//ul[@class='sc-XhUPp hYgdYI'])[3]")).isDisplayed());
    }


}
