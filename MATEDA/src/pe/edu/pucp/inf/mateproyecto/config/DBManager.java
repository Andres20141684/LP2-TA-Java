/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.config;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.FileReader;


public class DBManager {
    
    private String url;
    private String user;
    private String password;
    private static DBManager dbManager;

    public DBManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static DBManager getDbManager() {
        if (dbManager == null){
            XStream xstream = new XStream();
            xstream.addPermission(AnyTypePermission.ANY);
            FileReader reader;
            try{
                reader = new FileReader(DBManager.class.getResource("/pe/edu/pucp/inf/mateproyecto/config/config.xml").getFile());
                ConnectionParameters connParam =
                        (ConnectionParameters) xstream.fromXML(reader);
                String url = connParam.getUrl();
                String password = connParam.getPassword();
                String user = connParam.getUser();
                dbManager = new DBManager(url,user,password);
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Se ha registrado el Driver");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                System.out.println(ex.getStackTrace());
            }
        }
        return dbManager;
    }

    public void setDbManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }
    
}
