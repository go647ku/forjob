package com.db.sys.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.sys.entity.SysLog;
/**
 * 基于此DAO接口中访问数据库
 */
public interface SysLogDao {
	 int insertObject(SysLog entity);
	  /**
	   * 基于id执行日志删除操作
	   * @param ids 特殊的数组
	   * @return
	   */
	  int deleteObjects(@Param("ids")Integer... ids);
	  
      /**
       * 基于查询条件统计记录总数
       * @param username 查询条件
       * @return 查询到的总记录数
       */
	  int getRowCount(@Param("username")String username);
	  /**
	   * 按照查询条件查询当前页要呈现的记录信息
	   * @param username 查询条件
	   * @param startIndex 当前页起始位置
	   * @param pageSize 页面大小(每页最多显示多少条记录)
	   * @return
	   */
	  List<SysLog> findPageObjects(
			  @Param("username")String username,
			  @Param("startIndex")Integer startIndex,
			  @Param("pageSize")Integer pageSize);
}




