package de.mms.waterMe.services.Irrigations;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IrrigationNotFoundException extends RuntimeException {
    public IrrigationNotFoundException(Long id) {
        super("Could not find irrigation: " + id);
    }
}
