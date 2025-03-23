package org.example.atividade2_rev02;

import java.util.Scanner;

public class TestaClasse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Criar objetos das classes
        Carros carro = new Carros("Toyota", "Corolla", 2022);
        Cadeira cadeira = new Cadeira("Madeira", "Marrom", true);
        Refrigerante refrigerante = new Refrigerante("Cola", 2.0, true);

        // Menu em loop
        while (continuar) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Testar Carro");
            System.out.println("2. Testar Cadeira");
            System.out.println("3. Testar Refrigerante");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nTestando Carro:");
                    carro.ligar();
                    carro.acelerar();
                    carro.frear();
                    break;

                case 2:
                    System.out.println("\nTestando Cadeira:");
                    cadeira.exibirInformacoes();
                    cadeira.alterarCor("Preto");
                    cadeira.verificarDobradura();
                    break;

                case 3:
                    System.out.println("\nTestando Refrigerante:");
                    refrigerante.exibirInformacoes();
                    refrigerante.alterarVolume(1.5);
                    refrigerante.verificarGasoso();
                    break;

                case 4:
                    System.out.println("Saindo... Até mais!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

    }
}