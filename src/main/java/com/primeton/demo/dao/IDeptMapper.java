package com.primeton.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.primeton.demo.model.Dept;
import com.primeton.demo.model.Emp;

/**
 * 组织级别数据层接口
 * 
 * @author liuya
 *
 */
@Mapper
public interface IDeptMapper {

	/**
	 * 增 添加部门
	 * 
	 * @param dept 部门数据存放的对象
	 * @return 受影响的行数
	 */
	@Insert("INSERT INTO " + "DEMO_DEPT " + "(DEPTNO,DEPT_NAME,LOC,LEADER) " + "VALUES "
			+ "(#{deptno}, #{deptName}, #{loc},#{leader}) ")
	public Integer insertDept(Dept dept);

	/**
	 * 删 根据部门号删除部门 分析： 删除高级部门是要判断是否有下属部门存在 如果存在则提示不可删除或者先删除下属部门
	 * 如果没有下属部门则就删除下属员工在删除下属部门
	 * 
	 * @param deptno 部门号
	 * @return 受影响的行数
	 */
	@Delete("DELETE FROM DEMO_DEPT WHERE DEPTNO=#{deptno}  ")
	public Integer deleteDept(String deptno);

	/**
	 * 删 根据部门编号删除员工
	 * 
	 * @param deptno 部门编号
	 * @return 受影响的行数
	 */
	@Delete("DELETE FROM DEMO_EMP WHERE DEPTNO = #{deptno}")
	public Integer deleteEmpBydeptno(String deptno);

	/**
	 * 改 根据部门号修过部门名称和部门地址
	 * 
	 * @return 受影响的行数
	 */
	@Update("UPDATE DEMO_DEPT SET DEPT_NAME=#{deptName},DEPTNO=#{deptno}WHERE DEPT_ID=#{id}")
	public Integer updateDept(Integer id,String deptName,  String deptno);

	/**
	 * 查 根据该部门号查询该部门的全部人员的信息
	 * 
	 * @param deptno 部门编号
	 * @return 该部门全部人员信息集合
	 */
	@Select("SELECT" + " E.EMP_ID, E.EMPNO,E.EMP_NAME,E.JOB,E.MGR,E.CREATE_DATE,E.CREATE_USER, "
			+ "E.MODIFIED_DATE,E.MODIFIED_USER  " + "FROM " + "DEMO_EMP E " + "JOIN " + " DEMO_DEPT D " + "ON "
			+ "(E.DEPTNO = D.DEPTNO) " + "WHERE" + " E.DEPTNO=#{deptno}")
	public List<Emp> queryEmpByDeptno(String deptno);

	/**
	 * 查 根据部门名称查询部门信息
	 * 
	 * @param deptName 部门名称
	 * @return 包含部门信息的数据对象
	 */
	@Select("SELECT DEPT_ID AS id, DEPTNO,DEPT_NAME AS deptName,LOC,LEADER FROM DEMO_DEPT WHERE DEPT_NAME=#{deptName}")
	public Dept getDeptByDeptName(String deptName);

	/**
	 * 查 根据部门号查询部门信息
	 * 
	 * @param deptno 部门编号
	 * @return 包含部门信息的数据对象
	 */
	@Select("SELECT DEPT_ID AS id,DEPTNO,DEPT_NAME AS deptName,LOC,LEADER FROM DEMO_DEPT WHERE DEPTNO=#{deptno}")
	public Dept getDeptByDeptno(String deptno);
	
	
	/**
	 * 查 根据部门id查询部门信息
	 * 
	 * @param deptno 部门编号
	 * @return 包含部门信息的数据对象
	 */
	@Select("SELECT DEPT_ID AS id, DEPTNO,DEPT_NAME AS deptName,LOC,LEADER FROM DEMO_DEPT WHERE DEPT_ID=#{id}")
	public Dept getDeptById(Integer id);

	/**
	 * 查 根据部门号查询附属部门
	 * 
	 * @param deptno 部门号
	 * @return
	 */
	@Select("SELECT DEPT_ID AS id,DEPTNO, DEPT_NAME AS deptName,LEADER,LOC "
			+ "FROM DEMO_DEPT WHERE LEADER=#{leader}")
	public List<Dept> queryDeptByLeader(String leader);
	
	/**
	 * 查 根据部门名称模糊查询
	 */
	@Select("SELECT DEPT_ID AS id,DEPTNO, DEPT_NAME AS deptName,LEADER,LOC "
			+ "FROM DEMO_DEPT WHERE DEPT_NAME like #{deptName}")
	public List<Dept> queryDeptsByDeptName(String deptName);

	/**
	 * 查 所有的部门
	 * 
	 * @param deptno 部门号
	 * @return
	 */
	@Select("SELECT DEPT_ID AS id,DEPTNO, DEPT_NAME AS deptName,LEADER,LOC FROM DEMO_DEPT")
	public List<Dept> queryDepts();

}
