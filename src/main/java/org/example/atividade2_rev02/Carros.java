package org.example.atividade2_rev02;

public class Carros {
    String marca;
    public String modelo;
    public int ano;

    // Construtor padrão
    public Carros() {
        // Não inicializa os atributos (valores padrão)
    }


    // Construtor que inicializa todos os atributos
    public Carros(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }


    public void ligar() {
        System.out.println("O carro " + modelo + " está ligado!");
    }

    public void acelerar() {
        System.out.println("O carro " + modelo + " está acelerando!");
    }

    public void frear() {
        System.out.println("O carro " + modelo + " está freando!");
    }

    public static void main(String[] args) {
        Carros carro = new Carros();
        carro.modelo = "Fusca";
        carro.ano = 1970;
        carro.marca = "Volkswagen";

        carro.ligar();
        carro.acelerar();
        carro.frear();
    }
}
