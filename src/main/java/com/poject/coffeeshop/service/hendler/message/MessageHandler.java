package com.poject.coffeeshop.service.hendler.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface MessageHandler {
    SendMessage handle(Long chatId);
}
