package com.LaEsquina.CebiSystemHub.Service;

import com.LaEsquina.CebiSystemHub.Model.LoginRequest;

public interface LoginRequestService {
    LoginRequest findByUsername(String username);
}

