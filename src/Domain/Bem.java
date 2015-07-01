/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

public class Bem {
    private int idBem;
    private String descricaoBreve;
    private String descricaoCompleta;
    private Categoria categoria;
    private int leilao_id;
    
    public Bem(int idBem, String DescricaoBreve, String descricaoCompleta, Categoria categoria, int leilao_id) {
        this.idBem = idBem;
        this.descricaoBreve = DescricaoBreve;
        this.descricaoCompleta = descricaoCompleta;
        this.categoria = categoria;
        this.leilao_id = leilao_id;
    }

    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    public void setDescricaoBreve(String descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
    }
    
    public void setLeilao_id(int id){
        leilao_id = id;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdBem() {
        return idBem;
    }

    public int getLeilao_id() {
        return leilao_id;
    }
    
    public String toString() {
        return descricaoBreve + " " + categoria.getNomeCategoria();
    }
    
}
