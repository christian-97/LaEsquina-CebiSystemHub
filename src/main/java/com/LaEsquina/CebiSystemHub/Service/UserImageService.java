package com.LaEsquina.CebiSystemHub.Service;

import org.springframework.stereotype.Service;
import com.LaEsquina.CebiSystemHub.Model.UserImage;
import jakarta.transaction.Transactional;

@Service
@Transactional
public interface UserImageService {

	UserImage saveUserImage(UserImage userImage);

	UserImage getUserImageByUserId(Long userId);
}
