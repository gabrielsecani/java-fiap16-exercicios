package org.gabs.test;

import org.gabs.bo.BusiRunnable;

public class BusiThreadTest {

	public static void main(String[] args) {
		new Thread();
		BusiRunnable runA = new BusiRunnable("A",1);
		final Thread t1 = new Thread(runA, "busi1");
		final Thread t3 = new Thread(new BusiRunnable("B", 2), "busi3");

		t1.start();
		t3.start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.currentThread().join(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t1.stop();
				try {
					Thread.currentThread().join(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t3.stop();
			}
			
		}).start();
	}

}
