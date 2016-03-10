package org.gabs.bo;

public class BusiRunnable implements Runnable {
	int contagem;
	Thread t;
	String nome;
	private long interval;

	private String getIdNome() {
		t = Thread.currentThread();
		return "Thread ID:" + t.getId() + ", Name:" + t.getName() + "; Runnable Name:" + nome;
	}

	public BusiRunnable(String nome, long interval) {
		this.nome = nome;
		this.interval = interval;
		System.out.println(getIdNome() + "; contruido");
	}

	public BusiRunnable(String nome) {
		this(nome, 1000);
	}

	private void conta() {
		System.out.println(getIdNome() + "; Contagem: " + contagem++);
	}

	@SuppressWarnings("unused")
	private void roda() {
		while (Thread.currentThread().isAlive()) {
			// Thread.yield();
			conta();
			Thread.yield();
			conta();
		}
	}

	@Override
	public void run() {
		// t.yield();
		// conta();
		//
		// t.yield();
		// conta();
		conta();
		while (Thread.currentThread().isAlive()) {
			try {
				t.join(this.interval);
//				t.wait(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conta();
		}
	}
}
