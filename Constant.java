package com.migu.reconciliation.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class Constant {
	public static final class ALIPAY {
		public final static String HAS_NEXT_PAGE = "T";// 有下一页数据
		public final static String IS_SUCCESS = "T";// 数据获取成功
		public final static Integer PAY_CHANNEL_ORDER_STATUS_SUCCESS = 1; // 支付渠道支付(/退款)状态(1:成功)
		
		public static final class TRANS_CODE_MSG {
			public final static String TYPE_ONLINEPAYMENT = "在线支付";// 用户支付费用
			public final static String TYPE_TRANSFER_ACCOUNT = "转账";// 用户退款
			public final static String TYPE_TRANSFER_SERVICE_FEE = "收费";// 支付宝收取手续费
			public final static String TYPE_WITHDRAW = "提现";// 咪咕提现到银行账户
		}

		public static final class ACCOUNT_PAGE_QUERY_INTF {// 账户明细分页查询接口
			public final static String INTF_URL = "https://mapi.alipay.com/gateway.do";// 参数：url
			public final static String MD5_KEY = "qs5grizm45xoln4s2tgzkfnwg2dgpwiy";// md5加密时的私钥
			public final static String PARAM_SERVICE_NAME = "service";// 参数：service
			public final static String PARAM_SERVICE_VALUE = "account.page.query";// 参数：service的值
			public final static String PARAM_PARTNER_NAME = "partner";// 参数：partner
			public final static String PARAM_PARTNER_VALUE = "2088911492336585";// 参数：partner的值
			public final static String PARAM_INPUT_CHARSET_NAME = "_input_charset";// 参数：_input_charset
			public final static String PARAM_INPUT_CHARSET_VALUE = "GBK";// 参数：_input_charset的值
			public final static String PARAM_SIGN_TYPE_NAME = "sign_type";// 参数：sign_type
			public final static String PARAM_SIGN_TYPE_VALUE = "MD5";// 参数：sign_type的值
			public final static String PARAM_PAGE_NO_NAME = "page_no";// 参数：page_no
			public final static String PARAM_GMT_START_TIME_NAME = "gmt_start_time";// 参数：gmt_start_time
			public final static String PARAM_GMT_END_TIME_NAME = "gmt_end_time";// 参数：gmt_end_time
			public final static String PARAM_PAGE_SIZE_NAME = "page_size";// 参数：page_size
			public final static String PARAM_PAGE_SIZE_VALUE = "1000";// 参数：page_size的值
			public final static String PARAM_SIGN_NAME = "sign";// 参数：sign
			public final static String PARAM_LOGON_ID_NAME = "logon_id";// 参数：logon_id
			public final static String PARAM_LOGON_ID_VALUE = "";// 参数：logon_id的值
		}
	}
	
	//补账
	public static final class ORIGIN_REPAIR_DATA{
		//补账数据状态
		public static final class DATA_STATUS{
			public final static Integer DATA_STATUS_NORMAL = 1;//数据正常
			public final static Integer DATA_STATUS_INVALIDATE = 0;//数据作废
		}
		//补账数据文件名必须包含的文字
		public static final class FILE_NAME_KEYWORD{
			public final static String PAY_ORDER_KEYWORD = "103";//支付订单
			public final static String REFUND_ORDER_KEYWORD = "101";//退款订单
			public final static String PAY_PAYMENT_KEYWORD = "payment";//支付流水
			public final static String REFUND_PAYMENT_KEYWORD = "refund";//退款流水
		}
		
		//补账数据字符串长度
		public static final class STR_DATA_LENGTH{
			public final static Integer COL_ORDERPAY_RECORD_44 = 44;//支付订单		数据通过','截取后列数44
			public final static Integer COL_ORDER_REFUND_RECORD_44 = 44;//退款订单	数据通过','截取后列数44
			public final static Integer COL_PAYMENTRECORD_18 = 18;//支付流水	数据通过','截取后列数18
			public final static Integer COL_REFUNDRECORD_17= 17;//退款流水	数据通过','截取后列数17
		}
		
		//补账数据的数据类型
		public static final class STR_DATA_TYPE{
			public final static String PAY_ORDER = "1";//支付订单
			public final static String REFUND_ORDER = "2";//退款订单
			public final static String PAY_PAYMENT = "3";//支付流水
			public final static String REFUND_PAYMENT = "4";//退款流水			
		}
		
		//补账文件批量上传数量
		public static final class ONCE_COUNT{
			public final static Integer NUM_ONCE_COUNT = 1000;//批量分批次上传每次1000
		}
		
		
	}
	
	//电子码平台
	public static final class ElectronicCode {
		public final static String INTF_URL = "http://10.200.15.79:8080/proticketadmin/order/orderDetailList";// 参数：url
		public final static String PLATFORM_ELECTRONIC = "electroniccode";// 电子码平台
		
	}
	
	public static final class OriginThirdTheatre{
		//tomcat服务器地址和端口
//		public final static String receiveURL = "c:/yxiao";//本地
//		public final static String receiveURL = "http://10.200.25.21:8080";//生产环境
		
		//用户名
//		public final static String userName = "yxiao";//本地
//		private final static String userName = "recon";//生产环境
		
		//jsp文件上传路径
//		public final static String filePath = "/home/" + userName + "/tomcat7/inputfile/";//本地测试
//		public final static String filePath = File.separatorChar+"reconciliation"+File.separatorChar+"inputfile" +File.separatorChar ;//生产环境
//		public final static String httpPath = "http://";
		
		public final static String filePath = "/fileUpload/temp/";
		
		public final static String THEATRE_WP = "WP";//三方影票采集_微票
		public final static String THEATRE_ZZW = "ZZW";//三方影票采集_蜘蛛网
		public final static String THEATRE_WD = "WD";//三方影票采集_万达
		public final static String THEATRE_SFC = "SFC";//三方影票采集_SFC
		
		public final static Integer ONCE_NUMBER_WP = 1000;//微票,_分批批量上传个数
		public final static Integer ONCE_NUMBER_ZZW = 100;//蜘蛛网_分批批量上传个数
		public final static Integer ONCE_NUMBER_WD = 100;//万达_分批批量上传个数
		public final static Integer ONCE_NUMBER_SFC = 1000;//SFC,_分批批量上传个数
		
		public final static String FIRST_DAY = "-01";//每月第一天
		
		
	}
	
	
	public static final class WX {
		public static final Integer WX_COLLECT = 1;//采集数据
		public static final Integer WX_NOT_COLLECT = 0;//不采集数据
		
		public final static Double VATRATE = 100d;
		
		public static final class ACCOUNT_PAGE_QUERY_INTF {// 账户明细分页查询接口
			public final static String INTF_URL = "https://api.mch.weixin.qq.com/pay/downloadbill";// 参数：url
			public final static String PARAM_NONCE_NAME = "nonce_str";//参数：随机字符串
			public final static int PARAM_NONCE_LENGTH = 32;//参数：随机字符串长度
			public final static String PARAM_SIGN_NAME = "sign";// 参数：sign
			public final static String PARAM_BILLDATE_NAME = "bill_date";// 参数：bill_date
			public final static String PARAM_BILLTYPE_NAME = "bill_type";// 参数：bill_type
			public final static String PARAM_BILLTYPE_VALUE = "ALL";// 参数：bill_type的值
			public final static String INTF_RESULT_NO_BILL = "No Bill Exist";
			
			public static final class MG_SHIPIN {//咪咕视频
				public final static String BIZTYPE_NAME = "MG_SHIPIN";
				public final static String PARAM_APPID_NAME = "appid";//参数：应用ID
				public final static String PARAM_APPID_VALUE = "wx3260ad2b31fe6d24";//参数：应用ID的值
				public final static String PARAM_MCHID_NAME = "mch_id";//参数：商户号
				public final static String PARAM_MCHID_VALUE = "1260118901";//参数：商户号的值
				public final static String MD5_KEY = "xujlj55507ningqiaomiguchanpinbum";// md5加密时的私钥
			}
			
			public static final class MG_YINGYUAN {//咪咕影院
				public final static String BIZTYPE_NAME = "MG_YINGYUAN";
				public final static String PARAM_APPID_NAME = "appid";//参数：应用ID
				public final static String PARAM_APPID_VALUE = "wx47e96898d25377d5";//参数：应用ID的值
				public final static String PARAM_MCHID_NAME = "mch_id";//参数：商户号
				public final static String PARAM_MCHID_VALUE = "1261461401";//参数：商户号的值
				public final static String MD5_KEY = "2015miguqwertyuiopasdfghjklzxcvb";// md5加密时的私钥
			}
			
			public static final class MG_YINGYUAN2 {//咪咕影院
				public final static String BIZTYPE_NAME = "MG_YINGYUAN2";
				public final static String PARAM_APPID_NAME = "appid";//参数：应用ID
				public final static String PARAM_APPID_VALUE = "wx6212c9b1dd65043c";//参数：应用ID的值
				public final static String PARAM_MCHID_NAME = "mch_id";//参数：商户号
				public final static String PARAM_MCHID_VALUE = "1259103901";//参数：商户号的值
				public final static String MD5_KEY = "lovevISJ201508121502695958148381";// md5加密时的私钥
			}
			
			public static final class MG_HESHIPIN {//咪咕视频和4G版本
				public final static String BIZTYPE_NAME = "MG_HESHIPIN4G";
				public final static String PARAM_APPID_NAME = "appid";//参数：应用ID
				public final static String PARAM_APPID_VALUE = "wx97043013dd2104ef";//参数：应用ID的值
				public final static String PARAM_MCHID_NAME = "mch_id";//参数：商户号
				public final static String PARAM_MCHID_VALUE = "1260119101";//参数：商户号的值
				public final static String MD5_KEY = "18817391190migu18817391190miguwx";// md5加密时的私钥
			}
		}
		
		public static final class TRADESTATUS {
			public final static String TRADESTATUS_PAY = "SUCCESS";//支付
			public final static String TRADESTATUS_REFUND = "REFUND";//退款
		}
	}

	public static final class CHARACTER {
		public final static String CHARACTER_UTF8 = "UTF-8";// Utf-8编码格式
		public final static String CHARACTER_GBK = "GBK";// GBK编码格式
	}

	public static final class FTP {
		public final static String LOCAL_FILE_PATH = "";// 本地文件路径
		
		public final static class PRORATE_FTP {//分账FTP服务器信息
			public final static String FTP_SERVER_HOST = "172.16.19.70";
			public final static int FTP_SERVER_PORT = 22;
			public final static String FTP_SERVER_USER="checkGroup";
			public final static String FTP_SERVER_PWD="3edc#EDC";
			public final static String FTP_SERVER_DIR="/home/checkGroup/fileFolders";
			public final static String FTP_REMOTE_ORDER_PATH = "/order";
			public final static String FTP_REMOTE_PAYMENT_PATH = "/pay";
		}
		
		public final static class MIGU_HEBAO_PAY_FTP {//咪咕一级支付FTP服务器信息
			public final static String FTP_SERVER_HOST = "117.185.124.16";
			public final static int FTP_SERVER_PORT = 20022;
			public final static String FTP_SERVER_USER="video";
			public final static String FTP_SERVER_PWD="ymE80E7R4E8yJDH1";
			public final static String FTP_SERVER_DIR="/";
		}
	}
	
	public static final class PAGECONFIG {
		public static final class ISPAGING {
			public final static String PAGING = "1";// 查询分页
			public final static String NOPAGING = "";// 查询不分页
		}
	}
	
	public static final class COLLECT {
		public static final class COLLECT_ {
			public final static String ZERO = "0";//汇总统计数0
		}
	}
	
	
	
	//excel正确列数
	public static final class COL_NUMBER {
			public final static Integer COL_NUMBER_WP = 24;//微票附件正确列数24
			public final static Integer COL_NUMBER_ZZW = 13;//蜘蛛网附件正确列数13
			public final static Integer COL_NUMBER_WD = 21;//万达附件正确列数21
			public final static Integer COL_NUMBER_SFC = 16;//SFC附件正确列数16
			public final static Integer COL_NUMBER_NOSCOPE = 5;//三方影票非结算SCOPE表附件正确列数5

			
	}
	
	
	
	//是否将数据插入到数据库
	public static final class IS_INSERT{
		public final static String INSERT_YES = "是";
		public final static String INSERT_NO = "否";
	}
	
	public static final class OPERATOR_RESULT {
		public final static String SUCCESS = "SUCCESS";
		public final static String FALSE = "FALSE";
	}
	
	public static final class TRANDE_STATUS{
		public final static  String TRANDE_STATUS_REFUND = "REFUND";//退款
		public final static  String TRANDE_STATUS_SERVICE = "SUCCESS";//手续费
		public final static  String TRANDE_STATUS_ONLINE = "SUCCESS";//在线支付
	}
	
	public static final class SHOW_BLANK{
		public final static String SLANT = "/";
	}
	
	public static final class JSP_REMARK{
		public final static String REMARK = "collectTion";//报表查询->账期统计->三个页面隐藏域
		public final static String REMARK_SUMMARYOFRECONCILIATION = "sumMaryOfReconCiliation";//账期统计->对账汇总页面隐藏域
	}

	public static final class CollectData {
		public final static int COLLECT_DATA_TYPE = 1;//0:ETL格式话单数据/1:JSON格式话单格式
		public final static Integer N_DAYS_BEFORE = -2;// 离当前日期*天前
		public final static String LOCAL_FILE_PATH = "";// 本地保存文件的路径
		public final static String PLATFORM_HW = "huawei";// 华为
		public final static String PLATFORM_ALIPAY = "alipay";// 支付宝
		public final static String BIZTYPE_HW_ORDER = "hw_order";// 华为订单
		public final static String BIZTYPE_HW_ORDER_PAYMENT_REL = "hw_order_payment_rel";// 华为订单、支付流水关联关系
		public final static String BIZTYPE_HW_ORDER_PAYMENT = "hw_order_payment";// 华为支付流水关联关系
		public final static String BIZTYPE_HW_FINAL_STATE_ORDER = "hw_final_state_order";// 华为完成订单
		public final static String BIZTYPE_HW_REFUND_STATE_ORDER = "hw_refund_state_order";// 华为退款订单
		public final static String BIZTYPE_HW_FINAL_STATE_PAYMENT = "hw_final_state_payment";// 华为支付流水
		public final static String BIZTYPE_HW_REFUND_STATE_PAYMENT = "hw_refund_state_payment";// 华为退款流水
		public final static String BIZTYPE_THEATRE_ORDER = "theatre_order";//咪咕影院订单
		public final static String SUCCESS = "SUCCESS";
		public final static String FALSE = "FALSE";
		
		public final static String PLATFORM_APPLE = "apple";// 苹果支付
		public final static String PLATFORM_WEIXIN = "weixin";// 微信支付
		public final static String PLATFORM_MIGU = "migu";// 咪咕支付

		//public final static String HW_ORIGIN_DATA_FILE_PATH = "c:/fzf/vm/1";
		//public final static String HW_ORIGIN_DATA_FILE_PATH = "/home/recon";//测试路径
		public final static String HW_ORIGIN_DATA_FILE_PATH = "/mnt/nfs/cdmp/ftp";//CDMP提供的源文件路径
		public final static String HW_ORIGIN_HW_ORDER_DATA_FILE_PATH = HW_ORIGIN_DATA_FILE_PATH + "/Order";//华为订单数据
		public final static String HW_ORIGIN_HW_ORDER_PAYMENT_REL_DATA_FILE_PATH = HW_ORIGIN_DATA_FILE_PATH + "/ORDER_PAYMENT_REL";//华为订单与支付流水对应关系数据
		public final static String HW_ORIGIN_HW_ORDER_PAYMENT_DATA_FILE_PATH = HW_ORIGIN_DATA_FILE_PATH + "/Payment" ;//华为订单的支付流水数据
		public final static String HW_ORDER_DATA_FILE_KEY = "Order_";
		public final static String HW_ORDER_PAYMENT_REL_DATA_FILE_KEY = "ORDER_PAYMENT_REL_";
		public final static String HW_ORDER_PAYMENT_DATA_FILE_KEY = "Payment_";
		
		public final static String WD_THEATRE_ORDER_DATA_FILE_PATH = "/mnt/nfs/wangda/wd_piaowu";//咪咕影院订单数据话单文件路径
		public final static String WD_THEATRE_PAYMENT_ORDER_DATA_FILE_PATH = WD_THEATRE_ORDER_DATA_FILE_PATH + "/order";//支付话单文件路径
		public final static String WD_THEATRE_REFUND_ORDER_DATA_FILE_PATH = WD_THEATRE_ORDER_DATA_FILE_PATH + "/refundorder";//退款话单文件路径
		public final static String THEATRE_ORDER_DATA_FILE_KEY = "TICKET";//咪咕影院支付订单数据话单文件名称
		public final static String THEATRE_REFUND_ORDER_DATA_FILE_KEY = "REFUND_TICKET";//咪咕影院退款订单数据话单文件名称
		public final static String THEATRE_ORDER_DATA_FILE_SUFFIX = ".txt";//咪咕影院支付订单数据话单文件文件后缀
		
		public final static String JSON_HW_ORDER_DATA_FILE_PATH = "/mnt/nfs/hw/order_cdr";//华为订单Json格式话单路径
		public final static String JSON_HW_PAYMENT_DATA_FILE_PATH = "/mnt/nfs/hw/payment_cdr/payment";//华为支付Json格式话单路径
		public final static String JSON_HW_FERUND_PAYMENT_DATA_FILE_PATH = "/mnt/nfs/hw/payment_cdr/refund";//华为退款Json格式话单路径
		public final static String MIGUPAY_LOCAL_DATA_FILE_PATH = "/home/recon/hebao";//咪咕一级支付本地保存路径
		public final static String MIGUPAY_FILE_PREFIX = "MIGU_";//咪咕一级支付文件前缀
		public final static String MIGUPAY_FILE_SUFFIX = ".txt";//咪咕一级支付文件后缀
		
		public final static class MiGuPay {//咪咕一级支付
			public final static class MiGuPayStatus {//支付状态
				public final static Integer MIGUPAY_STATUS_SUCCESS = 0;// 数据处理状态(0:成功)
				public final static Integer MIGUPAY_STATUS_FALSE = 1;// 数据处理状态(1:失败)
				public final static Integer MIGUPAY_STATUS_PAYING = 2;// 数据处理状态(2:支付中)
				public final static Integer MIGUPAY_STATUS_REFUND = 4;// 数据处理状态(4:当天已退款)
			}
		}
		
		public final static class MiGuLive {//咪咕直播
			public final static String zzFilePath = "/mnt/nfs/hw/migulive/zhuanZhang";//转账文件路径
			public final static String czFilePath = "/mnt/nfs/hw/migulive/chongZhi";//充值文件路径
			public final static String bizTypeZZ = "ZZ";//转账
			public final static String bizTypeCZ = "CZ";//充值
			
			public final static class DataType {//数据类型
				public final static Integer DATA_TYPE_1 = 1;//1:充值
				public final static Integer DATA_TYPE_2 = 2;//2:转账
				public final static Integer DATA_TYPE_3 = 3;//3:提现
			}
			
			public final static class MIGULIVE_DEAL_RESULT {//咪咕直播余额稽核结果
				public final static Integer MIGULIVE_DEAL_RESULT_1 = 1;//1:平帐
				public final static Integer MIGULIVE_DEAL_RESULT_2 = 2;//2:咪咕直播本地交易流水多
				public final static Integer MIGULIVE_DEAL_RESULT_3 = 3;//3:用户中心交易流水多
				public final static Integer MIGULIVE_DEAL_RESULT_4 = 4;//4:两边交易金额不一致
				public final static Integer MIGULIVE_DEAL_RESULT_5 = 5;//5:两边账户不一致
				public final static Integer MIGULIVE_DEAL_RESULT_6 = 6;//6:两边账户不一致且两边交易金额不一致
			}
			
			public final static class CURRENCY {//咪咕直播货币类型
				public final static Integer MIGULIVE_DEAL_RESULT_1222 = 1222;//1222:咪咕钻
				public final static Integer MIGULIVE_DEAL_RESULT_1223 = 1223;//1223:咪咕票
			}
			
			public final static class MIGULIVE_TURNOVERTYPE {//咪咕直播流水类型
				public final static Integer MIGULIVE_TURNOVERTYPE_1 = 1;//1:充值
				public final static Integer MIGULIVE_TURNOVERTYPE_2 = 2;//2:直接扣款
				public final static Integer MIGULIVE_TURNOVERTYPE_3 = 3;//3:补款
				public final static Integer MIGULIVE_TURNOVERTYPE_4 = 4;//4:预留扣款
				public final static Integer MIGULIVE_TURNOVERTYPE_5 = 5;//5:回收账本
			}
			
			
		}
		
		public final static class MiGuAccountLive {//咪咕直播
			public final static String filePath = "/mnt/nfs/hw/migulive_hw";//文件路径
			public final static String fileKey = "migulive_";//文件关键字
		}
	}

	public static final class Order {
		public final static Integer DEAL_STATUS_UNHANDLE = 0;// 数据处理状态(0:未处理)
		public final static Integer DEAL_STATUS_HANDLED = 1;// 数据处理状态(1:已处理)
	}
	
	public static final class TheatreOrder {
		public final static Integer SERVICE_FEE_WP = 270;// 微票服务费
		public final static Integer SERVICE_FEE_ZZW = 280;// 蜘蛛网服务费
		public final static Integer SERVICE_FEE_WD = 0;// 万达服务费
		public final static Integer SERVICE_FEE_SFC = 300;// SFC服务费
		public final static Integer SERVICE_FEE_HL = 0;//华录服务费

		public final static Integer THIRD_PARTY_TYPE_WP = 2;// 微票
		public final static Integer THIRD_PARTY_TYPE_ZZW = 1;// 蜘蛛网
		public final static Integer THIRD_PARTY_TYPE_WD = 4;// 万达
		public final static Integer THIRD_PARTY_TYPE_SFC = 5;// SFC
		public final static Integer THIRD_PARTY_TYPE_HL = 6;// 华录
		public final static Double VATRATE = 0.06d;//税率
		private static Map<Integer, String> mgOrderStatusMap = null;
		
		public static Map<Integer, String> getMgorderstatusmap() {
			return mgOrderStatusMap;
		}

		/**
		 * 咪咕影票订单与支付流水稽核
		 * @author user
		 *
		 */
		public static final class ORDER_PAYMENT_AUDIT_RESULT {
			public final static Integer AUDIT_ORDER_RESULT_FAIR_BILL = 1; // 稽核结果(1:订单金额与支付金额一致)
			public final static Integer AUDIT_ORDER_RESULT_MORE_MGTHEATRE_ORDER_BILL = 2; // 稽核结果(2:咪咕影院订单流水多)
			public final static Integer AUDIT_ORDER_RESULT_DIFF_FEE_BILL = 3; // 稽核结果(3:订单金额与支付金额不一致)
		}
		
		/**
		 * 咪咕影票订单与三方影票订单稽核
		 * @author user
		 *
		 */
		public static final class THIRD_ORDER_AUDIT_RESULT {
			public final static Integer AUDIT_ORDER_RESULT_FAIR_BILL = 1; // 稽核结果(1:平帐)
			public final static Integer AUDIT_ORDER_RESULT_MORE_MGTHEATRE_ORDER_BILL = 2; // 稽核结果(2:咪咕影院订单流水多)
			public final static Integer AUDIT_ORDER_RESULT_MORE_THIRD_BILL = 3; // 稽核结果(3:三方影票订单流水多)
			public final static Integer AUDIT_ORDER_RESULT_DIFF_FEE_BILL = 4; // 稽核结果(4:两边订单金额不一致)
			public final static Integer AUDIT_ORDER_RESULT_IGNORE_BILL = 5; // 稽核结果(5:非参与结算数据)
			public final static Integer AUDIT_ORDER_RESULT_PAYMNET_NO_SECCESS = 6; // 稽核结果(6:支付数据状态非成功支付)
			public final static Integer AUDIT_ORDER_RESULT_CANNOT_AUDIT = 9; // 稽核结果(9:非人民币交易无法稽核)
		}
		
		public static final class MG_ORDER_STATUS {
			public final static Integer MG_ORDER_STATUS_0 = 0; // 本地影票系统订单状态:0:未出票
			public final static Integer MG_ORDER_STATUS_1 = 1; // 本地影票系统订单状态:1:出票成功
			public final static Integer MG_ORDER_STATUS_2 = 2; // 本地影票系统订单状态:2:出票失败
			public final static Integer MG_ORDER_STATUS_3 = 3; // 本地影票系统订单状态:3:出票中
			public final static String MG_ORDER_STATUS_0_VALUE = "未出票";
			public final static String MG_ORDER_STATUS_1_VALUE = "出票成功";
			public final static String MG_ORDER_STATUS_2_VALUE = "出票失败";
			public final static String MG_ORDER_STATUS_3_VALUE = "出票中";
		}
		
		public static final class SCOPE_CURRENCY_REL_STATUS {
			public final static Integer STATUS_0 = 0; // 状态:0:未启用
			public final static Integer STATUS_1 = 1; // 状态:1:启用
		}
		
		static {
			if (mgOrderStatusMap == null) {
				mgOrderStatusMap = new HashMap<>();
			}
			if(mgOrderStatusMap.size() == 0) {
				mgOrderStatusMap.put(MG_ORDER_STATUS.MG_ORDER_STATUS_0, MG_ORDER_STATUS.MG_ORDER_STATUS_0_VALUE);
				mgOrderStatusMap.put(MG_ORDER_STATUS.MG_ORDER_STATUS_1, MG_ORDER_STATUS.MG_ORDER_STATUS_1_VALUE);
				mgOrderStatusMap.put(MG_ORDER_STATUS.MG_ORDER_STATUS_2, MG_ORDER_STATUS.MG_ORDER_STATUS_2_VALUE);
				mgOrderStatusMap.put(MG_ORDER_STATUS.MG_ORDER_STATUS_3, MG_ORDER_STATUS.MG_ORDER_STATUS_3_VALUE);
			}
		}
	}

	public static final class Log {
		public final static Integer LOG_STATUS_UNDO = 0;// 作业执行状态(0:未执行)
		public final static Integer LOG_STATUS_DOING = 1;// 作业执行状态(1:执行中)
		public final static Integer LOG_STATUS_DONE = 2;// 作业执行状态(1:执行结束)

		public final static Integer LOG_RESULT_SUCCESS = 1;// 作业执行结果(1:成功)
		public final static Integer LOG_RESULT_FALSE = 0;// 作业执行结果(0:失败)

		public final static Integer LOG_TYPE_1001 = 1001;// 1001:本地华为交易日数据自动采集(系统触发)
		public final static Integer LOG_TYPE_1004 = 1004;// 1004:第三方支付-支付宝数据自动采集(系统触发)
		public final static Integer LOG_TYPE_1005 = 1005;// 1005:第三方支付-微信数据自动采集(系统触发)
		public final static Integer LOG_TYPE_1006 = 1006;// 1006:咪咕影院订单数据自动采集(系统触发)
		public final static Integer LOG_TYPE_1007 = 1007;// 1007:电子码平台数据自动采集(系统触发)
		public final static Integer LOG_TYPE_1008 = 1008;// 1008:咪咕一级支付数据自动采集(系统触发)
		public final static Integer LOG_TYPE_1009 = 1009;// 1009:咪咕直播数据自动采集(系统触发)
		public final static Integer LOG_TYPE_1010 = 1010;// 1010:咪咕账户中心直播数据自动采集(系统触发)
		public final static Integer LOG_TYPE_2001 = 2001;// 2001:本地华为日交易数据整合(系统触发)
		public final static Integer LOG_TYPE_2003 = 2003;// 2003:第三方支付渠道支付宝数据整合(系统触发)
		public final static Integer LOG_TYPE_2004 = 2004;// 2004:第三方支付渠道微信数据整合(系统触发)
		public final static Integer LOG_TYPE_2005 = 2005;// 2005:第三方票务数据整合(系统触发)
		public final static Integer LOG_TYPE_2006 = 2006;// 2006:第三方支付-咪咕一级支付数据整合(系统触发)
		public final static Integer LOG_TYPE_3001 = 3001;// 3001:本地交易与第三方支付渠道数据每日自动稽核(系统触发)
		public final static Integer LOG_TYPE_3002 = 3002;// 3002:生成分账数据(系统触发)
		public final static Integer LOG_TYPE_3004 = 3004;// 3004:咪咕影院订单数据自动稽核(系统触发)
		public final static Integer LOG_TYPE_3005 = 3005;// 3005:咪咕直播数据自动稽核(系统触发)
		public final static Integer LOG_TYPE_4001 = 4001;// 4001:咪咕影票与三方影票数据自动结算(系统触发)
		public final static Integer LOG_TYPE_6001 = 6001;// 6001:影票报表_购票日对账报表(系统触发)
		public final static Integer LOG_TYPE_6002 = 6002;// 6002:影票报表_影票订单支付数据日报表(系统触发)
		public final static Integer LOG_TYPE_6003 = 6003;// 6003:影票报表_退款影票详单报表数据(系统触发)
		
		
		public final static Integer LOG_TYPE_1051 = 1051;// 1051:本地华为交易日数据采集(页面触发)
		public final static Integer LOG_TYPE_1052 = 1052;// 1052:本地华为订单日数据采集(页面触发)
		public final static Integer LOG_TYPE_1054 = 1054;// 1054:第三方支付-支付宝数据采集(页面触发)
		public final static Integer LOG_TYPE_1055 = 1055;// 1055:第三方支付-微信数据采集(页面触发)
		public final static Integer LOG_TYPE_1056 = 1056;// 1056:咪咕影院订单数据采集(页面触发)
		public final static Integer LOG_TYPE_1057 = 1057;// 1057:电子码平台数据采集(页面触发)
		public final static Integer LOG_TYPE_1058 = 1058;// 1058:咪咕一级支付数据采集(页面触发)
		public final static Integer LOG_TYPE_1059 = 1059;// 1059:咪咕直播数据采集(页面触发)
		public final static Integer LOG_TYPE_1060 = 1060;// 1060:咪咕账户中心直播数据采集(页面触发)
		public final static Integer LOG_TYPE_2051 = 2051;// 2051:本地华为日交易数据整合(页面触发)
		public final static Integer LOG_TYPE_2053 = 2053;// 2053:第三方支付渠道支付宝数据整合(页面触发)
		public final static Integer LOG_TYPE_2054 = 2054;// 2054:第三方支付渠道微信数据整合(页面触发)
		public final static Integer LOG_TYPE_2055 = 2055;// 2055:第三方票务数据整合(页面触发)
		public final static Integer LOG_TYPE_2056 = 2056;// 2056:第三方支付-咪咕一级支付数据整合(页面触发)
		public final static Integer LOG_TYPE_3051 = 3051;// 3051:本地交易与第三方支付渠道数据日稽核(页面触发)
		public final static Integer LOG_TYPE_3052 = 3052;// 3052:生成分账数据(系统触发)
		public final static Integer LOG_TYPE_3053 = 3053;// 3053:关闭账期(页面触发)
		public final static Integer LOG_TYPE_3054 = 3054;// 3054:咪咕影院订单数据稽核(页面触发)
		public final static Integer LOG_TYPE_3055 = 3055;// 3055:咪咕直播数据稽核(页面触发)
		public final static Integer LOG_TYPE_4051 = 4051;// 4051:咪咕影票与三方影票数据结算(页面触发)
		public final static Integer LOG_TYPE_6051 = 6051;// 6051:影票报表_购票日对账报表(页面触发)
		public final static Integer LOG_TYPE_6052 = 6052;// 6052:影票报表_影票订单支付数据日报表(页面触发)
		public final static Integer LOG_TYPE_6053 = 6053;// 6053:影票报表_退款影票详单报表数据(页面触发)
		
		
		public final static String JOB_NAME_1001 = "本地华为交易日数据自动采集(系统触发)";
		public final static String JOB_NAME_1004 = "第三方支付-支付宝数据自动采集(系统触发)";
		public final static String JOB_NAME_1005 = "第三方支付-微信数据自动采集(系统触发)";
		public final static String JOB_NAME_1006 = "咪咕影院订单数据自动采集(系统触发)";
		public final static String JOB_NAME_1007 = "电子码平台数据自动采集(系统触发)";
		public final static String JOB_NAME_1008 = "咪咕一级支付数据自动采集(系统触发)";
		public final static String JOB_NAME_1009 = "咪咕直播数据自动采集(系统触发)";
		public final static String JOB_NAME_1010 = "咪咕账户中心直播数据自动采集(系统触发)";
		public final static String JOB_NAME_2001 = "本地华为交易日数据整合(系统触发)";
		public final static String JOB_NAME_2003 = "第三方支付渠道支付宝数据整合(系统触发)";
		public final static String JOB_NAME_2004 = "第三方支付渠道微信数据整合(系统触发)";
		public final static String JOB_NAME_2005 = "第三方票务数据整合(系统触发)";
		public final static String JOB_NAME_2006 = "第三方支付咪咕一级支付数据整合(系统触发)";
		public final static String JOB_NAME_3001 = "本地交易与第三方支付渠道数据每日自动稽核(系统触发)";
		public final static String JOB_NAME_3002 = "生成分账数据(系统触发)";
		public final static String JOB_NAME_3004 = "咪咕影院订单数据自动稽核(系统触发)";
		public final static String JOB_NAME_3005 = "咪咕直播数据自动稽核(系统触发)";
		public final static String JOB_NAME_4001 = "咪咕影票与三方影票数据自动结算(系统触发)";
		public final static String JOB_NAME_6001 = "影票报表_购票日对账报表(系统触发)";
		public final static String JOB_NAME_6002 = "影票报表_影票订单支付数据日报表(系统触发)";
		public final static String JOB_NAME_6003 = "影票报表_退款影票详单报表(系统触发)";
		
		public final static String JOB_NAME_1051 = "本地华为交易日数据采集(页面触发)";
		public final static String JOB_NAME_1052 = "本地华为订单日数据采集(页面触发)";
		public final static String JOB_NAME_1054 = "第三方支付-支付宝数据采集(页面触发)";
		public final static String JOB_NAME_1055 = "第三方支付-微信数据采集(页面触发)";
		public final static String JOB_NAME_1056 = "咪咕影院订单数据采集(页面触发)";
		public final static String JOB_NAME_1057 = "电子码平台数据采集(页面触发)";
		public final static String JOB_NAME_1058 = "咪咕一级支付数据采集(页面触发)";
		public final static String JOB_NAME_1059 = "咪咕直播数据采集(页面触发)";
		public final static String JOB_NAME_1060 = "咪咕账户中心直播数据采集(页面触发)";
		public final static String JOB_NAME_2051 = "本地华为日交易数据整合(页面触发)";
		public final static String JOB_NAME_2053 = "第三方支付渠道支付宝数据整合(页面触发)";
		public final static String JOB_NAME_2054 = "第三方支付渠道微信数据整合(页面触发)";
		public final static String JOB_NAME_2055 = "第三方票务数据整合(页面触发)";
		//public final static String JOB_NAME_2056 = "第三方票务(蜘蛛票)数据整合(页面触发)";
		public final static String JOB_NAME_2056 = "第三方支付咪咕一级支付数据整合(页面触发)";
		public final static String JOB_NAME_3051 = "本地交易与第三方支付渠道数据日稽核(页面触发)";
		public final static String JOB_NAME_3052 = "生成分账数据(系统触发)";
		public final static String JOB_NAME_3053 = "关闭账期(页面触发)";
		public final static String JOB_NAME_3054 = "咪咕影院订单数据稽核(页面触发)";
		public final static String JOB_NAME_3055 = "咪咕直播数据稽核(页面触发)";
		public final static String JOB_NAME_4051 = "咪咕影票与三方影票数据结算(页面触发)";
		public final static String JOB_NAME_6051 = "影票报表_购票日对账报表(页面触发)";
		public final static String JOB_NAME_6052 = "影票报表_影票订单支付数据日报表(页面触发)";
		public final static String JOB_NAME_6053 = "影票报表_退款影票详单报表(页面触发)";
		
		public final static String LOG_MSG_CLOSE_ACCOUNT_TERM = "没有相应账期或本账期已关闭,无法采集源数据";

	}
	
	public static final class TASK_SCHEDULER {
		public static final class TASK_STATUS {//任务计划状态
			public final static Integer TASK_STATUS_CLOSE = 0;// 任务计划状态(0:关闭)
			public final static Integer TASK_STATUS_OPEN = 1;// 任务计划状态(1:启用)
		}
		
		public static final class PERIOD_TYPE {//执行周期
			public final static Integer PERIOD_TYPE_ONCE = 0;// 执行周期(0:一次性)
			public final static Integer PERIOD_TYPE_EVERYHOUR = 1;// 执行周期(1:每小时)
			public final static Integer PERIOD_TYPE_EVERYDAY = 2;// 执行周期(2:每日)
			public final static Integer PERIOD_TYPE_EVERYWEEK = 3;// 执行周期(3:每周)
			public final static Integer PERIOD_TYPE_EVERYMONTH = 4;// 执行周期(4:每月)
			public final static Integer PERIOD_TYPE_EVERYYEAR = 5;// 执行周期(5:每年)
		}
		
		public static final class LAST_RUN_STATUS {//最近一次执行状态
			public final static Integer LAST_RUN_STATUS_UNDO = 0;// 最近一次执行状态(0:未执行)
			public final static Integer LAST_RUN_STATUS_DOING = 1;// 最近一次执行状态(1:执行中)
			public final static Integer LAST_RUN_STATUS_DONE = 2;// 最近一次执行状态(2:执行结束)
		}
		
		public static final class TASK_TYPE {//任务计划类型
			public final static Integer TASK_TYPE_1001 = 1001;// 任务计划类型(1001:影票报表)
		}
		
	}
	
	public static final class RPT {
		public static final class THEATRE_ORDER_RPT {
			public final static String THEATRE_ORDER_RPT_PATH = "/mnt/nfs/hw/theatre/rptdata";
			public final static String THEATRE_ORDER_RPT_DATA_FIELD_SEPARATOR = "\t";
			
			public static final class THEATRE_ORDER_RPT_NAME {
				public final static String RPT_SCHEDULER_NAME = "T_TASK_REPORT_SCHEDULER";//报表任务计划表
				public final static String RPT_THEATRE_ORDER_DETAIL = "T_RPT_THEATRE_ORDER_DETAIL";//影票报表_购票日对账报表
				public final static String RPT_THEATRE_ORDER_DETAIL_RCS = "RCS-Order-10301";//影票报表_购票日对账报表
				public final static String RPT_THEATRE_ORDER_PAYMENT_DETAIL = "T_RPT_THEATRE_ORDER_PAYMENT_DETAIL"; //影票报表_影票订单支付数据日报表
				public final static String RPT_THEATRE_ORDER_PAYMENT_RCS = "RCS-Payment-10302"; //影票报表_影票订单支付数据日报表
				public final static String RPT_THEATRE_REFUND_ORDER_DETAIL = "T_RPT_THEATRE_REFUND_ORDER_DETAIL"; //影票报表_退款影票详单报表
				public final static String RPT_THEATRE_REFUND_ORDER_RCS = "RCS-Refund-10303"; //影票报表_退款影票详单报表
			}
		}
	}

	public static final class AccountTerm {
		public final static Integer ACCOUNT_TERM_UNDO = 1;// 调账类型(1:未调账)
		public final static Integer ACCOUNT_TERM_ADD_FLOW = 2;// 作业执行状态(2:新增流水)
		public final static Integer ACCOUNT_TERM_DEL_FLOW = 3;// 作业执行状态(3:删除流水)
		public final static Integer ACCOUNT_TERM_UPDATE_FEE = 4;// 作业执行状态(4:金额修改)

		public final static Integer ACCOUNT_TERM_OPEN = 0;// 是否关闭账期(0:非关帐)
		public final static Integer ACCOUNT_TERM_CLOSE = 1;// 是否关闭账期(1:关帐)

		public final static Integer AUDIT_ORDER_RESULT_UNDO = 0; // 稽核结果(0:未稽核)
		public final static Integer AUDIT_ORDER_RESULT_FAIR_BILL = 1; // 稽核结果(1:平帐)
		public final static Integer AUDIT_ORDER_RESULT_UNFAIR_BILL = 2; // 稽核结果(2:非平帐)

		public final static Integer AccountTermBeginDayOfMonth = 25;// 账期每月开始时间
		public final static Integer AccountTermEndDayOfMonth = 24;// 账期每月结束时间
	}

	public static final class Time {
		public final static String BEGINTIME_HOUR_MINUTE_SECOND = " 00:00:00"; // 开始时间
		public final static String ENDTIME_HOUR_MINUTE_SECOND = " 23:59:59"; // 结束时间
	}

	public static final class OrderPaymentIntegration {
		public final static Integer PAYMENT_CHANNEL_TYPE_ALIPAY = 1;// 支付渠道类型(1:支付宝)
		public final static Integer PAYMENT_CHANNEL_TYPE_WEIXIN = 2;// 支付渠道类型(2:微信)
		public final static Integer PAYMENT_TYPE_PAY = 1;// 支付流水类型(1:支付)
		public final static Integer PAYMENT_TYPE_REFUND = 2;// 支付流水类型(2:退款)
		public final static String LINE_SEPARATOR = "|";//字段分隔符
	}

	public static final class AuditOrder {
		public final static Integer AUDIT_ORDER_RESULT_UNFAIR_BILL = 0; // 稽核结果(0:非平帐)
		public final static Integer AUDIT_ORDER_RESULT_FAIR_BILL = 1; // 稽核结果(1:平帐)
		public final static Integer AUDIT_ORDER_RESULT_MORE_LOCAL_BILL = 2; // 稽核结果(2:本地交易流水多)
		public final static Integer AUDIT_ORDER_RESULT_MORE_THIRD_BILL = 3; // 稽核结果(3:第三方交易流水多)
		public final static Integer AUDIT_ORDER_RESULT_DIFF_FEE_BILL = 4; // 稽核结果(4:两边交易金额不一致)
		public final static Integer AUDIT_ORDER_RESULT_CANNOT_AUDIT = 9; // 稽核结果(9:非人民币交易无法稽核)

		public final static Integer AUDIT_PAYMENT_TYPE_PAY = 1;// 支付流水类型(1:支付)
		public final static Integer AUDIT_PAYMENT_TYPE_REFUND = 2;// 支付流水类型(2:退款)
		public final static String AUDIT_PAYMENT_TYPE_PAY_1 = "支付";// 支付流水类型(1:支付)
		public final static String AUDIT_PAYMENT_TYPE_REFUND_2 ="退款";// 支付流水类型(2:退款)

		public final static Integer AUDIT_PAY_CHANNEL_ORDER_STATUS_1 = 1;// 支付渠道支付(/退款)状态(1:成功)
		public final static Integer AUDIT_PAY_CHANNEL_ORDER_STATUS_0 = 0;// 支付渠道支付(/退款)状态(0:失败)
		public final static String AUDIT_PAY_CHANNEL_ORDER_STATUS_SUCCESS ="成功";// 支付渠道支付(/退款)状态(1:成功)
		public final static String AUDIT_PAY_CHANNEL_ORDER_STATUS_FAIL ="失败";// 支付渠道支付(/退款)状态(0:失败)
		
		public final static Integer ORDER_STATUS_PAYMENT_FALSE = 1;// 支付状态：1：支付失败
		public final static Integer ORDER_STATUS_PAYMENT_SUCCESS = 3;// 支付状态：3：完成支付
		public final static Integer ORDER_STATUS_PAYMENT_CANCEL = 4;// 支付状态：4：交易取消
		public final static Integer ORDER_STATUS_PAYMENT_TIMEOUT = 14;// 支付状态：14：支付超时
		public final static Integer ORDER_STATUS_REFUND_FALSE = 1;// 退款状态：1：退款失败
		public final static Integer ORDER_STATUS_REFUND_SUCCESS = 0;// 退款状态：0：退款成功
		public final static Integer ORDER_STATUS_REFUND_FALSE_NEW = 16;// 退款状态：16：退款失败
		public final static Integer ORDER_STATUS_REFUND_SUCCESS_NEW = 4;// 退款状态：4：退款成功
		
		public final static String ORDER_STATUS_PAYMENT_FALSE_1 = "支付失败";// 支付状态：1：支付失败
		public final static String ORDER_STATUS_PAYMENT_SUCCESS_3 = "完成支付";// 支付状态：3：完成支付
		public final static String ORDER_STATUS_PAYMENT_CANCEL_4 = "交易取消";// 支付状态：4：交易取消
		public final static String ORDER_STATUS_PAYMENT_TIMEOUT_14 = "支付超时";// 支付状态：14：支付超时
		
		public final static Integer ORDER_STATUS_PAYMENT_0 = 0;//订单状态：草稿状态
		public final static String ORDER_STATUS_PAYMENT_0_WZ = "草稿状态";//订单状态：草稿状态
		public final static Integer ORDER_STATUS_PAYMENT_1 = 1;//
		public final static String ORDER_STATUS_PAYMENT_1_WZ = "已提交状态";//
		public final static Integer ORDER_STATUS_PAYMENT_2 = 2;//
		public final static String ORDER_STATUS_PAYMENT_2_WZ = "异步支付，正在等待支付";//
		public final static Integer ORDER_STATUS_PAYMENT_3 = 3;//
		public final static String ORDER_STATUS_PAYMENT_3_WZ = "已支付状态";//
		public final static Integer ORDER_STATUS_PAYMENT_4 = 4;//
		public final static String ORDER_STATUS_PAYMENT_4_WZ = "取消状态";//
		public final static Integer ORDER_STATUS_PAYMENT_5 = 5;//
		public final static String ORDER_STATUS_PAYMENT_5_WZ = "完成状态";//
		public final static Integer ORDER_STATUS_PAYMENT_6 = 6;//
		public final static String ORDER_STATUS_PAYMENT_6_WZ = "履约状态，已触发履约事件";//
		public final static Integer ORDER_STATUS_PAYMENT_7 = 7;//
		public final static String ORDER_STATUS_PAYMENT_7_WZ = "订单退订中";//
		public final static Integer ORDER_STATUS_PAYMENT_8 = 8;//
		public final static String ORDER_STATUS_PAYMENT_8_WZ = "订单已退订";//
		public final static Integer ORDER_STATUS_PAYMENT_9 = 9;//
		public final static String ORDER_STATUS_PAYMENT_9_WZ = "已支付未履约状态";//
		public final static Integer ORDER_STATUS_PAYMENT_10 = 10;//
		public final static String ORDER_STATUS_PAYMENT_10_WZ = "履约失败退款中";//
		public final static Integer ORDER_STATUS_PAYMENT_11 = 11;//
		public final static String ORDER_STATUS_PAYMENT_11_WZ = "cancelOrder退款中（不能重新发起cancelOrder）";//
		public final static Integer ORDER_STATUS_PAYMENT_12 = 12;//
		public final static String ORDER_STATUS_PAYMENT_12_WZ = "已退款未退履约（不能重新发起cancelOrder）";//
		public final static Integer ORDER_STATUS_PAYMENT_13 = 13;//
		public final static String ORDER_STATUS_PAYMENT_13_WZ = "已退款退履约中（不能重新发起cancelOrder）";//
		public final static Integer ORDER_STATUS_PAYMENT_14 = 14;//
		public final static String ORDER_STATUS_PAYMENT_14_WZ = "订单已取消";//
		public final static Integer ORDER_STATUS_PAYMENT_15 = 15;//
		public final static String ORDER_STATUS_PAYMENT_15_WZ = "已退款退履约失败（不能重新发起cancelOrder）";//
		public final static Integer ORDER_STATUS_PAYMENT_16 = 16;//
		public final static String ORDER_STATUS_PAYMENT_16_WZ = "未退款已退履约（不能重新发起cancelOrder）";//
		public final static Integer ORDER_STATUS_PAYMENT_17 = 17;//
		public final static String ORDER_STATUS_PAYMENT_17_WZ = "未退款退履约中（不能重新发起cancelOrder）";//
		public final static Integer ORDER_STATUS_PAYMENT_101 = 101;//
		public final static String ORDER_STATUS_PAYMENT_101_WZ = "支付失败101（可重新发起支付）";//
		public final static Integer ORDER_STATUS_PAYMENT_102 = 102;//
		public final static String ORDER_STATUS_PAYMENT_102_WZ = "订购失败（支付成功后履约失败，退款成功，无法重新发起支付)";//
		public final static Integer ORDER_STATUS_PAYMENT_501 = 501;//
		public final static String ORDER_STATUS_PAYMENT_501_WZ = "退款失败未退履约（可重新发起cancelOrder）";//
		public final static Integer ORDER_STATUS_PAYMENT_502 = 502;//
		public final static String ORDER_STATUS_PAYMENT_502_WZ = "未退款退履约失败（可重新发起cancelOrder）";//
		public final static Integer ORDER_STATUS_PAYMENT_20 = 20;//
		public final static String ORDER_STATUS_PAYMENT_20_WZ = "订单超时关闭";//
		public final static Integer ORDER_STATUS_PAYMENT_21 = 21;//
		public final static String ORDER_STATUS_PAYMENT_21_WZ = "订单超时退款中";//
		public final static Integer ORDER_STATUS_PAYMENT_22 = 22;//
		public final static String ORDER_STATUS_PAYMENT_22_WZ = "订单超时退款失败";//

		private static Map<Integer, String> orderStatus = null;
		static {
			if (orderStatus == null) {
				orderStatus = new HashMap<Integer, String>();
				orderStatus.put(ORDER_STATUS_PAYMENT_FALSE, ORDER_STATUS_PAYMENT_FALSE_1);
				orderStatus.put(ORDER_STATUS_PAYMENT_SUCCESS, ORDER_STATUS_PAYMENT_SUCCESS_3);
				orderStatus.put(ORDER_STATUS_PAYMENT_CANCEL, ORDER_STATUS_PAYMENT_CANCEL_4);
				orderStatus.put(ORDER_STATUS_PAYMENT_TIMEOUT, ORDER_STATUS_PAYMENT_TIMEOUT_14);
				orderStatus.put(AUDIT_PAYMENT_TYPE_PAY,AUDIT_PAYMENT_TYPE_PAY_1);
				orderStatus.put(AUDIT_PAYMENT_TYPE_REFUND,AUDIT_PAYMENT_TYPE_REFUND_2);
				orderStatus.put(AUDIT_PAY_CHANNEL_ORDER_STATUS_1,AUDIT_PAY_CHANNEL_ORDER_STATUS_SUCCESS);
				orderStatus.put(AUDIT_PAY_CHANNEL_ORDER_STATUS_0,AUDIT_PAY_CHANNEL_ORDER_STATUS_FAIL);
				orderStatus.put(ORDER_STATUS_PAYMENT_0,ORDER_STATUS_PAYMENT_0_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_1,ORDER_STATUS_PAYMENT_1_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_2,ORDER_STATUS_PAYMENT_2_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_3,ORDER_STATUS_PAYMENT_3_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_4,ORDER_STATUS_PAYMENT_4_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_5,ORDER_STATUS_PAYMENT_5_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_6,ORDER_STATUS_PAYMENT_6_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_7,ORDER_STATUS_PAYMENT_7_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_8,ORDER_STATUS_PAYMENT_8_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_9,ORDER_STATUS_PAYMENT_9_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_10,ORDER_STATUS_PAYMENT_10_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_11,ORDER_STATUS_PAYMENT_11_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_12,ORDER_STATUS_PAYMENT_12_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_13,ORDER_STATUS_PAYMENT_13_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_14,ORDER_STATUS_PAYMENT_14_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_15,ORDER_STATUS_PAYMENT_15_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_16,ORDER_STATUS_PAYMENT_16_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_17,ORDER_STATUS_PAYMENT_17_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_101,ORDER_STATUS_PAYMENT_101_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_102,ORDER_STATUS_PAYMENT_102_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_501,ORDER_STATUS_PAYMENT_501_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_502,ORDER_STATUS_PAYMENT_502_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_20,ORDER_STATUS_PAYMENT_20_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_21,ORDER_STATUS_PAYMENT_21_WZ);
				orderStatus.put(ORDER_STATUS_PAYMENT_22,ORDER_STATUS_PAYMENT_22_WZ);
			}
		}

		public static Map<Integer, String> getOrderStatus() {
			return orderStatus;
		}

		public final static Integer CURRENCY_156 = 156;// 货币类型：156：人民币
		public final static String CURRENCY_RMB = "人民币";// 货币类型：156：人民币

		public final static String AUDIT_ORDER_RESULT_UNFAIR_BILL_0 = "非平帐"; // 稽核结果(0:非平帐)
		public final static String AUDIT_ORDER_RESULT_FAIR_BILL_1 = "平帐"; // 稽核结果(1:平帐)
		public final static String AUDIT_ORDER_RESULT_MORE_LOCAL_BILL_2 = "本地交易流水多"; // 稽核结果(2:本地交易流水多)
		public final static String AUDIT_ORDER_RESULT_MORE_THIRD_BILL_3 = "第三方交易流水多"; // 稽核结果(3:第三方交易流水多)
		public final static String AUDIT_ORDER_RESULT_DIFF_FEE_BILL_4 = "两边交易金额不一致"; // 稽核结果(4:两边交易金额不一致)
		public final static String AUDIT_ORDER_RESULT_CANNOT_AUDIT_9 = "非人民币交易无法稽核"; // 稽核结果(9:非人民币交易无法稽核)

		private static Map<Integer, String> auditDealResult = null;
		static {
			if (auditDealResult == null) {
				auditDealResult = new HashMap<Integer, String>();
				auditDealResult.put(AUDIT_ORDER_RESULT_FAIR_BILL, AUDIT_ORDER_RESULT_FAIR_BILL_1);
				auditDealResult.put(AUDIT_ORDER_RESULT_MORE_LOCAL_BILL, AUDIT_ORDER_RESULT_MORE_LOCAL_BILL_2);
				auditDealResult.put(AUDIT_ORDER_RESULT_MORE_THIRD_BILL, AUDIT_ORDER_RESULT_MORE_THIRD_BILL_3);
				auditDealResult.put(AUDIT_ORDER_RESULT_DIFF_FEE_BILL, AUDIT_ORDER_RESULT_DIFF_FEE_BILL_4);
			}
		}

		public static Map<Integer, String> getAuditDealResult() {
			return auditDealResult;
		}
		
		private static Map<String, Integer> auditPaymentType = new HashMap<String, Integer>();

		static {
			if (auditPaymentType == null) {
				auditPaymentType = new HashMap<String, Integer>();
				auditPaymentType.put(Constant.ALIPAY.TRANS_CODE_MSG.TYPE_ONLINEPAYMENT, AUDIT_PAYMENT_TYPE_PAY);
				auditPaymentType.put(Constant.ALIPAY.TRANS_CODE_MSG.TYPE_TRANSFER_ACCOUNT, AUDIT_PAYMENT_TYPE_REFUND);
				
			}
		}

		public static Map<String, Integer> getAuditpaymenttype() {
			return auditPaymentType;
		}
		
		public static final Integer PAY_CHANNEL_SOURCE_ALI = 1;//比对数据来源 1:支付宝
		public static final Integer PAY_CHANNEL_SOURCE_WEIXIN = 2;//比对数据来源  2:微信
		public static final Integer PAY_CHANNEL_SOURCE_APPLE = 3;//比对数据来源 3:苹果
		public static final Integer PAY_CHANNEL_SOURCE_MIGU = 4;//比对数据来源 4:咪咕一级支付
		public static final Integer PAY_CHANNEL_SOURCE_OTHER = 9;//比对数据来源 9:其他
		public static final String PAY_CHANNEL_SOURCE_ALI_1 = "支付宝";//比对数据来源 1:支付宝
		public static final String PAY_CHANNEL_SOURCE_WEIXIN_2 = "微信";//比对数据来源  2:微信
		public static final String PAY_CHANNEL_SOURCE_APPLE_3 = "苹果";//比对数据来源 3:苹果
		public static final String PAY_CHANNEL_SOURCE_MIGU_4 = "咪咕一级支付";//比对数据来源 4:咪咕一级支付
		private static Map<Integer, String> transMap = null;
		
		static{
			if(transMap==null){
				transMap=new HashMap<Integer,String>();
				transMap.put(PAY_CHANNEL_SOURCE_ALI, PAY_CHANNEL_SOURCE_ALI_1);
				transMap.put(PAY_CHANNEL_SOURCE_WEIXIN, PAY_CHANNEL_SOURCE_WEIXIN_2);
				transMap.put(PAY_CHANNEL_SOURCE_APPLE, PAY_CHANNEL_SOURCE_APPLE_3);
				transMap.put(PAY_CHANNEL_SOURCE_MIGU, PAY_CHANNEL_SOURCE_MIGU_4);
			}
		}
		public static Map<Integer, String> gettransMap(){
			return transMap;
		}
		

	}

	public static final class PaymentChannelType {
		public final static Integer PAYMENT_CHANNEL_TYPE_UNREAL = 16;// (16:payment虚拟货币支付方式
		public final static Integer PAYMENT_CHANNEL_TYPE_ALI_MOBILE = 17;// 17:支付宝手机客户端支付，对应支付宝“手机网站支付”产品
		public final static Integer PAYMENT_CHANNEL_TYPE_ALI_WEB = 23;// 23:支付宝web即时到账支付
		public final static Integer PAYMENT_CHANNEL_TYPE_APP = 26;// 26:Appstore支付（验证receipt）
		public final static Integer PAYMENT_CHANNEL_TYPE_28 = 28;// 28:联通号码话费扣费
		public final static Integer PAYMENT_CHANNEL_TYPE_ALI_SDK = 44;// 44:支付宝SDK支付
		public final static Integer PAYMENT_CHANNEL_TYPE_50 = 50;// 50:话费点播支付
		public final static Integer PAYMENT_CHANNEL_TYPE_WEIXIN_SDK = 55;// 55:微信SDK支付
		public final static Integer PAYMENT_CHANNEL_TYPE_57 = 57;// 57:Payment虚拟货币支付
		public final static Integer PAYMENT_CHANNEL_TYPE_58 = 58;// 58:咪咕一级支付
		public final static Integer PAYMENT_CHANNEL_TYPE_MIGU = 59;// 59:咪咕SDK支付
		public final static Integer PAYMENT_CHANNEL_TYPE_60 = 60;// 60:电信IAP SDK支付
		public final static Integer PAYMENT_CHANNEL_TYPE_ALI_WITHHOLDING = 61;// 61:支付宝代扣费
		public final static Integer PAYMENT_CHANNEL_TYPE_62 = 62;// 62:银视通支付
		public final static Integer PAYMENT_CHANNEL_TYPE_63 = 63;// 63:浦发银行先看后付
		public final static Integer PAYMENT_CHANNEL_TYPE_ALI_SCAN_CODE = 300;// 300:支付宝扫码支付
		public final static Integer PAYMENT_CHANNEL_TYPE_WEIXIN_SCAN_CODE = 301;//301:微信扫码支付
		public final static Integer PAYMENT_CHANNEL_TYPE_302 = 302;//302:阳光计划话费支付
		public final static Integer PAYMENT_CHANNEL_TYPE_ALI_SCAN_CODE_IMMEDIATE_ACCOUNT = 303;// 303:支付宝扫码即时到账支付
		public final static Integer PAYMENT_CHANNEL_TYPE_304 = 304;// 304:网状网支付
		public final static Integer PAYMENT_CHANNEL_TYPE_305 = 305;// 305:浦发银行快捷支付
		
		public final static String PAYMENT_CHANNEL_TYPE_UNREAL_16 = "虚拟货币支付方式";
		public final static String PAYMENT_CHANNEL_TYPE_ALI_MOBILE_17 = "支付宝手机客户端支付";
		public final static String PAYMENT_CHANNEL_TYPE_ALI_WEB_23 = "支付宝web即时到账支付";
		public final static String PAYMENT_CHANNEL_TYPE_APP_26 = "Appstore支付";
		public final static String PAYMENT_CHANNEL_TYPE_ALI_SDK_44 = "支付宝SDK支付 ";
		public final static String PAYMENT_CHANNEL_TYPE_WEIXIN_SDK_55 = "微信SDK支付";
		public final static String PAYMENT_CHANNEL_TYPE_MIGU_59 = "咪咕SDK支付";
		public final static String PAYMENT_CHANNEL_TYPE_ALI_WITHHOLDING_61 = "支付宝代扣费";
		public final static String PAYMENT_CHANNEL_TYPE_ALI_SCAN_CODE_300 = "支付宝扫码支付";
		public final static String PAYMENT_CHANNEL_TYPE_WEIXIN_SCAN_CODE_301 = "微信扫码支付";
		public final static String PAYMENT_CHANNEL_TYPE_ALI_SCAN_CODE_IMMEDIATE_ACCOUNT_303 = "支付宝扫码即时到账支付";
		
		public final static String PAYMENT_CHANNEL_TYPE_28_VALUE = "联通号码话费扣费";//28:联通号码话费扣费
		public final static String PAYMENT_CHANNEL_TYPE_50_VALUE = "话费点播支付";//50:话费点播支付
		public final static String PAYMENT_CHANNEL_TYPE_57_VALUE = "Payment虚拟货币支付";//57:Payment虚拟货币支付
		public final static String PAYMENT_CHANNEL_TYPE_58_VALUE = "咪咕一级支付";//58:咪咕一级支付
		public final static String PAYMENT_CHANNEL_TYPE_60_VALUE = "电信IAP SDK支付";//60:电信IAP SDK支付
		public final static String PAYMENT_CHANNEL_TYPE_62_VALUE = "银视通支付";//62:银视通支付
		public final static String PAYMENT_CHANNEL_TYPE_63_VALUE = "浦发银行先看后付";//63:浦发银行先看后付
		public final static String PAYMENT_CHANNEL_TYPE_302_VALUE = "阳光计划话费支付";//302:阳光计划话费支付
		public final static String PAYMENT_CHANNEL_TYPE_304_VALUE = "网状网支付";//304:网状网支付
		public final static String PAYMENT_CHANNEL_TYPE_305_VALUE = "浦发银行快捷支付";//305:浦发银行快捷支付
		
		private static Map<Integer, String> paymentchanneltype = null;
		static {
			if (paymentchanneltype == null) {
				paymentchanneltype = new HashMap<Integer, String>();
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_UNREAL, PAYMENT_CHANNEL_TYPE_UNREAL_16);// (16:payment虚拟货币支付方式
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_ALI_MOBILE, PAYMENT_CHANNEL_TYPE_ALI_MOBILE_17);// 17:支付宝手机客户端支付，对应支付宝“手机网站支付”产品
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_ALI_WEB, PAYMENT_CHANNEL_TYPE_ALI_WEB_23);// 23:支付宝web即时到账支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_APP, PAYMENT_CHANNEL_TYPE_APP_26);// 26:Appstore支付（验证receipt）
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_ALI_SDK, PAYMENT_CHANNEL_TYPE_ALI_SDK_44);// 44:支付宝SDK支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_WEIXIN_SDK, PAYMENT_CHANNEL_TYPE_WEIXIN_SDK_55);//55:微信SDK支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_MIGU, PAYMENT_CHANNEL_TYPE_MIGU_59);// 59:咪咕SDK支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_ALI_WITHHOLDING, PAYMENT_CHANNEL_TYPE_ALI_WITHHOLDING_61);// 61:支付宝代扣费
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_ALI_SCAN_CODE, PAYMENT_CHANNEL_TYPE_ALI_SCAN_CODE_300);// 300:支付宝扫码支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_WEIXIN_SCAN_CODE, PAYMENT_CHANNEL_TYPE_WEIXIN_SCAN_CODE_301);//301:微信扫码支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_ALI_SCAN_CODE_IMMEDIATE_ACCOUNT, PAYMENT_CHANNEL_TYPE_ALI_SCAN_CODE_IMMEDIATE_ACCOUNT_303);// 303:支付宝扫码即时到账支付
				
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_28, PAYMENT_CHANNEL_TYPE_28_VALUE);// 28:联通号码话费扣费
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_50, PAYMENT_CHANNEL_TYPE_50_VALUE);// 50:话费点播支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_57, PAYMENT_CHANNEL_TYPE_57_VALUE);// 57:Payment虚拟货币支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_58, PAYMENT_CHANNEL_TYPE_58_VALUE);// 58:咪咕一级支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_60, PAYMENT_CHANNEL_TYPE_60_VALUE);// 60:电信IAP SDK支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_62, PAYMENT_CHANNEL_TYPE_62_VALUE);// 62:银视通支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_63, PAYMENT_CHANNEL_TYPE_63_VALUE);// 63:浦发银行先看后付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_302, PAYMENT_CHANNEL_TYPE_302_VALUE);// 302:阳光计划话费支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_304, PAYMENT_CHANNEL_TYPE_304_VALUE);// 304:网状网支付
				paymentchanneltype.put(PAYMENT_CHANNEL_TYPE_305, PAYMENT_CHANNEL_TYPE_305_VALUE);// 305:浦发银行快捷支付
			}
		}
		
		public static Map<Integer, String> getPaymentchanneltype() {
			return paymentchanneltype;
		}
	}
	
	//支付状态
	public  static final class  PayStatus{
		public final static Integer PAY_STATUS_1 = 1;//未支付/支付失败
		public final static String PAY_STATUS_1_WZ = "未支付/支付失败";
		public final static Integer PAY_STATUS_2 = 2;//预支付（已付款，待发货）
		public final static String PAY_STATUS_2_WZ = "预支付（已付款，待发货）";
		public final static Integer PAY_STATUS_3 = 3;//完成支付（已付款，已发货）
		public final static String PAY_STATUS_3_WZ = "完成支付（已付款，已发货）";
		public final static Integer PAY_STATUS_4 = 4;//交易已取消(退款成功)
		public final static String PAY_STATUS_4_WZ = "交易已取消(退款成功)";
		public final static Integer PAY_STATUS_5 = 5;//确认支付失败（暂不支持）
		public final static String PAY_STATUS_5_WZ = "确认支付失败（暂不支持）";
		public final static Integer PAY_STATUS_6 = 6;//预支付中
		public final static String PAY_STATUS_6_WZ = "预支付中";
		public final static Integer PAY_STATUS_7 = 7;//预完成支付中（暂不支持）
		public final static String PAY_STATUS_7_WZ = "预完成支付中（暂不支持）";
		public final static Integer PAY_STATUS_8 = 8;//取消支付中（暂不支持）
		public final static String PAY_STATUS_8_WZ = "取消支付中（暂不支持）";
		public final static Integer PAY_STATUS_9 = 9;//交易已取消（退款失败）（暂不支持）
		public final static String PAY_STATUS_9_WZ = "交易已取消（退款失败）（暂不支持）";
		public final static Integer PAY_STATUS_10 = 10;//交易已取消（退款失败）（暂不支持）
		public final static String PAY_STATUS_10_WZ = "交易已取消（退款失败）（暂不支持）";
		public final static Integer PAY_STATUS_11 = 11;//挂起（仅循环支付）（暂不支持）
		public final static String PAY_STATUS_11_WZ = "挂起（仅循环支付）（暂不支持）";
		public final static Integer PAY_STATUS_12 = 12;//暂停（仅循环支付）（暂不支持）
		public final static String PAY_STATUS_12_WZ = "暂停（仅循环支付）（暂不支持）";
		public final static Integer PAY_STATUS_13 = 13;//退款中
		public final static String PAY_STATUS_13_WZ = "退款中";
		public final static Integer PAY_STATUS_14 = 14;//支付超时
		public final static String PAY_STATUS_14_WZ = "支付超时";
		public final static Integer PAY_STATUS_15 = 15;//确认支付中
		public final static String PAY_STATUS_15_WZ = "确认支付中";
		public final static Integer PAY_STATUS_16 = 16;//退款失败
		public final static String PAY_STATUS_16_WZ = "退款失败";
		private static Map<Integer,String> payStatusMap = null;
		static{
			if(payStatusMap == null){
				payStatusMap = new HashMap<Integer,String>();
				payStatusMap.put(PAY_STATUS_1, PAY_STATUS_1_WZ);
				payStatusMap.put(PAY_STATUS_2, PAY_STATUS_2_WZ);
				payStatusMap.put(PAY_STATUS_3, PAY_STATUS_3_WZ);
				payStatusMap.put(PAY_STATUS_4, PAY_STATUS_4_WZ);
				payStatusMap.put(PAY_STATUS_5, PAY_STATUS_5_WZ);
				payStatusMap.put(PAY_STATUS_6, PAY_STATUS_6_WZ);
				payStatusMap.put(PAY_STATUS_7, PAY_STATUS_7_WZ);
				payStatusMap.put(PAY_STATUS_8, PAY_STATUS_8_WZ);
				payStatusMap.put(PAY_STATUS_9, PAY_STATUS_9_WZ);
				payStatusMap.put(PAY_STATUS_10, PAY_STATUS_10_WZ);
				payStatusMap.put(PAY_STATUS_11, PAY_STATUS_11_WZ);
				payStatusMap.put(PAY_STATUS_12, PAY_STATUS_12_WZ);
				payStatusMap.put(PAY_STATUS_13, PAY_STATUS_13_WZ);
				payStatusMap.put(PAY_STATUS_14, PAY_STATUS_14_WZ);
				payStatusMap.put(PAY_STATUS_15, PAY_STATUS_15_WZ);
				payStatusMap.put(PAY_STATUS_16, PAY_STATUS_16_WZ);				
			}
		}
		public static Map<Integer, String> getPayStatusMap() {
			return payStatusMap;
		}
		public static void setPayStatusMap(Map<Integer, String> payStatusMap) {
			PayStatus.payStatusMap = payStatusMap;
		}
	}
	
	//支付类型
	public  static final class  PayType{
		public final static String PLATFORM_ALIPAY_WZ = "支付宝";// 支付宝
		public final static String PLATFORM_APPLE_WZ = "苹果支付";// 苹果支付
		public final static String PLATFORM_WEIXIN_WZ = "微信支付";// 微信支付
		public final static String PLATFORM_MIGU_WZ = "咪咕支付";// 咪咕支付
		private static Map<String,String> payTypeMap = null;
		static{
			if(payTypeMap == null){
				payTypeMap = new HashMap<String,String>();
				payTypeMap.put(CollectData.PLATFORM_ALIPAY, PLATFORM_ALIPAY_WZ);
				payTypeMap.put(CollectData.PLATFORM_APPLE, PLATFORM_APPLE_WZ);
				payTypeMap.put(CollectData.PLATFORM_WEIXIN, PLATFORM_WEIXIN_WZ);
				payTypeMap.put(CollectData.PLATFORM_MIGU, PLATFORM_MIGU_WZ);
			}
		}
		public static Map<String, String> getPayTypeMap() {
			return payTypeMap;
		}
		public static void setPayTypeMap(Map<String, String> payTypeMap) {
			PayType.payTypeMap = payTypeMap;
		}
	}
	
	//微票订单状态
	public static final class wpOrderStatus{
		public final static String WP_REJECT = "退款已驳回";
		public final static Integer WP_REJECT_NO = 0;
		public final static String WP_ISSUE_SUCCESS = "已出票成功";
		public final static Integer WP_ISSUE_SUCCESS_NO = 1;
		public final static String WP_SEND_SUCCESS = "已发码";
		public final static Integer WP_SEND_SUCCESS_NO = 2;
		private static Map<String,Integer> wpOrderStatusMap = null;
		static {
			if(wpOrderStatusMap == null){
				wpOrderStatusMap = new HashMap<String,Integer>();
				wpOrderStatusMap.put(WP_REJECT, WP_REJECT_NO);//0:退款已驳回
				wpOrderStatusMap.put(WP_ISSUE_SUCCESS, WP_ISSUE_SUCCESS_NO);//1:已出票成功
				wpOrderStatusMap.put(WP_SEND_SUCCESS, WP_SEND_SUCCESS_NO);//2:已发码
			}
		}
		public static Map<String, Integer> getWpOrderStatusMap() {
			return wpOrderStatusMap;
		}
		public static void setWpOrderStatusMap(Map<String, Integer> wpOrderStatusMap) {
			wpOrderStatus.wpOrderStatusMap = wpOrderStatusMap;
		}
		
	}
	
	
	//支付货币类型
	public  static final class  Currency{
		public final static Integer CURRENCY_156 = 156;// 
		public final static String CURRENCY_156_WZ ="人民币";
		public final static Integer CURRENCY_1201 = 1201;// 
		public final static String CURRENCY_1201_WZ ="账户余额";
		public final static Integer CURRENCY_1202 = 1202;// 
		public final static String CURRENCY_1202_WZ ="咪咕影院次卡";
		public final static Integer CURRENCY_1203 = 1203;// 
		public final static String CURRENCY_1203_WZ ="咪咕影院金额卡";
		public final static Integer CURRENCY_1204 = 1204;// 
		public final static String CURRENCY_1204_WZ ="积分";
		public final static Integer CURRENCY_1205 = 1205;// 
		public final static String CURRENCY_1205_WZ ="非会员体验券";
		public final static Integer CURRENCY_1206 = 1206;// 
		public final static String CURRENCY_1206_WZ ="咪咕视频积分";
		public final static Integer CURRENCY_1207 = 1207;// 
		public final static String CURRENCY_1207_WZ ="咪咕影院积分";
		public final static Integer CURRENCY_1208 = 1208;// 
		public final static String CURRENCY_1208_WZ ="咪咕直播积分";
		public final static Integer CURRENCY_2000 = 2000;// 
		public final static String CURRENCY_2000_WZ ="非定向按次卡";
		public final static Integer CURRENCY_3000 = 3000;// 
		public final static String CURRENCY_3000_WZ ="非定向金额卡";
		private static Map<Integer,String> currencyTypeMap = null;
		static{
			if(currencyTypeMap == null){
				currencyTypeMap = new HashMap<Integer,String>();
				currencyTypeMap.put(CURRENCY_156, CURRENCY_156_WZ);
				currencyTypeMap.put(CURRENCY_1201, CURRENCY_1201_WZ);
				currencyTypeMap.put(CURRENCY_1202, CURRENCY_1202_WZ);
				currencyTypeMap.put(CURRENCY_1203, CURRENCY_1203_WZ);
				currencyTypeMap.put(CURRENCY_1204, CURRENCY_1204_WZ);
				currencyTypeMap.put(CURRENCY_1205, CURRENCY_1205_WZ);
				currencyTypeMap.put(CURRENCY_1206, CURRENCY_1206_WZ);
				currencyTypeMap.put(CURRENCY_1207, CURRENCY_1207_WZ);
				currencyTypeMap.put(CURRENCY_1208, CURRENCY_1208_WZ);
				currencyTypeMap.put(CURRENCY_2000, CURRENCY_2000_WZ);
				currencyTypeMap.put(CURRENCY_3000, CURRENCY_3000_WZ);
			}
		}
		public static Map<Integer, String> getCurrencyTypeMap() {
			return currencyTypeMap;
		}
		public static void setCurrencyTypeMap(Map<Integer, String> currencyTypeMap) {
			Currency.currencyTypeMap = currencyTypeMap;
		}
	}
	
	//渠道类型
	public  static final class  CHANNEL_TYPE{
		public final static String PAYMENT_CHANNEL_TYPE_ALIPAY = "1";// 支付渠道类型(1:支付宝)
		public final static String PAYMENT_CHANNEL_TYPE_WEIXIN = "2";// 支付渠道类型(2:微信)
		public final static String PAYMENT_CHANNEL_TYPE_ALIPAY_1 = "支付宝";// 支付渠道类型(1:支付宝)
		public final static String PAYMENT_CHANNEL_TYPE_WEIXIN_2 = "微信";// 支付渠道类型(2:微信)
		private static Map<String,String> channelTypeMap = null;
		static{
			if(channelTypeMap == null){
				channelTypeMap = new HashMap<String,String>();
				channelTypeMap.put(PAYMENT_CHANNEL_TYPE_ALIPAY, PAYMENT_CHANNEL_TYPE_ALIPAY_1);
				channelTypeMap.put(PAYMENT_CHANNEL_TYPE_WEIXIN, PAYMENT_CHANNEL_TYPE_WEIXIN_2);
			}
		}
		public static Map<String, String> getChannelTypeMap() {
			return channelTypeMap;
		}
		public static void setChannelTypeMap(Map<String, String> channelTypeMap) {
			CHANNEL_TYPE.channelTypeMap = channelTypeMap;
		}
	}
	
	//咪咕影院订单信息数据:优惠状态
	public  static final class  DISCOUNT_STATUS{
		public final static Integer DISCOUNT_STATUS_0 = 0;
		public final static Integer DISCOUNT_STATUS_1 = 1;		
		public final static String DISCOUNT_STATUS_NORMAL = "正常";
		public final static String DISCOUNT_STATUS_FAVORABLE = "优惠";		
		private static Map<Integer,String> discountStatusMap = null;
		static {
			if(discountStatusMap == null){
				discountStatusMap = new HashMap<Integer,String>();
				discountStatusMap.put(DISCOUNT_STATUS_0, DISCOUNT_STATUS_NORMAL);
				discountStatusMap.put(DISCOUNT_STATUS_1, DISCOUNT_STATUS_FAVORABLE);
			}
		}
		public static Map<Integer, String> getDiscountStatusMap() {
			return discountStatusMap;
		}
		public static void setDiscountStatusMap(Map<Integer, String> discountStatusMap) {
			DISCOUNT_STATUS.discountStatusMap = discountStatusMap;
		}		
	}
	
	//咪咕影院订单信息数据:出票方
	public static final class ACCESSORID{
		public final static Integer ACCESSORID_1 = 1;
		public final static Integer ACCESSORID_2 = 2;
		public final static Integer ACCESSORID_4 = 4;
		public final static String ACCESSORID_ZZ = "蜘蛛网";//1
		public final static String ACCESSORID_WX = "微信";//2
		public final static String ACCESSORID_WD = "万达";//4
		private static Map<Integer,String> accessorIdMap = null;
		static{
			if(accessorIdMap == null){
				accessorIdMap = new HashMap<Integer,String>();
				accessorIdMap.put(ACCESSORID_1, ACCESSORID_ZZ);
				accessorIdMap.put(ACCESSORID_2, ACCESSORID_WX);
				accessorIdMap.put(ACCESSORID_4, ACCESSORID_WD);
			}
		}
		public static Map<Integer, String> getAccessorIdMap() {
			return accessorIdMap;
		}
		public static void setAccessorIdMap(Map<Integer, String> accessorIdMap) {
			ACCESSORID.accessorIdMap = accessorIdMap;
		}
	}
	
	//咪咕影院订单信息数据:订单是否出票
	public static final class TICKET_ORDERSTATUS{
		public final static Integer TICKET_ORDERSTATUS_0 = 0;
		public final static Integer TICKET_ORDERSTATUS_1 = 1;
		public final static Integer TICKET_ORDERSTATUS_2 = 2;
		public final static Integer TICKET_ORDERSTATUS_3 = 3;
		
		public final static String TICKET_ORDERSTATUS_00 = "未出票";
		public final static String TICKET_ORDERSTATUS_01 = "出票成功";
		public final static String TICKET_ORDERSTATUS_02 = "出票失败";
		public final static String TICKET_ORDERSTATUS_03 = "出票中";
		
		private static Map<Integer,String> ticketOrderStatusMap = null;
		static {
			if(ticketOrderStatusMap == null){
				ticketOrderStatusMap = new HashMap<Integer,String>();
				ticketOrderStatusMap.put(TICKET_ORDERSTATUS_0, TICKET_ORDERSTATUS_00);
				ticketOrderStatusMap.put(TICKET_ORDERSTATUS_1, TICKET_ORDERSTATUS_01);
				ticketOrderStatusMap.put(TICKET_ORDERSTATUS_2, TICKET_ORDERSTATUS_02);
				ticketOrderStatusMap.put(TICKET_ORDERSTATUS_3, TICKET_ORDERSTATUS_03);			
			}
		}
		
		public static Map<Integer, String> getTicketOrderStatusMap() {
			return ticketOrderStatusMap;
		}
		public static void setTicketOrderStatusMap(Map<Integer, String> ticketOrderStatusMap) {
			TICKET_ORDERSTATUS.ticketOrderStatusMap = ticketOrderStatusMap;
		}
		
		
	}
	
	
	//咪咕影院订单信息数据订单状态
	public static final class ORDER_STATUS_MGYY{
		public final static Integer ORDER_STATUS_0 = 0;
		public final static String ORDER_STATUS_00 = "未生成蜘蛛网订单";
		public final static Integer ORDER_STATUS_1 = 1;
		public final static String ORDER_STATUS_01 = "出票成功";
		public final static Integer ORDER_STATUS_2 = 2;
		public final static String ORDER_STATUS_02 = "未生成华为订单";
		public final static Integer ORDER_STATUS_3 = 3;
		public final static String ORDER_STATUS_03 = "未支付订单";
		public final static Integer ORDER_STATUS_4 = 4;
		public final static String ORDER_STATUS_04 = "已经支付的订单(未出票)";
		public final static Integer ORDER_STATUS_5 = 5;
		public final static String ORDER_STATUS_05 = "退款中(取消华为订单成功)";
		public final static Integer ORDER_STATUS_6 = 6;
		public final static String ORDER_STATUS_06 = "华为创建订单失败";
		public final static Integer ORDER_STATUS_7 = 7;
		public final static String ORDER_STATUS_07 = "已退款(取消华为订单成功)";
		public final static Integer ORDER_STATUS_8 = 8;
		public final static String ORDER_STATUS_08 = "未支付订单取消成功";
		public final static Integer ORDER_STATUS_9 = 9;
		public final static String ORDER_STATUS_09 = "支付订单取消订单失败";
		public final static Integer ORDER_STATUS_10 = 10;
		public final static String ORDER_STATUS_010 = "取消订单异常";
		private static Map<Integer,String> orderStatusMGYYMap = null; 
		static {
			if(orderStatusMGYYMap == null){
				orderStatusMGYYMap = new HashMap<Integer,String>();
				orderStatusMGYYMap.put(ORDER_STATUS_0, ORDER_STATUS_00);
				orderStatusMGYYMap.put(ORDER_STATUS_1, ORDER_STATUS_01);
				orderStatusMGYYMap.put(ORDER_STATUS_2, ORDER_STATUS_02);
				orderStatusMGYYMap.put(ORDER_STATUS_3, ORDER_STATUS_03);
				orderStatusMGYYMap.put(ORDER_STATUS_4, ORDER_STATUS_04);
				orderStatusMGYYMap.put(ORDER_STATUS_5, ORDER_STATUS_05);
				orderStatusMGYYMap.put(ORDER_STATUS_6, ORDER_STATUS_06);
				orderStatusMGYYMap.put(ORDER_STATUS_7, ORDER_STATUS_07);
				orderStatusMGYYMap.put(ORDER_STATUS_8, ORDER_STATUS_08);
				orderStatusMGYYMap.put(ORDER_STATUS_9, ORDER_STATUS_09);
				orderStatusMGYYMap.put(ORDER_STATUS_10, ORDER_STATUS_010);				
			}
		}
		public static Map<Integer, String> getOrderStatusMGYYMap() {
			return orderStatusMGYYMap;
		}
		public static void setOrderStatusMGYYMap(Map<Integer, String> orderStatusMGYYMap) {
			ORDER_STATUS_MGYY.orderStatusMGYYMap = orderStatusMGYYMap;
		}
		
	}
	
	//咪咕影院订单信息数据:数据处理状态
	public static final class DEAL_STATUS{
		public final static Integer DEAL_STATUS_UNHANDLE = 0;// 数据处理状态(0:未处理)
		public final static Integer DEAL_STATUS_HANDLED = 1;// 数据处理状态(1:已处理)
		public final static String DEAL_STATUS_UNHANDLE_0 = "未处理";
		public final static String DEAL_STATUS_UNHANDLE_1 = "已处理";
		private static Map<Integer,String> dealStatusMap = null;
		static{
			if(dealStatusMap == null){
				dealStatusMap = new HashMap<Integer,String>();
				dealStatusMap.put(DEAL_STATUS_UNHANDLE, DEAL_STATUS_UNHANDLE_0);
				dealStatusMap.put(DEAL_STATUS_HANDLED, DEAL_STATUS_UNHANDLE_1);
			}
		}
		public static Map<Integer, String> getDealStatusMap() {
			return dealStatusMap;
		}
		public static void setDealStatusMap(Map<Integer, String> dealStatusMap) {
			DEAL_STATUS.dealStatusMap = dealStatusMap;
		}
	}
	
	//调账类型
	public static final class RECONCILATIONTYPE{
		public final static String ACCOUNT_TERM_UNDO_1 = "未调账";// 调账类型(1:未调账)
		public final static String ACCOUNT_TERM_ADD_FLOW_2 = "新增流水";// 作业执行状态(2:新增流水)
		public final static String ACCOUNT_TERM_DEL_FLOW_3 = "删除流水";// 作业执行状态(3:删除流水)
		public final static String ACCOUNT_TERM_UPDATE_FEE_4 = "金额修改";// 作业执行状态(4:金额修改)
		private static Map<Integer,String> reconcilationTypeMap = null;		
		static{
			reconcilationTypeMap = new HashMap<Integer,String>();
			reconcilationTypeMap.put(AccountTerm.ACCOUNT_TERM_UNDO, ACCOUNT_TERM_UNDO_1);
			reconcilationTypeMap.put(AccountTerm.ACCOUNT_TERM_ADD_FLOW, ACCOUNT_TERM_ADD_FLOW_2);
			reconcilationTypeMap.put(AccountTerm.ACCOUNT_TERM_DEL_FLOW, ACCOUNT_TERM_DEL_FLOW_3);
			reconcilationTypeMap.put(AccountTerm.ACCOUNT_TERM_UPDATE_FEE, ACCOUNT_TERM_UPDATE_FEE_4);
		}
		public static Map<Integer, String> getReconcilationTypeMap() {
			return reconcilationTypeMap;
		}
		public static void setReconcilationTypeMap(Map<Integer, String> reconcilationTypeMap) {
			RECONCILATIONTYPE.reconcilationTypeMap = reconcilationTypeMap;
		}
	}
	
	//本地退款状态
	public static final class REFUND_STATUS {
		public final static String ORDER_STATUS_REFUND_SUCCESS = "0";// 退款状态：0：退款成功
		public final static String ORDER_STATUS_REFUND_SUCCESS_0 = "退款成功";
		public final static String ORDER_STATUS_REFUND_SUCCESS_NO4 ="4";// 退款状态：4：退款成功
		public final static String ORDER_STATUS_REFUND_SUCCESS_4 = "退款成功";
		public final static String ORDER_STATUS_REFUND_FALSE = "1";// 退款状态：1：退款失败
		public final static String ORDER_STATUS_REFUND_FALSE_1 = "退款失败";
		public final static String ORDER_STATUS_REFUND_FALSE_NO16 = "16";// 退款状态：1：退款失败
		public final static String ORDER_STATUS_REFUND_FALSE_16 = "退款失败";
		public final static String ORDER_STATUS_REFUNDING = "2";// 退款状态：2：退款中
		public final static String ORDER_STATUS_REFUNDING_2 = "退款中";
		private static Map<String,String> refundStatusMap = null;		
		static{
			refundStatusMap = new HashMap<String,String>();
			refundStatusMap.put(ORDER_STATUS_REFUND_SUCCESS, ORDER_STATUS_REFUND_SUCCESS_0);
			refundStatusMap.put(ORDER_STATUS_REFUND_FALSE,ORDER_STATUS_REFUND_FALSE_1);
			refundStatusMap.put(ORDER_STATUS_REFUNDING,ORDER_STATUS_REFUNDING_2);
			refundStatusMap.put(ORDER_STATUS_REFUND_FALSE_NO16,ORDER_STATUS_REFUND_FALSE_16);
			refundStatusMap.put(ORDER_STATUS_REFUND_SUCCESS_NO4,ORDER_STATUS_REFUND_SUCCESS_4);
		}
		public static Map<String, String> getRefundStatusMap() {
			return refundStatusMap;
		}
		public static void setRefundStatusMap(Map<String, String> refundStatusMap) {
			REFUND_STATUS.refundStatusMap = refundStatusMap;
		}
		
	}
	
	//第三方退款状态
	public static final class PayChannelOrderStatus {
		public final static String PAY_CHANNEL_ORDER_STATUS_1 = "1";// 1：成功
		public final static String PAY_CHANNEL_ORDER_STATUS_1_WZ = "成功";
		private static Map<String,String> payChannelOrderStatusMap = null;		
		static{
			if(payChannelOrderStatusMap == null){
				payChannelOrderStatusMap = new HashMap<String,String>();
				payChannelOrderStatusMap.put(PAY_CHANNEL_ORDER_STATUS_1, PAY_CHANNEL_ORDER_STATUS_1_WZ);
			}
		}
		public static Map<String, String> getPayChannelOrderStatusMap() {
			return payChannelOrderStatusMap;
		}
		public static void setPayChannelOrderStatusMap(Map<String, String> payChannelOrderStatusMap) {
			PayChannelOrderStatus.payChannelOrderStatusMap = payChannelOrderStatusMap;
		}
		
	}
	

	public static final class TRANS_CODE_MSG {
		public final static String TYPE_ONLINEPAYMENT = "在线支付";// 用户支付费用
		public final static String TYPE_TRANSFER_ACCOUNT = "转账";// 用户退款
		public final static String TYPE_TRANSFER_SERVICE_FEE = "收费";// 支付宝收取手续费
		public final static String TYPE_WITHDRAW = "提现";// 咪咕提现到银行账户
	}

	public static final class OPERATION_RESULT {
		public final static String OPERATION_REUSLT_SUCCESS = "SUCCESS";// 操作结果:成功
		public final static String OPERATION_REUSLT_FALSE = "FALSE";// 操作结果:失败
		public final static String OPERATION_REUSLT_ERROR = "ERROR";// 操作结果:系统异常
	}

	public static final class EXPORT_DATA {
		public final static String SEPARATORLINE = "|";
		
		public final static int LINE = 10000;//每个文件存放的记录数
		public final static String WRITE_DATA_H = "horizontal";// 水平方向
		public final static String WRITE_DATA_V = "vertical";// 垂直方向
		
		public final static class PRORATEDATA {//分账
			public final static String EXPORT_DATA_FILEPATH = "/home/recon/tomcat7/file";
			public final static String EXPORT_PRORATE_ORDER_FILE = "ORDER";//分账订单文件
			public final static String EXPORT_PRORATE_PAYMENT_FILE = "PAY";//分账订单支付文件
			public final static String HANDER_AAA = "AAA";
			public final static String HANDER_MIGU_AUTH = "MIGU_AUTH";
			public final static String HANDER_AAA_PRODUCTID = "productID";
			public final static String HANDER_AAA_SUBTYPE = "subtype";
			public final static String HANDER_MIGU_AUTH_RESOURCE_ID = "resource_id";
			public final static String HANDER_MIGU_AUTH_RESOURCE_TYPE = "resource_type";
			public final static String HANDER_MIGU_AUTH_AUTHORIZE_TYPE = "authorize_type";
			
			public static class RESOURCETYPE {//资源类型
				public final static String RESOURCETYPE_PRODUCTID = "PMS_PRODUCT_ID";  		//PMS生成的产品ID
				public final static String RESOURCETYPE_PROGRAMID = "POMS_PROGRAM_ID";      //POMS节目id
				public final static String RESOURCETYPE_PKGID = "POMS_PKG_ID";          	//POMS产品包id
				public final static String RESOURCETYPE_SHELLID = "POMS_SHELL_ID";      	//剧集壳ID
				public final static String RESOURCETYPE_ALBUMID = "POMS_ALBUM_ID";   		//专辑ID
				public final static String RESOURCETYPE_MMSID = "MMS_ID";  					//媒资ID
				public final static String RESOURCETYPE_MEMBERID = "MEMBER_ID";   			//会员系统ID
			}
			
			public static class AUTHORIZETYPE {//认证类型
				public final static String AUTHORIZETYPE_PERIOD = "PERIOD";  			//时长授权(按时段)
				public final static String AUTHORIZETYPE_BOSS_MONTH = "BOSS_MONTH";     //BOSS包月
				public final static String AUTHORIZETYPE_TIMES = "TIMES";          		//按次授权(按次数)
				public final static String AUTHORIZETYPE_FREE = "FREE";      			//免费
			}       

			public static class HANDLER_AAA {
				public static class SUBTYPE {//订购类型
					public final static String SUBTYPE_01 = "01";		//根据生效时间和时长进行开通
					public final static String SUBTYPE_02 = "02";		//根据生效时间和失效时间进行开通
					public final static String SUBTYPE_03 = "03";		//按次产品订购
				}
				

			}
		}
		
		public final static class ALIPAY {
			public final static String XLS_NAME = "支付宝对账单";
			// 工作表：提现 表头
			public final static String TITLE_WITHDRAW_NAME = "提现";
			public final static String TITLE_WITHDRAW = "账务流水号,业务流水号,商户订单号,商品名称,发生时间,对方账号,收入金额(+元),支出金额(-元),账户余额(元),交易渠道,业务类型,备注";

			// 工作表：手续费 表头
			public final static String TITLE_SERVICE_FEE_NAME = "手续费";
			public final static String TITLE_SERVICE_FEE = "账务流水号,业务流水号,商户订单号,商品名称,发生时间,对方账号,收入金额(+元),支出金额(-元),账户余额(元),交易渠道,业务类型,备注";

			// 工作表：在线支付 表头
			public final static String TITLE_ONLINEPAYMENT_NAME = "在线支付";
			public final static String TITLE_ONLINEPAYMENT = "账务流水号,业务流水号,商户订单号,商品名称,发生时间,对方账号,收入金额(+元),支出金额(-元),账户余额(元),交易渠道,业务类型,备注";

			// 工作表：退款 表头
			public final static String TITLE_REFUND_NAME = "退款";
			public final static String TITLE_REFUND = "账务流水号,业务流水号,商户订单号,商品名称,发生时间,对方账号,收入金额(+元),支出金额(-元),账户余额(元),交易渠道,业务类型,备注";

			// 工作表：对账汇总 表头
			public final static String TITLE_SUMMARY_OF_RECONCILIATION_NAME = "对账汇总";
			public final static String TITLE_SUMMARY_OF_RECONCILIATION = "渠道类型,账号,账期,上期期末应缴金额(第三方交易金额:分),本期交易笔数,本期应收金额(本地交易金额:分),本期第三方交易笔数,本期应缴金额(第三方交易金额:分),本期手续费,本期提现笔数,本期提现金额(分),本期期末余额(第三方账户余额:分),本期差异笔数,本期差异金额数,本期退款笔数,本期退款金额(第三方退款金额:分),本期退款差异笔数,本期退款差异金额数";

			// 工作表：本地交易流水 表头
			public final static String TITLE_LOCAL_PAYMENT_NAME = "本地交易流水";
			// public final static String TITLE_LOCAL_PAYMENT =
			// "本地账户系统流水号,第三方账户交易流水,账户ID,子账户ID,第三方交易时间,本地交易时间,交易类型,值类型,交易金额,交易渠道,合作者身份id,本地账户平台标识,创建时间";
//			public final static String TITLE_LOCAL_PAYMENT = "本地账户系统流水号,第三方账户交易流水,第三方交易时间,本地交易时间,交易类型,值类型,交易金额,交易渠道,创建时间";
			public final static String TITLE_LOCAL_PAYMENT = "本地账户系统流水号,第三方交易时间,交易类型,值类型,交易金额,交易渠道,创建时间";
			
			// 工作表：本地退款流水 表头
			public final static String TITLE_LOCAL_REFUND_PAYMENT_NAME = "本地退款流水";
			// public final static String TITLE_LOCAL_PAYMENT =
			// "本地账户系统流水号,第三方账户交易流水,账户ID,子账户ID,第三方交易时间,本地交易时间,交易类型,值类型,交易金额,交易渠道,合作者身份id,本地账户平台标识,创建时间";
//			public final static String TITLE_LOCAL_REFUND_PAYMENT = "本地账户系统流水号,第三方账户交易流水,第三方交易时间,本地交易时间,交易类型,值类型,交易金额,交易渠道,创建时间";
			public final static String TITLE_LOCAL_REFUND_PAYMENT = "本地账户系统流水号,第三方交易时间,交易类型,值类型,交易金额,交易渠道,创建时间";
			
						
			// 工作表：支付对账 表头
			public final static String TITLE_ORDER_PAYMENT_AUDIT_NAME = "支付对账";
			// public final static String TITLE_ORDER_PAYMENT_AUDIT =
			// "第三方流水号,本地流水号,交易时间,本地交易金额(分),第三方交易金额(分),稽核结果,账期,费率,服务费(分)";
			public final static String TITLE_ORDER_PAYMENT_AUDIT = "第三方流水号,本地流水号,交易时间,本地交易金额(分),第三方交易金额(分),稽核结果,账期";

			// 工作表：退款对账 表头
			public final static String TITLE_ORDER_WITHDRAW_AUDIT_NAME = "退款对账";
			public final static String TITLE_ORDER_WITHDRAW_AUDIT = "第三方流水号,本地流水号,交易时间,本地交易金额(分),第三方交易金额(分),本地退款状态,第三方退款状态,稽核结果,账期,退款原因";

		}

		public final static class DIFF_RESULT_OF_RECONCILIATION {
			public final static String XLS_NAME = "差异对账结果说明";
			// 工作表：对账汇总 表头
			public final static String TITLE_SUMMARY_OF_RECONCILIATION_NAME = "对账汇总";
			public final static String TITLE_SUMMARY_OF_RECONCILIATION = "渠道类型,账号,账期,上期期末应缴金额,本期交易笔数,本期应收金额(本地交易金额:分),本期第三方交易笔数,本期应缴金额(第三方交易金额：分),本期手续费,本期提现笔数,本期提现金额(分),本期期末余额(第三方账户余额:分),本期差异笔数,本期差异金额数,本期退款笔数,本期退款金额(第三方退款金额:分),本期退款差异笔数,本期退款差异金额数";

			// 工作表：对账差异数据说明 表头
			public final static String TITLE_DIFF_OF_RECONCILIATION_NAME = "对账差异数据说明";
			// public final static String TITLE_DIFF_OF_RECONCILIATION =
			// "第三方流水号,本地流水号,交易时间,本地交易金额(分),第三方交易金额(分),稽核结果,账期,费率,服务费(分),差异原因";
			public final static String TITLE_DIFF_OF_RECONCILIATION = "第三方流水号,本地流水号,交易时间,本地交易金额(分),第三方交易金额(分),稽核结果,账期,差异原因";

			// 工作表：退款差异数据说明 表头
			public final static String TITLE_WITHDRAW_OF_RECONCILIATION_NAME = "退款差异数据说明";
			public final static String TITLE_WITHDRAW_OF_RECONCILIATION = "第三方流水号,本地流水号,交易时间,本地交易金额(分),第三方交易金额(分),稽核结果,账期,本地退款状态,第三方退款状态,差异原因";

		}

		// 支付渠道交易记录前端数据下载
		public final static class FRONT_RESULT_OF_THIRDPAYALIPAYMENT {
			public final static String XLS_NAME = "支付渠道交易记录";
			// 工作表：支付渠道交易记录 表头
			public final static String TITLE_THIRDPAYALIPAYMENT_OF_RECONCILIATION_NAME = "支付渠道交易记录";
			public final static String TITLE_THIRDPAYALIPAYMENT_OF_RECONCILIATION = "商户订单号,余额,收入金额,支出金额,交易付款时间,子业务类型,业务类型,订单号,银行名称,银行账户,银行账户名字,支付宝备注,商品名称,财务本方支付宝,财务对方邮箱,财务对方全称,交易服务费,交易服务费率,交易总金额,累积退款金额,签约产品,调账类型,数据导入时,数据处理状态,数据处理时间";
			//微信
			public final static String TITLE_THIRDPAYALIPAYMENT_WX_OF_RECONCILIATION = "流水号,交易时间,公众账号ID,商户号,子商户号,设备号,微信订单号,商户订单号,用户标识,交易类型,交易状态,付款银行,货币种类,总金额,企业红包金额,微信退款单号,商户退款单号,退款金额,企业红包退款金额,退款类型,退款状态,商品名称,商户数据包,手续费,费率,数据导入时间,数据处理状态,数据处理时间";
			
		}

		// 本地交易记录前端数据下载
		public final static class FRONT_RESULT_OF_ORIGINORDERDAILY {
			public final static String XLS_NAME = "本地交易记录";
			// 工作表：本地交易记录 表头
			public final static String TITLE_ORIGINORDERDAILY_OF_RECONCILIATION_NAME = "本地交易记录";
			public final static String TITLE_ORIGINORDERDAILY_OF_RECONCILIATION = "订单ID,SERVICECODE,用户ID,MERCHANTID,订单状态,订单总金额,商品名称,产品id,内容ID,内容类型,内容集id,渠道id,订单创建时间,订单结束时间,订单失效时间,外部订单id,记录类型,本地交易流水ID,用户ID,MERCHANTID,支付状态,支付类型,支付货币类型,总支付金额,支付创建时间,支付完成时间,支付最后修改时间,支付渠道,计费代码,原支付流水ID,退款状态,退款时间,退款最后更新时间,支付金额,退款金额,退款原因,手机号码";
		}
		
		//影票对账：前端数据下载
		public final static class AUDIT_THEATRE_ORDER{
			public final static String XLS_NAME = "影票对账";
			
			//工作表：影票对账详情
			public final static String TITLE_AUDIT_THEATRE_ORDER_NAME = "影票对账详情";
			public final static String TITLE_AUDIT_THEATRE_ORDER = "本地咪咕账期,三方影票账期,咪咕影院订单号,合作方名称,三方影票订单号,华为支付流水号,本地票数,咪咕影票订单平帐价(不含税),三方票数,三方影票订单金额,咪咕影票支付稽核结果,三方影票稽核结果";
		}
		
		//影票数据：前端模板下载
		public final static class  ORIGIN_THIRD_THEATRE{
			public final static String XLS_NAME = "影票数据表格模板";
			
			//万达
			public final static String ORIGIN_THIRD_THEATRE_WD_NAME = "万达";
			public final static String ORIGIN_THIRD_THEATRE_WD ="网站订单号,所属区域,法人名称,影城名称,营业日,销售类型,销售渠道,票类,活动名称,支付方式,票号,影片名称,影厅,销售日期,放映日期,放映时间,座位号,购票张数,影票金额,服务费,订单金额";
			
			//微票
			public final static String ORIGIN_THIRD_THEATRE_WP_NAME = "微票";
			public final static String ORIGIN_THIRD_THEATRE_WP ="订单号,影院ID,影院名称,影片名称,城市,影票数量,销售总额,支付类别,现金金额,预售券抵扣,红包,立减,减至,差异,订单日期,订单时间,支付日期,支付时间,订单状态,预售券活动ID,预售券活动名称,预售券购买金额,预售券使用个数,售卖来源,渠道";
		
			//蜘蛛网
			public final static String ORIGIN_THIRD_THEATRE_ZZW_NAME = "蜘蛛网";
			public final static String ORIGIN_THIRD_THEATRE_ZZW = "数量,创建时间,结算总额,服务费总额,影院系统订单号,取票号,订单号,支付方式,订单来源,影院名称,电影名称,用户实际支付金额,观影维度";
			
			//SFC
			public static final String ORIGIN_THIRD_THEATRE_SFC_NAME = "SFC";
			public static final String ORIGIN_THIRD_THEATRE_SFC = "订单号,影票系统订单号,场次来源,影院名称,影片名称,影片维度,放映时间,影厅名称,座位号,支付方式,渠道名称,商品数量(张),票款,订单状态,下单时间,支付时间";

			
		}
		
		//咪咕一级支付:前端下载
		public final static class ORIGIN_MIGU_PAY{
			public final static String XLS_NAME = "咪咕一级支付";
			public final static String ORIGIN_MIGU_PAY_NAME = "咪咕一级支付";
			public final static String ORIGIN_MIGU_PAYE = "支付订单号ID,业务平台订单号ID,BOSS交易流水ID,第三方交易流水ID,咪咕币交易流水ID,银行交易流水ID,用户ID值,子公司标识,渠道ID,是否需要二次批价,用户归属省,用户类型1,用户类型2,用户IP地址,IMEI,IMSI,设备编码,操作来源,计费类型,SP代码,业务代码,数量,支付总金额,话费支付金额,咪咕币支付金额,充值卡支付金额,第三方支付金额,第三方支付类型,优惠券点数,优惠券汇率,支付方式,内容编码,内容类型,计次单位,应用内计费点编码,支付状态,超时时间(秒),支付时间,产品描述,支付总金额描述,第三方支付补充信息,值卡补充信息,扩展字段,业务平台回调URL1,业务平台回调URL2,支付失败原因";
		}
		
		//电子码平台:前端下载
		public final static class  ELECTRONIC_CODE{
			public final static String XLS_NAME = "电子码平台";
			public final static String ELECTRONIC_CODE_NAME = "电子码平台";
			public final static String ELECTRONIC_CODE = "电子码号,订单号,对应次卡类型,使用用户ID,使用时间,取票手机号,影票展示价,咪咕订单号,第三方订单号,出票方,兑换成功时间";
		}
		
		
		//微信对账：前端数据下载
		public final static class WEIXIN_PAY{
			public final static String XLS_NAME = "微信对账单";

			// 工作表：手续费 表头
			public final static String TITLE_SERVICE_FEE_NAME = "手续费";
			public final static String TITLE_SERVICE_FEE = "交易时间,微信订单号,商户订单号,用户标识,交易状态,总金额,商品名称,手续费";

			// 工作表：在线支付 表头
			public final static String TITLE_ONLINEPAYMENT_NAME = "在线支付";
			public final static String TITLE_ONLINEPAYMENT = "交易时间,微信订单号,商户订单号,用户标识,交易状态,总金额,商品名称,手续费";

			// 工作表：退款 表头
			public final static String TITLE_REFUND_NAME = "退款";
			public final static String TITLE_REFUND = "交易时间,微信订单号,商户订单号,用户标识,交易状态,退款金额,商品名称,手续费";

			// 工作表：对账汇总 表头
			public final static String TITLE_SUMMARY_OF_RECONCILIATION_NAME = "对账汇总";
			public final static String TITLE_SUMMARY_OF_RECONCILIATION = "渠道类型,账号,账期,上期期末应缴金额(第三方交易金额:分),本期交易笔数,本期应收金额(本地交易金额:分),本期第三方交易笔数,本期应缴金额(第三方交易金额:分),本期手续费,本期提现笔数,本期提现金额(分),本期期末余额(第三方账户余额:分),本期差异笔数,本期差异金额数,本期退款笔数,本期退款金额(第三方退款金额:分),本期退款差异笔数,本期退款差异金额数";

			// 工作表：本地交易流水 表头
			public final static String TITLE_LOCAL_PAYMENT_NAME = "本地交易流水";
			public final static String TITLE_LOCAL_PAYMENT = "本地账户系统流水号,第三方交易时间,交易类型,值类型,交易金额,交易渠道,创建时间";
			
			// 工作表：本地退款流水 表头
			public final static String TITLE_LOCAL_REFUND_PAYMENT_NAME = "本地退款流水";
			public final static String TITLE_LOCAL_REFUND_PAYMENT = "本地账户系统流水号,第三方交易时间,交易类型,值类型,交易金额,交易渠道,创建时间";
			
						
			// 工作表：支付对账 表头
			public final static String TITLE_ORDER_PAYMENT_AUDIT_NAME = "支付对账";
			public final static String TITLE_ORDER_PAYMENT_AUDIT = "第三方流水号,本地流水号,交易时间,本地交易金额(分),第三方交易金额(分),稽核结果,账期";

			// 工作表：退款对账 表头
			public final static String TITLE_ORDER_WITHDRAW_AUDIT_NAME = "退款对账";
			public final static String TITLE_ORDER_WITHDRAW_AUDIT = "第三方流水号,本地流水号,交易时间,本地交易金额(分),第三方交易金额(分),本地退款状态,第三方退款状态,稽核结果,账期,退款原因";

		}
		
		// 查询影票订单数据
		public final static class FRONT_RESULT_OF_ORIGINTHERTREORDER{
			public final static String XLS_NAME = "影票订单数据";
			// 工作表：影票订单数据 表头
			public final static String TITLE_ORIGINTHERTREORDER_OF_RECONCILIATION_NAME = "影票订单数据";
			public final static String TITLE_ORIGINTHERTREORDER_OF_RECONCILIATION = "影票系统订单号,订单流水号,城市ID,城市名称,影院ID,影院名称,影厅ID,影厅名称,影片ID,影片名称,场次ID,放映日期,放映时间,座位号,语言类型,影片维度,取票手机号码,用户ID,渠道ID,订单总票数,影票单价,影票单价服务费,影票单价溢价价格,订单总结算金额,订单总服务费,订单总价(成本价),订单标准售价,订单支付总金额,活动ID,订单优惠总金额,优惠状态,订单状态,订单创建时间,合作方ID,合作方名称,订单是否出票,交易订单ID,第三方订单号";
		}

		public final static class AUDIT_ORDER_PAYMENT {
			public final static String XLS_MONTH_NAME = "交易稽核.xls";
			public final static String XLS_DAILY_NAME = "日交易稽核.xls";
			// 工作表：月交易稽核 表头 属性
			public final static String TITLE_MONTH_NAME = "交易稽核";
			public final static String TITLE_MONTH = "流水号,订单号,支付流水号,稽核结果 ,支付流水类型 ,支付渠道类型,支付货币类型,支付(退款)金额,支付(/退款)状态 ,支付(/退款)时间,支付(/退款)完成时间,支付渠道,计费代码,原支付流水ID,退款原因 ,手机号码,支付渠道业务流水ID,支付渠道支付(退款)金额,支付渠道支付(/退款)状态 ,支付渠道支付(/退款)时间,支付渠道支付(/退款)完成时间 ,稽核创建时间 ,人工调账申请单号 ,人工调账备注 ,人工调账时间";
			public final static String PROPERTY_MONTH = "pkid,orderid,paymentid,dealResult,paymentType,paymentChannelType,currency,fee,orderStatus,paymentTime,paymentFinishTime,channelCode,serviceid,rowpaymentid,reasoncode,mobile,payChannelBizId,payChannelFee,payChannelOrderStatus,payChannelPaymentTime,paychannelPaymentFinishTime,createTime,applyId,pAtRemark,pAtTime";
			// 工作表：日交易稽核 表头 属性
			public final static String TITLE_DAILY_NAME = "日交易稽核";
			public final static String TITLE_DAILY = "流水号,订单ID,支付流水ID,稽核结果,支付流水类型,支付渠道类型 ,支付货币类型,支付(退款)金额 ,支付(/退款)状态,支付(/退款)时间 ,支付(/退款)完成时间,支付渠道,计费代码,原支付流水ID,退款原因 ,手机号码,支付渠道业务流水ID,支付渠道支付(退款)金额,支付渠道支付(/退款)状态,支付渠道支付(/退款)时间 ,支付渠道支付(/退款)完成时间,比对数据来源,日期,稽核创建时间";
			public final static String PROPERTY_DAILY = "pkid,orderid,paymentid,paymentType,paymentChannelType,currency,fee,orderStatus,paymentTime,paymentFinishTime,channelCode,serviceid,rowpaymentid,reasoncode,mobile,payChannelBizId,payChannelFee,payChannelOrderStatus,payChannelPaymentTime,payChannelPaymentFinishTime,payChannelSource,orderDate,dealResult,createTime";
		}

	}
	
		// 非结算SCOPE模板表
		public final static class EXCLUDE_SCOPE_MODEL{
			public final static String XLS_NAME = "非结算SCOPE模板表";
			// 工作表：非结算SCOPE模板表 表头
			public final static String TITLE_EXCLUDE_SCOPE_MODEL_OF_RECONCILIATION_NAME = "非结算SCOPE模板表";
			public final static String TITLE_EXCLUDE_SCOPE_MODEL_OF_RECONCILIATION = "SCOPE(必填-如:1001),结算期(必填-如:201608),开始时间(选填-如:2016-09-08 14:35:52),结束时间(选填-如:2016-09-08 14:35:52),是否结算(必填-如:是)";
		}

	/**
	 * 定义各种Map
	 * 
	 * @author user
	 *
	 */
	public final static class Mapper {
		private static Map<String, Object> bizCNNMap = null;
		private static Map<Integer, Object> logCNNMap = null;

		static {
			if (bizCNNMap == null) {
				bizCNNMap = new HashMap<String, Object>();
				bizCNNMap.put(Constant.CollectData.PLATFORM_ALIPAY, "获取支付宝数据(页面触发)");
				bizCNNMap.put(Constant.CollectData.PLATFORM_WEIXIN, "获取微信数据(页面触发)");
				bizCNNMap.put(Constant.CollectData.PLATFORM_HW, "获取华为数据(页面触发)");
				bizCNNMap.put(Constant.CollectData.BIZTYPE_THEATRE_ORDER, "获取咪咕影院订单数据(页面触发)");
				bizCNNMap.put(Constant.CollectData.PLATFORM_MIGU, "获取咪咕一级支付数据(页面触发)");
				bizCNNMap.put(Constant.ElectronicCode.PLATFORM_ELECTRONIC, "获取电子码平台数据(页面触发)");
			}

			if (logCNNMap == null) {
				logCNNMap = new HashMap<Integer, Object>();
				logCNNMap.put(Constant.Log.LOG_TYPE_1001, Constant.Log.JOB_NAME_1001);
				logCNNMap.put(Constant.Log.LOG_TYPE_1004, Constant.Log.JOB_NAME_1004);
				logCNNMap.put(Constant.Log.LOG_TYPE_1005, Constant.Log.JOB_NAME_1005);
				logCNNMap.put(Constant.Log.LOG_TYPE_1006, Constant.Log.JOB_NAME_1006);
				logCNNMap.put(Constant.Log.LOG_TYPE_1007, Constant.Log.JOB_NAME_1007);
				logCNNMap.put(Constant.Log.LOG_TYPE_1008, Constant.Log.JOB_NAME_1008);
				logCNNMap.put(Constant.Log.LOG_TYPE_1009, Constant.Log.JOB_NAME_1009);
				logCNNMap.put(Constant.Log.LOG_TYPE_1010, Constant.Log.JOB_NAME_1010);
				logCNNMap.put(Constant.Log.LOG_TYPE_1051, Constant.Log.JOB_NAME_1051);
				logCNNMap.put(Constant.Log.LOG_TYPE_1052, Constant.Log.JOB_NAME_1052);
				logCNNMap.put(Constant.Log.LOG_TYPE_1054, Constant.Log.JOB_NAME_1054);
				logCNNMap.put(Constant.Log.LOG_TYPE_1055, Constant.Log.JOB_NAME_1055);
				logCNNMap.put(Constant.Log.LOG_TYPE_1056, Constant.Log.JOB_NAME_1056);
				logCNNMap.put(Constant.Log.LOG_TYPE_1057, Constant.Log.JOB_NAME_1057);
				logCNNMap.put(Constant.Log.LOG_TYPE_1058, Constant.Log.JOB_NAME_1058);
				logCNNMap.put(Constant.Log.LOG_TYPE_1059, Constant.Log.JOB_NAME_1059);
				logCNNMap.put(Constant.Log.LOG_TYPE_1060, Constant.Log.JOB_NAME_1060);
				logCNNMap.put(Constant.Log.LOG_TYPE_2001, Constant.Log.JOB_NAME_2001);
				logCNNMap.put(Constant.Log.LOG_TYPE_2003, Constant.Log.JOB_NAME_2003);
				logCNNMap.put(Constant.Log.LOG_TYPE_2004, Constant.Log.JOB_NAME_2004);
				logCNNMap.put(Constant.Log.LOG_TYPE_2005, Constant.Log.JOB_NAME_2005);
				logCNNMap.put(Constant.Log.LOG_TYPE_2006, Constant.Log.JOB_NAME_2006);
				logCNNMap.put(Constant.Log.LOG_TYPE_2051, Constant.Log.JOB_NAME_2051);
				logCNNMap.put(Constant.Log.LOG_TYPE_2053, Constant.Log.JOB_NAME_2053);
				logCNNMap.put(Constant.Log.LOG_TYPE_2054, Constant.Log.JOB_NAME_2054);
				logCNNMap.put(Constant.Log.LOG_TYPE_2055, Constant.Log.JOB_NAME_2055);
				logCNNMap.put(Constant.Log.LOG_TYPE_2056, Constant.Log.JOB_NAME_2056);
				logCNNMap.put(Constant.Log.LOG_TYPE_3001, Constant.Log.JOB_NAME_3001);
				logCNNMap.put(Constant.Log.LOG_TYPE_3002, Constant.Log.JOB_NAME_3002);
				logCNNMap.put(Constant.Log.LOG_TYPE_3004, Constant.Log.JOB_NAME_3004);
				logCNNMap.put(Constant.Log.LOG_TYPE_3005, Constant.Log.JOB_NAME_3005);
				logCNNMap.put(Constant.Log.LOG_TYPE_3051, Constant.Log.JOB_NAME_3051);
				logCNNMap.put(Constant.Log.LOG_TYPE_3052, Constant.Log.JOB_NAME_3052);
				logCNNMap.put(Constant.Log.LOG_TYPE_3053, Constant.Log.JOB_NAME_3053);
				logCNNMap.put(Constant.Log.LOG_TYPE_3054, Constant.Log.JOB_NAME_3054);
				logCNNMap.put(Constant.Log.LOG_TYPE_3055, Constant.Log.JOB_NAME_3055);
				logCNNMap.put(Constant.Log.LOG_TYPE_4001, Constant.Log.JOB_NAME_4001);
				logCNNMap.put(Constant.Log.LOG_TYPE_4051, Constant.Log.JOB_NAME_4051);
				logCNNMap.put(Constant.Log.LOG_TYPE_6001, Constant.Log.JOB_NAME_6001);
				logCNNMap.put(Constant.Log.LOG_TYPE_6002, Constant.Log.JOB_NAME_6002);
				logCNNMap.put(Constant.Log.LOG_TYPE_6003, Constant.Log.JOB_NAME_6003);
				logCNNMap.put(Constant.Log.LOG_TYPE_6051, Constant.Log.JOB_NAME_6051);
				logCNNMap.put(Constant.Log.LOG_TYPE_6052, Constant.Log.JOB_NAME_6052);
				logCNNMap.put(Constant.Log.LOG_TYPE_6053, Constant.Log.JOB_NAME_6053);
			}
			

		}

		public static Map<String, Object> getBizCNNMap() {
			return bizCNNMap;
		}

		public static void setBizCNNMap(Map<String, Object> bizCNNMap) {
			Mapper.bizCNNMap = bizCNNMap;
		}

		public static Map<Integer, Object> getLogCNNMap() {
			return logCNNMap;
		}

		public static void setLogCNNMap(Map<Integer, Object> logCNNMap) {
			Mapper.logCNNMap = logCNNMap;
		}

	}
	
	/**
	 * 将下拉框的值放入map
	 */
	/*public static Map<String,String> getPayTypes(){
	Map<String,String> payTypes = new HashMap<String,String>();
	
	payTypes.put("17","支付宝手机客户端支付");
	payTypes.put("13","支付宝web即时到账支付");
	payTypes.put("26","Appstore支付");
	payTypes.put("28","联通号码话费扣费");
	payTypes.put("44","话费点播支付");
	payTypes.put("55","微信SDK支付");
	payTypes.put("57","Payment虚拟货币支付");
	payTypes.put("58","咪咕一级支付");
	payTypes.put("59","咪咕SDK支付");
	payTypes.put("60","电信IAP SDK支付");
	payTypes.put("61","支付宝代扣费");
	payTypes.put("62","银视通支付");
	payTypes.put("63","浦发银行先看后付");
	payTypes.put("300","支付宝扫码支付");
	payTypes.put("301","微信扫码支付");
	payTypes.put("302","阳光计划话费支付");
	payTypes.put("303","支付宝扫码即时到账支付");
	return payTypes;
}*/
	
	
	public static Map<String,String> getPayChannelType(){
	Map<String,String> payChannelTypes = new HashMap<String,String>();	
	payChannelTypes.put("alipay","支付宝");
	payChannelTypes.put("weixin","微信");
	payChannelTypes.put("migu","咪咕");
	payChannelTypes.put("apple","苹果");
	return payChannelTypes;
}
	

	
	
	
}
