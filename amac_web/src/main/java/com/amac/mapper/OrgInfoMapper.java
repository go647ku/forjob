package com.amac.mapper;

import com.amac.pojo.OrgInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 机构信息表
 * @author qianP
 */
public interface OrgInfoMapper extends BaseMapper<OrgInfo> {

    /**
     * 持久层执行逻辑删除
     * @param ids
     */
    void logicDeleteByIds(@Param("ids")Integer... ids);

    void physicDeleteByIds(@Param("ids") Integer[] ids);
}
