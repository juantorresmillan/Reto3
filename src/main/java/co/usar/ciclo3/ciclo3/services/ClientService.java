package co.usar.ciclo3.ciclo3.services;

import co.usar.ciclo3.ciclo3.model.Client;
import co.usar.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client cli){
        Integer id = cli.getId();
        if(id==null){
            return clientRepository.save(cli);
        } else {
            Optional<Client> cliaux=clientRepository.getClient(cli.getId());
            if (cliaux.isEmpty()){
                return clientRepository.save(cli);
            } else {
                return cli;
            }
        }
    }

}
