package enums;

import lombok.Getter;

public enum RacasEnum {
    HUMANO("Humano"),
    GREE("Gree"),
    RAKATA("Rakata");

    @Getter
    private String descricao;

    RacasEnum(String descricao) {
        this.descricao = descricao;
    }
}
