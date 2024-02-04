/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Dao.ItemDao;
import Model.Item;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NoteC
 */
public class ItemControl {
    
    private Item item;
    private ItemDao bd;
    private ArrayList<Item> listaItem;

    public ItemControl() {
        this.item = new Item();
        this.bd = new ItemDao();
    }

    public Item getItem() {
        return item;
    }

    public ArrayList<Item> getListaItem() {
        TodosItens();
        return listaItem;
    }
    
    public boolean CadastrarItem (String nome) {
        this.item = new Item ();
        this.item.setNomeItem(nome);
        TodosItens();
        
        for (Item i:listaItem){
            if (i.getNomeItem().equalsIgnoreCase(nome)){
                return false;
            }
        }
        
        try {
            this.bd.Cadastrar(item);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void AlterarItem (int idItem, String nomeItem){
        this.item = new Item (idItem, nomeItem);
        
        try {
            this.bd.Alterar(item);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ExcluirItem (int idItem) {
        try {
            this.bd.Excluir(idItem);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void BuscaItem (int idItem){
        this.item = new Item();
        
        try {
            this.item = this.bd.RecuperaID(idItem);
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void TodosItens (){
        
        this.listaItem = new ArrayList<Item>();
        
        try {
            listaItem = this.bd.RetornaTudo();
        } catch (SQLException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
