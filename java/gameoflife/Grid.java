package gameoflife;


import java.util.Random;

public class Grid {
    private Cell[][] cells;
    private int sizeGrid;
    private Random rd;
    private int num;
    private Cell[][] tab;
    private Cell[][] tab2;

    public Grid(int sizeGrid) {
        this.rd = new Random();
        this.sizeGrid = sizeGrid;
        generateRandomInitialState();
    }

    Grid(int sizeGrid, Cell[][] cells) {
        this.sizeGrid = sizeGrid;
        this.cells = cells;
        this.tab = cells;
    }

    private void generateRandomInitialState() {
        this.tab = new Cell[this.sizeGrid][this.sizeGrid];

        for (int i = 0; i < this.sizeGrid; i++) {
            for (int j = 0; j < this.sizeGrid; j++) {
                this.tab[i][j]= new Cell(false);         // j'initialise tab avec des '.'

                num = this.rd.nextInt(10);                // je genere un chiffre entre 1 et 9
                if (num % 4 == 0) {                              // si ce chiffre est divisible par 4, la cellule prend 'X'
                    this.tab[i][j].setIsAlive(true);}
                else { this.tab[i][j].setIsAlive(false); }     // sinon '.'

                   }

                }

            }




    public void generateNextState() {
    int cont =0;
    Cell[][] tab2 = new Cell[this.sizeGrid][this.sizeGrid];         //je créé tab2
        for (int i = 0; i < this.sizeGrid; i++) {
            for (int j = 0; j < this.sizeGrid; j++) {

                tab2[i][j]= new Cell(false);         // j'initialise tab2

                if(this.tab[i][j].isAlive()==true){

                    if(i==0 && j==0){                                            //haut gauche
                        if(this.tab[i][j].isAlive()==this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j+1].isAlive()){cont++;} }

                    else if(i==0 && j == this.sizeGrid-1){                             //haut a droite
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j].isAlive()){cont++;} }

                    else if(i==this.sizeGrid-1 && j == this.sizeGrid-1){                             //bas a droite
                        if(this.tab[i][j].isAlive()==this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j-1].isAlive()){cont++;} }

                    else if(i==this.sizeGrid-1 && j == 0){                             //bas a gauche
                        if(this.tab[i][j].isAlive()==this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j+1].isAlive()){cont++;} }

                    else if(i == this.sizeGrid-1){
                        if(this.tab[i][j].isAlive()==this.tab[i][j+1].isAlive()){cont++;}              //ligne du bas
                        if(this.tab[i][j].isAlive()==this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j-1].isAlive()){cont++;} }

                    else if(i == 0){                                           //ligne du haut
                        if(this.tab[i][j].isAlive()==this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j-1].isAlive()){cont++;} }


                    else if(j == 0){
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j].isAlive()){cont++;}              //ligne de gauche
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j].isAlive()){cont++;} }


                    else if(j == this.sizeGrid-1){
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j].isAlive()){cont++;}              //ligne de droite
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j].isAlive()){cont++;} }

                    else {
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j].isAlive()){cont++;}              //autre
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j-1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i-1][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i][j].isAlive()==this.tab[i+1][j+1].isAlive()){cont++;}}


                    if (cont == 2 || cont == 3){tab2[i][j].setIsAlive(true);}
                    else{tab2[i][j].setIsAlive(false);}


                }     // si la cellule est un 'X'

               else if (this.tab[i][j].isAlive()==false){

                    if(i==0 && j==0){                                            //haut gauche
                        if(this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i+1][j].isAlive()){cont++;}
                        if(this.tab[i+1][j+1].isAlive()){cont++;} }

                    else if(i==0 && j == this.sizeGrid-1){                             //haut a droite
                        if(this.tab[i+1][j-1].isAlive()){cont++;}
                        if(this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i+1][j].isAlive()){cont++;} }

                    else if(i==this.sizeGrid-1 && j == this.sizeGrid-1){                             //bas a droite
                        if(this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i-1][j].isAlive()){cont++;}
                        if(this.tab[i-1][j-1].isAlive()){cont++;} }

                    else if(i==this.sizeGrid-1 && j == 0){                             //bas a gauche
                        if(this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i-1][j].isAlive()){cont++;}
                        if(this.tab[i-1][j+1].isAlive()){cont++;} }

                    else if(i == this.sizeGrid-1){
                        if(this.tab[i][j+1].isAlive()){cont++;}              //ligne du bas
                        if(this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i-1][j].isAlive()){cont++;}
                        if(this.tab[i-1][j+1].isAlive()){cont++;}
                        if(this.tab[i-1][j-1].isAlive()){cont++;} }

                    else if(i == 0){                                           //ligne du haut
                        if(this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i+1][j].isAlive()){cont++;}
                        if(this.tab[i+1][j+1].isAlive()){cont++;}
                        if(this.tab[i+1][j-1].isAlive()){cont++;} }


                    else if(j == 0){
                        if(this.tab[i-1][j].isAlive()){cont++;}              //ligne de gauche
                        if(this.tab[i-1][j+1].isAlive()){cont++;}
                        if(this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i+1][j+1].isAlive()){cont++;}
                        if(this.tab[i+1][j].isAlive()){cont++;} }


                    else if(j == this.sizeGrid-1){
                        if(this.tab[i-1][j].isAlive()){cont++;}              //ligne de droite
                        if(this.tab[i-1][j-1].isAlive()){cont++;}
                        if(this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i+1][j-1].isAlive()){cont++;}
                        if(this.tab[i+1][j].isAlive()){cont++;} }

                    else {
                        if(this.tab[i-1][j].isAlive()){cont++;}              //autre
                        if(this.tab[i-1][j-1].isAlive()){cont++;}
                        if(this.tab[i][j-1].isAlive()){cont++;}
                        if(this.tab[i+1][j-1].isAlive()){cont++;}
                        if(this.tab[i+1][j].isAlive()){cont++;}
                        if(this.tab[i-1][j+1].isAlive()){cont++;}
                        if(this.tab[i][j+1].isAlive()){cont++;}
                        if(this.tab[i+1][j+1].isAlive()){cont++;}}


                    if (cont == 3){tab2[i][j].setIsAlive(true);}
                    else{tab2[i][j].setIsAlive(false);}




                }   // si la cellule est un '.'

               this.tab2 = tab2;

                cont =0;

            }

        }
        this.tab= new Cell[this.sizeGrid][this.sizeGrid];
        this.tab=this.tab2;

    }

    public String toString() {
        String[] chaine=new String[this.sizeGrid];                     //j'initialise la chaine
        String finalchain = "";
        for (int i = 0; i < this.sizeGrid; i++) {
            chaine[i]="";
            for (int j = 0; j < this.sizeGrid; j++) {


               chaine[i]+= this.tab2[i][j].toString() + " ";           // je concatene le bout de chaine


            }

            chaine[i] = chaine[i].substring(0, chaine[i].length()-1);     // je supprime l'espace a la fin
            chaine[i] = chaine[i] + "\n";
            finalchain = finalchain + chaine[i];                            // je met toutes les chaines ensemble
        }
        finalchain = finalchain.substring(0, finalchain.length()-1);
        return finalchain;
    }
}
