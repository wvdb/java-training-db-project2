import domain.Employees;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by wvdbrand on 18/09/2017.
 */
public class ProcessXMLFile {
    private static final Logger LOGGER = Logger.getLogger(ProcessXMLFile.class);

    public static void unmarshalMyXmlFile() {
        File file = new File("c:/temp/employees.xml") ;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Employees employees = (Employees) jaxbUnmarshaller.unmarshal(file);

            LOGGER.info("Employees have been retrieved. Employees: " + employees);
        } catch (JAXBException e) {
            LOGGER.info("!!!XML File employees.xml has NOT been processed successfully. Exception = " + e);
        }

    }
}
