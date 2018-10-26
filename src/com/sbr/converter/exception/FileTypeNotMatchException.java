package com.sbr.converter.exception;

/**
 * 
  * 文件类型不匹配异常
  *
  * @author 曹传红
  * @date 2018年9月15日 上午12:36:30
  * @version 1.0 
  *
 */
public class FileTypeNotMatchException extends RuntimeException {

	/**   
	  * @Fields serialVersionUID
	  */
	private static final long serialVersionUID = 1L;
	
	public FileTypeNotMatchException(String meg) {
		super(meg);
	}
	public FileTypeNotMatchException() {
		super();
	}
	

}
