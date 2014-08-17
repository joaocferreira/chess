/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 *
 * @author rebento
 */
public class peao extends pecas {

    public peao(int a, int b, int a9, int b9, int valor, int valor2, String cor, String direccao, String estado, int instancia) {
        super(a, b, a9, b9, valor, valor2, cor, direccao, estado, instancia);


    }

    public int mover(int a2, int b2, int[][] ab) {
        if (valor > 0) {
            int p = 0;
            if (p == 0 && a == 1 && b2 == b) {
                if (p == 0 && direccao.equals("baixo") && a2 == a + 2 && ab[a + 1][b] == 0 && ab[a + 2][b] == 0) {
                    a = a2;
                    return 1;
                }
            }
            if (p == 0 && a == 6 && b2 == b) {
                if (direccao.equals("cima") && a2 == a - 2 && ab[a - 1][b] == 0 && ab[a - 2][b] == 0) {
                    a = a2;
                    return 1;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("baixo") && a2 == a + 1 && b2 == b && ab[a + 1][b] == 0) {
                    a = a2;
                    p = 1;
                    if (p == 1 && a == 7) {
                        int u = promover(a, b, a9, b9, instancia);
                        while (u == 0) {
                            u = promover(a, b, a9, b9, instancia);
                        }
                    }
                    return 1;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("cima") && a2 == a - 1 && b2 == b && ab[a - 1][b] == 0) {
                    a = a2;
                    p = 1;
                    if (p == 1 && a == 0) {
                        int u = promover(a, b, a9, b9, instancia);
                        while (u == 0) {
                            u = promover(a, b, a9, b9, instancia);
                        }
                    }
                    return 1;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("baixo") && a2 == a + 1 && b2 == b + 1 && ab[a + 1][b + 1] < 8 && ab[a + 1][b + 1] > 0) {
                    comer(a2, b2);
                    a = a2;
                    b = b2;
                    p = 1;
                    if (p == 1 && a == 7) {
                        int u = promover(a, b, a9, b9, instancia);
                        while (u == 0) {
                            u = promover(a, b, a9, b9, instancia);
                        }
                    }
                    return 1;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("baixo") && a2 == a + 1 && b2 == b - 1 && ab[a + 1][b - 1] < 8 && ab[a + 1][b - 1] > 0) {
                    comer(a2, b2);
                    a = a2;
                    b = b2;
                    p = 1;
                    if (p == 1 && a == 7) {
                        int u = promover(a, b, a9, b9, instancia);
                        while (u == 0) {
                            u = promover(a, b, a9, b9, instancia);
                        }
                    }
                    return 1;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("cima") && a2 == a - 1 && b2 == b + 1 && ab[a - 1][b + 1] >= 7) {
                    comer(a2, b2);
                    a = a2;
                    b = b2;
                    p = 1;
                    if (p == 1 && a == 0) {
                        int u = promover(a, b, a9, b9, instancia);
                        while (u == 0) {
                            u = promover(a, b, a9, b9, instancia);
                        }
                    }
                    return 1;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("cima") && a2 == a - 1 && b2 == b - 1 && ab[a - 1][b - 1] >= 7) {
                    comer(a2, b2);
                    a = a2;
                    b = b2;
                    p = 1;
                    if (p == 1 && a == 0) {
                        int u = promover(a, b, a9, b9, instancia);
                        while (u == 0) {
                            u = promover(a, b, a9, b9, instancia);
                        }
                    }
                    return 1;
                }
            }

        }
        return 0;
    }

    public int ameacar(int a2, int b2, int[][] ab) {
        if (valor > 0) {
            int p = 0;
            if (p == 0 && a == 1 && b2 == b) {
                if (p == 0 && direccao.equals("baixo") && a2 == a + 2 && ab[a + 1][b] == 0 && ab[a + 2][b] == 0) {
                    b9 = b2;
                    return 2;
                }
            }
            if (p == 0 && a == 6 && b2 == b) {
                if (direccao.equals("cima") && a2 == a - 2 && ab[a - 1][b] == 0 && ab[a - 2][b] == 0) {
                    a9 = a2;
                    b9 = b2;
                    return 2;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("baixo") && a2 == a + 1 && b2 == b && ab[a + 1][b] == 0) {
                    b9 = b2;
                    return 2;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("cima") && a2 == a - 1 && b2 == b && ab[a - 1][b] == 0) {
                    a9 = a2;
                    b9 = b2;
                    return 2;
                }
            }

            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("baixo") && a2 == a + 1 && b2 == b + 1 && ab[a2][b2] < 7 && ab[a2][b2] > 0) {
                    p = 1;
                    a9 = a2;
                    b9 = b2;
                    return 2;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("baixo") && a2 == a + 1 && b2 == b - 1 && ab[a2][b2] < 7 && ab[a2][b2] > 0 && ab[a2][b2] > 0) {
                    comer(a2, b2);
                    p = 1;
                    a9 = a2;
                    b9 = b2;
                    return 2;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("cima") && a2 == a - 1 && b2 == b + 1 && ab[a2][b2] > 6 && ab[a2][b2] > 0) {
                    comer(a2, b2);
                    p = 1;
                    a9 = a2;
                    b9 = b2;
                    return 2;
                }
            }
            if (p == 0 && a2 >= 0 && b2 < 8 && a2 < 8 && b2 >= 0) {
                if (direccao.equals("cima") && a2 == a - 1 && b2 == b - 1 && ab[a2][b2] > 6 && ab[a2][b2] > 0) {
                    comer(a2, b2);
                    p = 1;
                    a9 = a2;
                    b9 = b2;
                    return 2;
                }
            }
        }
        return 0;
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
            int p = 0;
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (p == 0 && a9 > 0 && b9 < 8 && a9 < 8 && b9 >= 0) {
                        if (direccao.equals("baixo") && x == a9 + 1 && y == b9 + 1 && ab[a9 + 1][b9 + 1] < 7) {
                            percorrer(x, y);
                            return 2;
                        }
                    }
                    if (p == 0 && a > 0 && b9 < 8 && a9 < 8 && b9 >= 0) {
                        if (direccao.equals("baixo") && x == a9 + 1 && y == b9 - 1 && ab[a9 + 1][b9 - 1] < 7) {
                            percorrer(x, y);
                            return 2;
                        }
                    }
                    if (p == 0 && a9 > 0 && b9 < 8 && a9 < 8 && b9 >= 0) {
                        if (direccao.equals("baixo") && x == a9 + 1 && y == b9 + 1 && ab[x][y] < 7 && ab[x][y] > 0) {
                            percorrer(x, y);
                            return 2;
                        }
                    }
                    if (p == 0 && a > 0 && b < 8 && a < 8 && b >= 0) {
                        if (direccao.equals("baixo") && x == a9 + 1 && y == b9 - 1 && ab[x][y] < 7 && ab[x][y] > 0) {
                            percorrer(x, y);
                            return 2;
                        }
                    }
                    if (p == 0 && a9 > 0 && b9 < 8 && a9 < 8 && b9 >= 0) {
                        if (direccao.equals("cima") && x == a9 - 1 && y == b9 + 1 && ab[x][y] > 6) {
                            percorrer(x, y);
                            return 2;
                        }
                    }
                    if (p == 0 && a9 > 0 && b9 < 8 && a9 < 8 && b9 >= 0) {
                        if (direccao.equals("cima") && x == a9 - 1 && y == b9 - 1 && ab[x][y] > 6) {
                            percorrer(x, y);
                            return 2;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
