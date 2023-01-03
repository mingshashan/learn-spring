package com.mingshashan.learn.learnmybatis.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mingshashan.learn.learnmybatis.domain.Address;
import com.mingshashan.learn.learnmybatis.domain.Customer;
import com.mingshashan.learn.learnmybatis.mapper.AddressMapper;
import com.mingshashan.learn.learnmybatis.mapper.CustomerMapper;
import com.mingshashan.learn.learnmybatis.util.DaoUtils;

import java.util.List;

public class CustomerService {

    public String register(String name, String phone) {
        // 检查传入的name参数以及phone参数是否合法
        Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "name is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(phone), "phone is empty");
        // 我们还可以完成其他业务逻辑，例如检查用户名是否重复、手机号是否重复等，这里不再展示
        return DaoUtils.execute(sqlSession -> {
            // 创建Customer对象，并通过CustomerMapper.save()方法完成持久化
            CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = new Customer();
            customer.setName(name);
            customer.setPhone(phone);
            int affected = mapper.save(customer);
            if (affected <= 0) {
                throw new RuntimeException("Save Customer fail...");
            }
            return customer.getId();
        });
    }

    // 用户添加一个新的送货地址
    public String addAddress(String customerId, String street, String city, String country) {
        // 检查传入参数是否合法
        Preconditions.checkArgument(!Strings.isNullOrEmpty(customerId), "customerId is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(street), "street is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(city), "city is empty");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(country), "country is empty");
        // 我们还可以完成其他业务逻辑，例如检查该地址是否超出了送货范围等，这里不再展示
        return DaoUtils.execute(sqlSession -> {
            // 创建Address对象并调用AddressMapper.save()方法完成持久化
            AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
            Address address = new Address();
            address.setStreet(street);
            address.setCity(city);
            address.setCountry(city);
            int affected = mapper.save(address, customerId);
            if (affected <= 0) {
                throw new RuntimeException("Save Customer fail...");
            }
            return address.getId();
        });
    }

    public List<Address> findAllAddress(String customerId) {
        // 检查用户id参数是否合法
        Preconditions.checkArgument(!Strings.isNullOrEmpty(customerId), "customerId is empty");
        return DaoUtils.execute(sqlSession -> {
            // 执行AddressMapper.find()方法完成查询
            AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
            return mapper.findAll(customerId);
        });
    }

    public Customer find(String id) {
        // 检查用户id参数是否合法
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id), "id is empty");
        return DaoUtils.execute(sqlSession -> {
            // 执行CustomerMapper.find()方法完成查询
            CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
            return mapper.find(id);
        });
    }

    public Customer findWithAddress(String id) {
        // 检查用户id参数是否合法
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id), "id is empty");
        return DaoUtils.execute(sqlSession -> {
            // 执行CustomerMapper.findWithAddress()方法完成查询
            CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
            return mapper.findWithAddress(id);
        });
    }
}