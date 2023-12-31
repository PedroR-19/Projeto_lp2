package spo.ifsp.edu.br.projeto_lp2.service.interfaces;

import org.springframework.data.domain.Pageable;
import spo.ifsp.edu.br.projeto_lp2.domain.User;
import spo.ifsp.edu.br.projeto_lp2.domain.enums.Region;
import spo.ifsp.edu.br.projeto_lp2.domain.enums.UserType;
import spo.ifsp.edu.br.projeto_lp2.domain.pagination.UserPage;

import java.util.List;

public interface IUserService {
    void insertInitialUsers();

    List<User> getUsers();

    UserPage<User> getUsers(Pageable pageable);

    UserPage<User> getUsersFromTypes(Pageable pageable, List<UserType> types);

    UserPage<User> getUsersFromRegions(Pageable pageable, List<Region> regions);

    UserPage<User> getUsersFromTypesAndRegions(Pageable pageable, List<UserType> types, List<Region> regions);

    User getUserById(Long id);
}
