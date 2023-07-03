package com.infy.InStepPlatform.service;


import com.infy.InStepPlatform.dto.LoginDTO;
import com.infy.InStepPlatform.dto.UserDTO;
import com.infy.InStepPlatform.entity.User;
import com.infy.InStepPlatform.entity.UserEdQual;
import com.infy.InStepPlatform.exception.DuplicateDataException;
import com.infy.InStepPlatform.exception.NotFoundException;
import com.infy.InStepPlatform.exception.UserRegistrationFailed;
import com.infy.InStepPlatform.repository.UserEdQualRepository;
import com.infy.InStepPlatform.repository.UserRepository;
import com.infy.InStepPlatform.util.InStepConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserEdQualRepository userEdQualRepo;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public String registerUser(UserDTO userDTO) throws UserRegistrationFailed, DuplicateDataException {
        if(userRepo.existsByEmail(userDTO.getEmail()))
            throw new DuplicateDataException(InStepConstants.USER_ALREADY_PRESENT.toString());
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setActive(true);
        List<UserEdQual> userEdQualList = new ArrayList<>();
        userDTO.getUserEdQuals().forEach(ed-> {
                UserEdQual userEdQual = modelMapper.map(ed, UserEdQual.class);
                userEdQual.setUser(user);
                System.out.println(userEdQual.getUser().getPhoneNumber());
                userEdQualList.add(userEdQual);
        });
        if(userRepo.save(user)!=null && userEdQualRepo.saveAll(userEdQualList) != null) {
            return InStepConstants.USER_REGISTRATION_SUCCESSFUL.toString();
        }
        throw new UserRegistrationFailed(InStepConstants.USER_REGISTRATION_FAILED.toString());
    }

    public String login(LoginDTO loginDTO) throws NotFoundException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return InStepConstants.USER_LOGIN_SUCCESS.toString();
    }
}
