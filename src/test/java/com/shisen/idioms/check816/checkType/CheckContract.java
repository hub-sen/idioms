package com.shisen.idioms.check816.checkType;

import com.shisen.idioms.check816.CheckResult;
import com.shisen.idioms.check816.CheckType;
import com.shisen.idioms.check816.checkParam.CheckParam;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/16 16:54
 * </pre>
 */
@Service
public class CheckContract implements CheckType {

	@Override
	public CheckResult docheck(CheckParam checkParam) {
		return CheckResult.builder().checkResult("check contract").name(checkParam.getResName()).build();
	}

}
