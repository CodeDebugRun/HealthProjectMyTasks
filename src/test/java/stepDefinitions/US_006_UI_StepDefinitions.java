package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import pages.US006_Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class US_006_UI_StepDefinitions {

    US006_Page settingsTestPage = new US006_Page();
    String excelPath = "src/test/resources/MedunnaPersonel.xlsx";
    FileInputStream fis;
    {
        try {
            fis = new FileInputStream(excelPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Workbook workbook;
    {
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Sheet sheet = workbook.getSheet("Sheet1");

    @Given("EA kullanici {string} sayfasina gider")
    public void eaKullaniciSayfasinaGider(String baseUrl) {
        Driver.getDriver().get(baseUrl);
    }

    @When("EA login olmak icin signin e tiklar")
    public void eaLoginOlmakIcinSigninETiklar() {
        ReusableMethods.waitForClickablility(settingsTestPage.signinSymbol,5);
        settingsTestPage.signinSymbol.click();
        settingsTestPage.signinButtonMainPage.click();
    }

    @And("EA username icin {string} kullanici adini gonderir")
    public void eaUsernameIcinKullaniciAdiniGonderir(String userName) {
        settingsTestPage.userNameBox.sendKeys(userName);
    }

    @And("EA password icin {string} parolasini gonderir")
    public void eaPasswordIcinParolasiniGonderir(String password)
    {
        settingsTestPage.passwordBox.sendKeys(password);
    }

    @And("EA signine tiklar")
    public void eaSignineTiklar() {
        settingsTestPage.submitButton.click();
    }

    @Then("EA username ile giris yaptigini dogrular")
    public void eaUsernameIleGirisYaptiginiDogrular() {
        Assert.assertTrue("My Pages'a gidilmedi",settingsTestPage.myPagesLink.getText().contains("MY PAGES"));
        }

    @Then("EA settings linkini tiklar")
    public void eaSettingsLinkiniTiklar() {
        settingsTestPage.accountMenu.click();
        settingsTestPage.settingsLink.click();
    }

    @Then("EA FirstName in dogru {string} oldugunu dogrular")
    public void eaFirstNameInDogruOldugunuDogrular(String firstName) {
                Assert.assertTrue("FirstName dogrulanmadi",
                settingsTestPage.settingsFirstNameBox.getAttribute("value").contains(firstName));
    }
     @Then("EA LastName in dogru {string} oldugunu dogrular")
    public void eaLastNameInDogruOldugunuDogrular(String lastName) {
         Assert.assertTrue("FirstName dogrulanmadi",
                 settingsTestPage.settingsLastNameBox.getAttribute("value").contains(lastName));
     }
    @Then("EA Email in dogru {string} oldugunu dogrular")
    public void eaEmailInDogruOldugunuDogrular(String eMail) {
        Assert.assertTrue("Email dogrulanmadi",
                settingsTestPage.settingsEmailBox.getAttribute("value").contains(eMail));
        }
    @Then("EA sign out icin Account menuye tiklar")
    public void eaSignOutIcinAccountMenuyeTiklar() {
        settingsTestPage.accountMenu.click();
        settingsTestPage.signOutLink.click();
    }

    @And("EA username icin {string} kullanici adini excelden gonderir")
    public void eaUsernameIcinKullaniciAdiniExceldenGonderir(String userNameEx) {
        Row row = sheet.getRow(3);
        Cell cellUsername = row.getCell(4);
        userNameEx = cellUsername.toString();
        settingsTestPage.userNameBox.sendKeys(userNameEx);
    }
    @And("EA password icin {string} parolasini excelden gonderir")
    public void eaPasswordIcinParolasiniExceldenGonderir(String passwordEx) {
        Row row = sheet.getRow(3);
        Cell cellPassword = row.getCell(6);
        passwordEx = cellPassword.toString();
        settingsTestPage.passwordBox.sendKeys(passwordEx);
    }

    @Then("EA FirstName in dogru {string} oldugunu excelden dogrular")
    public void eaFirstNameInDogruOldugunuExceldenDogrular(String firstNameEx) {
        Row row = sheet.getRow(3);
        Cell cellFirstName = row.getCell(2);
        firstNameEx = cellFirstName.toString();
        Assert.assertTrue("FirstName dogrulanmadi",
                settingsTestPage.settingsFirstNameBox.getAttribute("value").contains(firstNameEx));
    }

    @Then("EA LastName in dogru {string} oldugunu excelden dogrular")
    public void eaLastNameInDogruOldugunuExceldenDogrular(String lastNameEx) {
        Row row = sheet.getRow(3);
        Cell cellLastName = row.getCell(3);
        lastNameEx = cellLastName.toString();
        Assert.assertTrue("LasttName dogrulanmadi",
                settingsTestPage.settingsLastNameBox.getAttribute("value").contains(lastNameEx));
    }

    @Then("EA Email in dogru {string} oldugunu excelden dogrular")
    public void eaEmailInDogruOldugunuExceldenDogrular(String emailEx) {
        Row row = sheet.getRow(3);
        Cell cellEmail = row.getCell(5);
        emailEx = cellEmail.toString();
        Assert.assertTrue("Email dogrulanmadi",
                settingsTestPage.settingsEmailBox.getAttribute("value").contains(emailEx));
    }

    @Then("EA FirstName {string} gunceller")
    public void eaFirstNameGunceller(String guncelFirstName) {
        Row row = sheet.getRow(3);
        Cell cellGuncelFirstName = row.getCell(15);
        guncelFirstName = cellGuncelFirstName.toString();
        settingsTestPage.settingsFirstNameBox.clear();
        settingsTestPage.settingsFirstNameBox.sendKeys(guncelFirstName);
    }

    @Then("EA LastName {string} gunceller")
    public void eaLastNameGunceller(String guncelLastName) {
        Row row = sheet.getRow(3);
        Cell cellGuncelLastName = row.getCell(16);
        guncelLastName = cellGuncelLastName.toString();
        settingsTestPage.settingsLastNameBox.clear();
        settingsTestPage.settingsLastNameBox.sendKeys(guncelLastName);

    }

    @Then("EA Email in {string} gunceller")
    public void eaEmailInGunceller(String guncelEmail) {
        Row row = sheet.getRow(3);
        Cell cellGuncelEmail = row.getCell(17);
        guncelEmail = cellGuncelEmail.toString();
        settingsTestPage.settingsEmailBox.clear();
        settingsTestPage.settingsEmailBox.sendKeys(guncelEmail);

    }

    @Then("EA save butonuna tiklar")
    public void eaSaveButonunaTiklar() {
        settingsTestPage.settingsSubmitButton.click();
    }

    @Then("EA sign in again butonuna tiklar")
    public void eaSignInAgainButonunaTiklar() {
        settingsTestPage.signInAgainButton.click();
    }

    @Then("EA FirstName in guncel {string} oldugunu excelden dogrular")
    public void eaFirstNameInGuncelOldugunuExceldenDogrular(String guncelFirstName) {
        Row row = sheet.getRow(3);
        Cell cellGuncelFirstName = row.getCell(15);
        guncelFirstName = cellGuncelFirstName.toString();
        Assert.assertTrue("FirstName dogrulanmadi",
                settingsTestPage.settingsFirstNameBox.getAttribute("value").contains(guncelFirstName));
    }

    @Then("EA LastName in guncel {string} oldugunu excelden dogrular")
    public void eaLastNameInGuncelOldugunuExceldenDogrular(String guncelLastName) {
        Row row = sheet.getRow(3);
        Cell cellGuncelLastName = row.getCell(16);
        guncelLastName = cellGuncelLastName.toString();
        Assert.assertTrue("FirstName dogrulanmadi",
                settingsTestPage.settingsLastNameBox.getAttribute("value").contains(guncelLastName));
    }

    @Then("EA Email in guncel {string} oldugunu excelden dogrular")
    public void eaEmailInGuncelOldugunuExceldenDogrular(String guncelEmail) {
        Row row = sheet.getRow(3);
        Cell cellGuncelEmail = row.getCell(17);
        guncelEmail = cellGuncelEmail.toString();
        Assert.assertTrue("FirstName dogrulanmadi",
                settingsTestPage.settingsEmailBox.getAttribute("value").contains(guncelEmail));

    }
}


