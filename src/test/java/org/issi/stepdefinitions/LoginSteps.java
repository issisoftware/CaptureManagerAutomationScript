package org.issi.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.issi.constants.FrameworkConstants;
import org.issi.driver.DriverManager;

import java.util.List;
import java.util.Map;

import static org.issi.pages.BasePage.*;
import static org.issi.pages.LoginPage.actualErrorMessage;
import static org.issi.pages.LoginPage.doLogin;

public class LoginSteps {

    private static String title;
    private static String errormsg;

    /**
     * Valid login steps
     * @param dataTable as username and password
     */
    @Given("user should login to capture manager application")
    public void user_should_login_to_capture_manager_application(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps(String.class, String.class);
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverManager.getDriver().get(configreader().url()); // launching the URL
        log().info("Entered url as " + configreader().url() ); // Printing the URL in console, that we entered

        Assertions.assertThat(getPage_Title()).isEqualTo(FrameworkConstants.getLoginPageTitle()); //validating login page title after launching the URL
        log().info("Found and validated Login page title as : " +getPage_Title());


        doLogin(username, password);
    }
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = getPage_Title();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assertions.assertThat(title).isEqualTo(expectedTitle);
        log().info("Found page title as : " + title);
    }

    /**
     * Steps for invalid login
     */

    @When("user gets error message on invalid login")
    public void user_gets_error_message_on_invalid_login() {
        errormsg = actualErrorMessage();
    }
    @Then("error message  should be {string}")
    public void error_message_should_be(String errormessage) {
       Assertions.assertThat(errormsg).isEqualTo(errormessage);
       log().info("Error message on invalid login is : " + errormsg);
    }
}
