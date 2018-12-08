/*  File: DataBaseBuffer.java
 *
 *  This is a the main program which contains the algorithm controls execution of
 *  readers and writers. It also provide animation canvas to the applet class.
 *  Readers can access the shared buffer simultaneously, but the writers have to access
 *  the shared buffer exclusively.
 *
 *  The want-to-in readers and writers will wait in a queue in the order of their arrival
 *  first, then try to acquire the lock to access the shared data buffer.
 *
 *  If the user chooses "Same Priority", the readers and writers will access the
 *  shared data buffer in the order of their arrival. If there is any writer arrived
 *  before the waiting reader(s), the waiting reader(s) cannot access the shared data even
 *  there is a reader reading.
 *
 *  If the user chooses "Readers have Priority", the writers have to give up their chances
 *  if there is any reader is waiting in the queue. In this situation, the writers may
 *  experience the starvation.
 *
 *  If the user chooses "Writers have Priority", the readers have to give up their chances
 *  if there is any writer is waiting in the queue. In this situation, the readers may
 *  experience the starvation.
 *
 */
package ReaderWriter;

import java.awt.*;

public class DataBaseBuffer extends Canvas{
	int[] readWantQ;
	int[] writerWantQ;
	String[] wantQ;
	int frameDelay = 1560;

	private int writerID;
	private int readerCount;
	private int wantCount;
	private int readerWantCount, writerWantCount;
	private int writerCount;
	private int wn, rn; 					// the number of readers and writers
	private int readTop, readBottom, writerTop, writerBottom;
	private int wantTop, wantBottom;
	private Font font;
	private FontMetrics fm;
	private boolean readLock  = false;
	private boolean writeLock = false;

	public DataBaseBuffer( ){

		resize(500, 300);
		setBackground(Color.white);
		font = new Font("TimesRoman", Font.BOLD, 18);
		fm	 = getFontMetrics(font);
 	 }

	public void setSize(int readerN, int writerN)
	{
		rn = readerN;
		wn = writerN;

		readTop 	= readBottom  = writerTop 		= writerBottom 	  = 0;
		readerCount = writerCount = readerWantCount = writerWantCount = 0;
		wantTop 	= wantBottom  = 0;
		wantCount   = 0;
		writerID	= 0;
		readLock	= false;
		writeLock 	= false;
		wantQ		= new String[rn+wn];
		writerWantQ = new int[wn];
		readWantQ	= new int[rn];
		repaint();

	}

	/* The waiting queue is implemented as an array to handle the "Writers have Priority"
	 * and "Readers have Priority" situation more easily.
	 */
	public synchronized void enterQueue(String s, int id)
	{
		wantQ[wantTop] = s + id;
		wantTop ++;
		wantCount ++;
		repaint();
	}

	public synchronized void dequeue(String s, int id )
	{
		String str;
		str = s+id;
		while(!wantQ[0].equals(str))
		{
			try{ wait(); } catch(InterruptedException e) { }
		}
		for(int i = 0; i < (wantTop-1); i++)
		{
			wantQ[i] = wantQ[i+1];
		}
		wantTop --;
		wantCount --;
		repaint();
	}

	/* This method is to move the writer ahead in "Writers have Priority" situation.
	 * Or move the reader ahead in "Readers have Priority" situation.
	 */
	public synchronized void changePosition(String s, int id)
	{
		String str;
		String tmp;

		int pos = 0;     	//to find the posting of 1st writer
		String wtr;
		wtr = s+id;


		while(!(wantQ[pos].equals(wtr)))
		{
			pos++;
		}

		for(int i = 0; i < wantTop; i++)
		{
			System.out.println(wantQ[i]);
		}
		str = wantQ[pos];
		for(int i = pos; i > 0; i--)
		{
			wantQ[i] = wantQ[i-1];
		}
		wantQ[0] = str;
		repaint();
		for(int i = 0; i < wantTop; i++)
		{
			System.out.println(wantQ[i]);
		}
	}


