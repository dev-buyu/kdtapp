/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.kdt;

/**
 *
 * @author w
 */
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class InformationDAO {
    /**
     * 查询给定用户名的用户的详细信息
     *
     * @param userName 给定的用户名
     * @return 查询到的封装了详细信息的User对象
     */
    
     public static Information InsertInformation(String receiver,String code,String phone,String address,String way,String size,String type,String cost,String userName) {
        // TODO Auto-generated method stub
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("insert into information(Receiver,Code,Phone,Address,Way,Size,Type,Cost,UserName) values(?,?,?,?,?,?,?,?,?)");
        
        try{
            Information information = new Information();
            preparedStatement= connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1,receiver);
            preparedStatement.setString(2,code);
            preparedStatement.setString(3,phone);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,way);
            preparedStatement.setString(6,size);
            preparedStatement.setString(7,type);
            preparedStatement.setString(8,cost);
            preparedStatement.setString(9,userName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return information;
         
        }
        catch(SQLException ex){
            return null;
        }finally {
             DBManager.closeAll(connection, preparedStatement, resultSet);
        }
   }
     
     

     public static  ArrayList<Object> SeleInformation(){
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM information");
       
        
        try{
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            resultSet = preparedStatement.executeQuery();
           
           ArrayList<Object> list =new ArrayList<Object>();
            while (resultSet.next()) {
                Information information=new Information();
                information.setId(resultSet.getString("Id"));
                information.setReceiver(resultSet.getString("Receiver"));
                information.setCode(resultSet.getString("Code"));
                information.setPhone(resultSet.getString("Phone"));
                information.setAddress(resultSet.getString("Address"));
                information.setWay(resultSet.getString("Way"));
                information.setSize(resultSet.getString("Size"));
                information.setType(resultSet.getString("Type"));
                information.setCost(resultSet.getString("Cost"));
                information.setUserName(resultSet.getString("UserName"));
                information.setCondition(resultSet.getString("conditions"));
                information.setJiedan(resultSet.getString("jiedan"));
                list.add(information);
            }
            return list;
           
            
        
        } catch(Exception e){
            e.printStackTrace();
             return null;
        }finally {
             DBManager.closeAll(connection, preparedStatement, resultSet);
     }
     }
     
     public static void ChangeInformation(String jiedan,String Id){
         
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("update information set conditions=1, jiedan=? where Id=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, jiedan);
            preparedStatement.setString(2, Id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
     }
     
     
     public static void ChangeConmation(String Id){
         
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("update information set conditions=2 where Id=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, Id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
     }
     
          public static void DeletInformation(String Id){
         
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("DELETE FROM information WHERE Id=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, Id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
     }
     
}
    
             



