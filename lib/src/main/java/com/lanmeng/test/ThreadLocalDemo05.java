package com.lanmeng.test;

public class ThreadLocalDemo05 {
	public static void main(String[] args) {
		User user = new User("jack");
		new Service1().service1(user);
	}

}

class Service1 {
	public void service1(User user) {
		// ��ThreadLocal��ֵ�������ķ���ֱ��ͨ��ThreadLocal��ȡ�����ˡ�
		UserContextHolder.holder.set(user);
		new Service2().service2();
	}
}

class Service2 {
	public void service2() {
		User user = UserContextHolder.holder.get();
		user.setName("server2");
		System.out.println("service2�õ����û�:" + user.name);
		new Service3().service3();
	}
}

class Service3 {
	public void service3() {
		User user = UserContextHolder.holder.get();
		System.out.println("service3�õ����û�:" + user.name);
		// ����������ִ����Ϻ�һ��Ҫִ��remove
		UserContextHolder.holder.remove();
	}
}

class UserContextHolder {
	// ����ThreadLocal����User����
	public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {
	String name;

	public User(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