	public synchronized boolean hasWriterWant()
	{
		return (writerWantCount > 0);
	}

	public synchronized boolean hasReaderWant()
	{
		return (readerWantCount > 0);
	}

	public synchronized void acquireReadLock(ReaderWriterApplet applet, int id)
	{
		readWantQ[readTop] = id;     //nums is the index for readWantQ
		readTop = (readTop+1) % rn;
		readerWantCount ++;
		repaint();
		notifyAll();
		enterQueue("R", id);
		applet.r[id].status = 1;    //want in
		applet.mc.println(applet.r[id].status, "r", id);
		try{	applet.r[id].sleep(frameDelay);	}catch(InterruptedException e) {}

		if(applet.writerPriority)
		{
			while(hasWriterWant() || writeLock)
			{
				applet.r[id].status = 3;
				applet.mc.println(applet.r[id].status, "r", id);
				try{ wait(); } catch(InterruptedException e) { }
			}//end of while loop
		}//end of if statement
		else if(applet.readerPriority)
		{
			while(readWantQ[readBottom] != id)
			{
				try { wait(); } catch(InterruptedException e) {}
			}
			changePosition("R",id);
		}
		else
		{
			applet.r[id].status = 3;
			applet.mc.println(applet.r[id].status, "r", id);
			while(!wantQ[wantBottom].equals("R"+id))
			{
				try{ wait(); } catch(InterruptedException e) { }
			}
		}

		while(writeLock)		//if there is any writer is writing
		{
			applet.r[id].status = 3;
			applet.mc.println(applet.r[id].status, "r", id);
			try{ wait(); } catch(InterruptedException e) { }
		}

		if(readLock == false)
		{
			readLock = true;
			notifyAll();
	    }

		readBottom = (readBottom+1) %rn;
		readerWantCount --;
		dequeue("R", id);
		readerCount ++;
		repaint();
		applet.r[id].status = 2;
		applet.mc.println(applet.r[id].status, "r", id);
		System.out.println("Reader "+id + "is reading");
		notifyAll();
	}

	public synchronized boolean hasReader()
	{
		return (readerCount > 0);
	}
	public synchronized void releaseReadLock(ReaderWriterApplet applet,int id)
	{
			readerCount --;
			notifyAll();
			if(!hasReader())
			{
				readLock = false;
				notifyAll();
				applet.r[id].status = 4;
				applet.mc.println(applet.r[id].status, "r", id);
			}
			repaint();
	}

	public synchronized void acquireWriteLock(ReaderWriterApplet applet, int id)
	{
		writerWantQ[writerTop] = id;
		writerTop=(writerTop+1)%wn;
		writerWantCount ++;
		notifyAll();
		repaint();
		enterQueue("W", id);
		applet.w[id].status = 1;  				//want in
		applet.mc.println(applet.w[id].status, "w", id);
		try{ applet.w[id].sleep(frameDelay); }catch(InterruptedException e) {}


		if(applet.writerPriority)
		{
			while(writerWantQ[writerBottom] != id)
			{
				try{ wait(); } catch(InterruptedException e) { }
			}
			/* change the  positions of writer and other readers */
			changePosition("W", id);
			while(readLock || writeLock)
			{
				try{ wait(); } catch(InterruptedException e) { }
			}
		}
		else if(applet.readerPriority)
		{
			while(!(wantQ[wantBottom].equals("W"+id)) || hasReaderWant() || readLock || writeLock)
			{
				try{ wait(); } catch(InterruptedException e) { }
			}
			System.out.println("Writer "+ id + " move forward");
		}
		else
		{
			while(!(wantQ[wantBottom].equals("W"+id)))
			{
				try{ wait(); } catch(InterruptedException e) { }
			}
			while(readLock || writeLock)
			{
				try{ wait(); } catch(InterruptedException e) { }
			}
		}

		writeLock = true;
		System.out.println("Writer "+ id+ " Got the lock ******");
		notifyAll();
		dequeue("W", id);
		writerBottom = (writerBottom + 1)%wn;
		writerID = id;
		writerWantCount --;
		writerCount++;
		notifyAll();
		repaint();
		applet.w[id].status = 2;
		applet.mc.println(applet.w[id].status, "w", id);
	}

