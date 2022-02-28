package com.systemorderservice.domain.model.enums;

public enum Message {

    NO_FOUND_MSG("Order não encontrada na base de dados"),
    ERROR_SERVER("Houve um erro no servidor tente novamente mais tarde"),
    CREATED("Order criada com sucesso!"),
    SENDING_MSG("Menssagem envia para ActveMQ com sucesso"),
    ACEPTED_DELETE("Mensagem deletada com sucesso!");

    private final String value;

    private Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
