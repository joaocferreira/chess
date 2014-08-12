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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// TODO code application logic here
        pecas[] array0 = new pecas[32];
        int y0;
        int p1 = -1;
        for (y0 = 0; y0 < 8; y0++) {
            p1 = p1 + 1;
            array0[y0] = new peao(1, p1, 1, p1, 7, 1, "preto", "baixo", "activo", y0);
        }
        p1 = -1;
        for (y0 = 8; y0 < 16; y0++) {
            p1 = p1 + 1;
            array0[y0] = new peao(6, p1, 6, p1, 1, 1, "branco", "cima", "activo", y0);
        }
        array0[16] = new torre(7, 0, 7, 0, 2, 2, "branco", "cima", "activo", 16);
        array0[17] = new torre(7, 7, 7, 7, 2, 2, "branco", "cima", "activo", 17);
        array0[18] = new torre(0, 0, 0, 0, 8, 2, "preto", "cima", "activo", 18);
        array0[19] = new torre(0, 7, 0, 7, 8, 2, "preto", "cima", "activo", 19);
        array0[20] = new cavalo(7, 1, 2, 3, 3, 3, "branco", "cima", "activo", 20);
        array0[21] = new cavalo(7, 6, 7, 6, 3, 3, "branco", "cima", "activo", 21);
        array0[22] = new cavalo(0, 1, 0, 1, 9, 3, "preto", "cima", "activo", 22);
        array0[23] = new cavalo(0, 6, 0, 6, 9, 3, "preto", "cima", "activo", 23);
        array0[24] = new bispo(7, 2, 7, 2, 4, 4, "branco", "cima", "activo", 24);
        array0[25] = new bispo(7, 5, 7, 5, 4, 4, "branco", "cima", "activo", 25);
        array0[26] = new bispo(0, 2, 0, 2, 10, 4, "preto", "cima", "activo", 26);
        array0[27] = new bispo(0, 5, 0, 5, 10, 4, "preto", "cima", "activo", 27);
        array0[28] = new rainha(7, 3, 7, 3, 5, 5, "branco", "cima", "activo", 28);
        array0[29] = new rainha(0, 4, 0, 4, 11, 5, "preto", "cima ", "activo", 29);
        array0[30] = new rei(7, 4, 7, 4, 6, 6, "branco", "cima", "activo", 30);
        array0[31] = new rei(0, 3, 0, 3, 12, 6, "preto", "cima", "activo", 31);
        pecas.arrpecas = array0;

        int x3 = seleccionar();
        while (x3 == 0) {
            x3 = seleccionar();
        }
        if (pecas.mcor2.equals("branco")) {
            while (array0[30].valor != 0 && array0[31].valor != 0) {
                jogar_sozinho_todas();
                valorizar();
                pecas.jogar();
                valorizar();
            }
        }
        while (array0[30].valor != 0 && array0[31].valor != 0) {
            pecas.jogar();
            valorizar();
            jogar_sozinho_todas();
            valorizar();
        }
        if (array0[30].valor == 0) {
            System.out.println("As pecas pretas ganharam");
        }
        if (array0[31].valor == 0) {
            System.out.println("As pecas brancas ganharam");
        }
    }

    public static int jogar_sozinho_todas() {
        int x4 = 0;
        for (int w = 0; w < 32; w++) {
            if (pecas.arrpecas[w].cor.equals(pecas.mcor2)) {
                pecas.ns++;
                pecas.ns2 = -1;
                pecas.arrpecas[w].jogar_sozinho();
            }
        }

        pecas.maior();
        pecas.ns = -1;
        int mo = pecas.arrpecas[pecas.soma5[pecas.aux2]].mover(pecas.soma3[pecas.aux2][pecas.aux3], pecas.soma4[pecas.aux2][pecas.aux3], pecas.ab);
        while (mo == 0) {
            for (int w = 0; w < 32; w++) {
                if (pecas.arrpecas[w].cor.equals(pecas.mcor2)) {
                    for (int w2 = 0; w2 < 8; w2++) {
                        for (int w3 = 0; w3 < 8; w3++) {
                            mo = pecas.arrpecas[w].mover(w2, w3, pecas.ab);
                            if (mo != 0) {
                                for (int w4 = 0; w4 < 16; w4++) {
                                    pecas.soma5[w4] = 0;
                                    for (int w24 = 0; w24 < 32; w24++) {
                                        pecas.soma2[w4][w24] = 0;
                                        pecas.soma3[w4][w24] = 0;
                                        pecas.soma4[w4][w24] = 0;

                                    }
                                }
                                return 1;
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static int seleccionar() {
        int x3 = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Com que cor deseja jogar:");
        System.out.println("1-Preto");
        System.out.println("2-Branco");
        try {
            x3 = teclado.nextInt();
        } catch (java.util.InputMismatchException x) {
            teclado.nextLine();
            System.out.println("Erro");
            x3 = 0;
        }
        if (x3 == 1) {
            pecas.mcor2 = "branco";
            return 1;
        }
        if (x3 == 2) {
            pecas.mcor2 = "preto";
            return 1;
        }
        return 0;
    }

    public static int valorizar() {
        for (int w = 0; w < 32; w++) {
            if (pecas.arrpecas[w].estado.equals("comido")) {
                pecas.arrpecas[w].valor = 0;
                pecas.arrpecas[w].valor2 = 0;
            }
        }
        for (int w0 = 0; w0 < 8; w0++) {
            for (int w1 = 0; w1 < 8; w1++) {
                pecas.ab[w0][w1] = 0;
            }
        }

        for (int q = 0; q < 32; q++) {
            int q2 = 0;
            int q3 = 0;
            q2 = pecas.arrpecas[q].a;
            q3 = pecas.arrpecas[q].b;
            if (pecas.arrpecas[q].estado.equals("activo") || pecas.arrpecas[q].estado.equals("ameacado")) {
                if (pecas.arrpecas[q].valor > 0) {
                    pecas.ab[q2][q3] = pecas.arrpecas[q].valor;
                }
            }
        }
        mostrar();
        return 0;
    }

    public static int mostrar() {
        System.out.println(" |0|1|2|3|4|5|6|7");
        for (int a = 0; a < 8; a++) {
            System.out.print(a);
            for (int b = 0; b < 8; b++) {
                System.out.print("|");
                switch (pecas.ab[a][b]) {
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("p");
                        break;
                    case 2:
                        System.out.print("t");
                        break;
                    case 3:
                        System.out.print("c");
                        break;
                    case 4:
                        System.out.print("b");
                        break;
                    case 5:
                        System.out.print("q");
                        break;
                    case 6:
                        System.out.print("r");
                        break;
                    case 7:
                        System.out.print("P");
                        break;
                    case 8:
                        System.out.print("T");
                        break;
                    case 9:
                        System.out.print("C");
                        break;
                    case 10:
                        System.out.print("B");
                        break;
                    case 11:
                        System.out.print("Q");
                        break;
                    case 12:
                        System.out.print("R");
                }
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println(" =================");
        return 0;
    }
}
