package ar.com.eayzenberg.service;

import ar.com.eayzenberg.persistenceModel.DnaRecord;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class DataStoreService {
    static {
        ObjectifyService.register(DnaRecord.class);
    }

    public static Objectify getOfy() {
        return ofy();
    }
}

