package com.migu.reconciliation.utils;


public interface BasicsGlobal {

	/**
	 * 系统管理员角色ID
	 * @author zhangwei
	 *
	 */
	public static final class RolesFixed {
		public final static String ADMIN 			= "1"; // 系统管理员		
	}
	
	/**
	 * 角色是否可修改
	 * @author zhangwei
	 *
	 */
	public static final class RoleWritable {
		public final static int WRITABLE 			= 1; // 可修改
		public final static int DISWRITABLE			= 2; // 不可修改
	}
	
	
	/**
	 * 用户类型
	 * @author zhangwei
	 *
	 */
	public static final class UserType {
		public final static int NORMAL 			= 1; // 普通
	}
	
	/**
	 * 用户状态
	 * @author zhangwei
	 *
	 */
	public static final class UserStatus{
		public final static int OPEN  = 1; //激活
		public final static int CLOSE = 2; //禁用
	}
	
	/**
	 * 是否显示虚拟账号，1：否 2：是
	 * @author zhangwei
	 *
	 */
	public static final class Virtual{
		public final static int NO  = 1;
		public final static int YES = 2;
	}
	
	
}
