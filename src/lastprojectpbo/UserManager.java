/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lastprojectpbo;

/**
 *
 * @author Owner
 */
import java.sql.SQLException;

public interface UserManager {

    void addUser(String username, String password) throws SQLException;

    boolean validateUser(String username, String password) throws SQLException;
}