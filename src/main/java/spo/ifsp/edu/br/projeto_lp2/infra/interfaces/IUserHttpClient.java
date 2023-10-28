package spo.ifsp.edu.br.projeto_lp2.infra.interfaces;

import spo.ifsp.edu.br.projeto_lp2.domain.User;

import java.util.List;

public interface IUserHttpClient {
    List<User> getUsers() throws Exception;
}
