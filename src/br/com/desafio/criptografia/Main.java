package br.com.desafio.criptografia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CriptografiaJulioCesar cp = new CriptografiaJulioCesar();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com o numero de casas:");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Entre com o texto:");
        String texto = scanner.nextLine();
        String criptografado = cp.criptografar(texto,numero);
        System.out.println(criptografado);
        String resumo = cp.resumoCriptografo(criptografado);
        System.out.println("Resumo Criptografo:\n"+resumo);
    }
}
