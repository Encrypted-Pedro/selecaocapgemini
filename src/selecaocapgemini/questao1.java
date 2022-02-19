/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selecaocapgemini;

import java.util.Scanner;

/**
 *
 * @author PedroAndre
 */
public class questao1 {
    public static void iniciar(){
        questao1();
    }
    private static void questao1(){
        Scanner scan = new Scanner(System.in); //Recebe dados do teclado
        System.out.println("Questão 1: Escada em * de acordo com o número digitado\nPorfavor digite um número inteiro:");
        String num = scan.next();
        try{
            int n = Integer.parseInt(num); //Tenta fazer a conversao para um número caso falhe vai para o catch
            String ast = "*";
            String esp = " ";
            System.out.println("Resultado:");
            for(int i = 0; i != n; i++){ //Coloca espaços de acordo ao número digitado
                esp = esp + " ";
            }
            for(int i = 0; i != n; i++){ //Subrai os espaços e adiciona os asteríscos cada vez que entra no laço de repetição
                int x = n - i;
                esp = esp.substring(0, x);
                if(i == 0){
                    System.out.println(esp + ast);
                }else{
                    ast = ast + "*";
                    String novo = esp + ast;
                    System.out.println(novo); //Imprime na tela o resultado
                }
            }
            questao2 questao2 = new questao2(); //Puxa a qustão 2 imediatamente após o resultado
            questao2.iniciar();
        }catch(Exception e){ //Informa ao usuário que é necessário colocar um número inteiro
            System.out.println("Digite apenas números inteiros");
            questao1();
        }
    }
}
