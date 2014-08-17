/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

import java.util.Scanner;

/**
 *
 * @author rebento
 */
public abstract class pecas {

    static int x98 = -1;
    static int x998 = -1;
    int instancia;
    static int ns = -1;
    static int ns2 = -1;
    static String mcor2;
    int a9;
    int b9;
    int a;
    int b;
    int valor;
    String cor;
    String estado;
    String direccao;
    int valor2;
    public static pecas[] arrpecas;
    public static int[][] ab = new int[8][8];
    static int soma = 0;
    static int aux = 0;
    static int aux2 = 0;
    static int aux3 = 0;
    static int[][] soma2 = new int[16][32];
    static int[][] soma3 = new int[16][32];
    static int[][] soma4 = new int[16][32];
    static int[] soma5 = new int[16];

    public pecas(int a, int b, int a9, int b9, int valor, int valor2, String cor, String direccao, String estado, int instancia) {
        this.a = a;
        this.b = b;
        this.a9 = a9;
        this.b9 = b9;
        this.valor = valor;
        this.valor2 = valor2;
        this.cor = cor;
        this.estado = estado;
        this.direccao = direccao;
        this.instancia = instancia;

    }

    public abstract int mover(int a2, int b2, int[][] ab);

    public abstract int ameacar(int a2, int b2, int[][] ab);

    public abstract void jogar_sozinho();

    public abstract int ameacar_todos();

    public void percorrer(int x, int x2) {
        for (int qq = 0; qq < arrpecas.length; qq++) {
            if (arrpecas[qq].a9 == x && arrpecas[qq].b9 == x2) {
                arrpecas[qq].estado = "ameacado";
            }
        }


    }

    public void comer(int a6, int b6) {
        for (int w = 0; w < 32; w++) {
            if (pecas.arrpecas[w].a == a6 && pecas.arrpecas[w].b == b6) {
                pecas.arrpecas[w].estado = "comido";
            }
        }
    }

    public static int somar_possibilidades() {
        for (int w = 0; w < 32; w++) {
            if (pecas.arrpecas[w].estado.equals("ameacado") && pecas.arrpecas[w].cor != pecas.mcor2) {
                soma = soma + (pecas.arrpecas[w].valor2 * 2);

            }
            if (pecas.arrpecas[w].estado.equals("comido") && pecas.arrpecas[w].cor != pecas.mcor2) {
                soma = soma + (pecas.arrpecas[w].valor2 * 3);
            }
            if (pecas.arrpecas[w].estado.equals("ameacado") && pecas.arrpecas[w].cor.equals(pecas.mcor2)) {
                soma = soma - (pecas.arrpecas[w].valor2 * 4);

            }
            if (pecas.arrpecas[w].estado.equals("comido") && pecas.arrpecas[w].cor.equals(pecas.mcor2)) {
                soma = soma - (pecas.arrpecas[w].valor2 * 5);
            }
        }
        return 0;
    }

    public void somar_guardar(int x, int y, int t1, int t2, int t3) {
        pecas.soma2[x][y] = soma;
        pecas.soma3[x][y] = t1;
        pecas.soma4[x][y] = t2;
        pecas.soma5[x] = t3;
        aux = 0;
        soma = 0;
        for (int x2 = 0; x2 < 32; x2++) {
            pecas.arrpecas[x2].estado = "activo";
        }
    }

