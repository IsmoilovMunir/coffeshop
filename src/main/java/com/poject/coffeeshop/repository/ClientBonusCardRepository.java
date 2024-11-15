package com.poject.coffeeshop.repository;

import com.poject.coffeeshop.entity.ClientBonusCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientBonusCardRepository extends JpaRepository<ClientBonusCard, Long> {

    @Query(
            nativeQuery = true,
            value = """
                select bc.*
                from client_bonus_card bc
                join client c on bc.client_id = c.id
                where c.chat_id = :chatId
            """
    )
    Optional<ClientBonusCard> findByChatId(@Param("chatId") Long chatId);

    @Query(
            nativeQuery = true,
            value = """
                select bc.*
                from client_bonus_card bc
                join client c on bc.client_id = c.id
                where c.phone = :phone
            """
    )
    Optional<ClientBonusCard> findByPhone(@Param("phone") String phone);
}
