package com.example.demo.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.system.User;
import com.example.demo.mapper.system.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	/**
	 * 缓存的key
	 */
	public static final String THING_ALL_KEY   = "\"thing_all\"";
	/**
	 * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
	 */
	public static final String DEMO_CACHE_NAME = "demo";
	
	@Autowired
	private UserMapper userDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return userDao.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userDao.insertSelective(record);
	}
	@Cacheable(value = DEMO_CACHE_NAME)
	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		System.err.println ("没有走缓存！" + id);
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userDao.updateByPrimaryKey(record);
	}

	@Override
	public Object getList() {
		// TODO Auto-generated method stub
		return userDao.getList();
	}

}
