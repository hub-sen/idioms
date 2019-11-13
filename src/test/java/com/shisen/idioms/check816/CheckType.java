package com.shisen.idioms.check816;

import com.shisen.idioms.check816.checkParam.CheckParam;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/16 16:49
 * </pre>
 */
public interface CheckType<T extends CheckResult> {


	/**
	 * 执行校验,并返回校验结果
	 *
	 * @return
	 */
	T docheck(CheckParam checkParam);
}
