package com.pawaPay.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.junit5.TextReportExtension;
import static com.codeborne.selenide.WebDriverConditions.*;


@ExtendWith({TextReportExtension.class})
public class aboutPageTests extends TestBase {

    /**
     *This test checks Logo's functionality ,
     *the user expects to be redirected to home page after clicking on it'
     *
     * No need to repeat, I just used it to show as an example
     */
    @DisplayName("Logo function test at About page")
    @RepeatedTest(value=2, name="{displayName} :: {currentRepetition} of {totalRepetitions}")
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
    @DisplayName("LinkedIn icon function test at the About page")
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
     *
     *Note: There is no need to use Thread.sleep, I just used to show scroll down
     */

    @Test
    @DisplayName("Address Text Verification Test")
    public void checkAddressIncludesEngland() throws InterruptedException {
        open("/");
        $(".header-nav-item.header-nav-item--collection").click();                  //About
        $(By.xpath("(//div[@class='sqs-block-content'])[10]")).scrollIntoView(true);         //ScrollDown
        Thread.sleep(1000);                                                            //not necessary, to show scroll down
        $(By.xpath("(//div[@class='sqs-block-content'])[10]")).shouldHave(text("England"));  //Verify
    }

}

