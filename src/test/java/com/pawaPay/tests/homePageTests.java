package com.pawaPay.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({TextReportExtension.class})
public class homePageTests extends TestBase {

    /**
    *This test checks "Get API access" button function,
    *it redirects form page and fills form automatically
    *with dummy values
    */
    @Test
    public void GetAPIAccessButton() {
        open("/");
        $(By.partialLinkText("Get API access")).click();                                             //get API access link
        $(By.name("fname")).setValue("testName");                                                    //enter Name
        $(By.name("lname")).setValue("testLastName");                                                //enter lastname
        $(By.xpath("//input[@name='email']")).setValue("test@test.com");             //enter email
        $(By.id("select-2f393a3d-e559-4d98-a98f-61a2764a2ca4-field")).selectOption("20,000 - 40,000");      //select payment option
        $(By.id("textarea-yui_3_17_2_1_1610023391961_10243-field")).setValue("Hi everybody, please ignore this data");      //message
        $(By.xpath("//input[@type='submit']")).click();

        $(By.xpath("//input[@type='submit']")).shouldNotBe(Condition.visible);

    }


    /**
     *This test checks that if user hover over mobile account owners pictures
     * it gives an information about picture
     */

    @Test
    public void hoverOverPictures() throws InterruptedException {
        open("/");

        for(int i=1;i<5;i++){
            $(By.xpath("(//div[@class='col sqs-col-3 span-3'])["+i+"]")).hover();
            Thread.sleep(1000);                                                   //not mandatory, just to show hover
        }
    }


    /**
     *This test checks "Send Me Use Cases" button function,
     *it redirects form page and checks form is displayed dor not
     */
    @Test
    public void sendMeUseCasesButton() throws InterruptedException {
        open("/");
        $(".sqs-block-button-element--medium.sqs-button-element--primary.sqs-block-button-element").click();
        Thread.sleep(1000);                                                          //not necessary, just to shot contact form
        assertTrue($(".sqs-block.form-block.sqs-block-form").isDisplayed());     //check form is displayed or not
    }


    /**
     *This test checks "Send me dev docs and access info" button function,
     *it redirects form page and checks form is displayed dor not
     */
    @Test
    public void sendMeDevDocsButton() throws InterruptedException {
        open("/");
        $(withText("dev docs")).click();
        Thread.sleep(1000);                                                          //not necessary, just to shot contact form.
        assertTrue($(".sqs-block.form-block.sqs-block-form").isDisplayed());     //check form is displayed or not.
    }




}
