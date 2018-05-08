package tests.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import tests.pages.LoginPage;
import tests.pages.RegistrationFormPage;
import tests.pages.SearchServicePage;

public class SignUpStepDefs {

    SearchServicePage searchServicePage = new SearchServicePage();
    LoginPage loginPage = new LoginPage();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    @And("^I push Login button$")
    public void iPushLoginButton() {
        searchServicePage.pushLoginButton();
    }

    @And("^I can see registration form$")
    public void iCanSeeRegistrationForm() {
        loginPage.verifyIfRegisterFormIsVisible();
    }

    @When("^I fill in all necessary registration data with testEmail, \"([^\"]*)\", \"([^\"]*)\",$")
    public void iFillInAllNecessaryRegistrationDataWithTestEmail(String name, String surname) {
        String newEmail = "test+" + loginPage.generateTimeStamp() + "@gmail.com";
        setEmail(newEmail);
        loginPage.sendName(name);
        loginPage.sendSurname(surname);
        loginPage.sendEmail(email);
    }

    @And("^I push Register button$")
    public void iPushRegisterButton() {
        loginPage.pushRegisterButton();
    }

    @And("^I can see expanded registration form$")
    public void iCanSeeExpandedRegistrationForm() {
        registrationFormPage.verifyIfExpandedRegisterFormIsVisible();
    }

    @And("^I can see name filled with \"([^\"]*)\"$")
    public void iCanSeeNameFilledWith(String name) {
        registrationFormPage.checkIfNameIsFilled(name);
    }

    @And("^I can see surname filled with \"([^\"]*)\"$")
    public void iCanSeeSurnameFilledWith(String surname) {
        registrationFormPage.checkIfSurnameIsFilled(surname);
    }

    @And("^I can see email filled with testEmail$")
    public void iCanSeeEmailFilledWithTestEmail() {
        registrationFormPage.checkIfEmailIsFilled(email);
    }

    @And("^I fill in password with \"([^\"]*)\"$")
    public void iFillInPasswordWith(String password) {
        registrationFormPage.sendPassword(password);
    }

    @And("^I fill in all necessary personal data with \"([^\"]*)\", \"([^\"]*)\"$")
    public void iFillInAllNecessaryPersonalDataWith(String phoneNumber, String bankAccountNumber) {
        registrationFormPage.sendPhone(phoneNumber);
        registrationFormPage.sendBankAccountNumber(bankAccountNumber);
    }

    @And("^I select dataForInvoice checkbox$")
    public void iSelectDataForInvoiceCheckbox() {
        registrationFormPage.checkInvoice();
    }

    @And("^I fill in all necessary invoice data with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iFillInAllNecessaryInvoiceDataWith(String name, String nip, String street, String number, String zipCode, String city) {
        registrationFormPage.sendCompanyName(name);
        registrationFormPage.sendNip(nip);
        registrationFormPage.sendCompanyStreet(street);
        registrationFormPage.sendCompanyNumber(number);
        registrationFormPage.sendCompanyZipCode(zipCode);
        registrationFormPage.sendCompanyCity(city);
    }

    @And("^I accept terms of personal data processing$")
    public void iAcceptTermsOfPersonalDataProcessing() {
        registrationFormPage.acceptTermsOfPersonalDataProcessing();
    }

    @And("^I click Register button$")
    public void iClickRegisterButton() {
        registrationFormPage.pushRegisterButton();
    }

    @Then("^I should see register confirmation message \"([^\"]*)\"$")
    public void iShouldSeeRegisterConfirmationMessage(String message) {
        registrationFormPage.verifyIfConfirmationMessageIsVisible(message);
    }

    @And("^I should see Login button$")
    public void iShouldSeeLoginButton() {
        registrationFormPage.verifyIfLLoginButtonIsVisible();
    }

    @And("^I should be registered user in database$")
    public void iShouldBeRegisteredUserInDatabase() {
        String URI = "https://patronage2018.intive-projects.com/api/users/email=" + email;
        Response response = RestAssured.given().get(URI);
        ResponseBody body = response.getBody();
        String checkBody = body.asString();
        Assert.assertEquals(checkBody, "true");
    }

    @And("^I accept statute$")
    public void iAcceptStatute() {
        registrationFormPage.acceptStatute();
    }

    @And("^I fill in all necessary address data with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void iFillInAllNecessaryAddressDataWith(String street, String number, String city, String zipCode, String voivodeship) {
        registrationFormPage.sendStreet(street);
        registrationFormPage.sendNumber(number);
        registrationFormPage.sendCity(city);
        registrationFormPage.sendZipCode(zipCode);
        registrationFormPage.selectVoivodeship(voivodeship);
    }

    @When("^I fill in all necessary registration data with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iFillInAllNecessaryRegistrationDataWith(String name, String surname, String email) {
        loginPage.sendName(name);
        loginPage.sendSurname(surname);
        loginPage.sendEmail(email);
    }

    @And("^I push Register button with fail$")
    public void iPushRegisterButtonWithFail() {
        loginPage.pushRegisterButtonWithFail();
    }

    @Then("^I can see inserted values in filled fields$")
    public void iCanSeeInsertedValuesInFilledFields() {
        loginPage.verifyIfValuesEqualsAfterPageRefresh();
    }

    @And("^I can see an error message \"([^\"]*)\"$")
    public void iCanSeeAnErrorMessage(String message) {
        loginPage.verifyIfValidationErrorMessageIsVisible(message);
    }

    @Then("^I should see in name maximum (\\d+) characters$")
    public void iShouldSeeInNameMaximumCharacters(int expected) {
        loginPage.verifyIfNameInputLimited(expected);
    }

    @And("^I should see in surname maximum (\\d+) characters$")
    public void iShouldSeeInSurnameMaximumCharacters(int expected) {
        loginPage.verifyIfSurnameInputLimited(expected);
    }
}