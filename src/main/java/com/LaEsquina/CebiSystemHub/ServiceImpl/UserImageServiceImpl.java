package com.LaEsquina.CebiSystemHub.ServiceImpl;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaEsquina.CebiSystemHub.Model.UserImage;
import com.LaEsquina.CebiSystemHub.Repository.UserImageRepository;
import com.LaEsquina.CebiSystemHub.Service.UserImageService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserImageServiceImpl implements UserImageService {

    @Autowired
    private UserImageRepository userImageRepository;

    @Override
    public UserImage saveUserImage(UserImage userImage) {
        return userImageRepository.save(userImage);
    }

	@Override
	public UserImage getUserImageByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
    

}