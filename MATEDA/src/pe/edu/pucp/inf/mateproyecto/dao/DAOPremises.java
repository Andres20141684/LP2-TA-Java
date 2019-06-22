/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Premises;

/**
 *
 * @author Usuario
 */
public interface DAOPremises {
    int insert(Premises premises);
    ArrayList<Premises> queryAll();
    int update (Premises premises);
    int delete (Premises premises);
    Premises queryPremises(String infPremises);
}
