/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selecaocapgemini;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PedroAndre
 */
public class questao2 {
    public static void iniciar(){
        questao2();
    }
    private static void questao2(){
        Scanner scan = new Scanner(System.in); //Recebe dados do teclado
        System.out.println("Questão 2: Escreva uma senha de no mínimo 6 dígitos para passar na senha forte:");
        String senha = scan.next();
        if(senha.length() >= 6){//Confere se a senha tem ao menos 6 dígitos caso sim entra no if
            if(verificar(senha)){ /**Verifica se a senha atende aos requesitos de senha forte, verifique na função quais são estes
                requesitos.*/
            System.out.println("Você tem uma senha forte com " + senha.length() + " dígitos.");
            questao3 q3 = new questao3(); //Chama a questão 3 assim que imprimir o sucesso da senha;
            q3.inicar();
            }else{
                questao2(); //Caso não atenda aos requesitos de senha forte a função é chamada novamente.
            }
        }else{ // Caso não tenha ao menos 6 dígitos, retorna ao usuário quantos carácteres faltam para alcançar os 6 dígitos.
            int tamanho = 6 - senha.length();
            String d = "dígitos";
            String r = "restam";
            if(tamanho == 1){
                d = "dígito";
                r = "resta";
            }
            System.out.println("Senha deve conter no mínimo 6 dígitos, " + r + " "  +  tamanho + " " + d);
            questao2();
        }
    }
    /**
     * Função para verificar se a senha possui os cararcteres necessários para ser uma senha forte, este método é chamado assim que atende ao requesito
     * de ter no mínimo 6 caracteres
     * @param senha
     * @return 
     */
    public static boolean verificar(String senha){
        boolean verifica = false;
        String deveconter = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()+-])(?=\\S+$).*$"; //String com os requesitos de número, letra minúscula, 
        //maiúscula e número divididos entre parênteses e no final um pattern que não indica limite de carácteres.
        Pattern pattern = Pattern.compile(deveconter); //Colocando a string no pattern em si
        Matcher m = pattern.matcher(senha); //Verificando se a senha atende aos requisitos
        verifica = m.matches(); //Retorna um booleano de true para atende aos requesitos e false para não atende
        if(verifica == false){ //Caso retorne false mostra a mensagem para o usuários do que deve ser feito
            System.out.println("Sua senha é fraca, para atender aos requisitos verifique se: "
                    + "\n-Contém ao menos 1 letra minúscula."
                    + "\n-Contém ao menos 1 letra maiúscula."
                    + "\n-Contém ao menos 1 caráctere especial ex.(!@#$%^&*()-+).");
        }
        return verifica;
    }
}
