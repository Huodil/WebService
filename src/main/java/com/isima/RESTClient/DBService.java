package com.isima.RESTClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;

@Path("db")
public class DBService {

    @GET
    public String db() {
        try (Connection connection = getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

            ArrayList<String> output = new ArrayList<String>();
            while (rs.next()) {
                output.add("Read from DB: " + rs.getTimestamp("tick"));
            }

            return output.toString();
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        System.out.println("URL db:"+ dbUrl);
        return DriverManager.getConnection(dbUrl);
    }
}
