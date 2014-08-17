/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 *
 * @author rebento
 */
public class bispo extends pecas {

    public bispo(int a, int b, int a9, int b9, int valor, int valor2, String cor, String direccao, String estado, int instancia) {
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

            int a3 = 0;
            int a4 = 0;
            if (a > a2) {
                a3 = a - a2;
                if (b > b2 && a3 == b - b2) {
                    a4 = 2;
                    for (int x2 = 1; x2 < a3; x2++) {
                        if (ab[a - x2][b - x2] != 0) {
                            a4 = 1;
                        }
                    }
                }
                if (b < b2 && a3 == b2 - b) {
                    a4 = 2;
                    for (int x2 = 1; x2 < a3; x2++) {
                        if (ab[a - x2][b + x2] != 0) {
                            a4 = 1;
                        }
                    }
                }
            }
            if (a < a2) {
                a3 = a2 - a;
                if (b > b2 && a3 == b - b2) {
                    a4 = 2;
                    for (int x2 = 1; x2 < a3; x2++) {
                        if (ab[a + x2][b - x2] != 0) {
                            a4 = 1;
                        }
                    }
                }
                if (b < b2 && a3 == b2 - b) {
                    a4 = 2;
                    for (int x2 = 1; x2 < a3; x2++) {
                        if (ab[a + x2][b + x2] != 0) {
                            a4 = 1;
                        }
                    }
                }
            }
            if (a4 == 2) {
                if (ab[a2][b2] == 0 || ab[a2][b2] > auxcor && ab[a2][b2] < auxcor2) {
                    comer(a2, b2);
                    a = a2;
                    b = b2;
                    return 1;
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

            int a3 = 0;
            int a4 = 0;
            if (a > a2) {
                a3 = a - a2;
                if (b > b2 && a3 == b - b2) {
                    a4 = 2;
                    for (int x2 = 1; x2 < a3; x2++) {
                        if (ab[a - x2][b - x2] != 0) {
                            a4 = 1;
                        }
                    }
                }
                if (b < b2 && a3 == b2 - b) {
                    a4 = 2;
                    for (int x2 = 1; x2 < a3; x2++) {
                        if (ab[a - x2][b + x2] != 0) {
                            a4 = 1;
                        }
                    }
                }
            }
            if (a < a2) {
                a3 = a2 - a;
                if (b > b2 && a3 == b - b2) {
                    a4 = 2;
                    for (int x2 = 1; x2 < a3; x2++) {
                        if (ab[a + x2][b - x2] != 0) {
                            a4 = 1;
                        }
                    }
                }
                if (b < b2 && a3 == b2 - b) {
                    a4 = 2;
                    for (int x2 = 1; x2 < a3; x2++) {
                        if (ab[a + x2][b + x2] != 0) {
                            a4 = 1;
                        }
                    }
                }
            }
            if (a4 == 2) {
                if (ab[a2][b2] == 0 || ab[a2][b2] > auxcor && ab[a2][b2] < auxcor2) {
                    comer(a2, b2);
                    a9 = a2;
                    b9 = b2;
                    return 2;
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

                    int a3 = 0;
                    int a4 = 0;
                    if (a9 > x) {
                        a3 = a9 - y;
                        if (b9 > y && a3 == b9 - y) {
                            a4 = 2;
                            for (int x2 = 1; x2 < a3; x2++) {
                                if (ab[a9 - x2][b9 - x2] != 0) {
                                    a4 = 1;
                                }
                            }
                        }
                        if (b9 < y && a3 == y - b9) {
                            a4 = 2;
                            for (int x2 = 1; x2 < a3; x2++) {
                                if (ab[a9 - x2][b9 + x2] != 0) {
                                    a4 = 1;
                                }
                            }
                        }
                    }
                    if (a9 < x) {
                        a3 = x - a9;
                        if (b9 > y && a3 == b9 - y) {
                            a4 = 2;
                            for (int x2 = 1; x2 < a3; x2++) {
                                if (ab[a9 + x2][b9 - x2] != 0) {
                                    a4 = 1;
                                }
                            }
                        }
                        if (b < x && a3 == y - b9) {
                            a4 = 2;
                            for (int x2 = 1; x2 < a3; x2++) {
                                if (ab[a9 + x2][b9 + x2] != 0) {
                                    a4 = 1;
                                }
                            }
                        }
                    }
                    if (a4 == 2) {
                        if (ab[x][y] == 0 || ab[x][y] > auxcor && ab[x][y] < auxcor2) {
                            percorrer(x, y);
                            return 2;
                        }

                    }
                }
            }
        }
        return 1;
    }
}
