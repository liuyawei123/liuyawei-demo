package com.primeton.demo.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.demo.LiuyaweiDemoApplication;
import com.primeton.demo.model.Dept;
import com.primeton.demo.service.IDeptService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiuyaweiDemoApplication.class)

public class DeptControllerTestCase {

	@Autowired
	private IDeptService deptService;

	/**
	 * 可重复执行代码
	 */
	@Test
	public void testDept() {
		testRemoveDept();
		testCreateDept();
		testModifyDept();
	}
	/**
	 * 增 插入 yes
	 */
	public void testCreateDept() {

		Dept dept = new Dept();
		dept.setDeptno("11");
		dept.setDeptName("开发2222");
		dept.setLeader("3");
		Dept res = deptService.createDept(dept);
		assertNotNull("返回的对象为空", res.getDeptName());
	}

	/**
	 * 删 删除部门 yes
	 */
	public void testRemoveDept() {

		Object row = deptService.removeDept("10");
		Assert.assertEquals(1, row);
	}

	/**
	 * 改 根据部门号修改部门信息 yes
	 */
	public void testModifyDept() {
		Dept data=deptService.getDeptByDeptno("11");
		Object row = deptService.modifyDept(data.getId(), "开发1111", "10");
		Assert.assertEquals(1, row);

	}



}
