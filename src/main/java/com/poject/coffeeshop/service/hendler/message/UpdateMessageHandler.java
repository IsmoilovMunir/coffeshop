package com.poject.coffeeshop.service.hendler.message;

import com.poject.coffeeshop.entity.Client;
import com.poject.coffeeshop.service.enums.MessageType;
import com.poject.coffeeshop.service.enums.RegistrationState;
import com.poject.coffeeshop.service.hendler.registration.ClientRegistrationHandler;
import com.poject.coffeeshop.service.ClientService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateMessageHandler {

    private final ClientService clientService;
    private final ClientRegistrationHandler clientRegistrationHandler;
    private final Map<MessageType, MessageHandler> messageHandlers = new HashMap<>();

    public UpdateMessageHandler(ClientService clientService,
                                StartMessageHandler startMessageHandler,
                                MyBonusCardMessageHandler myBonusCardMessageHandler,
                                ClientRegistrationHandler clientRegistrationHandler,
                                UnknownMessageHandler unknownMessageHandler) {
        this.clientService = clientService;
        this.clientRegistrationHandler = clientRegistrationHandler;
        messageHandlers.put(MessageType.START, startMessageHandler);
        messageHandlers.put(MessageType.MY_BONUS_CARD, myBonusCardMessageHandler);
        messageHandlers.put(MessageType.UNKNOWN, unknownMessageHandler);
    }

    public SendMessage handle(Update update) {
        Long chatId = update.getMessage().getChatId();
        Client client = clientService.getByChatId(chatId);
        String messageText = update.getMessage().getText();
        if (isClientRegistered(client)) {
            MessageType messageType = MessageType.fromMessageText(messageText);
            MessageHandler messageHandler = messageHandlers.get(messageType);
            return messageHandler.handle(chatId);
        } else {
            return clientRegistrationHandler.register(messageText, chatId, client);
        }
    }

    private boolean isClientRegistered(Client client) {
        return client.getRegistrationState().equals(RegistrationState.REGISTERED.name());
    }
}