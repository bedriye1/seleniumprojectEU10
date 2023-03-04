package com.cydeo.day6_alerts_iframes_windows;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsHandling {
    @Test
    public void test1() throws InterruptedException {
        Driver.getDriver().get("https://letcode.in/test");
        String homePage=Driver.getDriver().getWindowHandle();

        Thread.sleep(3000);
        WebElement windowsButton=Driver.getDriver().findElement(By.xpath("//a[text()='Tabs']"));
        windowsButton.click();
        String secondPage=Driver.getDriver().getWindowHandle();

        Thread.sleep(3000);
        WebElement multipleButton=Driver.getDriver().findElement(By.xpath("//button[text()='Muiltiple windows']"));
        multipleButton.click();
        String thirdPage=Driver.getDriver().getWindowHandle();

        Set<String> allWindows=Driver.getDriver().getWindowHandles();
        for (String each : allWindows) {
            System.out.println("each = " + each);
            Driver.getDriver().switchTo().window(each);
            System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
            Thread.sleep(3000);
        }
        Thread.sleep(3000);
        Driver.getDriver().switchTo().window(secondPage);
        System.out.println(Driver.getDriver().getTitle());




    }
}
