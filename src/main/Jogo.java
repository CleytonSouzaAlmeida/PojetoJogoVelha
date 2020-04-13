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
    public int jogadaAtualx;
    public int jogadaAtualy;
    public ArrayList<Integer> jogadax = new ArrayList();
    public ArrayList<Integer> jogaday = new ArrayList();
    
            
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
                    jogadaAtualx = posx;
                    
                    jogaday.add(posy);
                    jogadaAtualy = posy;
                    
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
                }else if  (turno > 8){
                    System.out.println( "O jogo terminou EMPATADO, ninguém ganhou!");
                }
                }else if (vezComputador == true) {
                    jogadaComputador();
                    turno++;
                    ganhou = verificarGanhador();
                if (ganhou == true){
                    break;
                }else if  (turno > 8){
                    System.out.println( "O jogo terminou EMPATADO, ninguém ganhou!");
                    ganhou = true;
                }
                }
            }
        }
    }
    
    public boolean jogadaComputador(){
        while (ganhou == false || vezComputador == true){
            
            int turnoAnterior;
            int jogadaAnteriorx;
            int jogadaAnteriory;
            
            if (turno == 2){
              turnoAnterior = 0;
            }else {
             turnoAnterior = ((turno/2)-2);
             jogadaAnteriorx = jogadax.get(turnoAnterior);
             jogadaAnteriory = jogaday.get(turnoAnterior);
            
            if (jogadaAnteriorx == jogadaAtualx){
                posxComputador = jogadaAnteriorx;
                posyComputador = numAleatorio.nextInt(3);
            
            } else if (jogadaAnteriory == jogadaAtualy){
                posxComputador = numAleatorio.nextInt(3);
                posyComputador = jogadaAnteriory;
            
            } else if (jogadaAnteriory == jogadaAnteriorx && jogadaAtualx == jogadaAtualy ){
                posxComputador = numAleatorio.nextInt(3);
                posyComputador = posxComputador;
            } else {
                posxComputador = numAleatorio.nextInt(3);
                posyComputador = numAleatorio.nextInt(3);
            }
            }
        
            verificarLimiteComputador (posxComputador, posyComputador);
                posxComputador = verificarPosicaoComputador[0];
                posyComputador = verificarPosicaoComputador[1];
                
            verificarTabuleiroComputador (posxComputador, posyComputador);
                posxComputador = verificarPosicaoComputador[0];
                posyComputador = verificarPosicaoComputador[1];    
            
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
       
    



        
    

