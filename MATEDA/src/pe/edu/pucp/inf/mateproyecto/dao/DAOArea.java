/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Area;

/**
 *
 * @author Usuario
 */
public interface DAOArea {
    int insert(Area area);
    ArrayList<Area> queryAll();
    int update(Area area);
    int delete(Area area);
}
