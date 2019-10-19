package com.learning.jdbc.mysql;

import java.sql.*;

public class FetchMetedata {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/learning_db","root","mysql");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employee");

            ResultSetMetaData metedata = rs.getMetaData();
            int Col_count = metedata.getColumnCount();
            System.out.println("Please find the number of columns " + Col_count);

            DatabaseMetaData DBmetadata = con.getMetaData();

            ResultSet rsColumns = DBmetadata.getColumns(null, null, "employee", null);


            while (rsColumns.next()) {
                System.out.println(rsColumns.getString("TYPE_NAME"));
                System.out.println(rsColumns.getString("COLUMN_NAME"));
            }

//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}

