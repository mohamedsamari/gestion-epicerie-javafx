package model;

import java.math.BigDecimal;

public class Produit {

    private int id;
    private String nom;
    private BigDecimal prix;
    private int quantiteStock;
    private int fournisseurId;

    public Produit() {}

    public Produit(int id, String nom, BigDecimal prix, int quantiteStock, int fournisseurId) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.fournisseurId = fournisseurId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }

    public int getQuantiteStock() { return quantiteStock; }
    public void setQuantiteStock(int quantiteStock) { this.quantiteStock = quantiteStock; }

    public int getFournisseurId() { return fournisseurId; }
    public void setFournisseurId(int fournisseurId) { this.fournisseurId = fournisseurId; }
}
