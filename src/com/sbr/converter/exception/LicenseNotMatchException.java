package com.sbr.converter.exception;


/**
 * 
  * aspose授权验证文件不匹配异常
  *
  * @author 曹传红
  * @date 2018年9月21日 下午2:44:22
  * @version 1.0 
  *
 */
public class LicenseNotMatchException extends RuntimeException {

	/**   
	  * @Fields serialVersionUID
	  */
	private static final long serialVersionUID = 1L;
	public LicenseNotMatchException() {
		super();
	}
	public LicenseNotMatchException(String msg) {
		super(msg);
	}
}
