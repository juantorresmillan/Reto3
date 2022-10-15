package co.usar.ciclo3.ciclo3.repository;

import co.usar.ciclo3.ciclo3.model.Client;
import co.usar.ciclo3.ciclo3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public ClientRepository(){
    }

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client cli){
        return clientCrudRepository.save(cli);
    }

    public void delete (Client cli){
        clientCrudRepository.delete(cli);
    }

}
