package com.poject.coffeeshop.hendler.registration;

import com.poject.coffeeshop.entity.Client;
import com.poject.coffeeshop.enums.RegistrationState;
import com.poject.coffeeshop.service.ClientService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class InitRegistrationHandler implements RegistrationHandler {

    private static final String TEXT = "Давайте познакомимся, я COFFLIB, а вас как зовут?";
    private final ClientService clientService;

    public InitRegistrationHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public SendMessage handle(String message, Long chatId, Client client) {
        client.setChatId(chatId);
        client.setRegistrationState(RegistrationState.ASK_NAME.name());
        clientService.create(client);
        return SendMessage
                .builder()
                .chatId(chatId)
                .text(TEXT)
                .build();
    }
}
