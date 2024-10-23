/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Win 10
 */
public class Validator {

    public Validator() {
    }

    
    public static boolean validatorUsername(String username) {
        return username != null && !(username.isEmpty());
    }
    
    
    public static boolean validatorPassworda(String password){
        return password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        //minimum 8 karaktera
        //jedno veliko slovo
        //jedno malo slovo
        //jedan broj
        //jedan specijalni karakter
    }
    
    public static boolean validatorImena(String ime){
        return ime != null && !(ime.isEmpty());
    }
   
    
    public static boolean validatorPrezimena(String prezime){
        return prezime != null && !(prezime.isEmpty());
    }
    
   public static boolean validatorBrojIndeksa(String brojIndeksaStr) {
    
    if (brojIndeksaStr == null || brojIndeksaStr.isEmpty()) {
        return false;
    }
    
    
    if (brojIndeksaStr.length() != 8) {
        return false;
    }
    
    // Provera da li su sve karaktere u stringu cifre
    for (char c : brojIndeksaStr.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }
    
    // Ako nijedan uslov nije ispunjen, broj indeksa je ispravan
    return true;
}
    
    public static boolean validatorIntegerTextBoxa(String s){
    return s != null && !s.isEmpty() && s.matches("\\d+");
}
    public static boolean validatorDatuma(String s){
         if (!s.matches("^\\d{4}\\.\\d{2}\\.\\d{2}$")) {
        return false;
    }
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    
    try {
        LocalDate date = LocalDate.parse(s, formatter);
        
        // Provera da li je datum u budućnosti
        if (!date.isAfter(LocalDate.now())) {
            return false;
        }
        
        // Provera validnosti dana u mesecu
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        
        // Februar
        if (month == 2 && day > 29) {
            return false;
        }

        // Meseci sa 30 dana
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        }

        // Meseci sa 31 danom
        if (day > 31) {
            return false;
        }

        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
    }
    
    
}
