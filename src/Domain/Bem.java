/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Eduardo
 */
public class Bem {
    private int idBem;
    private String descricaoBreve;
    private String descricaoCompleta;
    private Categoria categoria;
    private Leilao leilao;
    
    public Bem(int idBem, String DescricaoBreve, String descricaoCompleta, Categoria categoria, Leilao leilao) {
        this.idBem = idBem;
        this.descricaoBreve = DescricaoBreve;
        this.descricaoCompleta = descricaoCompleta;
        this.categoria = categoria;
        this.leilao = leilao;
    }

    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    public void setDescricaoBreve(String descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
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

    public Leilao getLeilao() {
        return leilao;
    }
    
}
