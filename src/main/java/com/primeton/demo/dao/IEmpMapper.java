package com.primeton.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.primeton.demo.model.Emp;

/**
 * 数据操作接口以及数据库增删查改
 * @author liuyawei
 */
@Mapper

public interface IEmpMapper {

	/**
	 * 增
	 * 注册功能，即向表中插入数据
	 * @param emp 用户插入的数据对象
	 * @return  数据对象
	 */
	@Insert("INSERT INTO "
			+ "DEMO_EMP "
			+ "(EMPNO,EMP_NAME,PASSWORD,JOB,MGR,CREATE_DATE,CREATE_USER,"
			+ " MODIFIED_DATE,MODIFIED_USER,DEPTNO) "
			+ "VALUES"
			+ " (#{empno},#{empName},#{password},#{job},#{mgr},"
			+ "#{createdDate},#{createdUser},#{modifiedDate},#{modifiedUser},#{deptno})")
	public Integer insertEmp(Emp emp);

	/**
	 * 删
	 * 根据用户名删除用户
	 * @param empName  用户名
	 * @return 收影响的行数
	 */
	@Delete("DELETE FROM DEMO_EMP WHERE EMP_NAME=#{empName}")
	public Integer deleteEmp(String empName);

	/**
	 * 改
	 * 根据个人用户名用户修改个人信息
	 * @param emp 用户之前的个人信息
	 * @return 收影响的行数
	 */
	@Update("UPDATE DEMO_EMP SET EMP_NAME=#{empName},PASSWORD=#{password} WHERE EMP_ID=#{id}")
	public Integer updateEmp(Emp emp);

	/**
	 * 查
	 * 根据用户名查询用户数据
	 * @param empName 用户名
	 * @return 与参数用户名匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	@Select("SELECT "
			+ "EMP_ID AS id, EMPNO,EMP_NAME AS empName,PASSWORD,JOB,MGR,"
			+ "CREATE_DATE,CREATE_USER, MODIFIED_DATE,"
			+ "MODIFIED_USER  AS modifiedUser,DEPTNO FROM DEMO_EMP"
			+ " WHERE"
			+ " EMP_NAME = #{empName}")
	public Emp getEmpByEmpName(String empName);

	/**
	 * 查
	 * 根据id查询用户数据
	 * @param id 用户id
	 * @return 与参数用户id匹配的用户数据，如果没有匹配的数据，则返回null
	 */ 
	@Select("SELECT "
			+ "EMPNO,EMP_NAME AS empName,PASSWORD,JOB,MGR,"
			+ "CREATE_DATE AS createDate,CREATE_USER AS createUser,"
			+ " MODIFIED_DATE AS modifiedDate,MODIFIED_USER AS modifiedUser,DEPTNO FROM "
			+ "DEMO_EMP "
			+ "WHERE"
			+ " EMP_ID = #{id}")
	public Emp getEmpByEmpId(int id);

	/**
	 * 查 模糊查询
	 * 
	 * @return 该公司所有员工集合
	 */
	@Select("SELECT"
			+ " D.EMP_ID AS id,"
			+ "EMPNO,"
			+ "EMP_NAME AS empName,"
			+ "JOB,"
			+ "MGR,"
			+ "E.DEPT_NAME AS deptName "
			+ "FROM "
			+ "DEMO_EMP D JOIN DEMO_DEPT E "
			+ "ON D.DEPTNO=E.DEPTNO"
			+" WHERE "
			+ " D.EMP_NAME like #{empName}")
	public List<Emp> queryAllEmps(String empName);

	/**
	 * 查 根据部门号员工
	 * 
	 * @return 该公司员工集合
	 */
	@Select("SELECT EMP_ID AS id,"
			+ "EMPNO,EMP_NAME AS "
			+ "empName,JOB,MGR,CREATE_DATE AS createDate,"
			+ "CREATE_USER AS createUser, "
			+ "MODIFIED_DATE AS modifiedDate,"
			+ "MODIFIED_USER AS modifiedUser"
			+ " FROM DEMO_EMP  "
			+ "WHERE "
			+ "deptno = #{deptno}")
	public List<Emp> queryEmpsByDeptno(String empName);



}
