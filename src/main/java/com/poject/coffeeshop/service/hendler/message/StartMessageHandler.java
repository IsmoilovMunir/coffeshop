package com.poject.coffeeshop.service.hendler.message;

import com.poject.coffeeshop.service.utils.KeyboardUtils;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
@Service
public class StartMessageHandler implements MessageHandler{

    private static final String START_MESSAGE = """
            Добро пожаловать в кофейню! Это твоя бонусная карта.
            Если хочешь узнать сколько у тебя баллов, просто нажми на неё:
            """;
    @Override
    public SendMessage handle(Long chatId) {
        return SendMessage
                .builder()
                .chatId(chatId)
                .text(START_MESSAGE)
                .replyMarkup(KeyboardUtils.buildKeyboard())
                .build();
    }
}
