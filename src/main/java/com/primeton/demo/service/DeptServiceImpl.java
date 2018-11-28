package com.primeton.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.primeton.demo.dao.IDeptMapper;
import com.primeton.demo.excption.DemoException;
import com.primeton.demo.model.Dept;
import com.primeton.demo.model.ResponseResult;
import com.primeton.demo.model.Emp;

/**
 * 组织级业务逻辑
 * 
 * @author liuya
 *
 */
@Service("deptService")
@Transactional(rollbackFor = Exception.class)
public class DeptServiceImpl implements IDeptService {

	@Autowired
	IDeptMapper orgMapper;

	/**
	 * 增 插入新的部门信息， 根据用户名查询部门信息判断该部门是否存在则插入 否则抛出异常
	 */
	@Override
	public Dept createDept(Dept dept) {

		Dept data = getDeptByDeptName(dept.getDeptName());
		if (data == null) {
			orgMapper.insertDept(dept);
		} else {
			throw new DemoException("用户名(" + dept.getDeptName() + ")已经被注册！", ResponseResult.ERROR_DEPTNAME);
		}
		return dept;
	}

	/**
	 * 删 根据部门编号查询子部门信息如果有则提示先删除子部门 没有则删除下属员工和改部门
	 */
	@Override
	@Transactional
	public Integer removeDept(String deptno) {

		List<Dept> deptList = queryDeptByLeader(deptno);
		Integer row;
		if (deptList.size() == 0) {
			Integer r = removeEmpBydeptno(deptno);
			row = orgMapper.deleteDept(deptno);
			return row + r;
		} else {

			throw new DemoException("删除失败，有下属部门", ResponseResult.ERROR_DELETE);
		}
	}

	/**
	 * 删 根据部门号删除部门员工
	 */
	@Override
	public Integer removeEmpBydeptno(String deptno) {
		return orgMapper.deleteEmpBydeptno(deptno);
	}

	/**
	 * 改 根据部门编号更新部门信息 只能更新部门名称和部门地址 逻辑： 根据部门编号查询部门信息如果为空则没有该部门抛出异常 如果不为空说明有该部门可以修改
	 * 在修改的同事有可能多人是操作数据库所以抛出异常跟心失败
	 */
	@Override
	public Integer modifyDept(Integer id,String deptName,  String deptno) {

		Dept data = getDeptById(id);
		if (data == null) {
			throw new DemoException("没有该部门", ResponseResult.ERROR_UPDATE);
		} else {
			Dept dept = getDeptByDeptName(deptName);
			Dept d= getDeptByDeptno(deptno);
			if (dept == null&&d==null) {
				data.setDeptName(deptName);
				data.setDeptno(deptno);
				Integer rows = orgMapper.updateDept(id,deptName,deptno);
				if (rows != 1) {
					throw new DemoException("更新失败", ResponseResult.ERROR_UPDATE);
				}
			} else {
				throw new DemoException("部门号或者部门名称冲突", ResponseResult.ERROR_UPDATE);
			}
		}

		return 1;
	}



	/**
	 * 查 根据子部门编号查询下属员工的信息
	 */
	@Override
	public List<Emp> queryEmpByDeptno(String deptno) {

		return orgMapper.queryEmpByDeptno(deptno);
	}

	/**
	 * 查 根据上级领导部门查询子部门信息
	 */
	@Override
	public List<Dept> queryDeptByLeader(String leader) {

		return orgMapper.queryDeptByLeader(leader);
	}

	/**
	 * 查 根据部门号查询部门信息
	 */
	@Override
	public Dept getDeptByDeptno(String deptno) {

		return orgMapper.getDeptByDeptno(deptno);
	}

	/**
	 * 查 根据部门名称查询部门信息
	 */
	@Override
	public Dept getDeptByDeptName(String deptName) {

		return orgMapper.getDeptByDeptName(deptName);
	}
	/**
	 * 查 所有的部门
	 * 
	 */
	public List<Dept> queryDepts(){
		return orgMapper.queryDepts();
	}

	@Override
	public Dept getDeptById(Integer id) {
		return orgMapper.getDeptById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public PageInfo<Dept> queryDepts(String deptName,Integer pageNum,Integer pageSize) {
		deptName="%"+deptName+"%";
		if (pageNum == null || pageNum<0) {
			pageNum = 0;
		}
		if (pageSize == null || pageSize<0) {
			pageSize = 5;
		}
		PageHelper.startPage(pageNum, pageSize);
		List<Dept> depts = orgMapper.queryDeptsByDeptName(deptName);
		return new PageInfo<Dept>(depts);
	}

}
