package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.UserDto;
import com.dao.PaginationRepository;
import com.dao.SignupDaoRepository;
import com.dao.UserEntity;
import com.utils.NullPropertyUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private SignupDaoRepository signupDao;
	
	@Autowired
	private PaginationRepository paginationRepository;
	
	public UserDto authUser(String username, String password) {
		Optional<UserEntity> userEntity = signupDao.findByUsernameAndPassword(username, password);
		UserDto userDto = null;
		if(userEntity != null) {
			userDto=new UserDto();
 			BeanUtils.copyProperties(userEntity.get(), userDto);
		}
		return userDto;
	}

	public void signup(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto,userEntity);
		signupDao.save(userEntity);

	}

	public List<UserDto> displayAll() {
		List<UserDto> userListDto = new ArrayList<UserDto>();
		List<UserEntity> userListDao = signupDao.findAll();
		for(UserEntity entity:userListDao) {
 			UserDto userDto= new UserDto();
 			BeanUtils.copyProperties(entity, userDto);
 			userListDto.add(userDto);
 		}
		
		return userListDto;
	}

	public void deleteById(int sid) {
		signupDao.deleteById(sid);
	}

	public UserDto selectById(int sid) {
		Optional<UserEntity> userEntity = signupDao.findById(sid);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userEntity.get(),userDto);
		return userDto;
	}

	public void updateUser(UserDto userDto) {
		UserDto dUserDto = selectById(userDto.getuID());
		NullPropertyUtils.copyNonNullProperties(userDto, dUserDto);
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(dUserDto,userEntity);
		signupDao.save(userEntity);	

	}

	public List<UserDto> getSignups(int pageid,int total) {
		//List<UserEntity> userListDao = signupDao.getSignups(pageid, total);
		//List<UserEntity> userListDao = signupDao.findAll();
		Pageable paging = PageRequest.of(pageid, total, Sort.by("uID"));
		Page<UserEntity> pageedResult = paginationRepository.findAll(paging);
		List<UserEntity> userListDao = pageedResult.getContent();
		List<UserDto> userListDto = new ArrayList<UserDto>();
		for(UserEntity entity:userListDao) {
 			UserDto userDto= new UserDto();
 			BeanUtils.copyProperties(entity, userDto);
 			userListDto.add(userDto);
 		}
		return userListDto;
	}

	public int findTotalSignup() {
		int count = (int)signupDao.count();
		return count;
	}

	public List<UserDto> searchUser(String name) {
		List<UserEntity> userListDao = signupDao.findByName(name);
		List<UserDto> userListDto = new ArrayList<UserDto>();
		for(UserEntity entity:userListDao) {
 			UserDto userDto= new UserDto();
 			BeanUtils.copyProperties(entity, userDto);
 			userListDto.add(userDto);
 		}
		return userListDto;
	}

	public byte[] findImageById(int uid) {
		byte[]  photo = signupDao.findById(uid).get().getBphoto();
		return photo;
	}

}
