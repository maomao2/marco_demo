package com.marco.demo.entity.result;

import java.util.Map;

import com.marco.demo.entity.enums.ApiResultType;

public class MapStringResult extends CommonResult<Map<String, String>> {

	private static final long serialVersionUID = -87749144248269845L;

	public MapStringResult() {
	}

	public MapStringResult(ApiResultType result, Map<String, String> data) {
		super(result, data);
	}

	public MapStringResult(ApiResultType result) {
		super(result);
	}

	public MapStringResult(Integer code, String msg, Map<String, String> data) {
		super(code, msg, data);
	}

}
