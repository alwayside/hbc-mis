package com.hbcmis.service;

import com.hbcmis.entity.repository.AdminDo;
import com.hbcmis.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
