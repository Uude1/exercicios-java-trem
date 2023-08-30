package atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//História de Usuário

//Limites do trilho:
//definir os limites do trilho se caso for finito, 
//para que eu possa garantir que o trem permaneça dentro dos limites.

//Informar Posição Inicial:
//posição inicial do trem no trilho,
//para que o trem comece a operar na posição que eu escolhi

//Informar Lista de Comandos:
//lista completa de comandos que o trem deve executar,
//para que o trem possa executar os comandos na sequência que escolhi.

//Restrição de Tamanho de Comandos:
//regra, que so possa adicionar no max  30 comandos,

//Evitar Extrapolar Limites:
//garantir que o trem nunca exceda os limites definidos do trilho finito

public class trem_ex3 {
    private static final int TRILHO_INFINITO = 0;

    public static int moverTrem(List<String> comandos, int trilhoTipo, int posicaoAtual, int limiteMin, int limiteMax) {
        for (String comando : comandos) {
            if (comando.equals("DIREITA")) {
                posicaoAtual += 1;
            } else if (comando.equals("ESQUERDA")) {
                posicaoAtual -= 1;
            }

            if (trilhoTipo != TRILHO_INFINITO && (posicaoAtual < limiteMin || posicaoAtual > limiteMax)) {
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

        System.out.print("Informe o limite min do trilho: ");
        int limiteMin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o limite max do trilho: ");
        int limiteMax = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe a posição inicial do trem: ");
        int posicaoInicial = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite os comandos (se mais de um separe por ',')(max 30): ");
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

        if (comandos.size() > 30) {
            System.out.println("foi adicionado mais de 30 comandos.");
        } else {
            int posicaoFinal = moverTrem(comandos, trilhoTipo, posicaoInicial, limiteMin, limiteMax);
            if (posicaoFinal != -1) {
                System.out.println("Posição Final: " + posicaoFinal);
            }
        }

        scanner.close();
    }
}