package com.itheima.spring.demo3;


public class ProductDaoImpl implements ProductDao {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("保存商品.......");

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("更新商品.......");
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		System.out.println("删除商品.......");
		return "aaa";
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("查询商品.......");
		int i = 1/0;
	}

}
