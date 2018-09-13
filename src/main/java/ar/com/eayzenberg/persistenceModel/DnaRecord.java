package ar.com.eayzenberg.persistenceModel;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class DnaRecord{
    private static final String KIND = "dnaRecord";
    private static final String PROP_IS_MUTANT = "isMutant";

    @Id
    private String id;
    private Boolean isMutant;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setIsMutant(Boolean isMutant) {
        this.isMutant = isMutant;
    }

    public Boolean getIsMutant() {
        return isMutant;
    }

}
