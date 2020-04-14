package main;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class Jogo{

    Scanner input = new Scanner(System.in);
    Random numAleatorio = new Random();
    
    public char [][] tabuleiro = new char[3][3];
    public boolean ganhou = false;
    public int posx;
    public int posy;
    public boolean foraLimite = false;
    public boolean tabuleiroOcupado = false;
    public boolean foraLimiteComputador = false;
    public boolean tabuleiroOcupadoComputador = false;
    public char jogador1;
    public char computador;
    public int escolha;
    public int [] verificarPosicao = new int[2];
    public int [] verificarPosicaoComputador = new int[2];
    public int posxComputador;
    public int posyComputador;
    public boolean vezComputador = false;
    public int posxOcupadaComputador;
    public int posyOcupadaComputador;
    public int turno;
    public ArrayList<Integer> jogadax = new ArrayList();
    public ArrayList<Integer> jogaday = new ArrayList();
    public ArrayList<Integer> diagonal = new ArrayList();
    int xLinha1 =0;
    int xLinha2 =0;
    int xLinha3 =0;
    int yColuna1 =0;
    int yColuna2 =0;
    int yColuna3 =0;
            
    public Jogo(){        
    }
    
    public void EscolherSimbolo(){
        System.out.println(" -----------------INICIAR JOGO------------------");
        System.out.println("Escolha com qual simbolo você quer jogar: \nSimbolo 1 ('X')\nSimbolo 2 ('O')");
        System.out.print("Digite (1/2):");
        escolha = input.nextInt();
            if (escolha == 1){
                System.out.println();
                System.out.println(" VOCÊ ESCOLHEU O SÍMBOLO 'X' ");
                System.out.println(" O COMPUTADOR FICARÁ COM O SÍMBOLO 'O' ");
                System.out.println();
                jogador1 = 'X';
                computador = 'O';
            } else if (escolha == 2) {
                System.out.println();
                System.out.println(" VOCÊ ESCOLHEU O SÍMBOLO 'O' ");
                System.out.println(" O COMPUTADOR FICARÁ COM O SÍMBOLO 'X' ");
                System.out.println();
                jogador1 = 'O';
                computador = 'X';
            } 
            System.out.println();
            System.out.println("===========================================================");
            System.out.println();
    }
    
    public void ImprimirTabuleiro(){
        System.out.println("VAMOS COMEÇAR !!!!!");
        System.out.println();
        System.out.println("BOA SORTE!!");
        System.out.println();
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>  TABULEIRO EXEMPLO >>>>>>>>>>>>>>>>>");
        System.out.println();
        System.out.println("ESTE SERÁ O FORMATO DO TABULEIRO NO QUAL IREMOS JOGAR...");
        System.out.println("PRESTE ATENÇÃO NAS COORDENADAS DO TABULEIRO"); 
        System.out.println("OS NÚMEROS REPRESENTAM AS COORDENADAS QUE PRECISAMOS PARA JOGAR");
        System.out.println();
        
        System.out.println("      1       2      3   ");
        System.out.println("-------------------------");
        for (int i = 0; i<tabuleiro.length ; i++){
            System.out.print((i+1) + " - ");
            for (int j = 0; j<tabuleiro[i].length; j++){
                tabuleiro[i][j] = ' ';
                System.out.print(" | " + tabuleiro[i][j] + " | ");
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }  
    }
    
    public boolean verificarLimite(int posx, int posy){
        while (posx >= 3 || posy >= 3){
            System.out.println();
            System.out.println("\n    COORDENADAS INVÁLIDAS, TENTE NOVAMENTE!");
            System.out.print("  Digite a coordenada da linha:");
            posx = input.nextInt();
            posx --;
            System.out.print("  Digite a coordenada da coluna:");
            posy = input.nextInt();
            posy--;
            System.out.println();
        }       
        this.verificarPosicao[0] = posx;
        this.verificarPosicao[1] = posy;
        return foraLimite = false;
    } 
    
    public boolean verificarLimiteComputador(int posx, int posy){
        
        while (posx >= 3 || posy >= 3){
            posxComputador = numAleatorio.nextInt(3);
            posyComputador = numAleatorio.nextInt(3);
        }       
        this.verificarPosicaoComputador[0] = posxComputador;
        this.verificarPosicaoComputador[1] = posyComputador;
        return foraLimiteComputador = false;
    }
    
        public boolean verificarTabuleiroComputador (int posx, int posy){
        if (tabuleiro[posx][posy] == 'X' || tabuleiro[posx][posy] == 'O'){
            tabuleiroOcupadoComputador = true;
        } else if (tabuleiro[posx][posy] == ' '){
                    tabuleiroOcupadoComputador = false;
        } 
        
        while (tabuleiroOcupadoComputador == true){
            posxComputador = numAleatorio.nextInt(3);
            posyComputador = numAleatorio.nextInt(3);
            
                if (tabuleiro[posxComputador][posyComputador] == 'X' || tabuleiro[posxComputador][posyComputador] == 'O'){
                tabuleiroOcupadoComputador = true;
                } else if (tabuleiro[posxComputador][posyComputador] == ' '){
                tabuleiroOcupadoComputador = false;
                } 
        }
        this.verificarPosicaoComputador[0] = posxComputador;
        this.verificarPosicaoComputador[1] = posyComputador;
        return tabuleiroOcupadoComputador = false;
    }
        
    public boolean verificarTabuleiroComputadorX (int posx, int posy){
        if (tabuleiro[posx][posy] == 'X' || tabuleiro[posx][posy] == 'O'){
            tabuleiroOcupadoComputador = true;
        } else if (tabuleiro[posx][posy] == ' '){
                    tabuleiroOcupadoComputador = false;
        } 
        
        while (tabuleiroOcupadoComputador == true){
            posxComputador = numAleatorio.nextInt(3);
            posyComputador = posy;
            
                if (tabuleiro[posxComputador][posyComputador] == 'X' || tabuleiro[posxComputador][posyComputador] == 'O'){
                tabuleiroOcupadoComputador = true;
                } else if (tabuleiro[posxComputador][posyComputador] == ' '){
                tabuleiroOcupadoComputador = false;
                } 
        }
        this.verificarPosicaoComputador[0] = posxComputador;
        this.verificarPosicaoComputador[1] = posyComputador;
        return tabuleiroOcupadoComputador = false;
    } 
    public boolean verificarTabuleiroComputadorY (int posx, int posy){
        if (tabuleiro[posx][posy] == 'X' || tabuleiro[posx][posy] == 'O'){
            tabuleiroOcupadoComputador = true;
        } else if (tabuleiro[posx][posy] == ' '){
                    tabuleiroOcupadoComputador = false;
        } 
        
        while (tabuleiroOcupadoComputador == true){
            posxComputador = posx;
            posyComputador = numAleatorio.nextInt(3);
            
            verificarLimiteComputador(posxComputador, posyComputador);
                    
                if (tabuleiro[posxComputador][posyComputador] == 'X' || tabuleiro[posxComputador][posyComputador] == 'O'){
                tabuleiroOcupadoComputador = true;
                } else if (tabuleiro[posxComputador][posyComputador] == ' '){
                tabuleiroOcupadoComputador = false;
                } 
        }
        this.verificarPosicaoComputador[0] = posxComputador;
        this.verificarPosicaoComputador[1] = posyComputador;
        return tabuleiroOcupadoComputador = false;
    } 
    
    public boolean verificarTabuleiro(int posx, int posy){
        if (tabuleiro[posx][posy] == 'X' || tabuleiro[posx][posy] == 'O'){
            tabuleiroOcupado = true;
        } else if (tabuleiro[posx][posy] == ' '){
            tabuleiroOcupado = false;
        } 
        
        while (tabuleiroOcupado == true){
            System.out.println();
            System.out.println("    COORDENADAS INVÁLIDAS, TENTE NOVAMENTE!");
            System.out.print("  Digite a coordenada da linha:");
            posx = input.nextInt();
            posx--;
            System.out.print("  Digite a coordenada da coluna:");
            posy = input.nextInt();
            posy--;
            System.out.println();
            verificarLimite(posx, posy);
                    
            if (tabuleiro[posx][posy] == 'X' || tabuleiro[posx][posy] == 'O'){
            tabuleiroOcupado = true;
            } else if (tabuleiro[posx][posy] == ' '){
            tabuleiroOcupado = false;
            } 
        }
        this.verificarPosicao[0] = posx;
        this.verificarPosicao[1] = posy;
        return tabuleiroOcupado = false;
    } 
        
    public boolean verificarGanhador(){
    if (tabuleiro[0][0]  == jogador1 && tabuleiro[0][1] == jogador1 && tabuleiro[0][2] == jogador1 ||
        tabuleiro[1][0]  == jogador1 && tabuleiro[1][1] == jogador1 && tabuleiro[1][2] == jogador1 ||
        tabuleiro[2][0]  == jogador1 && tabuleiro[2][1] == jogador1 && tabuleiro[2][2] == jogador1 ||
        tabuleiro[0][0]  == jogador1 && tabuleiro[1][1] == jogador1 && tabuleiro[2][2] == jogador1 ||
        tabuleiro[2][0]  == jogador1 && tabuleiro[1][1] == jogador1 && tabuleiro[0][2] == jogador1 ||
        tabuleiro[0][0]  == jogador1 && tabuleiro[1][0] == jogador1 && tabuleiro[2][0] == jogador1 ||
        tabuleiro[0][1]  == jogador1 && tabuleiro[1][1] == jogador1 && tabuleiro[2][1] == jogador1 ||
        tabuleiro[0][2]  == jogador1 && tabuleiro[1][2] == jogador1 && tabuleiro[2][2] == jogador1){
        System.out.println("Você ganhou o jogo, PARABÉNS!!");
        ganhou = true;
    } else if 
        (tabuleiro[0][0]  == computador && tabuleiro[0][1] == computador && tabuleiro[0][2] == computador ||
        tabuleiro[1][0]  == computador && tabuleiro[1][1] == computador && tabuleiro[1][2] == computador ||
        tabuleiro[2][0]  == computador && tabuleiro[2][1] == computador && tabuleiro[2][2] == computador ||
        tabuleiro[0][0]  == computador && tabuleiro[1][1] == computador && tabuleiro[2][2] == computador ||
        tabuleiro[2][0]  == computador && tabuleiro[1][1] == computador && tabuleiro[0][2] == computador ||
        tabuleiro[0][0]  == computador && tabuleiro[1][0] == computador && tabuleiro[2][0] == computador ||
        tabuleiro[0][1]  == computador && tabuleiro[1][1] == computador && tabuleiro[2][1] == computador ||
        tabuleiro[0][2]  == computador && tabuleiro[1][2] == computador && tabuleiro[2][2] == computador){
                    System.out.println("Você perdeu o jogo, o COMPUTADOR venceu!");
        ganhou = true;
        } else {
        ganhou = false;
    }
    return ganhou;
    }
    
    public void IniciarJogo(){
        while (ganhou == false){
            for (turno = 1; turno < 9;){
                System.out.println("===========================================================");
                System.out.println();
                System.out.println("TURNO " + (turno));
                if ( turno % 2 == 0) {
                    vezComputador = true;
                    System.out.println(">>>>>>>>>>>>>>>JOGADA DO COMPUTADOR<<<<<<<<<<<<<<<<<<");
                } else{
                    vezComputador = false;
                }
                
                if (vezComputador == false){
                    System.out.print("  Digite a coordenada da linha:");
                    posx = input.nextInt();
                    posx--;
                    System.out.print("  Digite a coordenada da coluna:");
                    posy = input.nextInt();
                    posy--;
                
                    verificarLimite(posx, posy);
                    posx = verificarPosicao[0];
                    posy = verificarPosicao[1];

                    verificarTabuleiro(posx, posy);
                    posx = verificarPosicao[0];
                    posy = verificarPosicao[1];
                    
                    jogadax.add(posx);
                    jogaday.add(posy);
                    if (posx == posy){
                        diagonal.add(posx);
                    }
                    
                if (foraLimite == false && tabuleiroOcupado == false){
                    System.out.println();
                    System.out.println();
                    System.out.println("                      TABULEIRO                       ");
                    
                                      
                    
                    for( int j =0 ; j < tabuleiro.length; j++){
                        for (int k =0; k<tabuleiro[j].length; k++ ){
                            tabuleiro[posx][posy] = jogador1;
                            System.out.print(" | " + tabuleiro[j][k] + " | ");
                        }
                        System.out.println();
                        System.out.println();
                    }

                }
                
                turno++;
                ganhou = verificarGanhador();
                
                if (ganhou == true){
                    break;
                }else if  (turno > 9){
                    System.out.println( "O jogo terminou EMPATADO, ninguém ganhou!");
                }
                }else if (vezComputador == true) {
                    jogadaComputador();
                    turno++;
                    ganhou = verificarGanhador();
                if (ganhou == true){
                    break;
                }else if  (turno > 9){
                    System.out.println( "O jogo terminou EMPATADO, ninguém ganhou!");
                    ganhou = true;
                }
                }
            }
        }
    }
    
    public boolean jogadaComputador(){
        while (ganhou == false || vezComputador == true){
            
        if (xLinha1 < 2){
            xLinha1 = 0;
            if (xLinha2 < 2){
                xLinha2 = 0;
                if (xLinha3 < 2){
                    xLinha3 = 0;
                    if (yColuna1 < 2){
                        yColuna1 = 0;
                        if (yColuna2 < 2){
                            yColuna2 = 0;
                            if (yColuna3 < 2){
                                yColuna3 = 0;
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("Antes do switch case");
        System.out.println("Quantas vezes foi jogado na linha 1: " + xLinha1);
        System.out.println("Quantas vezes foi jogado na linha 2: " + xLinha2);
        System.out.println("Quantas vezes foi jogado na linha 3: " + xLinha3);
        System.out.println("Quantas vezes foi jogado na coluna 1: " + yColuna1);
        System.out.println("Quantas vezes foi jogado na coluna 2: " + yColuna2);
        System.out.println("Quantas vezes foi jogado na coluna 3: " + yColuna3);
        
        
            for (Integer listax : jogadax){
                System.out.println(listax);
                switch (listax){
                    case 0:
                        xLinha1++;
                        break;
                        
                    case 1:
                        xLinha2++;
                        break;
                        
                    case 2:
                        xLinha3++;
                        break;
                }
            }

 
            for (Integer listay : jogaday){
                System.out.println(listay);
                switch (listay){
                    case 0:
                        yColuna1++;
                        break;
                        
                    case 1:
                        yColuna2++;
                        break;
                        
                    case 2:
                        yColuna3++;
                        break;
                }
            }
            
            if (diagonal.size() == 2){
                posxComputador = numAleatorio.nextInt(3);
                posyComputador = posxComputador;
                
                verificarTabuleiroComputador(posxComputador, posyComputador);
            
            } else if (xLinha1 == 2){
                posxComputador = 0;
                posyComputador = numAleatorio.nextInt(3);
                
                xLinha1 = 3;
                
                verificarTabuleiroComputadorY(posxComputador, posyComputador);
                
            } else if(xLinha2 == 2){
                posxComputador = 1;
                posyComputador = numAleatorio.nextInt(3);
                
                xLinha2 = 3;

                
                verificarTabuleiroComputadorY(posxComputador, posyComputador);
                
            } else if(xLinha3 == 2){
                posxComputador = 2;
                posyComputador = numAleatorio.nextInt(3);
                
                xLinha3 = 3;
                
                verificarTabuleiroComputadorY(posxComputador, posyComputador);
                
            } else if(yColuna1 == 2){
                posxComputador = numAleatorio.nextInt(3);
                posyComputador = 0;
                
                 yColuna1 = 3;
               
                verificarTabuleiroComputadorX(posxComputador, posyComputador);
            
            } else if(yColuna2 == 2){
                posxComputador = numAleatorio.nextInt(3);
                posyComputador = 1;
                
                yColuna2 = 3;
                
                verificarTabuleiroComputadorX(posxComputador, posyComputador);
                
            } else if(yColuna3 == 2){
                posxComputador = numAleatorio.nextInt(3);
                posyComputador = 2;
                
                yColuna3 = 3;
                
                verificarTabuleiroComputadorX(posxComputador, posyComputador);
                
            } else {
                posxComputador = numAleatorio.nextInt(3);
                posyComputador = numAleatorio.nextInt(3);
                
                verificarTabuleiroComputador (posxComputador, posyComputador);
                posxComputador = verificarPosicaoComputador[0];
                posyComputador = verificarPosicaoComputador[1];
            }
                foraLimite = false;
                posxComputador = verificarPosicaoComputador[0];
                posyComputador = verificarPosicaoComputador[1];    
            
        System.out.println("Depois do ifelse");
        System.out.println("Quantas vezes foi jogado na linha 1: " + xLinha1);
        System.out.println("Quantas vezes foi jogado na linha 2: " + xLinha2);
        System.out.println("Quantas vezes foi jogado na linha 3: " + xLinha3);
        System.out.println("Quantas vezes foi jogado na coluna 1: " + yColuna1);
        System.out.println("Quantas vezes foi jogado na coluna 2: " + yColuna2);
        System.out.println("Quantas vezes foi jogado na coluna 3: " + yColuna3);
        System.out.println();
        System.out.println("posx " + posxComputador);
        System.out.println("posy " + posyComputador);
        
                if (foraLimiteComputador == false && tabuleiroOcupadoComputador == false){
                    System.out.println();
                    System.out.println();
                    System.out.println("                      TABULEIRO                       ");

                    for( int j =0 ; j < tabuleiro.length; j++){
                        for (int k =0; k<tabuleiro[j].length; k++ ){
                            tabuleiro[posxComputador][posyComputador] = computador;
                            System.out.print(" | " + tabuleiro[j][k] + " | ");
                        } 
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                } 
            break;
                
        } 
    return vezComputador = false;
    }

}
       
    



        
    

