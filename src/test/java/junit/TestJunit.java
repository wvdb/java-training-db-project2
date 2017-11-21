package junit;

import be.ictdynamic.training.XMLFileProcessor;
import be.ictdynamic.training.domain.EmployeeFile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wvdbrand on 18/09/2017.
 */
public class TestJunit {
    @Test
    public void dummyTestHappyFlow() {
        XMLFileProcessor xmlFileProcessor = new XMLFileProcessor();
        EmployeeFile employeeFile = xmlFileProcessor.unmarshalEmployeeXmlFileToEmployees("employees.xml");

        // this way we avoid NPEs

        assertNotNull("employees should not be null", employeeFile);
        assertNotNull("employees.getEmployees should not be null", employeeFile.getEmployees());
        assertEquals("We should have retrieved 2 employees", 2, employeeFile.getEmployees().size());

        assertEquals("employee 0 age", new Integer(49), employeeFile.getEmployees().get(0).getAge());
        assertEquals("employee 0 id", new Integer(1), employeeFile.getEmployees().get(0).getId());
        assertEquals("employee 0 address", "Tweebunder 4", employeeFile.getEmployees().get(0).getAddress());
        assertEquals("employee 0 name", "wim van den brande", employeeFile.getEmployees().get(0).getName());
        assertNull("employee 0 salary", employeeFile.getEmployees().get(0).getSalary());
        assertNotNull("employee 0 hireDate should not be null", employeeFile.getEmployees().get(0).getHireDate());
        assertEquals("employee 0 hireDate", "Sat Mar 01 00:00:00 CET 2014", employeeFile.getEmployees().get(0).getHireDate().toString());

    }

}
