package vn.devpro.BTCK.service;

import org.springframework.stereotype.Service;

import vn.devpro.BTCK.model.User;

@Service
public class UserService extends BaseService<User>{
	
	@Override
	public Class<User> clazz() {
		// TODO Auto-generated method stub
		return User.class;
	}

}
