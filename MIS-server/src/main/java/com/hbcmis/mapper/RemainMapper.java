package com.hbcmis.mapper;

import com.hbcmis.entity.repository.AdminDo;
import com.hbcmis.entity.repository.RemainDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hbc-asuna
 */
@Repository
public interface RemainMapper {
    /**
     * select record by store and type
     * @param remainStore
     * @param remainType
     * @return com.hbcmis.entity.repository.RemainDo
     */
    public List<RemainDo> selectByTypeAndStore(@Param("remainStore")int remainStore, @Param("remainType")int remainType);

    /**
     * add a new record
     * @param remainStore
     * @param remainType
     * @param remainNumber
     */
    public void addRecord(@Param("remainStore")int remainStore, @Param("remainType")int remainType,@Param("remainNumber")int remainNumber);

    /**
     * update Record number value
     * @param id
     * @param remainNumber
     */
    public void updateRecord(@Param("id")int id,@Param("remainNumber")int remainNumber);
}
