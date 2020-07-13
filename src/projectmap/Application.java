/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmap;

import entities.Candidato;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;


public class Application {

    
    public static void main(String[] args) {
        Scanner read = new Scanner (System.in);
        Locale.setDefault(Locale.US);
        Map <String, Integer> candidato = new LinkedHashMap<>();
        
        
        System.out.print("Digite o caminho do arquivo: ");
        String path = read.nextLine();
       // File newparh = new File("C:\\arquivos\\votesResult.csv");
        
        try(BufferedReader br = new BufferedReader( new FileReader(path))){
       
        String line= br.readLine();
        while(line != null){
                String[] camp = line.split(",");

                String name = camp[0];        
                int count = Integer.parseInt(camp[1]);
                
                 if(candidato.containsKey(name)){
                 int votos = candidato.get(name);
                 candidato.put(name,count+votos);
                 
                 }
                 else{
                 candidato.put(name, count);
                 }

                line=br.readLine();

        }
        for(String obj : candidato.keySet()){
            System.out.println(obj +":"+ candidato.get(obj));
        
        }
        
        
        }catch(IOException erro){
            System.out.println("erro: "+erro.getMessage());
        
        }
    }
    
}
