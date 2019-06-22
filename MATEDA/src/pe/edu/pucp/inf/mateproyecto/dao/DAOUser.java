/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.User;

/**
 *
 * @author Usuario
 */
public interface DAOUser {
    int insert(User user);
    int update(User user);
    ArrayList<User> queryAll();
    User queryUser(String infuser);
}
