package spo.ifsp.edu.br.projeto_lp2.service.interfaces;

import spo.ifsp.edu.br.projeto_lp2.domain.Location;
import spo.ifsp.edu.br.projeto_lp2.domain.enums.Region;

public interface IRegionService {
    Region getRegionByLocation(Location location);
}
