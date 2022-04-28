package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.mapper;

import by.it.academy.Mk_JD2_88_22.homework.hw1.model.Message;
import by.it.academy.Mk_JD2_88_22.homework.hw1.dao.hibernate.api.entity.MessageEntity;

public class MessageMapper {
    private static final MessageMapper instance = new MessageMapper();

    public static MessageMapper getInstance() {
        return instance;
    }

    public Message toDto(MessageEntity entity){
        return new Message(entity.getId(),entity.getTo(), entity.getFrom(), entity.getMessage(),entity.getSendingTime());
    }
    public MessageEntity toEntity(Message dto){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(dto.getMessage());
        messageEntity.setFrom(dto.getFrom());
        messageEntity.setTo(dto.getTo());
        messageEntity.setSendingTime(dto.getSendingTime());
        return messageEntity;
    }
}
