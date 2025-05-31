/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Usuario
 */
public class Usuario {
    private String username;
    private String password;
    private String rol;
    private int intentosFallidos;
    private boolean bloqueado;

    public Usuario(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.intentosFallidos = 0;
        this.bloqueado = false;
    }

    public String getUsername() {
        return username;
    }

    public String getRol() {
        return rol;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public boolean login(String pass) {
        if (bloqueado) return false;
        if (this.password.equals(pass)) {
            intentosFallidos = 0;
            return true;
        } else {
            intentosFallidos++;
            if (intentosFallidos >= 5) bloqueado = true;
            return false;
        }
    }

    public void cambiarPassword(String nuevaClave) {
        if (nuevaClave.length() >= 8 && nuevaClave.matches(".*[a-zA-Z].*") && nuevaClave.matches(".*\\d.*")) {
            this.password = nuevaClave;
        } else {
            throw new IllegalArgumentException("La contraseña debe tener mínimo 8 caracteres, una letra y un número");
        }
    }
}
