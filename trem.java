package atividade;

import java.util.ArrayList;
import java.util.Scanner;

public class trem {
    public static int moverTrem(ArrayList<String> comandos) {
        int posicaoAtual = 0;

        for (String comando : comandos) {
            if (comando.equals("DIREITA")) {
                posicaoAtual++;
            } else if (comando.equals("ESQUERDA")) {
                posicaoAtual--;
            }
        }

        return posicaoAtual;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite os comandos (se mais de um separe por ','): ");
        String input = scanner.nextLine();
        
        String[] comandosArray = input.split(",");
        ArrayList<String> comandos = new ArrayList<>();
        
        for (String comando : comandosArray) {
            String comandoLimpo = comando.trim().toUpperCase();
            if (comandoLimpo.equals("DIREITA") || comandoLimpo.equals("ESQUERDA")) {
                comandos.add(comandoLimpo);
            } else {
                System.out.println("Comando inválido: " + comando);
            }
        }

        int posicaoFinal = moverTrem(comandos);
        System.out.println("Posição Inicial: 0 Posição Final: " + posicaoFinal);

        scanner.close();
    }
}
