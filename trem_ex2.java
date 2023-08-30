package atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//História de Usuário 
//Trilho Finito:
//para que o trem não ultrapasse os limites do trilho,
//Para garantir que ele fique dentro de -2 e +10.

//Escolha do Trilho:
//escolher entre um trilho infinito ou em um trilho finito, com limites ou nao

public class trem_ex2 {
    private static final int TRILHO_INFINITO = 0;
    private static final int TRILHO_MIN = -2;
    private static final int TRILHO_MAX = 10;

    public static int moverTrem(List<String> comandos, int trilhoTipo) {
        int posicaoAtual = 0;

        for (String comando : comandos) {
            if (comando.equals("DIREITA")) {
                posicaoAtual += 1;
            } else if (comando.equals("ESQUERDA")) {
                posicaoAtual -= 1;
            }

            if (trilhoTipo != TRILHO_INFINITO && (posicaoAtual < TRILHO_MIN || posicaoAtual > TRILHO_MAX)) {
                System.out.println("Excedeu os limites do trilho");
                return -1;
            }
        }

        return posicaoAtual;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escolha o tipo de trilho (0 - Infinito, 1 - Finito): ");
        int trilhoTipo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite os comandos (se mais de um separe por ','): ");
        String input = scanner.nextLine();

        String[] comandosArray = input.split(",");
        List<String> comandos = new ArrayList<>();

        for (String comando : comandosArray) {
            String comandoLimpo = comando.trim().toUpperCase();
            if (comandoLimpo.equals("DIREITA") || comandoLimpo.equals("ESQUERDA")) {
                comandos.add(comandoLimpo);
            } else {
                System.out.println("Comando inválido: " + comando);
            }
        }

        int posicaoFinal = moverTrem(comandos, trilhoTipo);
        if (posicaoFinal != -1) {
            System.out.println("Posição Final: " + posicaoFinal);
        }

        scanner.close();
    }
}