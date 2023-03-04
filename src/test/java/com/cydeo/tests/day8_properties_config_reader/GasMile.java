package com.cydeo.day8_properties_config_reader;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMile {


    //Task #: Gas Mileage Calculator Automation Test
    //1. Add a new class GasMileageCalculatorTest
    //2. Go to https://www.calculator.net
    @Test
    public void testGasMile(){
        Driver.getDriver().get(" https://www.calculator.net");

    //3. Search for “gas mileage” using search box
        WebElement searchBox=Driver.getDriver().findElement(By.id("calcSearchTerm"));
        searchBox.sendKeys("gas mileage"+ Keys.ENTER);

    //4. Click on the “Gas Mileage Calculator” link
        WebElement GMC=Driver.getDriver().findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        GMC.click();

    //5. On Next page verify:
    //a. Title equals: “Gas Mileage Calculator”

    String actualTitle=Driver.getDriver().getTitle();
    String expectedTitle="Gas Mileage Calculator";
        Assert.assertEquals(actualTitle,expectedTitle);
        //b. “Gas Mileage Calculator” label is displayed
    WebElement label=Driver.getDriver().findElement(By.xpath("//h1[.='Gas Mileage Calculator']"));
    String actualLabel=label.getText();
    String expectedLabel="Gas Mileage Calculator";
    Assert.assertEquals(actualLabel,expectedLabel);
    Assert.assertTrue(label.isDisplayed());

    //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometer=Driver.getDriver().findElement(By.xpath("//input[@value='18900']"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");
    //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer=Driver.getDriver().findElement(By.xpath("//input[@value='18300']"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");
    //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded=Driver.getDriver().findElement(By.xpath("//input[@value='50']"));
        gasAdded.clear();
        gasAdded.sendKeys("16");
    //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice=Driver.getDriver().findElement(By.xpath("//input[@value='1']"));
        gasAdded.clear();
        gasAdded.sendKeys("3.55");
    //10. Click on Calculate button
        WebElement calculateButton=Driver.getDriver().findElement(By.xpath("(//table[@class='panel2']//tr[5])[2]//input[@type='image']"));
        calculateButton.click();
    //11. Verify mpg value is as expected:
        WebElement mpg=Driver.getDriver().findElement(By.xpath("//span[@class='bigtext']"));
        String actualPMG=mpg.getText();

    //Expected value: “ mpg”
        Assert.assertTrue(actualPMG.contains("23.44"));

    //

}}
