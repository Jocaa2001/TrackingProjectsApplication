/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import forme.ServerskaForma;
import hashing.PasswordHasher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 10
 */
public class Main {
    public static void main(String[] args) {
        ServerskaForma sf = new ServerskaForma();
        sf.setVisible(true);
        controller.Controller.getInstance().setSf(sf);

   
    }
}
