package com.primeton.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.PageInfo;
import com.primeton.demo.model.Emp;

/**
 * 个人业务层方法接口
 * 
 * @author liuyawei
 *
 */
public interface IEmpService {

	/**
	 * 增 注册功能，即向表中插入数据
	 * 
	 * @param emp 用户插入的数据对象
	 * @return 受影响的行数
	 */
	Emp createEmp(Emp emp);

	/**
	 * 删 根据用户名删除用户
	 * 
	 * @param empName 用户名
	 * @return 收影响的行数
	 */
	Integer removeEmp(String empName);

	/**
	 * 改 用户修改个人信息
	 * 
	 * @param empName  新用户名
	 * @param password 新的密码
	 * @param 用户id
	 * @return 受影响的行数
	 */
	Integer modifyEmp(String empName, String password, Integer id);

	/**
	 * 查 根据用户名查询用户数据
	 * 
	 * @param empName 用户名
	 * @return 与参数用户名匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	public Emp getEmpByEmpName(String empName);

	/**
	 * 查 用户登录
	 * 
	 * @param username 用户名
	 * @param password 用户密码
	 * @return 用户个信息
	 */
	Emp login(String username, String password);
	

	/**
	 * 利用模糊查询该公司所有员工
	 * 
	 * @return 该公司所有员工集合
	 */
	public PageInfo<Emp> queryAllEmps(String empName,Integer pageNum,Integer pageSize);
	
	/**
	 * 查 根据部门号员工
	 * 
	 * @return 该公司员工集合
	 */
	public List<Emp> queryEmpsByDeptno(String deptno);

}
