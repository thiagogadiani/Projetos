/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author android
 */
public class Item {
    
    private int idItem;
    private String nomeItem;
    
    public Item() {
        nomeItem=null;
    }

    public Item(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public Item(int idItem, String nomeItem) {
        this.idItem = idItem;
        this.nomeItem = nomeItem;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

}
