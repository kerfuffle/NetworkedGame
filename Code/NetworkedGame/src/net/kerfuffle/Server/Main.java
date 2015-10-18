package net.kerfuffle.Server;

public class Main {

	public static void main(String args[])
	{
		final Server server = new Server(25585);
		
		Thread admit = new Thread(new Runnable()
		{
			public void run()
			{
				while (true)
				{

					server.admitClients();
				}
			}
		});
		
		Thread updateThreads = new Thread(new Runnable()
		{
			public void run()
			{
				while (true)
				{
					server.updateThreads();
				}
			}
		});
		
		Thread run = new Thread(new Runnable()
		{
			public void run()
			{
				while (true)
				{
					server.run();
				}
			}
		});
		
		admit.start();
		updateThreads.start();
		run.start();
		
	}
	
}
