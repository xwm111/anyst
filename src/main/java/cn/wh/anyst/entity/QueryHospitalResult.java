package cn.wh.anyst.entity;

import java.util.ArrayList;

/*
 * 查询医院结果对象
 * 
 * 生成的JSON为：
 * {"total":7,"rows":[
 *	{"id":1,				"name":"中南医院"	},
 *	{"id":2,"_parentId":1,	"name":"皮肤科"},
 *	{"id":3,"_parentId":1,	"name":"消化科"},
 *	{"id":4,				"name":"省人民医院"},
 *	{"id":5,"_parentId":4,	"name":"内科"},
 *	{"id":6,"_parentId":4,	"name":"呼吸科"},
 *	{"id":7,"_parentId":4,	"name":"妇科"}
 * ]}
 * 
 */
public class QueryHospitalResult {
	private HospitalResultList rows;
	
	public QueryHospitalResult() {
		rows = new HospitalResultList();
	}
	
	public int getTotal() {
		return rows.size();
	}
	
	public HospitalResultList getRows() {
		return rows;
	}
	
	
	/*************************************************************
	 * 内部类 =====
	 *        ||
	 *       \  /
	 *        \/
	 *************************************************************/
	/*
	 * 结果集的内容（医院、部门信息及其所属结构）
	 */
	public static class HospitalResultData {
		private String id;			//医院或者部门的ID（医院ID ＝ H ＋ 医院ID， 部门ID ＝ D ＋ 部门ID）
		private String _parentId;	//部门所属医院ID（医院为NULL，部门为医院的ID（H ＋ 医院ID））
		private String name;		//部门或者医院的名称
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String get_parentId() {
			return _parentId;
		}
		
		public void set_parentId(String _parentId) {
			this._parentId = _parentId;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
	
	/*
	 * 存放结果的数据结构（链表）
	 */
	public static class HospitalResultList extends ArrayList<HospitalResultData> {
		
		//向链表中添加医院对象
		public void addHospital(Hospital hospital) {
			HospitalResultData data = new HospitalResultData();
			data.setId("H" + String.valueOf(hospital.getId()));
			data.setName(hospital.getHospitalName());
			data.set_parentId(null);
			this.add(data);
		}
		
		//向链表中添加部门对象
		public void addDepartment(Department department) {
			HospitalResultData data = new HospitalResultData();
			data.setId("D" + String.valueOf(department.getId()));
			data.setName(department.getDepartmentName());
			data.set_parentId("H" + String.valueOf(department.getHospitalId()));
			this.add(data);
		}
	}
}
