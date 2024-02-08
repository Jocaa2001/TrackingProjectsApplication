/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author Win 10
 */
public class LoginValidatorPassword {
    
    private String password;

    public LoginValidatorPassword() {
    }
    
    private boolean Validacija(){
        return password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        //minimum 8 karaktera
        //jedno veliko slovo
        //jedno malo slovo
        //jedan broj
        //jedan specijalni karakter
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
