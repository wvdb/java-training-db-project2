package bdd;

import be.ictdynamic.training.domain.EmployeeFile;
import be.ictdynamic.training.XMLFileProcessor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProcessEmployeesXMLFileStepDefinitions {
    private XMLFileProcessor xmlFileProcessor;
    private EmployeeFile employeeFile;

	@Given("^there is a valid XML file$")
	public void there_is_a_valid_XML_file() {
        xmlFileProcessor = new XMLFileProcessor();
	}

	@When("^the file has been processed$")
	public void the_file_has_been_processed() {
        employeeFile = xmlFileProcessor.unmarshalEmployeeXmlFileToEmployees("employees.xml");
	}

	@Then("^employees should contain 2 entries$")
	public void employees_should_contain_2_entries() {
        assertThat(employeeFile.getEmployees().size(), is(2));
	}

    @And("^age should be correct$")
    public void age_should_be_correct() {
        assertThat(employeeFile.getEmployees().get(0).getAge(), is(49));
    }

    @And("^name should be correct$")
    public void name_should_be_correct() {
        assertThat(employeeFile.getEmployees().get(0).getName(), is("wim van den brande"));
    }
}
