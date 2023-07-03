package com.infy.InStepPlatform.configs;

import com.infy.InStepPlatform.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = null;
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            email =  ((User) authentication.getPrincipal()).getEmail();
        }
        return Optional.ofNullable(email);
    }

}