package com.poject.coffeeshop.service;

import com.poject.coffeeshop.entity.Client;
import com.poject.coffeeshop.entity.ClientBonusCard;
import com.poject.coffeeshop.service.enums.RegistrationState;
import com.poject.coffeeshop.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientBonusCardService clientBonusCardService;

    public ClientService(ClientRepository clientRepository, ClientBonusCardService clientBonusCardService) {
        this.clientRepository = clientRepository;
        this.clientBonusCardService = clientBonusCardService;
    }

    public Client getByChatId(Long chatId) {
        return clientRepository.findByChatId(chatId)
                .orElse(new Client(RegistrationState.INIT.name()));
    }

    @Transactional
    public void create(Client client) {
        Client savedClient = clientRepository.save(client);
        ClientBonusCard clientBonusCard = new ClientBonusCard();
        clientBonusCard.setClient(savedClient);
        clientBonusCardService.save(clientBonusCard);
    }

    public void update(Client client) {
        clientRepository.save(client);
    }
}
