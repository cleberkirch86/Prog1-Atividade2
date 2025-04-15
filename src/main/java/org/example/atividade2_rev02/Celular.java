package org.example.atividade2_rev02;

import java.util.Random;

public class Celular {
    private String marca;
    private String modelo;
    private int bateria;

    public Celular(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = 100;
    }

    public void ligar() {
        Random rand = new Random();
        int gasto = rand.nextInt(100) + 1;
        bateria -= gasto;
        if (bateria < 0) bateria = 0;
    }

    public void carregarBateria() {
        Random rand = new Random();
        int carga = rand.nextInt(100) + 1;
        bateria += carga;
        if (bateria > 100) bateria = 100;
    }

    public void enviarMensagem(String numero, String mensagem) {
        System.out.println("Enviando mensagem para " + numero + ": " + mensagem);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getBateria() {
        return bateria;
    }
}
