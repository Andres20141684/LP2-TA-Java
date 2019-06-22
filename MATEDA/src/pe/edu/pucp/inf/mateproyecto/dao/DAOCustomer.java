/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Customer;

/**
 *
 * @author Usuario
 */
public interface DAOCustomer {
    int insert(Customer customer);
    int update(Customer customer);
    ArrayList<Customer> queryAll();
    Customer queryById(String idCustomer);
    int delete(Customer customer);
}
