package ar.com.eayzenberg.controller;

import ar.com.eayzenberg.httpModel.MutantsStats;
import ar.com.eayzenberg.module.DNAModule;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(
        name = "mutantDetector",
        version = "v1",
        namespace =
        @ApiNamespace(
                ownerDomain = "ar.com.eayzenberg",
                ownerName = "ar.com.eayzenberg",
                packagePath = ""
        )
)
public class StatsController {

    @ApiMethod(path = "stats")
    public MutantsStats getStats() {
        return new DNAModule().retrieveStats();
    }

}
