package bank.management.system;
import java.sql.*;
//import java.beans.Statement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//we create a connection of our program to the database
public class connect {
    //we need to make a connection
    Connection connection;
    Statement statement;

    public connect(){
        try{
            connection = DriverManager.getConnection(/*Url of database*/"jdbc:mysql://localhost:3306/bankSystem","root","Mysqlpass12345");
            statement = connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();
            //will help identifying where the exception took place
        }
    }
}
