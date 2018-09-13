package ar.com.eayzenberg.controller;

import ar.com.eayzenberg.httpModel.Dna;
import ar.com.eayzenberg.httpModel.Message;
import ar.com.eayzenberg.module.DNAModule;
import ar.com.eayzenberg.pattern.Detector;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.ForbiddenException;

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
public class MutantController {

    @ApiMethod(path="mutant", httpMethod = ApiMethod.HttpMethod.POST)
    public Message postDna(Dna dna) throws Exception {

        boolean isMutant = new Detector().isMutant(dna.getDna());
        new DNAModule().saveDna(dna.getDna(), isMutant);

        if (!isMutant) {
            throw new ForbiddenException("Human!");
        }

        return new Message("OK");
    }
}

