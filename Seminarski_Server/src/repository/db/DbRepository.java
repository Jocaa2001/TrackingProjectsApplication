/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;
import repository.Repository;
/**
 *
 * @author Win 10
 */
public interface DbRepository<T> extends Repository<T> {
    
    default public void connect() throws Exception{
        DBConnectionFactory.getinstance().getConnection();
    }
    default public void disconnect() throws Exception{
        DBConnectionFactory.getinstance().getConnection().close();
    }
    
    default public void commit() throws Exception{
        DBConnectionFactory.getinstance().getConnection().commit();
    }
    
    default public void rollback() throws Exception{
        DBConnectionFactory.getinstance().getConnection().rollback();
    }
}
