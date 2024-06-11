package concepts.designpatterns.behavioral.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

//In Observer design pattern we have Observers(list of Objects) that are Observing the Subject(Object)
public class ObserverDesignPattern {
	public static void main(String[] args) {
		//create subject
		MyTopic topic = new MyTopic();
		
		//create observers
		Observer obj1 = new MyTopicSubscriber("Obj1");
		Observer obj2 = new MyTopicSubscriber("Obj2");
		Observer obj3 = new MyTopicSubscriber("Obj3");
		
		//register observers to the subject
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		//check if any update is available
		obj1.update();
		
		//now send message to subject
		topic.postMessage("New Message");
	}
}

//Subject Interface
interface Subject {

	//methods to register and unregister observers
	public void register(Observer obj);
	public void unregister(Observer obj);
	
	//method to notify observers of change
	public void notifyObservers();
	
	//method to get updates from subject
	public Object getUpdate(Observer obj);
	
}

interface Observer {
	
	//method to update the observer, used by subject
	public void update();
	
	//attach with subject to observe
	public void setSubject(Subject sub);
}

/*
 * The method implementation to register and unregister an observer is very
 * simple, the extra method is postMessage() that will be used by client
 * application to post String message to the topic. Notice the boolean variable
 * to keep track of the change in the state of topic and used in notifying
 * observers. This variable is required so that if there is no update and
 * somebody calls notifyObservers() method, it doesn’t send false notifications
 * to the observers. Also notice the use of synchronization in notifyObservers()
 * method to make sure the notification is sent only to the observers registered
 * before the message is published to the topic. Here is the implementation of
 * Observers that will watch over the subject.
 */

class MyTopic implements Subject {

	private List<Observer> observers; //list of observers that are subscribing the subject
	private String message;
	private boolean changed;
	private final Object MUTEX= new Object();
	
	public MyTopic(){
		this.observers=new ArrayList<>();
	}
	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) { //synchronization to check that observer already exists or not
		if(!observers.contains(obj)) observers.add(obj);
		}
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
		observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();//updating the observer
		}

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
	public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}

}

//Observer implementation
/*
 * Notice the implementation of update() method where it’s calling Subject
 * getUpdate() method to get the message to consume. We could have avoided this
 * call by passing message as argument to update() method. Here is a simple test
 * program to consume our topic implementation.
 */
class MyTopicSubscriber implements Observer {
	
	private String name;
	private Subject topic;
	
	public MyTopicSubscriber(String nm){
		this.name=nm;
	}
	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if(msg == null){
			System.out.println(name+":: No new message");
		}else
		System.out.println(name+":: Consuming message::"+msg);
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;
	}

}
