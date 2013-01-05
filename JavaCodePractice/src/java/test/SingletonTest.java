package java.test;

//method 1: double check/synchronization

public class SingletonTest {
	private static SingletonTest instance;

	private SingletonTest() {
		// do work
	}

	public static SingletonTest getInstance() {
		if (instance == null)
			synchronized (SingletonTest.class) {
				if (instance == null)
					instance = new SingletonTest();
			}
		return instance;
	}
}

// method 2: no synchronization

class SingletonTest2 {
	private static SingletonTest2 instance = new SingletonTest2();

	private SingletonTest2() {
		// do work
	}

	public static SingletonTest2 getInstance() {
		return instance;
	}
}
