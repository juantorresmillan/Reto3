package co.usar.ciclo3.ciclo3.services;

import co.usar.ciclo3.ciclo3.model.Gymmachine;
import co.usar.ciclo3.ciclo3.model.Message;
import co.usar.ciclo3.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message mes){
        Integer id = mes.getIdMessage();
        if(id==null){
            return messageRepository.save(mes);
        } else {
            Optional<Message> mesaux=messageRepository.getMessage(mes.getIdMessage());
            if (mesaux.isEmpty()){
                return messageRepository.save(mes);
            } else {
                return mes;
            }
        }
    }

    public Message update(Message mes){
        Integer id = mes.getIdMessage();
        if(id != null){
            Optional<Message> mesaux = messageRepository.getMessage(mes.getIdMessage());
            if(!mesaux.isEmpty()){
                if(mes.getMessageText() != null){
                    mesaux.get().setMessageText(mes.getMessageText());
                }
                messageRepository.save(mesaux.get());
                return  mesaux.get();
            } else {
                return mes;
            }
        } else {
            return mes;
        }
    }

    public boolean delete(int idClient){
        boolean mes = getMessage(idClient).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return mes;
    }
}
