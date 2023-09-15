package com.project.service;

import com.project.connection.DatabaseConnection;
import com.project.model.Model_Client;
import com.project.model.Model_Login;
import com.project.model.Model_Message;
import com.project.model.Model_Register;
import com.project.model.Model_User_Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceUser {
// xu ly du lieu dang ky de luu vao DB 

    public ServiceUser() {
        //ket noi csdl
        this.con = DatabaseConnection.getInstance().getConnection();
    }

    // đăng ký 
    public Model_Message register(Model_Register data) {
        //kiem tra user da co hay chua
        Model_Message message = new Model_Message();
        try {
            PreparedStatement p = con.prepareStatement(CHECK_USER);
            p.setString(1, data.getUserName());
            ResultSet r = p.executeQuery();
            if (r.first()) {
                message.setAction(false);
                message.setMessage("User Already Exit");
            } else {
                message.setAction(true);
            }
            r.close();
            p.close();
            if (message.isAction()) {
                //  Insert User Register
                con.setAutoCommit(false);
                p = con.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                p.setString(1, data.getUserName());
                p.setString(2, data.getPassword());
                p.execute();
                r = p.getGeneratedKeys();
                r.first();
                int userID = r.getInt(1);
                r.close();
                p.close();
                //  Create user account
                p = con.prepareStatement(INSERT_USER_ACCOUNT);
                p.setInt(1, userID);
                p.setString(2, data.getUserName());
                p.setString(3, "1");
                p.execute();
                p.close();
                con.commit();
                con.setAutoCommit(true);
                message.setAction(true);
                message.setMessage("Ok");
                message.setData(new Model_User_Account(userID, data.getUserName(), "", "", true));
            }
        } catch (Exception e) {
            message.setAction(false);
            message.setMessage("Server Error");
            System.out.println(e);
            try {
                if (con.getAutoCommit() == false) {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            } catch (Exception e1) {
            }
        }
        return message;
    }

    // đăng nhập
    public Model_User_Account login(Model_Login login) throws SQLException {
        Model_User_Account data = null;
        PreparedStatement p = con.prepareStatement(LOGIN);
        p.setString(1, login.getUserName());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        if (r.first()) {
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            data = new Model_User_Account(userID, userName, gender, image, true);
        }
        r.close();
        p.close();
        return data;
    }

    // lấy danh sách user
    public List<Model_User_Account> getUser(int existUser) throws SQLException {
        List<Model_User_Account> list = new ArrayList<>();
        PreparedStatement p = con.prepareStatement(SELECT_USER_ACCOUNT);
        p.setInt(1, existUser);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            list.add(new Model_User_Account(userID, userName, gender, image, checkUserStatus(userID)));
        }
        r.close();
        p.close();
        return list;
    }

    // neu client co bat (server có nhận) thì set status là bật -> đang hoạt động
    private boolean checkUserStatus(int userID) {
        List<Model_Client> clients = Service.getInstance(null).getListClient();
        for (Model_Client c : clients) {
            if (c.getUser().getUserID() == userID) {
                return true;
            }
        }
        return false;
    }

    //SQL
    private final String LOGIN = "SELECT UserID, user_account.UserName, Gender, ImageString FROM user join user_account using (UserID) WHERE user.UserName=BINARY(?) AND user.Password=BINARY(?) AND user_account.`Status`='1'";
    private final String SELECT_USER_ACCOUNT = "SELECT UserID, UserName, Gender, ImageString FROM chat_application.user_account WHERE UserID<>?";
    //WHERE user_account.`Status`='1' and UserID<>?
    private final String INSERT_USER = "INSERT INTO chat_application.user (UserName, Password) VALUES(?,?)";
    private final String INSERT_USER_ACCOUNT = "INSERT INTO chat_application.user_account (UserID, UserName, Status) VALUES(?,?,?)";
    private final String CHECK_USER = "SELECT UserID FROM user WHERE UserName =? LIMIT 1";
    //instance
    private final Connection con;
}
