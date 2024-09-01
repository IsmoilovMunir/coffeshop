package com.poject.coffeeshop.hendler.registration;

import com.poject.coffeeshop.entity.Client;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface RegistrationHandler {
    SendMessage handle(String message, Long chatId, Client client);
}
