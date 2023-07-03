package com.infy.InStepPlatform.exception;

public class UserRegistrationFailed extends Exception{

    UserRegistrationFailed(){
        super();
    }
    public UserRegistrationFailed(String message){
        super(message);
    }
}

