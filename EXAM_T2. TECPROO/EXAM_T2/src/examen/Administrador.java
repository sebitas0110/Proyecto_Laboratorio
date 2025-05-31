/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;
/**
 *
 * @author Usuario
 */
public class Administrador{
    private static final String USUARIO_VALIDO = "admin";
    private static final String CONTRASENA_VALIDA = "admin123";
    
    public boolean autenticarUsuario(String usuario, String contrasena){
        return USUARIO_VALIDO.equals(usuario) && CONTRASENA_VALIDA.equals(contrasena);
    }

}
