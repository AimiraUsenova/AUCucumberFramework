package utilities;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {
    //methods static
    //establishConnection()
    //run sql query(String query) ->  will return listOfMaps,
    //closedataBase()
    //countRows(String query) -> will return int

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     * This method establishing a connection with ORACLE SQL database
     *
     * @throws IOException
     * @throws SQLException
     */

    public static void establishConnection() throws IOException, SQLException {
        connection = DriverManager.getConnection(
                Configuration.getProperties("dbHostname"),
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword"));

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

    }

    /**
     * This method will run query to database and will return the data as list of maps
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public static List<Map<String, Object>> runSQLQuery(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        ResultSetMetaData rsMetaData = resultSet.getMetaData();

        List<Map<String, Object>> listOfMaps = new ArrayList<>();

        int columnCount = rsMetaData.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsMetaData.getColumnName(i);
                Object columnValue = resultSet.getObject(columnName);
                row.put(columnName, columnValue);
            }
            listOfMaps.add(row);
        }
        return listOfMaps;
    }

    /**
     * This method will execute query and return number of rows
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public static int countRows(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        resultSet.last();
        return resultSet.getRow();

    }

    /**
     * This method will close database connection ,statement and resultSet
     *
     * @throws SQLException
     */

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}

