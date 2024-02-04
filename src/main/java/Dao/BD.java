/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.ArrayList;

/**
 *
 * @author android
 */
public interface BD {
    public abstract void Cadastrar (Object objeto);
    
    public abstract void Alterar (Object objeto);
    
    public abstract void Excluir (int codigo);
    
    //public abstract void consultar ();
    
    public abstract ArrayList<Object> RetornaTudo();
}
