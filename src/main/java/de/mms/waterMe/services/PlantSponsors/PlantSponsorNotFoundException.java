package de.mms.waterMe.services.PlantSponsors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlantSponsorNotFoundException extends RuntimeException {
    public PlantSponsorNotFoundException(Long id) {
        super("Could not find plant sponsor: " + id);
    }
}

