package co.usar.ciclo3.ciclo3.services;

import co.usar.ciclo3.ciclo3.model.Admin;
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
        Integer id = cli.getIdClient();
        if(id==null){
            return clientRepository.save(cli);
        } else {
            Optional<Client> cliaux=clientRepository.getClient(cli.getIdClient());
            if (cliaux.isEmpty()){
                return clientRepository.save(cli);
            } else {
                return cli;
            }
        }
    }

    public Client update(Client cli) {
        Integer id = cli.getIdClient();
        if (id != null) {
            Optional<Client> cliaux = clientRepository.getClient(cli.getIdClient());
            if (!cliaux.isEmpty()) {
                if (cli.getEmail() != null) {
                    cliaux.get().setEmail(cli.getEmail());
                }
                if (cli.getPassword() != null) {
                    cliaux.get().setPassword(cli.getPassword());
                }
                if (cli.getName() != null) {
                    cliaux.get().setName(cli.getName());
                }
                Integer age = cli.getAge();
                if (age != null) {
                    cliaux.get().setAge(cli.getAge());
                }
                clientRepository.save(cliaux.get());
                return cliaux.get();
            } else {
                return cli;
            }

        } else {
            return cli;
        }
    }

    public boolean delete(int idClient){
        boolean cli = getClient(idClient).map(category -> {
            clientRepository.delete(category);
            return true;
        }).orElse(false);
        return cli;
    }

}
