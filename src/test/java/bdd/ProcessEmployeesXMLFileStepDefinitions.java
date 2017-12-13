package bdd;

import be.ictdynamic.training.XMLFileProcessor;
import be.ictdynamic.training.domain.EmployeeFile;
import be.ictdynamic.training.utilities.DateUtility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class ProcessEmployeesXMLFileStepDefinitions {
    private XMLFileProcessor xmlFileProcessor;
    private EmployeeFile employeeFile;
    private List<Exception> exceptions = new ArrayList();

	@Given("^there is an XML File Processor$")
	public void there_is_an_XML_File_Processor() {
        xmlFileProcessor = new XMLFileProcessor();
	}

	@When("^a correct file has been processed$")
	public void a_correct_file_has_been_processed() {
        try {
            employeeFile = xmlFileProcessor.unmarshalEmployeeXmlFileToEmployees("employees.xml");
        } catch (JAXBException e) {
            assertThat(true, is(false));
        }
    }

    @When("^a not existing file has been processed$")
    public void aNotExistingFileHasBeenProcessed() {
        try {
            employeeFile = xmlFileProcessor.unmarshalEmployeeXmlFileToEmployees("this-file-does-not-exist.xml");
        } catch (Exception e) {
            exceptions.add(e);
        }
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

    @And("^hire-date should be correct$")
    public void hiredateShouldBeCorrect() {
        assertThat(DateUtility.convertLocalDateTimeToEuropeanDateAsString(DateUtility.convertDateToLocalDateTime(employeeFile.getEmployees().get(0).getHireDate())), is("01/03/2014"));
    }

    @Then("^a correct exception should have been thrown$")
    public void aCorrectExceptionShouldHaveBeenThrown() {
        assertThat(exceptions.size(), is(1));
        assertThat(exceptions.get(0), instanceOf(IllegalArgumentException.class));
        assertThat(exceptions.get(0).getMessage(), is(XMLFileProcessor.EXCEPTION_MESSAGE_XML_FILE_DOES_NOT_EXIST));
    }
}
