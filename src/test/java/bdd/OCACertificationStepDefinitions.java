package bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OCACertificationStepDefinitions {
    private boolean eligibleForParticipation;
    private boolean certified;
    private float score;

    @Given("^I participate$")
    public void iParticipate() throws Throwable {
        setEligibleForParticipation(true);
    }

    @When("^I succeed$")
    public void iSucceed() throws Throwable {
        // TODO : possible usage of randomizer
        setScore(70);
        setCertified(true);
    }

    public void setEligibleForParticipation(boolean eligibleForParticipation) {
        this.eligibleForParticipation = eligibleForParticipation;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Then("^I should be certified and have a score of at least (\\d+)$")
    public void iShouldBeCertifiedAndHaveAScoreOfAtLeast(int minimumScore) throws Throwable {
        assertThat(isCertified(), is(true));
        assertThat(getScore() > minimumScore , is(true));
    }

}
