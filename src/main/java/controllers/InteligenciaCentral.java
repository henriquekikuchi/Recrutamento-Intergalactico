package controllers;

import domain.Rebelde;
import domain.SelectionSort;
import enums.FieldsEnum;
import interfaces.Ordenacao;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.*;
import java.util.stream.Collectors;

public class InteligenciaCentral {

    @Getter
    @Setter
    private List<Rebelde> rebeldesAprovados = new LinkedList<Rebelde>();

    public void add(Rebelde rebelde){
        if (testeDeAptidao(rebelde))  {
            this.rebeldesAprovados.add(rebelde);
        }
    }

    public void addAll(Rebelde[] rebeldes) {
        List<Rebelde> aprovados = Arrays.asList(rebeldes)
                .stream()
                .filter(this::testeDeAptidao)
                .collect(Collectors.toList());
        this.rebeldesAprovados.addAll(aprovados);
    }

    public void imprimirAprovados(){
        @Cleanup PrintWriter writer = null;
        try {
            writer = new PrintWriter("aprovados.txt", "UTF-8");
            PrintWriter finalWriter = writer;
            this.getRebeldesAprovados().stream().forEach(x -> {
                finalWriter.println(x.toString());
            });
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void ordenarRebeldesAprovados(Ordenacao ordenacao, FieldsEnum fieldsEnum){
        List<Rebelde> rebeldeListOrdenada = ordenacao.sortBy(this.getRebeldesAprovados(), fieldsEnum);
        this.setRebeldesAprovados(rebeldeListOrdenada);
    }

    private boolean testeDeAptidao(Rebelde rebelde){
        String[] possiveisRespostas = {"Apto","Inapto"};
        int resultado = new Random().nextInt(1);
        if (possiveisRespostas[resultado] == "Apto") {
            System.out.println("Parabens você foi aprovado!");
            return true;
        } else {
            System.out.println("Infelizmente você foi reprovado!");
            return false;
        }
    }
}
