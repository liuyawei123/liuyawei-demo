package com.primeton.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 部门实体类
 * 
 * @author liuya
 *
 */
@ApiModel(value = "UserBean", description = "部门信息")
public class Dept implements Serializable {

	private static final long serialVersionUID = 3721673760609073354L;
	
	@ApiModelProperty(value = "部门号")
	private String deptno;
	@ApiModelProperty(value = "部门名称")
	private String deptName;
	@ApiModelProperty(value = "部门地址")
	private String loc;
	@ApiModelProperty(value = "上级部门")
	private String leader;
	@ApiModelProperty(value = "部门ID")
	private Integer id;

	public Dept(String deptno, String deptName, String loc, String leader) {
		super();
		this.deptno = deptno;
		this.deptName = deptName;
		this.loc = loc;
		this.leader = leader;
	}

	public Dept() {
		super();
	}

	@Override
	public String toString() {
		return "dept [deptno=" + deptno + ", deptName=" + deptName + ", loc=" + loc + ", leader=" + leader + ", id="
				+ id + "]";
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
