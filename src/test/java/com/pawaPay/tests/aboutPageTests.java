package com.pawaPay.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.junit5.TextReportExtension;
import static com.codeborne.selenide.WebDriverConditions.*;

@ExtendWith({TextReportExtension.class})
public class aboutPageTests {

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void config() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.pawapay.co.uk";
        Configuration.reportsFolder = "test-result/screenshots";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }



    /**
     *This test checks Logo's functionality ,
     *the user expects to be redirected to home page after clicking on it'
     */
    @Test
    public void checkLogoReturnsHomePage(){
        open("/");
        $(".header-nav-item.header-nav-item--collection").click();                      //About
        $(".header-title-logo").click();                                                //Click Logo
        webdriver().shouldHave(url("https://www.pawapay.co.uk/"));

    }


    /**
     *This test checks LinkedIn icon's functionality ,
     *the user expects to be redirected to LinkedIn page of pawaPay'
     */
    @Test
    public void LinkedInIconOnAboutPage(){
        open("/");
        $(".header-nav-item.header-nav-item--collection").click();                        //About
        $(".sqs-svg-icon--wrapper.linkedin-unauth").click();                              //Click LinkedIn
        switchTo().window(1);                                                                 //switch tab
        webdriver().shouldHave(url("https://www.linkedin.com/company/pawapay/"));
    }


    /**
     *This test checks address box which is located on about page
     *to be sure that includes "England" text
     */

    @Test
    public void checkAddressIncludesEngland() throws InterruptedException {
        open("/");
        $(".header-nav-item.header-nav-item--collection").click();                  //About
        $(By.xpath("(//div[@class='sqs-block-content'])[10]")).scrollIntoView(true);         //ScrollDown
        Thread.sleep(1000);                                                            //not necessary, to show scroll down
        $(By.xpath("(//div[@class='sqs-block-content'])[10]")).shouldHave(text("England"));  //Verify
    }

}