    public static int maior() {
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 8; y++) {
                if (soma2[x][y] > aux) {
                    aux = soma2[x][y];
                    aux2 = x;
                    aux3 = y;

                }
            }
        }
        return 0;
    }

    public static int jogar() {
        int r = pos_inicial();
        while (r < 0) {
            r = pos_inicial();
        }
        int i = pos_final();
        while (i == 0) {
            i = pos_final();
        }
        int y = pecas.arrpecas[arrpecas[r].instancia].mover(x98, x998, ab);
        if (y == 0) {
            jogar();
        }
        return 2;
    }

    public static int pos_inicial() {
        int x99 = -1;
        int x999 = -1;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Que a posição A inicial da peça que pretende jogar?");
        try {
            x99 = teclado.nextInt();
        } catch (java.util.InputMismatchException x) {
            teclado.nextLine();
            System.out.println("Erro");
            System.out.println("Presta atenção");
            x99 = -1;
        }
        System.out.println("Que a posição B inicial da peça que pretende jogar?");
        try {
            x999 = teclado.nextInt();
        } catch (java.util.InputMismatchException x) {
            teclado.nextLine();
            System.out.println("Erro");
            System.out.println("Presta atenção");
            x999 = -1;
        }
        if (x99 >= 0 && x99 < 8 && x999 >= 0 && x999 < 8) {
            for (int t = 0; t < 32; t++) {
                if (arrpecas[t].a == x99 && arrpecas[t].b == x999 && arrpecas[t].cor != mcor2) {
                    return t;
                }
            }
            return -1;
        }
        return -1;
    }

    public static int pos_final() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Que a posição A final da peça que pretende jogar?");
        try {
            x98 = teclado.nextInt();
        } catch (java.util.InputMismatchException x) {
            teclado.nextLine();
            System.out.println("Erro");
            System.out.println("Presta atenção");
            x98 = 0;
        }
        System.out.println("Que a posição B final da peça que pretende jogar?");
        try {
            x998 = teclado.nextInt();
        } catch (java.util.InputMismatchException x) {
            teclado.nextLine();
            System.out.println("Erro");
            System.out.println("Presta atenção");
            x998 = 0;
        }
        if (x98 >= 0 && x98 < 8 && x998 >= 0 && x998 < 8) {
            return 1;
        }
        return 0;
    }

    public static int promover(int a, int b, int a9, int b9, int c) {
        if (arrpecas[c].cor!=mcor2){
        int x99 = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Para que figura deseja coroar o seu peão?");
        System.out.println("1- Torre");
        System.out.println("2- Cavalo");
        System.out.println("3-Bispo");
        System.out.println("4- Rainha");
        try {
            x99 = teclado.nextInt();
        } catch (java.util.InputMismatchException x) {
            teclado.nextLine();
            System.out.println("Erro");
            x99 = 0;
        }
        if (x99 == 1) {
            if (arrpecas[c].cor.equals("preto")) {
                arrpecas[c] = new torre(a, b, a9, b9, 8, 2, "preto", "cima", "activo", c);
            }
            if (arrpecas[c].cor.equals("branco")) {
                arrpecas[c] = new torre(a, b, a9, b9, 2, 2, "branco", "cima", "activo", c);
            }
            return 1;
        }
        if (x99 == 2) {
            if (arrpecas[c].cor.equals("preto")) {
                arrpecas[c] = new cavalo(a, b, a9, b9, 9, 3, "preto", "cima", "activo", c);
            }
            if (arrpecas[c].cor.equals("branco")) {
                arrpecas[c] = new cavalo(a, b, a9, b9, 3, 3, "branco", "cima", "activo", c);
            }
            return 1;
        }
        if (x99 == 3) {
            if (arrpecas[c].cor.equals("preto")) {
                arrpecas[c] = new bispo(a, b, a9, b9, 10, 4, "preto", "cima", "activo", c);
            }
            if (arrpecas[c].cor.equals("branco")) {
                arrpecas[c] = new bispo(a, b, a9, b9, 4, 4, "branco", "cima", "activo", c);
            }
            return 1;
        }
        if (x99 == 4) {
            if (arrpecas[c].cor.equals("preto")) {
                arrpecas[c] = new rainha(a, b, a9, b9, 11, 5, "preto", "cima", "activo", c);
            }
            if (arrpecas[c].cor.equals("branco")) {
                arrpecas[c] = new rainha(a, b, a9, b9, 5, 5, "branco", "cima", "activo", c);
            }
            return 1;
        }}
        if(arrpecas[c].cor.equals(mcor2)){
            if (arrpecas[c].cor.equals("preto")) {
                arrpecas[c] = new rainha(a, b, a9, b9, 11, 5, "preto", "cima", "activo", c);
            }
            if (arrpecas[c].cor.equals("branco")) {
                arrpecas[c] = new rainha(a, b, a9, b9, 5, 5, "branco", "cima", "activo", c);
            }
            return 1;
        }
        return 0;
    }
}
