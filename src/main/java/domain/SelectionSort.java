package domain;

import enums.FieldsEnum;
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
                rebeldesLinkedList = selectionSortByNome(rebeldeList);
                break;
            case "Idade":
                rebeldesLinkedList = selectionSortByIdade(rebeldeList);
                break;
            case "Raca":
                rebeldesLinkedList = selectionSortByRaca(rebeldeList);
                break;
            default:
                System.out.println("Opção invalida!");
        }
        return rebeldesLinkedList;
    }

    private static ArrayList<Rebelde> selectionSortByNome(List<Rebelde> rebeldeList) {
        Rebelde[] rebeldes = rebeldeList.toArray(Rebelde[]::new);

        for (int i = 0; i < rebeldes.length; i++){
            int indiceMenor = i;
            for (int j = i + 1; j < rebeldes.length; j++){
                int indiceSeguinte = j;
                if (compareByNome(rebeldes[indiceSeguinte],rebeldes[indiceMenor])){
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

    private static ArrayList<Rebelde> selectionSortByIdade(List<Rebelde> rebeldeList) {
        Rebelde[] rebeldes = rebeldeList.toArray(Rebelde[]::new);

        for (int i = 0; i < rebeldes.length; i++){
            int indiceMenor = i;
            for (int j = i + 1; j < rebeldes.length; j++){
                int indiceSeguinte = j;
                if (compareByIdade(rebeldes[indiceSeguinte],rebeldes[indiceMenor])){
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

    private static ArrayList<Rebelde> selectionSortByRaca(List<Rebelde> rebeldeList) {
        Rebelde[] rebeldes = rebeldeList.toArray(Rebelde[]::new);

        for (int i = 0; i < rebeldes.length; i++){
            int indiceMenor = i;
            for (int j = i + 1; j < rebeldes.length; j++){
                int indiceSeguinte = j;
                if (compareByRaca(rebeldes[indiceSeguinte],rebeldes[indiceMenor])){
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

    private static boolean compareByNome(Rebelde rebelde, Rebelde otherRebelde){
        return rebelde.getNome().compareToIgnoreCase(otherRebelde.getNome()) < 0;
    }

    private static boolean compareByIdade(Rebelde rebelde, Rebelde otherRebelde){
        Integer idadeInteger = Integer.valueOf(rebelde.getIdade());
        Integer otherIdadeInteger = Integer.valueOf(otherRebelde.getIdade());
        return idadeInteger.compareTo(otherIdadeInteger) < 0;
    }

    private static boolean compareByRaca(Rebelde rebelde, Rebelde otherRebelde){
        return rebelde.getRaca().getDescricao().compareToIgnoreCase(rebelde.getRaca().getDescricao()) < 0;
    }

}

