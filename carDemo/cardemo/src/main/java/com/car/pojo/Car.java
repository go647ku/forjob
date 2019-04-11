package com.car.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;
// 汽车
@Data
@Accessors(chain=true)
@TableName
public class Car extends BasePojo{
	
	@TableId(type=IdType.NONE)
	private String cId;
	
	private Integer uId;
	
	private String error;
	
	
}
