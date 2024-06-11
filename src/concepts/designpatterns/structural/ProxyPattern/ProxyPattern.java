package concepts.designpatterns.structural.ProxyPattern;

import java.io.IOException;

//This is just for explanation it wont execute as expected.
public class ProxyPattern {
	public static void main(String[] args){
		CommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
		try {
			String[] cmds = {"ls -ltr"," rm -rf abc.pdf"};
			executor.runCommand(cmds);
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}
		
	}
}

//Interface for executing the commands
interface CommandExecutor {

	public void runCommand(String[] cmd) throws Exception;
}


class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String[] cmd) throws IOException {
                //some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}

}

//Here we are allowing only admin to run all the commands, other than admin no one can execute the rm commands.
class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor executor;
	
	public CommandExecutorProxy(String user, String pwd){
		if("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) isAdmin=true;
		executor = new CommandExecutorImpl();
	}
	
	@Override
	public void runCommand(String[] cmds) throws Exception {
		if(isAdmin){
			executor.runCommand(cmds);
		}else{
			for(String cmd:cmds) {
			if(cmd.trim().startsWith("rm")){
				throw new Exception("rm command is not allowed for non-admin users.");
			}else{
				String[] temp = {cmd};
				executor.runCommand(temp);
			}
			}
		}
	}

}