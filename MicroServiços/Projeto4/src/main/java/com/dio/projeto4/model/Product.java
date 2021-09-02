package com.dio.projeto4.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product", type = "catalog")
public class Product {

    @Id
    private long id;
    private String nome;
    private int am0ount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAm0ount() {
        return am0ount;
    }

    public void setAm0ount(int am0ount) {
        this.am0ount = am0ount;
    }
}
