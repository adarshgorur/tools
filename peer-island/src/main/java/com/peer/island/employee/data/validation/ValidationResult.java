package com.peer.island.employee.data.validation;

import java.util.Optional;

 public interface ValidationResult{
    static ValidationResult valid(){
        return new Valid("success");
    }
    
    static ValidationResult invalid(String reason){
        return new Invalid(reason);
    }
    
    boolean isValid();
    
    Optional<String> getReason();
}
