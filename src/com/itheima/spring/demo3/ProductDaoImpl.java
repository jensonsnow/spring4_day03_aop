package com.itheima.spring.demo3;


public class ProductDaoImpl implements ProductDao {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("������Ʒ.......");

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("������Ʒ.......");
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		System.out.println("ɾ����Ʒ.......");
		return "aaa";
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("��ѯ��Ʒ.......");
		int i = 1/0;
	}

}
