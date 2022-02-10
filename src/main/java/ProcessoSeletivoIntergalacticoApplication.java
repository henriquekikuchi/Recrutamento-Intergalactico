import controllers.InteligenciaCentral;
import domain.Rebelde;
import domain.SelectionSort;
import enums.FieldsEnum;
import enums.RacasEnum;
import views.RebeldeView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProcessoSeletivoIntergalacticoApplication {
    public static void main(String[] args) {

        String resposta="S";
        InteligenciaCentral ic = new InteligenciaCentral();
        do {
            Rebelde newRebelde = RebeldeView.getInstanciaRebelde();
            ic.add(newRebelde);
            System.out.println("Deseja adicionar mais rebeldes? [S/N] ");
            Scanner scanner = new Scanner(System.in);
            resposta = scanner.next();
            scanner.nextLine();
        } while (resposta.equalsIgnoreCase("S"));

        int fieldNumber = 0;
        do {
            System.out.println("Por qual campo deseja ordenar?");
            Arrays.stream(FieldsEnum.values()).forEach(field -> System.out.printf("%d - %s%n", field.ordinal(), field.getDescricao()));
            Scanner scanner = new Scanner(System.in);
            fieldNumber = scanner.nextInt();
        } while (fieldNumber < 0 || fieldNumber > FieldsEnum.values().length);
        FieldsEnum fieldsEnum = FieldsEnum.values()[fieldNumber];

        List<Rebelde> rebeldeListOrdenada = SelectionSort.selectionSortBy(ic.getRebeldesAprovados(), fieldsEnum);
        ic.setRebeldesAprovados(rebeldeListOrdenada);
        ic.imprimirAprovados();

    }
}
