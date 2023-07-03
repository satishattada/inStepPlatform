package com.infy.InStepPlatform.service;

import com.infy.InStepPlatform.dto.LoginDTO;
import com.infy.InStepPlatform.dto.UserDTO;
import com.infy.InStepPlatform.exception.DuplicateDataException;
import com.infy.InStepPlatform.exception.NotFoundException;
import com.infy.InStepPlatform.exception.UserRegistrationFailed;

public interface UserService {

    String registerUser(UserDTO userDTO) throws UserRegistrationFailed, DuplicateDataException;

    public String login(LoginDTO loginDTO)throws NotFoundException;

}
