/*
	Imagine you have a call center with three levels of employees: 
respondent, manager, and director. 

	An incoming telephone call must be first allocated to a 
respondent who is free. If the respondent can't handle the call, 
he or she must escalate the call to a manager. If the manager is 
not free or notable to handle it, then the call should be escalated 
to a director. Design the classes and data structures for this 
problem. Implement a method dispatchCall() which assigns a call to 
the first available employee.
*/


/*
	CallHandler is implemented as a singleton class. It represents 
the body of the program, and all calls are funneled first through it.
*/
public class CallHandler{
	private static CallHandler callHandler;

	/* 3 levels of employees: respondents, managers, directors. */
	private final int LEVELS = 3;

	/* Initialize 10 respondents, 4 managers, and 2 directors. */
	private final int NUM_REPRESENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;

	/* List of employees, by level.
	* employeeLevels[0] = respondents 
	* employeeLevels[1] = managers
	* employeeLevels[2] = directors */

	ArrayList<ArrayList<Employee>> employeeLevels;

	/* queues for each call's rank */
	ArrayList<ArrayList<Call>> callQueues;

	protected CallHandler(){
		employeeLevels = new ArrayList<ArrayList<Employee>>(LEVELS);
		callQueues = new ArrayList<ArrayList<Call>>(LEVELS);

		// Create respondents
		ArrayList<Employee> respondents = new ArrayList<Employee>(NUM_REPRESENTS);
		for(int i = 0; i < NUM_REPRESENTS - 1; i ++){
			respondents.add(new Respondent());
		}
		employeeLevels.add(respondents);

		// Create managers
		ArrayList<Employee> managers = new ArrayList<Employee>(NUM_MANAGERS);
		managers.add(new Manager());
		employeeLevels.add(managers);

		ArrayList<Employee> directors = new ArrayList<Employee>(NUM_DIRECTORS);
		directors.add(new Director());
		employeeLevels.add(directors);
	}

	/* Get instance of singleton class. */
	public static CallHandler getInstance(){
		if(callHandler == null)
			callHandler = new CallHandler();
		return callHandler;
	}

	/* Gets the first available employee who can handle this call. */
	public Employee getHandlerForCall(Call call){
		for(int level = call.getRank().getValue(); level < LEVELS - 1; level ++){
			ArrayList<Employee> employeeLevel = employeeLevels.get(level);
			for(Employee e : employeeLevel){
				if(e.isFree())
					return e;
			}
		}
		return null;
	}

	/* Routes the call to an available employee, or saves in a queue 
	* if no employee available. */
	public void dispatchCall(Caller caller){
		Call call = new Call(caller);
		dispatchCall(call);
	}

	/* Routes the call to an available employee, or saves in a queue if no employee available. */
	public void dispatchCall(Call call){
		/* Try to route the call to an employee with minimal rank. */
		Employee e = getHandlerForCall(call);
		if(e != null){
			e.receiveCall(call);
			call.setHandler(e);
		}else{
			/* Place the call into corresponding call queue according to its rank. */
			call.reply("Please wait for free employee to reply");
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}

	/* An employee got free. Look for a waiting call that he/she can serve. 
	 * Return true if we were able to assign a call, false otherwise. */
	public boolean assignCall(Employee e){
		/* Check the queues, starting from the highest rank this employee can serve. */
		for(int rank = emp.getRank().getValue(); rank >= 0; rank --){
			ArrayList<Call> queue = callQueues.get(rank);

			/* Remove the first call, if any */
			if(queue.size() > 0){
				Call call = queue.remove(0);
				if(call != null){
					e.receiveCall(call);
					return true;
				}
			}
		}
		return false;
	}
}

public enum Rank{
	Responder(0), Manager(1), Director(2);

	private int value;

	private Rank(int v){
		value = v;
	}

	public int getValue(){
		return value;
	}
}

/* Call represents acall froma user. A call hasa minimumrank and isassigned 
* to the first employee who can handle it.
*/
public class Call{
	/* Minimal rank of employee whocan handle this call. */
	private Rank rank;
	/* Person who is calling. */
	private Caller caller;
	/* Employee who is handling call. */
	private Employee handler;

	public Call(Caller c){
		rank = Rank.Responder;
		caller = c;
	}

	/* Set employee who is handling call */
	public void setHandler(Employee e){
		handler = e;
	}

	/* Play recorded message to the customer. */
	public void reply(String message){
		System.out.println(message);
	} 

	public Rank getRank(){
		return rank;
	}

	public void setRank(Rank r){
		rank = r;
	}

	public Rank incrementRank(){
		if(rank == Rank.Responder){
			rank = Rank.Manager;
		}
		else if(rank == Rank.Manager){
			rank = Rank.Director;
		}
		return rank;
	}

	/* Disconnect call. */
    public void disconnect(){
        reply("Thank you for calling");
    }
}


public class Caller{
	private String name;
	private int userId;
	
	public Caller(int id, String n){
		userId = id;
		name = n;
	}
}


/* Employee is a super class for the Director, Manager, and Respondent classes. It is implemented as an
 * abstract class, since there should be no reason to instantiated an Employee type directly.
 */
public abstract class Employee{
	private Call currentCall = null;
	protected Rank rank;

	public Employee(){}

	/* Start the conversation */
	public void receiveCall(Call call){
		currentCall = call;
	}

	/* the issue is resolved, finish the call */
	public void callCompleted(){
		if(currentCall != null){
			/* Disconnect the call. */
			currentCall.disconnect();
			/* Free the employee */
			currentCall = null;
		}

		/* Check if there is a call waiting in queue */
		assignNewCall();
	}

	/*The issue has not been resolved. Escalate the call, and assign a new call
    * to the employee.
    */
    public void escalateAndReassign(){
    	if(currentCall != null){
    		/* escalate call */
    		currentCall.incrementRank();
    		CallHandler.getInstance().dispatchCall(currentCall);
    		/* free the employee */
    		currentCall = null;
    	}

    	/* assign a new call */
    	assignNewCall();
    }

    /* Assign a new call to an employee, if the employee is free. */
    public boolean assignNewCall(){
    	if(!isFree()){
    		return false;
    	}
    	return CallHandler.getInstance().assignCall(this);
    }

    /* Returns whether or not the employee is free. */
    public boolean isFree(){
    	return currentCall == null;
    }

    public Rank getRank(){
    	return rank;
    }
}





















