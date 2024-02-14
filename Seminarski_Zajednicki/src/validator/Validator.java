/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author Win 10
 */
public class Validator {
    
    

    public Validator() {
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
    // Provera da li je string prazan ili null
    if (brojIndeksaStr == null || brojIndeksaStr.isEmpty()) {
        return false;
    }
    
    // Provera dužine stringa
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
    
    
    
}
