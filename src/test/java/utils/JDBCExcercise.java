package utils;

import java.sql.*;
import java.util.*;

public class JDBCExcercise {

    /*

    Connection -> it helps us to provide DB credentials and connect to the DB.
    Statement -> we define our conditions/query to get the result from the DB.
    ResultSet -> we store the data/response from the database to the result set object in Java.

     */

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@codefish.cfxmtijfjb4b.us-east-2.rds.amazonaws.com:1521/ORCL",
                "techtorial",
                "techtorialb13"
        );

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees");

        // System.out.println(resultSet);

        resultSet.next(); // it will go to the next row. If there is next row it will return true and go to the next row
        // if there is no next, row it will return false.

        System.out.println(resultSet.getString("first_name"));

        resultSet.next();

        System.out.println(resultSet.getString("email"));

        //System.out.println(resultSet);

        // resultSet.first(); //it will move to the first row of the result set
        // resultSet.last(); //it will move to the last row of the result set

        System.out.println(resultSet.getString("last_name"));

        // how to print header record (column names)
        resultSet.beforeFirst(); //it will go to the header record

        // Metadata is an information about our data. A set of information that describes and give the details about some other data.
        // Metatda is an information about the columns, rows, data types in your table.
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        System.out.println("Column count is -> " + resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(2));

        List<Map<String, Object>> employees = new ArrayList<>();

        resultSet.beforeFirst();

        while (resultSet.next()) {
            Map<String, Object> employee = new LinkedHashMap<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                employee.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }
            employees.add(employee);
        }

        System.out.println(employees.size());
        System.out.println(employees.get(2).get("EMAIL"));








    }
}