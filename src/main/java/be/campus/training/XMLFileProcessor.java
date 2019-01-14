package be.campus.training;

import be.campus.training.domain.EmployeeFile;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by wvdbrand on 18/09/2017.
 */
public class XMLFileProcessor {
    private static final Logger LOGGER = Logger.getLogger(XMLFileProcessor.class);

    public static final String EXCEPTION_MESSAGE_XML_FILE_DOES_NOT_EXIST = "xml file does not exist";

    public EmployeeFile unmarshalEmployeeXmlFileToEmployees(String fileName) throws JAXBException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        if (classLoader.getResource(fileName) == null) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_XML_FILE_DOES_NOT_EXIST);
        }
        File file = new File(classLoader.getResource(fileName).getFile());

        EmployeeFile employeeFile = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeFile.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            employeeFile = (EmployeeFile) jaxbUnmarshaller.unmarshal(file);

            LOGGER.info("Employees have been retrieved. # of employees: " + (employeeFile == null ? 0 : employeeFile.getEmployees().size()));
        } catch (JAXBException e) {
            LOGGER.error("!!!XML File " + fileName + " has NOT been processed successfully. Exception = " + e);
            throw e;
        }

        return employeeFile;
    }
}
