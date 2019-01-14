package bdd;

import be.campus.training.utilities.DateUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DummyStringStepDefinitions {
    private String lowerCaseString;

    @Given("^The system is in a known state$")
    public void theSystemIsInAKnownState() throws Throwable {
    }

    @When("^I have a string with the value \"([^\"]*)\"$")
    public void iHaveAStringWithTheValue(String lowerCaseString) throws Throwable {
        this.lowerCaseString = lowerCaseString;
    }

    @Then("^the length should be (\\d+)$")
    public void theLengthShouldBe(Integer lengthOfString) throws Throwable {
        assertThat(DateUtility.calculateLengthOfString(lowerCaseString), is(lengthOfString));
    }

}
