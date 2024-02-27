package com.LaEsquina.CebiSystemHub.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaEsquina.CebiSystemHub.Model.LoginRequest;
import com.LaEsquina.CebiSystemHub.Repository.LoginRequestRepository;
import com.LaEsquina.CebiSystemHub.Service.LoginRequestService;

@Service
public class LoginRequestServiceImpl implements LoginRequestService {

    @Autowired
    private LoginRequestRepository loginRequestRepository;

    @Override
    public LoginRequest findByUsername(String username) {
        return loginRequestRepository.findByUsername(username);
    }
}
