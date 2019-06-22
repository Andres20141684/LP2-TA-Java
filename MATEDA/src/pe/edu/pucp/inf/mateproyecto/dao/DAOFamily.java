/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Family;

/**
 *
 * @author Usuario
 */
public interface DAOFamily {

    int insert(Family family);
    ArrayList<Family> queryALL();
    int update(Family family);
    int delete(Family family);
    Family queryFamily(String infFamily);
}
