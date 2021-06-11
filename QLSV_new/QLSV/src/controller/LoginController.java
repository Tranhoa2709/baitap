/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import utils.DBConnection;

public class LoginController {
    public boolean checkLogin(String username, String password){
        DBConnection dbc = new DBConnection();
        dbc.connect();
        boolean ok = false;
        try {
            String sql = "select * from account where username = ? and password = ?";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, username);
                dbc.getPreparedStatement().setString(2, password);
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    ok = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        return ok;
    }
}
