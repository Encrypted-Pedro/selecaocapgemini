/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selecaocapgemini;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author PedroAndre
 */
public class questao3 {
    public static void inicar(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Questão 3: Escreva uma palavra para o algorítmo calcular quantos pares de anagramas nas substring existem");
        String palavra = scan.next();
        System.out.println("Resultado: " + anagramas(palavra) + " anagramas pares." );
        
    }
    
   public static int anagramas(String palavra){

        int p = palavra.length(); 
        int anag = 0; //Contador dos anagramas
        HashMap<String,Integer> mapa_letras= new HashMap<String,Integer>();
        for(int i = 1;i<p;i++){//Começa a partir de 1 e vai pecorrendo a string
            for(int j= 0;i+j<p+1; j++){
                String sub = palavra.substring(j,i+j);
                //Ordena antes de colocar no mapa, ex(a,b,c)
                char[] char_array = sub.toCharArray();
                Arrays.sort(char_array);
                String ordenado = new String(char_array);
                Integer num = mapa_letras.get(ordenado);
                if(num == null )//Verifica se já existe a sequencia
                    mapa_letras.put(ordenado,1);//Caso seja nula, inicia
                else{
                    num++;//Como já foi instanciando, agora incrementa
                    mapa_letras.put(ordenado,num);
                    //Incrementa o anag com n*(n-1)/2 então remove o valor anterior
                    anag -= ((num-1)*(num-2))/2;
                    //System.out.println("Achou " + ans);
                    anag += (num*(num-1))/2;
                    //System.out.println("de novo " + ans);
                }

            }
        }
        return anag;
    }
}
