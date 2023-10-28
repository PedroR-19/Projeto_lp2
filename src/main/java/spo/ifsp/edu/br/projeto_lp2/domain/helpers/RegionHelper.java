package spo.ifsp.edu.br.projeto_lp2.domain.helpers;

import spo.ifsp.edu.br.projeto_lp2.domain.enums.Region;

import java.util.ArrayList;
import java.util.List;

public class RegionHelper {
    public static List<Region> getRegionsByString(String regions) {
        List<Region> regionsList = new ArrayList<>();
        if (regions != null) {
            String[] regionsArray = regions.split(",");
            for (String region : regionsArray) {
                regionsList.add(Region.valueOf(region.toUpperCase()));
            }
        }
        return regionsList;
    }
}
