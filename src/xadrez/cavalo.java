/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 *
 * @author rebento
 */
public class cavalo extends pecas {

    public cavalo(int a, int b, int a9, int b9, int valor, int valor2, String cor, String direccao, String estado, int instancia) {
        super(a, b, a9, b9, valor, valor2, cor, direccao, estado, instancia);


    }

    public int mover(int a2, int b2, int[][] ab) {
        if (valor > 0) {
            int auxcor = -1;
            int auxcor2 = 7;
            if (cor.equals("branco")) {
                auxcor = 6;
                auxcor2 = 13;
            }
            if (ab[a2][b2] > auxcor && ab[a2][b2] < auxcor2 || ab[a2][b2] == 0 && a2 >= 0 && a2 <= 7 && b2 >= 0 && b2 <= 7) {
                if (a2 == a + 2 || a2 == a - 2) {
                    if (b2 == b + 1 || b2 == b - 1) {
                        comer(a2, b2);
                        a = a2;
                        b = b2;
                        return 1;
                    }
                }
                if (b2 == b + 2 || b2 == b - 2) {
                    if (a2 == a + 1 || a2 == a - 1) {
                        comer(a2, b2);
                        a = a2;
                        b = b2;
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public int ameacar(int a2, int b2, int[][] ab) {
        if (valor > 0) {
            int auxcor = -1;
            int auxcor2 = 7;
            if (cor.equals("branco")) {
                auxcor = 6;
                auxcor2 = 13;
            }
            if (ab[a2][b2] > auxcor && ab[a2][b2] < auxcor2 || ab[a2][b2] == 0 && a2 >= 0 && a2 <= 7 && b2 >= 0 && b2 <= 7) {
                if (a2 == a + 2 || a2 == a - 2) {
                    if (b2 == b + 1 || b2 == b - 1) {
                        comer(a2, b2);
                        a9 = a2;
                        b9 = b2;
                        return 2;
                    }
                }
                if (b2 == b + 2 || b2 == b - 2) {
                    if (a2 == a + 1 || a2 == a - 1) {
                        comer(a2, b2);
                        a9 = a2;
                        b9 = b2;
                        return 2;
                    }
                }

            }
        }
        return 1;
    }

    public void jogar_sozinho() {

        for (int w0 = 0; w0 < 8; w0++) {
            for (int w1 = 0; w1 < 8; w1++) {
                int x = arrpecas[instancia].ameacar(w0, w1, ab);
                if (x == 2) {
                    ns2++;
                    for (int x2 = 0; x2 < 32; x2++) {
                        arrpecas[x2].ameacar_todos();
                    }

                    somar_possibilidades();
                    somar_guardar(ns, ns2, a9, b9, instancia);






                }
            }
        }
    }

    public int ameacar_todos() {
        if (valor > 0) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    int auxcor = -1;
                    int auxcor2 = 7;
                    if (cor.equals("branco")) {
                        auxcor = 6;
                        auxcor2 = 13;
                    }
                    if (ab[x][y] > auxcor && ab[x][y] < auxcor2 || ab[x][y] == 0 && x >= 0 && x <= 7 && y >= 0 && y <= 7) {
                        if (x == a9 + 2 || x == a9 - 2) {
                            if (y == b9 + 1 || y == b9 - 1) {
                                percorrer(x, y);
                                return 2;
                            }
                        }
                        if (y == b9 + 2 || y == b9 - 2) {
                            if (x == a9 + 1 || x == a9 - 1) {
                                percorrer(x, y);
                                return 2;
                            }
                        }
                    }



                }
            }
        }
        return 0;
    }
}
