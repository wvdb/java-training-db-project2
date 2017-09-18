package bdd;

import be.ictdynamic.training.domain.Employees;
import be.ictdynamic.training.XMLFileProcessor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProcessEmployeesXMLFileStepDefinitions {
    private XMLFileProcessor xmlFileProcessor;
    private Employees employees;

	@Given("^there is a valid XML file$")
	public void there_is_a_valid_XML_file() {
        xmlFileProcessor = new XMLFileProcessor();
	}

	@When("^the file has been processed$")
	public void the_file_has_been_processed() {
        employees = xmlFileProcessor.unmarshalEmployeeXmlFileToEmployees("employees.xml");
	}

	@Then("^employees should contain 2 entries$")
	public void employees_should_contain_2_entries() {
        assertThat(employees.getEmployees().size(), is(2));
	}

    @And("^employee should be correct$")
    public void employee_should_be_correct() {
        assertThat(employees.getEmployees().get(0).getAge(), is(49));
        assertThat(employees.getEmployees().get(0).getName(), is("wim van den brande"));
    }
}