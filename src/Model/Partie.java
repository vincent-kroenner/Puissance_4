package Model;

public class Partie {
    public static int LARGEUR = 7;
    public static int LONGUEUR = 6;
    public static int VICTOIRE = 4;
    private int[][] plateauDeJeu;
    private boolean[] victory ;
    public int placerUnJetonRouge;

    public Partie() {
        plateauDeJeu = new int[LARGEUR][LONGUEUR];
    }

    public int getCaseDuPlateauDeJeu(int i, int j) {
        return plateauDeJeu[i][j];
    }

    public void majPlateau(int colone) {
        int ligne = LONGUEUR - 1;
        if (colone == 0 & plateauDeJeu[colone][0] == 0) {
            while (plateauDeJeu[colone][ligne] != 0) {
                ligne--;
            }
            plateauDeJeu[colone][ligne] = 1;
            victoire(1, colone, ligne);
            genererUnJetonRouge();
            victoire(2, placerUnJetonRouge, ligne);
        } else if (colone == 1 & plateauDeJeu[colone][0] == 0) {
            while (plateauDeJeu[colone][ligne] != 0) {
                ligne--;
            }
            plateauDeJeu[colone][ligne] = 1;
            victoire(1, colone, ligne);
            genererUnJetonRouge();
            victoire(2, placerUnJetonRouge, ligne);
        } else if (colone == 2 & plateauDeJeu[colone][0] == 0) {
            while (plateauDeJeu[colone][ligne] != 0) {
                ligne--;
            }
            plateauDeJeu[colone][ligne] = 1;
            victoire(1, colone, ligne);
            genererUnJetonRouge();
            victoire(2, placerUnJetonRouge, ligne);
        } else if (colone == 3 & plateauDeJeu[colone][0] == 0) {
            while (plateauDeJeu[colone][ligne] != 0) {
                ligne--;
            }
            plateauDeJeu[colone][ligne] = 1;
            victoire(1, colone, ligne);
            genererUnJetonRouge();
            victoire(2, placerUnJetonRouge, ligne);

        } else if (colone == 4 & plateauDeJeu[colone][0] == 0) {
            while (plateauDeJeu[colone][ligne] != 0) {
                ligne--;
            }
            plateauDeJeu[colone][ligne] = 1;
            victoire(1, colone, ligne);
            genererUnJetonRouge();
            victoire(2, placerUnJetonRouge, ligne);
        } else if (colone == 5 & plateauDeJeu[colone][0] == 0) {
            while (plateauDeJeu[colone][ligne] != 0) {
                ligne--;
            }
            plateauDeJeu[colone][ligne] = 1;
            victoire(1, colone, ligne);
            genererUnJetonRouge();
            victoire(2, placerUnJetonRouge, ligne);
        } else if (colone == 6 & plateauDeJeu[colone][0] == 0) {
            while (plateauDeJeu[colone][ligne] != 0) {
                ligne--;
            }
            plateauDeJeu[colone][ligne] = 1;
            victoire(1, colone, ligne);
            genererUnJetonRouge();
            victoire(2, placerUnJetonRouge, ligne);
        }
    }

    public void genererUnJetonRouge() {
        do {
            placerUnJetonRouge = (int) (Math.random() * LARGEUR);
        } while (plateauDeJeu[placerUnJetonRouge][0] != 0);
        int ligne = LONGUEUR - 1;
        while (plateauDeJeu[placerUnJetonRouge][ligne] != 0) {
            ligne--;
        }
        plateauDeJeu[placerUnJetonRouge][ligne] = 2;
    }

    public void victoire(int couleur, int colone, int ligne) {
        int max = 0;
        int x;
        int y;
        int somme;



        x = colone;
        y = ligne;
        somme = -1;
        while (y >= 0 && x >= 0 && plateauDeJeu[x][y] == couleur) {
            y--;
            x--;
            somme++;
        }
        x = colone;
        y = ligne;
        while (y < LONGUEUR && x < LARGEUR && plateauDeJeu[x][y] == couleur) {
            y++;
            x++;
            somme++;
        }
        if (somme > max) max = somme;



        x = colone;
        y = ligne;
        somme = -1;
        while (y >= 0 && x < LARGEUR && plateauDeJeu[x][y] == couleur) {
            y--;
            x++;
            somme++;
        }
        x = colone;
        y = ligne;
        while (y < LONGUEUR && x >= 0 && plateauDeJeu[x][y] == couleur) {
            y++;
            x--;
            somme++;
        }
        if (somme > max) max = somme;




        x = colone;
        y = ligne;
        somme = -1;
        while (y >= 0 && plateauDeJeu[x][y] == couleur) {
            y--;
            somme++;
        }
        y = ligne;
        while (y < LONGUEUR && plateauDeJeu[x][y] == couleur) {
            y++;
            somme++;
        }
        if (somme > max) max = somme;




        x = colone;
        y = ligne;
        somme = -1;
        while (x >= 0 && plateauDeJeu[x][y] == couleur) {
            x--;
            somme++;
        }
        x = colone;
        while (x < LARGEUR && plateauDeJeu[x][y] == couleur) {
            x++;
            somme++;
        }
        if (somme > max) max = somme;



        if (max >= VICTOIRE & couleur == 1) {
            System.out.println("Vous avez gagné");
            //victory[0] = true;
        }else if (max >= VICTOIRE & couleur == 2){
            System.out.println("L'ordinateur à gagné");
            //victory[1] = true;
        }

    }

    public boolean[] getVictory() {
        return victory;
    }
}





