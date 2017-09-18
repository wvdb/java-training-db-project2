import domain.Employees;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by wvdbrand on 18/09/2017.
 */
public class TestJunit {
    @Test
    public void dummyTestHappyFlow() {
        XMLFileProcessor xMLFileProcessor = new XMLFileProcessor();
        Employees employees = xMLFileProcessor.unmarshalEmployeeXmlFileToEmployees("employees.xml");

        // this way we avoid NPEs

        assertNotNull("employees should not be null", employees);
        assertNotNull("employees.getEmployees should not be null", employees.getEmployees());
        assertEquals("We should have retrieved 2 employees", 2, employees.getEmployees().size());

        assertEquals("employee 0 age", new Integer(49), employees.getEmployees().get(0).getAge());
        assertEquals("employee 0 id", new Integer(1), employees.getEmployees().get(0).getId());
        assertEquals("employee 0 address", "Tweebunder 4", employees.getEmployees().get(0).getAddress());
        assertEquals("employee 0 name", "wim van den brande", employees.getEmployees().get(0).getName());
        assertNull("employee 0 salary", employees.getEmployees().get(0).getSalary());
        assertNotNull("employee 0 hireDate should not be null", employees.getEmployees().get(0).getHireDate());
        assertEquals("employee 0 hireDate", "Sat Mar 01 00:00:00 CET 2014", employees.getEmployees().get(0).getHireDate().toString());

    }

}
