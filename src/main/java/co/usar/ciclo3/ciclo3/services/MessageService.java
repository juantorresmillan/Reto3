package co.usar.ciclo3.ciclo3.services;

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
        Integer id = mes.getId();
        if(id==null){
            return messageRepository.save(mes);
        } else {
            Optional<Message> mesaux=messageRepository.getMessage(mes.getId());
            if (mesaux.isEmpty()){
                return messageRepository.save(mes);
            } else {
                return mes;
            }
        }
    }
}
