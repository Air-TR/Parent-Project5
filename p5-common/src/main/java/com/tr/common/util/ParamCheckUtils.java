package com.tr.common.util;

import com.tr.common.exception.MyException;
import com.tr.common.result.ResultEnum;

/**
 * 判断非空工具类
 * 
 * @author taorun
 * @date 2017年8月29日 下午3:13:08
 *
 */

public final class ParamCheckUtils {
	
	/**
	 * 判断非空
	 * 
	 * @param objects
	 * @param names
	 * @throws MyException
	 */
	public static void notNull(Object[] objects, String[] names) throws MyException {
		for (int i = 0; i < objects.length; i++) {
			Object object = objects[i];
			if (object instanceof String && StringUtilies.isNullOrEmpty((String) object)) {
				throw new MyException(ResultEnum.PARAM_NULL.getCode(), "必要参数 " + names[i] + " 为空");
			} else if (!(object instanceof String) && object == null) {
				throw new MyException(ResultEnum.PARAM_NULL.getCode(), "必要参数 " + names[i] + " 为空");
			}
		}
	}

	/**
	 * 判断参数是否全部为空,若是则抛出异常
	 * 
	 * @author jiangxia
	 * @param objects
	 * @param names
	 * @throws ParameterException
	 */
	public static void notAllNull(Object[] objects) throws MyException {
		if ((objects == null) || (objects.length == 0)) {
			return;
		}

		int num = 0;
		for (int i = 0; i < objects.length; i++) {
			Object object = objects[i];
			if (object instanceof String && StringUtilies.isNullOrEmpty((String) object)) {
				num++;
			} else if (!(object instanceof String) && object == null) {
				num++;
			}
		}
		if (num == objects.length) {
			throw new MyException(ResultEnum.PARAM_NULL.getCode(), "必要参数为空");
		}
	}

//	/**
//	 * 判断手机号码是否正确
//	 * 
//	 * @author jiangxia
//	 * @param objects
//	 * @param names
//	 * @throws ParameterException
//	 */
//	public static void checkMobilePhone(String phone) {
//		if (!StringUtilies.isMobilePhone(phone)) {
//			throw new MyException(Code.MOBILEPHONE_ILLEGAL);
//		}
//	}
//
//	/**
//	 * 判断邮箱是否正确
//	 * 
//	 * @author jiangxia
//	 * @param objects
//	 * @param names
//	 * @throws ParameterException
//	 */
//	public static void checkMail(String mail) {
//		if (!StringUtilies.isMail(mail)) {
//			throw new MyException(Code.MAIL_ILLEGAL);
//		}
//	}

}
