package com.car.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@TableName
public class User extends BasePojo{
	
	@TableId(type=IdType.AUTO)
	private Integer u_Id;
	
	private String username;
	
	private String password;
	
}
