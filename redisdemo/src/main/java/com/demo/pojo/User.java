package com.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
	
	@TableId(type=IdType.AUTO)
	Integer id;
	
	private String name;
	private Integer age;
	private String sex;
}
