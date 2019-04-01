// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ThreadPool.java

package com.sinosoft.banklns.utility;

import java.util.LinkedList;

public class ThreadPool
{
	class Worker extends Thread
	{

		Runnable runner;
		final ThreadPool this$0;

		private synchronized void wakeup(Runnable runner)
		{
			this.runner = runner;
			notify();
		}

		public void run()
		{
_L2:
			synchronized (this)
			{
				if (runner == null)
					try
					{
						wait(60000L);
					}
					catch (InterruptedException interruptedexception) { }
			}
			if (runner == null)
			{
				if (notifyTimeout(this))
					return;
				continue; /* Loop/switch isn't completed */
			}
			try
			{
				runner.run();
				break MISSING_BLOCK_LABEL_103;
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			runner = null;
			if (notifyFree(this))
				return;
			continue; /* Loop/switch isn't completed */
			Exception exception;
			exception;
			runner = null;
			if (notifyFree(this))
				return;
			else
				throw exception;
			runner = null;
			if (notifyFree(this))
				return;
			if (true) goto _L2; else goto _L1
_L1:
		}


		private Worker(String name)
		{
			this$0 = ThreadPool.this;
			super(name);
			runner = null;
		}

		Worker(String s, Worker worker)
		{
			this(s);
		}
	}


	private static final long IDLE_TIMEOUT = 60000L;
	private String name;
	private int minsize;
	private int maxsize;
	private int nextWorkerId;
	private LinkedList pool;

	protected ThreadPool()
	{
		this("PooledThread");
	}

	protected ThreadPool(String name)
	{
		this(name, 0, 10);
	}

	protected ThreadPool(String name, int minsize, int maxsize)
	{
		nextWorkerId = 0;
		pool = new LinkedList();
		this.name = name;
		this.minsize = minsize;
		this.maxsize = maxsize;
	}

	public synchronized void run(Runnable runner)
	{
		if (runner == null)
			throw new NullPointerException();
		Worker worker;
		if (!pool.isEmpty())
		{
			worker = (Worker)pool.removeFirst();
		} else
		{
			worker = new Worker((new StringBuilder(String.valueOf(name))).append("-").append(++nextWorkerId).toString(), null);
			worker.start();
		}
		worker.wakeup(runner);
	}

	private synchronized boolean notifyTimeout(Worker worker)
	{
		if (worker.runner != null)
			return false;
		if (pool.size() > minsize)
		{
			pool.remove(worker);
			return true;
		} else
		{
			return false;
		}
	}

	private synchronized boolean notifyFree(Worker worker)
	{
		if (pool.size() < maxsize)
		{
			pool.addLast(worker);
			return false;
		} else
		{
			return true;
		}
	}


}
