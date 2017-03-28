package com.migu.reconciliation.utils;

public interface SignConstant {
	
	public static final class ActivityVariable {
		public static final String APPLYUSER 		= "applyUser"; 		//申请人
		public static final String BRANCHPRE 		= "branchPre"; 		//部门预审
		public static final String MARKETINGDEPT	= "marketingDept"; 	//市场部-营销策划部预审意见(谢丽丽)
		public static final String DECISIONASSIGNEE	= "decisionAssignee"; //决策者
		public static final String LEADERS			= "leaders";		  //分管领导
		public static final String PERS				= "pers";			  //部门会签用户
		public static final String MANAGER			= "manager";		  //总经理审批
		public static final String FOREIGNKEY		= "foreignKey";		  //外键 AA_ID
		public static final String FLAG				= "flag";
	}

	public static final class Variable{
		public static final String RESULT			= "result";			//审批意见：同意or不同意
		public static final String SUGGESTION		= "suggestion";		//审批意见
	}
	
	
	public static final class Result{
		public static final String YES = "yes"; //同意
		public static final String NO  = "no"; //不同意
	}
	
	/**
	 * 会签结果
	 * @author admin
	 *
	 */
	public static final class SignJoinResult{
		public static final int yes = 1;
		public static final int no  = 2;
	}
	
	public static final class ActivitiKey{
		public static final String ACTIVITY = "activity";
	}
	
	/**
	 * 签报状态
	 * @author admin
	 *
	 */
	public final static class Status{
		public final static int OPEN 	= 1; //开启
		public final static int CLOSE 	= 2; //关闭
		//public final static int RESTART	= 3; //重新发起
	}
	
	/**
	 * 营销活动申请状态
	 * @author admin
	 *
	 */
	public final static class AAStatus{
		public final static int APPLY  	= 1;//待发起
		public final static int RUNINGE = 2;//流转中
		public final static int DONE  	= 3;//已完成(审批通过)
		public final static int CANCL 	= 4; //结束(审批未通过)
	}

	/**
	 * 签报类型
	 * @author admin
	 *
	 */
	public final static class Type{
		public final static String ACTIVITY = "1"; //营销活动 
	}
	
	/**
	 * 审核意见
	 * @author admin
	 *
	 */
	public final static class Bear{
		public final static int no	 	= 1; //不同意
		public final static int yes	 	= 2; //同意
		public final static int start 	= 3; //发起
		public final static int close	= 4; //关闭
	}
	
	
	/**
	 * 签报用户状态
	 * @author admin
	 *
	 */
	public final static class SignUserStatus{
		public final static int VIEW 			= 1;//查看
		public final static int APPROVE			= 2;//审批
		public final static int APPROVED		= 3;//已审批
	}
	
	
	/**
	 * 流程步骤
	 * @author admin
	 *
	 */
	public final static class Step{
		public final static int START 						= 1;  //申请人发起申请
		public final static int BRANCH 						= 2;  //部门预审
		public final static int SCB_OPINION					= 3;  //市场部意见
		public final static int BRANCH_JOIN 				= 4;  //多部门会签
		public final static int LEADER_JOIN 				= 5;  //分管领导会签
		public final static int DECISION					= 6;  //决策
		public final static int MANAGER 					= 7;  //总经理审批
		public final static int ALERT_SUCCESS 				= 8; //通知活动发起人，审批完成
		public final static int ALERT_FAIL					= 9; //通知活动发起人，活动审批未通过
		public final static int END							= 10; //活动结束
		public final static int DONE						= 11; //活动完成
	}
	
	/**
	 * 营销活动状态
	 * @author admin
	 *
	 */
	public final static class ActivityStatus{
		public final static int INITIAL  				= 0;//初始化
		public final static int PRE_AUDIT  				= 1;//待审核
		public final static int TEST 					= 2;//测试
		public final static int NORMAL  				= 3;//正常
		public final static int CLOSE 					= 4; //关闭
		public final static int AUDIT_FALSE 			= 10; //审核失败
	}
	
	/**
	 * 营销活动物品预算/结算
	 * @author admin
	 *
	 */
	public final static class ActivityWareBudgetSettlement{
		public final static int BUDGET  				= 1;//预算
		public final static int SETTLEMENT 				= 2;//结算
	}
	
	/**
	 * 身份
	 * @author admin
	 *
	 */
	/*public final static class Identity{
		public final static int EMPLOYEE 	= 1; //员工
		public final static int DIRECTOR 	= 2; //总监
		public final static int LEADER		= 3; //分管总
	}*/
	
	/**
	 * 流程实例
	 * @author admin
	 *
	 */
	public final static class SignExample{
		public final static String activity = "activity.bpmn";
	}
	
	
	/**
	 * 状态常量,所有状态通用
	 * @author admin
	 *
	 */
	public final static class OPStatus{
		public final static int OPEN 	= 1; //激活
		public final static int CLOSE 	= 2; //禁用
	}
	

	/**
	 * 是否经过决策
	 * @author admin
	 *
	 */
	public final static class Decision{
		public final static int yes = 1; //经过
	}
	
	/**
	 * 位置
	 * @author admin
	 *
	 */
	public final static class Position{
		public final static int YS  = 1; //预审人员
		public final static int ZJ 	= 2; //总监
		public final static int FGZ = 3; //分管总
		public final static int ZJL = 4; //总经理
	}
	
	/**
	 * 活动性质
	 * @author admin
	 *
	 */
	public final static class Nature{
		public final static int ONLINE 		= 1; //线上
		public final static int OFFLINE 	= 2; //线下参与执行
		public final static int OFFLINE2 	= 3; //线下不参与执行
	}
	
}
