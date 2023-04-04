package ma.enset.springgestioncomptebancaire.entity.projection;

import ma.enset.springgestioncomptebancaire.entity.Compte;
import org.hibernate.engine.transaction.spi.IsolationDelegate;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "projection2" ,types = Compte.class)
public interface CompteProjection2 {
        public Long getId();

}
