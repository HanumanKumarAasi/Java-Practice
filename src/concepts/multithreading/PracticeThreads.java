package concepts.multithreading;

public class PracticeThreads {

	
	public static void main(String args[]) {
		/*
		 * System.out.println("main is started");
		 * 
		 * Thread thread2 = new Thread(new Thread2(),"UserThread2"); thread2.start();
		 * 
		 * Thread thread3 = new Thread(()->{ for(int i=0;i<5;i++) {
		 * System.out.println("User thread "+ Thread.currentThread().getName()+" "+i); }
		 * },"UserThread2"); thread3.start();
		 * 
		 * System.out.println("main is finished");
		 */
		
		//-------------------------stack operation for synchronization------------------
		/*
		 * ThreadStack stack = new ThreadStack(5);
		 * 
		 * new Thread(()->{ int count=0; while(++count<10) {
		 * System.out.println("pushing ele : "+stack.push(count)); }
		 * },"pusher").start();
		 * 
		 * new Thread(()->{ int count=0; while(++count<10) {
		 * System.out.println("popping ele : "+stack.pop()); } },"pusher").start();
		 */
	
		//-----------------------------Threads state-----------------------------------
		/*
		 * Thread threadStates = new Thread(()->{ try { Thread.sleep(1000); for(int
		 * i=0;i<100;i++) {
		 * 
		 * } }catch(Exception e) {
		 * 
		 * } }); System.out.println(threadStates.getState());//NEW
		 * threadStates.start();//ACTIVE - RUNNABLE or RUNNING
		 * System.out.println(threadStates.getState());// TIME WAITING while(true) {
		 * System.out.println(threadStates.getState());
		 * if(threadStates.getState()==Thread.State.TERMINATED) { break; }
		 * 
		 * }
		 */
		
		//---------------------------join()---------------
		/*
		 * System.out.println("main method started...."); Thread threadJoin = new
		 * Thread(() -> { try { for (int i = 0; i < 10; i++) { System.out.println(i); }
		 * } catch (Exception e) {
		 * 
		 * } }); Thread threadJoin1 = new Thread(() -> { try { for (int i = 0; i < 10;
		 * i++) { System.out.println("join1"+i); } } catch (Exception e) {
		 * 
		 * } }); threadJoin.start(); try { threadJoin.join(1000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } threadJoin1.start(); try { threadJoin1.join(); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * System.out.println("main method finished.....");
		 */
		
		/*Thread thread1 = new Thread(()->{System.out.println(Thread.currentThread().getName());},"thread1");
		thread1.setPriority(2);
		Thread thread2 = new Thread(()->{System.out.println(Thread.currentThread().getName());},"thread2");
		thread2.setPriority(1);
		Thread thread3 = new Thread(()->{System.out.println(Thread.currentThread().getName());},"thread3");
		thread3.setPriority(3);
		Thread thread5 = new Thread(()->{System.out.println(Thread.currentThread().getName());},"thread5");
		thread5.setPriority(1);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread5.start();*/
		
		
		//Deadlock
		char a[] = {'c','h','a','r'};
		String str1 = new String(a);
		String str2 = new String(a);
		
		Thread thread1 = new Thread(()->{
			synchronized(str1) {
				System.out.println("str1 acquired...");
				synchronized(str2) {
					System.out.println("str2 acquired...");
				}
			}
		},"");
		
		Thread thread2 = new Thread(()->{
			synchronized(str2) {
				System.out.println("str2 acquired...");
				synchronized(str1) {
					System.out.println("str1 acquired...");
				}
			}
		},"");
		
		thread1.start();
		thread2.start();
	}
}


