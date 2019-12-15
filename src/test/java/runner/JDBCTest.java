package runner;

import utilities.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    //JDBC->Java DataBase Connectivity
    public static void main(String[] args) throws IOException, SQLException {
        //interfaces :
        // Connection
        //Statement
        //ResultSet


        //how do you do connection :
        Connection connection = DriverManager.getConnection(Configuration.getProperties("dbHostname"),
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword"));

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("Select * from employees");
        //object holding all data //actual values of data

        //System.out.println(resultSet.getRow());
        // System.out.println(resultSet.getObject("employee_id"));

        resultSet.next();
        resultSet.next();
        resultSet.next();
        String myFirstData = resultSet.getString("First_name");
        System.out.println(myFirstData);

        resultSet.next();
        System.out.println(resultSet.getObject("first_name"));

        resultSet.next();
        System.out.println(resultSet.getObject("employee_id"));
        System.out.println(resultSet.getRow());


        ResultSetMetaData rsMetaData = resultSet.getMetaData(); //holding all general info

        System.out.println("==================");

        System.out.println(rsMetaData.getColumnCount());
        System.out.println(rsMetaData.getColumnName(5));
        System.out.println(rsMetaData.getColumnType(5));
        System.out.println(rsMetaData.getColumnClassName(5));

        List<Map<String, Object>> listofMaps = new ArrayList<>();

        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                row.put(rsMetaData.getColumnName(i), resultSet.getObject(rsMetaData.getColumnName(i)));
            }
            listofMaps.add(row);
        }
        for (int i = 0; i < listofMaps.size(); i++) {
            for (String key : listofMaps.get(i).keySet()) {

                System.out.println(listofMaps.get(i).get(key));
            }
        }
    }
}

