package com.hbcmis.mapper;

import com.hbcmis.entity.repository.AdminDo;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    AdminDo selectId(int id);
}
