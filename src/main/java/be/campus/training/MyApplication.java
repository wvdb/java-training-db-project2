package be.campus.training;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wvdbrand on 14/09/2017.
 */
@SpringBootApplication
public class MyApplication {

    private static final Logger LOGGER = Logger.getLogger(MyApplication.class);
    public static final String EMPLOYEE_XML_FILE = "employees.xml";

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

//    public static void main(String args[]) {
//        Connection connection = null;
//
//        try {
//            Class.forName("org.sqlite.JDBC");
//            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
//
//            long start = System.currentTimeMillis();
//            LOGGER.info("Opened database successfully");
//            CreateDatabase.createTables(connection);
//            LOGGER.info("Created database successfully");
//
//            EmployeeFile employeeFile = new XMLFileProcessor().unmarshalEmployeeXmlFileToEmployees(EMPLOYEE_XML_FILE);
//            LOGGER.info(String.format("XML File %s has been processed successfully", EMPLOYEE_XML_FILE));
//
//            long end = System.currentTimeMillis();
//            LOGGER.info(String.format("Processing XML File took %06d milliseconds", (end - start)));
//
//        } catch (Exception e) {
//            LOGGER.error("!!!Something went wrong: message = " + e.getMessage());
//            System.exit(-1);
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                // connection close failed.
//                LOGGER.error("!!!Something went wrong: message = " + e.getMessage());
//            }
//        }
//
//    }

}
