package com.hbcmis.service;

import com.hbcmis.entity.repository.AdminDo;
import com.hbcmis.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author hbc-asuna
 */
@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public AdminDo selectAdmin(int id) {
        return adminMapper.selectId(id);
    }

    public boolean userLogin(AdminDo adminDo) {
        AdminDo user = adminMapper.selectAccount(adminDo.getAccount());
        String password = adminDo.getPassWord();
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(password.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            password = encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return user.getPassWord().equals(password);
    }

    public void registerAdmin() {
        String account = "admin";
        String username = "admin";
        String password = "hbc123";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(password.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            password = encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if ("hbc123".equals(password)) {
            return;
        }
        adminMapper.adminRegister(account, username, password);
    }
}
