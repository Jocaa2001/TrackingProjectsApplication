/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Win 10
 */
public interface Repository<T> {
    
    List<T> pretraga(T param) throws Exception;
    void dodaj(T param) throws Exception;
    void izmeni(T param) throws Exception;
    void izbrisi (T param) throws Exception;
    List<T> vratiSve();
    
}
