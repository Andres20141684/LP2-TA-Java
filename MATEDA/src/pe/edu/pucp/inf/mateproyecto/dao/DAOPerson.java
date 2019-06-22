/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import pe.edu.pucp.inf.mateproyecto.model.bean.Person;

/**
 *
 * @author Alexander
 */
public interface DAOPerson {
    int insert(Person person);
    int update(Person person);
    int delete(Person person);
}
