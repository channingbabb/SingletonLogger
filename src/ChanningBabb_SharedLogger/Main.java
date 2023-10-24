package ChanningBabb_SharedLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final Logger LOG = Logger.getInstance();
//    private static final Database DB = Database.getInstance();

    public static void main(String[] args) throws SQLException {
        LOG.log("Doing something...",3);
        LOG.log("Doing something that causes a warning...",2);
        LOG.log("Doing something that causes an error...",1);

//        Connection connection  = DB.getConnection();
//        Statement statement = connection.createStatement();
//        String sqlQuery = "SELECT * FROM your_table";
//        ResultSet resultSet = statement.executeQuery(sqlQuery);

    }
}
