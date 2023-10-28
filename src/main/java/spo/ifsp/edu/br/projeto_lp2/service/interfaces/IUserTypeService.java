package spo.ifsp.edu.br.projeto_lp2.service.interfaces;

import spo.ifsp.edu.br.projeto_lp2.domain.Coordinates;
import spo.ifsp.edu.br.projeto_lp2.domain.enums.UserType;

public interface IUserTypeService {
    UserType getUserTypeByCoordinates(Coordinates coordinates);
}
