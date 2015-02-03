package cn.wh.anyst.entity;

/*
 * 结算报表类
 */
public class SettlementReport {
	private String orderId;				//编号
	private String opt;					//操作
	private Long customerId;			//客户ID
	private String customerName;		//客户姓名
	private String customerPhone;		//客户电话
	private int customerType;			//客户类型
	private Long hospitalId;			//医院ID
	private String hospitalName;		//医院名称
	private Long departmentId;			//部门ID
	private String departmentName;		//部门名称
	private Long representorId;			//代表ID
	private String representorName;		//代表姓名
	private Long giftId;				//礼品ID
	private String giftCode;			//礼品编码
	private String giftName;			//礼品名称
	private int giftQuality;			//礼品数量
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public int getCustomerType() {
		return customerType;
	}
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getRepresentorId() {
		return representorId;
	}
	public void setRepresentorId(Long representorId) {
		this.representorId = representorId;
	}
	public String getRepresentorName() {
		return representorName;
	}
	public void setRepresentorName(String representorName) {
		this.representorName = representorName;
	}
	public Long getGiftId() {
		return giftId;
	}
	public void setGiftId(Long giftId) {
		this.giftId = giftId;
	}
	public String getGiftCode() {
		return giftCode;
	}
	public void setGiftCode(String giftCode) {
		this.giftCode = giftCode;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public int getGiftQuality() {
		return giftQuality;
	}
	public void setGiftQuality(int giftQuality) {
		this.giftQuality = giftQuality;
	}
}
