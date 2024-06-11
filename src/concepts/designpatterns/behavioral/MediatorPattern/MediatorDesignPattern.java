package concepts.designpatterns.behavioral.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

//Chat mediator where we can send messages to group of users and we can add users
public class MediatorDesignPattern {
	
	public static void main(String[] args) {
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		
		user1.send("Hi All");
		
	}

}
//Mediator interface that will define the contract for concrete mediators.
interface ChatMediator {

	public void sendMessage(String msg, User user);

	void addUser(User user);
}

//Mediator Pattern Colleague Interface where Users can send and receive messages, so we can have User interface or abstract class.
abstract class User {
	//User has a reference to the mediator object, it’s required for the communication between different users.
	protected ChatMediator mediator;
	protected String name;
	
	public User(ChatMediator med, String name){
		this.mediator=med;
		this.name=name;
	}
	
	public abstract void send(String msg);
	
	public abstract void receive(String msg, String sentby);
}

//Implementation of chatMediator through Concrete Mediator - it will have a list of users in the group and provide logic for the communication between the users.
class ChatMediatorImpl implements ChatMediator {

	private List<User> users;
	
	public ChatMediatorImpl(){
		this.users=new ArrayList<>();
	}
	
	@Override
	public void addUser(User user){
		this.users.add(user);
	}
	
	@Override
	public void sendMessage(String msg, User user) {
		for(User u : this.users){
			//message should not be received by the user sending it
			if(u != user){
				u.receive(msg, user.name);
			}
		}
	}

}


class UserImpl extends User {

	public UserImpl(ChatMediator med, String name) {
		super(med, name);
	}

	@Override
	public void send(String msg){
		System.out.println(this.name+": Sending Message="+msg);
		mediator.sendMessage(msg, this);
	}
	@Override
	public void receive(String msg, String sentby) {
		System.out.println(this.name+" you have received from the user : "+ sentby+ " 'text' : "+msg);
	}

}


