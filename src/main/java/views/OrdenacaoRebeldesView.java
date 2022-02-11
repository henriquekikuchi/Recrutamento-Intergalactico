package views;

import controllers.InteligenciaCentral;
import enums.FieldsEnum;

import java.util.Arrays;
import java.util.Scanner;

public class OrdenacaoRebeldesView {

    public static FieldsEnum iniciarOrdenacaoRebeldes(InteligenciaCentral ic){
        int fieldNumber;
        do {
            System.out.println("Por qual campo deseja ordenar?");
            Arrays.stream(FieldsEnum.values()).forEach(field -> System.out.printf("%d - %s%n", field.ordinal(), field.getDescricao()));
            Scanner scanner = new Scanner(System.in);
            fieldNumber = scanner.nextInt();
        } while (fieldNumber < 0 || fieldNumber > FieldsEnum.values().length);
        return FieldsEnum.values()[fieldNumber];
    }
}
