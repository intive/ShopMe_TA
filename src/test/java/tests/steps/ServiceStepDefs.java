package tests.steps;

import cucumber.api.java.en.And;
import tests.pages.SearchResultsPage;
import tests.pages.ServiceProfilePage;

import static org.junit.Assert.assertEquals;

public class ServiceStepDefs {


    SearchResultsPage searchResultsPage = new SearchResultsPage();
    ServiceProfilePage serviceProfilePage = new ServiceProfilePage();


    @And("^I can click on the first search result to see the details$")
    public void iCanClickOnTheFirstSearchResultToSeeTheDetails() {
        searchResultsPage.chooseFirstSearchResult();
    }

    @And("^I can see the title \"([^\"]*)\"$")
    public void iCanSeeTheTitle(String title) {
        String expectedTitle = serviceProfilePage.getTitleFieldText();
        assertEquals(title, expectedTitle);
    }

    @And("^I can see the category \"([^\"]*)\"$")
    public void iCanSeeTheCategory(String category) {
        String expectedCategory = serviceProfilePage.getCategoryFieldText();
        assertEquals(category, expectedCategory);
    }

    @And("^I can see user's name \"([^\"]*)\"$")
    public void iCanSeeUserSName(String userName) {
        String expectedUserName = serviceProfilePage.getUserNameFieldText();
        assertEquals(userName, expectedUserName);
    }

    @And("^I expand user's email and user's phone$")
    public void iExpandUserSEmailAndUserSPhone() {

    }

    @And("^I can see user's email \"([^\"]*)\"$")
    public void iCanSeeUserSEmail(String userMail) {

    }

    @And("^I can see user's phone \"([^\"]*)\"$")
    public void iCanSeeUserSPhone(String userPhone) {

    }

    @And("^I can see additional user info \"([^\"]*)\"$")
    public void iCanSeeAdditionalUserInfo(String userInfo) {

    }

    @And("^I can see basic service \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void iCanSeeBasicServiceAndPrice(String basicInfo, String basicPrice) {

    }

    @And("^I can see extended service \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void iCanSeeExtendedServiceAndPrice(String extendedInfo, String extendedPrice) {

    }

    @And("^I can see extra service \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void iCanSeeExtraServiceAndPrice(String extraInfo, String extraPrice) {

    }
}