	public synchronized void releaseWriteLock(ReaderWriterApplet applet, int id)
	{
		        System.out.println("Writer " + id + " released the lock");
		        writerCount --;
				writerID  = 0;
				writeLock = false;
				notifyAll();
				repaint();
    }


	public void clear()
	{
		writerBottom 	= writerTop = 0;
		readBottom 		= readTop 	= 0;
		writerWantCount = 0;
		readerWantCount = 0;
		readerCount 	= 0;
		writerCount 	= 0;
		readLock 		= writeLock = false;

		writerWantQ 	= new int[wn];
		readWantQ 		= new int[rn];
		wantQ			= new String[wn+rn];
		wantTop 		= wantBottom = 0;
	}

	/* print the queue on the canvas */
	public void paint(Graphics g){
		int xpos = 630;
		int ypos = 5;
		g.setFont(new Font("TimesRoman", Font.BOLD, 11));
		g.setColor(Color.green);
		g.draw3DRect(xpos, ypos, 10, 10, true);
		g.fillRect(xpos, ypos, 10, 10);
		g.drawString("Reading", xpos+15, ypos+10);
		g.setColor(Color.red);
		g.draw3DRect(xpos, ypos+14, 10, 10, true);
		g.fillRect(xpos, ypos+14, 10, 10);
		g.drawString("Writing", xpos+15, ypos+25);
		g.setColor(Color.blue);
		g.draw3DRect(xpos, ypos+28, 10, 10, true);
		g.fillRect(xpos, ypos+28, 10, 10);
		g.drawString("Empty", xpos+15, ypos+40);

		g.setFont(new Font("TimesRoman", Font.BOLD, 14));
		g.setColor(Color.blue);
		xpos = 40;
		ypos = 50;
		g.drawString("Waiting Queue", xpos-5, ypos-20);

		/** Draw want-in queue on the top of canvas **/
		int i = wantBottom;
		for(int j = 0; j < wantCount; j++)
		{
			if(	wantQ[i].equals("W1") || wantQ[i].equals("W2")
			  ||wantQ[i].equals("W3")|| wantQ[i].equals("W4")
			  ||wantQ[i].equals("W5"))
			{
				g.setColor(Color.red);
				g.drawString(wantQ[i], xpos+450-30*j, ypos-18);
				g.draw3DRect(xpos+445-30*j, ypos-35, 28, 28, true);
			}
			if( wantQ[i].equals("R1") || wantQ[i].equals("R2")
			  ||wantQ[i].equals("R3")|| wantQ[i].equals("R4")
			  ||wantQ[i].equals("R5"))
			  {
				g.setColor(Color.green);
				g.drawString(wantQ[i], xpos+450-30*j, ypos-18);
				g.draw3DRect(xpos+445-30*j, ypos-35, 28, 28, true);
			  }
			i = (i+1) % (wn+rn);
		}

		/** Draw database buffer on canvas      **/
		if(readLock) 	     		g.setColor(Color.green);
		else if(writeLock) 		    g.setColor(Color.red);
		else                 		g.setColor(Color.blue);

		g.draw3DRect(xpos+250, ypos+20, 100, 100, true);
		g.fillRect(xpos+250, ypos+20, 100, 100);
		if(readLock)
		{
			g.setColor(Color.black);
			g.drawString("Reading", xpos + 270, ypos+60);
		}
		else if(writeLock)
		{
			g.setColor(Color.black);
			g.drawString("W " +Integer.toString(writerID), xpos + 280, ypos+45);
			g.drawString("Writing", xpos + 270, ypos+60);
		}
	}
}