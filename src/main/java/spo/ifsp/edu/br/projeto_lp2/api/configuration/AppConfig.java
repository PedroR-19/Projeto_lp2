package spo.ifsp.edu.br.projeto_lp2.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spo.ifsp.edu.br.projeto_lp2.service.RegionService;
import spo.ifsp.edu.br.projeto_lp2.service.UserService;
import spo.ifsp.edu.br.projeto_lp2.service.UserTypeService;
import spo.ifsp.edu.br.projeto_lp2.service.interfaces.IRegionService;
import spo.ifsp.edu.br.projeto_lp2.service.interfaces.IUserService;
import spo.ifsp.edu.br.projeto_lp2.service.interfaces.IUserTypeService;

@Configuration
public class AppConfig {
    @Bean
    public IUserService userService() {
        return new UserService();
    }

    @Bean
    public IUserTypeService userTypeService() {
        return new UserTypeService();
    }

    @Bean
    public IRegionService regionService() {
        return new RegionService();
    }
}
