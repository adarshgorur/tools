package com.peer.island.employee.data.validation;

import java.util.Optional;

public final class Invalid implements ValidationResult {

    private final String reason;

    Invalid(String reason){
        this.reason = reason;
    }

    public boolean isValid(){
        return false;
    }

    public Optional<String> getReason(){
        return Optional.of(reason);
    }

    // equals and hashCode on field reason
}
