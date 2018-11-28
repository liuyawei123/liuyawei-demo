package com.primeton.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类用于把数据转化为对象
 * 
 * @author liuyawei
 *
 */
@ApiModel(value = "User", description = "用户信息")
@Component
public class Emp implements Serializable {

	private static final long serialVersionUID = 8019720987325936224L;
	@ApiModelProperty(value = "用户ID")
	private Integer id;
	@ApiModelProperty(value = "员工号")
	private String empno;
	@ApiModelProperty(value = "用户名")
	private String empName;
	@ApiModelProperty(value = "密码")
	private String password;
	@ApiModelProperty(value = "职位")
	private String job;
	@ApiModelProperty(value = "上级领导")
	private String mgr;
	@ApiModelProperty(value = "创建人")
	private String createdUser;
	@ApiModelProperty(value = "创建时间")
	private Date createdDate;
	@ApiModelProperty(value = "修改用户")
	private String modifiedUser;
	@ApiModelProperty(value = "修改用户")
	private Date modifiedDate;
	@ApiModelProperty(value = "部门号")
	private String deptno;
	@ApiModelProperty(value = "部门名称")
	private String deptName;

	

	public Emp(String empName, String password) {
		super();
		this.empName = empName;
		this.password = password;
	}

	

	public Emp() {
		super();
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



	public Emp(Integer id, String empno, String empName, String password, String job, String mgr, String createdUser,
			Date createdDate, String modifiedUser, Date modifiedDate, String deptno, String deptName) {
		super();
		this.id = id;
		this.empno = empno;
		this.empName = empName;
		this.password = password;
		this.job = job;
		this.mgr = mgr;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.modifiedUser = modifiedUser;
		this.modifiedDate = modifiedDate;
		this.deptno = deptno;
		this.deptName = deptName;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
}
