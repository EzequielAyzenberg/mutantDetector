package ar.com.eayzenberg.module;

import ar.com.eayzenberg.httpModel.MutantsStats;
import ar.com.eayzenberg.persistenceModel.DnaRecord;
import ar.com.eayzenberg.service.DataStoreService;

import java.util.List;

public class DNAModule {

    public void saveDna(String[] dnaLines, Boolean isMutant) {
        String collapsedDNA = String.join("#", dnaLines);
        DnaRecord dnaRecord = new DnaRecord();
        dnaRecord.setId(collapsedDNA);
        dnaRecord.setIsMutant(isMutant);

        // First try to retrieve the entity. If fails, record
        DnaRecord persisted = DataStoreService.getOfy()
                .load()
                .type(DnaRecord.class)
                .id(collapsedDNA)
                .now();

        if (persisted == null) {
            DataStoreService.getOfy()
                    .save()
                    .entities(dnaRecord)
                    .now();
        }
    }

    public MutantsStats retrieveStats() {
        List<DnaRecord> results = DataStoreService.getOfy()
                .load()
                .type(DnaRecord.class)
                .list();

        int mutants = 0;
        int humans = 0;

        for(DnaRecord entity : results) {
            if (entity.getIsMutant()) {
                mutants++;
            } else {
                humans++;
            }
        }

        return new MutantsStats(mutants, humans);
    }
}
