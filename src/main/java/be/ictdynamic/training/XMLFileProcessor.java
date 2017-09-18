package be.ictdynamic.training;

import be.ictdynamic.training.domain.Employees;
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

    public Employees unmarshalEmployeeXmlFileToEmployees(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        // TODO : explain warning of Intellij
        File file = new File(classLoader.getResource(fileName).getFile());

        Employees employees = new Employees();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            employees = (Employees) jaxbUnmarshaller.unmarshal(file);

            LOGGER.info("Employees have been retrieved. Employees: " + employees);
        } catch (JAXBException e) {
            // TO DISCUSS : error handling
            LOGGER.error("!!!XML File " + fileName + " has NOT been processed successfully. Exception = " + e);
        }

        return employees;
    }
}
