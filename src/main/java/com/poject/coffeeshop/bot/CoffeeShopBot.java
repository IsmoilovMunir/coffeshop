package com.poject.coffeeshop.bot;

import com.poject.coffeeshop.service.hendler.callback.CallbackHandler;
import com.poject.coffeeshop.service.hendler.message.UpdateMessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class CoffeeShopBot  implements LongPollingSingleThreadUpdateConsumer {

    private final UpdateMessageHandler updateMessageHandler;
    private final CallbackHandler callbackHandler;
    private final MessageSender messageSender;

    public CoffeeShopBot(UpdateMessageHandler updateMessageHandler,
                         CallbackHandler callbackHandler,
                         MessageSender messageSender) {
        this.updateMessageHandler = updateMessageHandler;
        this.callbackHandler = callbackHandler;
        this.messageSender = messageSender;
    }

    @Override
    public void consume(Update update) {
        SendMessage message = null;
        if (update.hasMessage() && update.getMessage().hasText()) {
            message = updateMessageHandler.handle(update);
        } else if (update.hasCallbackQuery()) {
            message = callbackHandler.handle(update);
        }

        if (message != null) {
            messageSender.sendMessage(message);
        }
    }
}
