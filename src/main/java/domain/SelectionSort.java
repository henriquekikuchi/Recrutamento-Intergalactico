package domain;

import enums.FieldsEnum;
import implementacaoInterfaces.OrdenarPorIdade;
import implementacaoInterfaces.OrdenarPorNome;
import implementacaoInterfaces.OrdenarPorRaca;
import interfaces.Comparacao;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SelectionSort {

    public static ArrayList<Rebelde> selectionSortBy(List<Rebelde> rebeldeList, FieldsEnum fieldParaOrdenar) {
        ArrayList<Rebelde> rebeldesLinkedList = null;
        switch (fieldParaOrdenar.getDescricao()) {
            case "Nome":
                rebeldesLinkedList = selectionSort(rebeldeList, new OrdenarPorNome());
                break;
            case "Idade":
                rebeldesLinkedList = selectionSort(rebeldeList, new OrdenarPorIdade());
                break;
            case "Raca":
                rebeldesLinkedList = selectionSort(rebeldeList, new OrdenarPorRaca());
                break;
            default:
                System.out.println("Opção invalida!");
        }
        return rebeldesLinkedList;
    }

    private static ArrayList<Rebelde> selectionSort(List<Rebelde> rebeldeList, Comparacao comparar) {
        Rebelde[] rebeldes = rebeldeList.toArray(Rebelde[]::new);

        for (int i = 0; i < rebeldes.length; i++){
            int indiceMenor = i;
            for (int j = i + 1; j < rebeldes.length; j++){
                int indiceSeguinte = j;
                if (comparar.ehMenorQue(rebeldes[indiceSeguinte],rebeldes[indiceMenor])){
                    indiceMenor = j;
                }
            }
            Rebelde aux = rebeldes[i];
            rebeldes[i] = rebeldes[indiceMenor];
            rebeldes[indiceMenor] = aux;
        }

        Arrays.stream(rebeldes).forEach(x -> System.out.println(x.toString()));
        return (ArrayList<Rebelde>) Arrays.stream(rebeldes).collect(Collectors.toList());
    }

}

