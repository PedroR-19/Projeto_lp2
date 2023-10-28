package spo.ifsp.edu.br.projeto_lp2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import spo.ifsp.edu.br.projeto_lp2.api.exceptions.UserNotFoundException;
import spo.ifsp.edu.br.projeto_lp2.domain.User;
import spo.ifsp.edu.br.projeto_lp2.domain.enums.Region;
import spo.ifsp.edu.br.projeto_lp2.domain.enums.UserType;
import spo.ifsp.edu.br.projeto_lp2.domain.pagination.UserPage;
import spo.ifsp.edu.br.projeto_lp2.infra.CsvUserHttpClient;
import spo.ifsp.edu.br.projeto_lp2.infra.JsonUserHttpClient;
import spo.ifsp.edu.br.projeto_lp2.infra.interfaces.repositories.IUserRepository;
import spo.ifsp.edu.br.projeto_lp2.service.interfaces.IRegionService;
import spo.ifsp.edu.br.projeto_lp2.service.interfaces.IUserService;
import spo.ifsp.edu.br.projeto_lp2.service.interfaces.IUserTypeService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    @Autowired
    private IUserRepository _userRepository;

    @Autowired
    private IRegionService _regionService;

    @Autowired
    private IUserTypeService _userTypeService;

    @Override
    public void insertInitialUsers() {
        var jsonHttpClient = new JsonUserHttpClient();
        var csvHttpClient = new CsvUserHttpClient();

        try {
            var usersFromJson = jsonHttpClient.getUsers();
            var usersFromCsv = csvHttpClient.getUsers();

            List<User> users = new ArrayList<User>();
            users.addAll(usersFromJson);
            users.addAll(usersFromCsv);

            for (User user : users) {
                var region = _regionService.getRegionByLocation(user.getLocation());
                var userType = _userTypeService.getUserTypeByCoordinates(user.getLocation().getCoordinates());

                user.getLocation().setRegion(region);
                user.setType(userType);
            }

            _userRepository.saveAll(users);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        return _userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        var user = _userRepository
                .findById(id)
                .orElse(null);

        if (user == null) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }

        return user;
    }

    @Override
    public UserPage<User> getUsers(Pageable pageable) {
        var page = _userRepository.findAll(pageable);
        return UserPage.of(page);
    }

    @Override
    public UserPage<User> getUsersFromTypes(Pageable pageable, List<UserType> types) {
        var page = _userRepository.findAllByTypeIn(pageable, types);
        return UserPage.of(page);
    }

    @Override
    public UserPage<User> getUsersFromRegions(Pageable pageable, List<Region> regions) {
        var page = _userRepository.findAllByLocationRegionIn(pageable, regions);
        return UserPage.of(page);
    }

    @Override
    public UserPage<User> getUsersFromTypesAndRegions(Pageable pageable, List<UserType> types, List<Region> regions) {
        var page = _userRepository.findAllByTypeInAndLocationRegionIn(pageable, types, regions);
        return UserPage.of(page);
    }
}
