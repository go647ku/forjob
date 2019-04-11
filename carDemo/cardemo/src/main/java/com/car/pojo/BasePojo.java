package com.car.pojo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

// 基类
@Data
@Accessors(chain=true)
public class BasePojo {
	
	// 创建时间
	Date created;
	
	// 更新时间
	Date updated;
	
}
