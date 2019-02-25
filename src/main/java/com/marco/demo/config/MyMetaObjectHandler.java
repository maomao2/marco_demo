package com.marco.demo.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

public class MyMetaObjectHandler extends MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		this.setFieldValByName("createTime", new Date(), metaObject);
	}

	@Override
	public boolean openUpdateFill() {
		return false;
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		// 关闭更新填充、这里不执行
		this.setFieldValByName("updateTime", new Date(), metaObject);
	}
}
