package com.poject.coffeeshop.service.hendler.message;

import com.poject.coffeeshop.entity.ClientBonusCard;
import com.poject.coffeeshop.service.ClientBonusCardService;
import com.poject.coffeeshop.service.utils.KeyboardUtils;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
@Service
public class MyBonusCardMessageHandler implements MessageHandler{
    private static final  String BONUS_AMOUNT_TEMPLATE_TEXT = "У вас %s баллов";
    private final ClientBonusCardService clientBonusCardService;

    public MyBonusCardMessageHandler(ClientBonusCardService clientBonusCardService) {
        this.clientBonusCardService = clientBonusCardService;
    }

    @Override
    public SendMessage handle(Long chatId) {
        ClientBonusCard bonusCard = clientBonusCardService.findByChatId(chatId);
        return SendMessage
                .builder()
                .chatId(chatId)
                .text(String.format(BONUS_AMOUNT_TEMPLATE_TEXT, bonusCard.getAmount()))
                .replyMarkup(KeyboardUtils.buildKeyboard())
                .build();
    }
}
