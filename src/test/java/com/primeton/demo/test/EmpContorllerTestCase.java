package com.primeton.demo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.demo.LiuyaweiDemoApplication;
import com.primeton.demo.controller.EmpController;
import com.primeton.demo.model.Emp;
import com.primeton.demo.model.ResponseResult;
import com.primeton.demo.service.IEmpService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiuyaweiDemoApplication.class)

public class EmpContorllerTestCase {

	@Autowired
	private EmpController empController;
	@Autowired
	private IEmpService empService;

	/**
	 * 可重复执行测试方法
	 */
	@Test
	public void testEmp() {
		testRemoveEmp();
		testCreateEmp();
		testModifyEmp();
	}

	/**
	 * 增 添加用户 yes
	 */
	public void testCreateEmp() {
		Emp emp = new Emp();
		emp.setEmpno("111");
		emp.setEmpName("liuu");
		emp.setPassword("123");
		ResponseResult<Emp> r = empController.createEmp(emp);
		Assert.assertNotNull("创建用户信息异常", r);
	}

	/**
	 * 删 删除 yes
	 */
	public void testRemoveEmp() {
		ResponseResult<Void> rr = empController.removeEmp("liu");
		Assert.assertNotNull("1004", rr.getState());
	}

	/**
	 * 改 修改 yes
	 */
	public void testModifyEmp() {
		Emp emp = new Emp();
		
		Emp e=empService.getEmpByEmpName("liuu");
		emp.setId(e.getId());
		emp.setEmpName("liu");
		emp.setPassword("123");
		ResponseResult<Void> rr = empController.modifyEmp(emp);
		Assert.assertNotNull("1", rr.getState());
	}

}
