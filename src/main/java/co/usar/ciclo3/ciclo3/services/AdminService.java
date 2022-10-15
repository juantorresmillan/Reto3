package co.usar.ciclo3.ciclo3.services;

import co.usar.ciclo3.ciclo3.model.Admin;
import co.usar.ciclo3.ciclo3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminService (){
    }

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin adm){
        Integer id = adm.getId();
        if(id==null){
            return adminRepository.save(adm);
        } else {
            Optional<Admin> admaux = adminRepository.getAdmin(adm.getId());
            if (admaux.isEmpty()){
                return adminRepository.save(adm);
            } else {
                return adm;
            }
        }
    }

    public Admin update(Admin adm) {
        Integer id = adm.getId();
        if (id != null) {
            Optional<Admin> admaux = adminRepository.getAdmin(adm.getId());
            if (!admaux.isEmpty()) {
                if (adm.getName() != null) {
                    admaux.get().setName(adm.getName());
                }
                if (adm.getEmail() != null) {
                    admaux.get().setEmail(adm.getEmail());
                }
                if (adm.getPassword() != null) {
                    admaux.get().setPassword(adm.getPassword());
                }
                return adminRepository.save(admaux.get());
            }
            return adm;
        }
        return adm;
    }

    public boolean delete(int id){
        boolean adm = getAdmin(id).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return adm;
    }
}
