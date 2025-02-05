package com.shinhan.day12;

public class MultiThreadTest3 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
		System.out.println("MAIN END");
	}

	private static void f6() {
		// 데몬thread
		AutoSaveThread tt = new AutoSaveThread();
		tt.setDaemon(true); // 주thread가 끝나면 같이 종료
		tt.start();
		
		try {
			tt.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// PrintThread2 2번 방법
	private static void f5() {
		PrintThread2 t1 = new PrintThread2();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt(); // InterruptedException 발생
		
	}

	// PrintThread2 1번 방법
	private static void f4() {
		PrintThread2 t1 = new PrintThread2();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.setStop(true);		
	}

	private static void f3() {
		WorkObject workObject=new WorkObject();
		
		ThreadA t1 = new ThreadA(workObject);
		ThreadB t2 = new ThreadB(workObject);
		t1.start();
		t2.start();
	}

	private static void f2() {
		Calculator cal = new Calculator();
		User1Thread t1 = new User1Thread();
		User2Thread t2 = new User2Thread();
		
		t1.setCalculator(cal);
		t2.setCalculator(cal);
		
		t1.start();
		t2.start();
		
	}

	private static void f1() {
		SumThread t1 = new SumThread(100);
		SumThread t2 = new SumThread(10);
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); // Thread가 끝날때까지 기다림
			System.out.println(t1.getSum());
			System.out.println(t2.getSum());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
