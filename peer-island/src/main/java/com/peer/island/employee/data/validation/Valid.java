package com.peer.island.employee.data.validation;

import java.util.Optional;

public final class Valid implements ValidationResult {

    private final String reason;
    
    Valid(String reason){
        this.reason = reason;
    }

    public boolean isValid(){
        return true;
    }

    public Optional<String> getReason(){
        return Optional.of(reason);
    }

    // equals and hashCode on field reason
}
