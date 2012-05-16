package org.openjasmine.logics;

public class StateMachine {
	Object 	owner;
	State 	currentState;
	State	prevState;
	State	globalState;
	public StateMachine() {
		super();
		// TODO Auto-generated constructor stub
		this.currentState 	= null;
		this.prevState 		= null;
		this.globalState	= null;
		this.owner			= null;
	}
	
	public StateMachine(Object owner) {
		this.currentState 	= null;
		this.prevState 		= null;
		this.globalState	= null;
		this.owner			= owner;
	}
	
	public StateMachine(Object owner, State currentState, State privState,
			State globalState) {
		super();
		this.owner 			= owner;
		this.currentState 	= currentState;
		this.prevState 		= privState;
		this.globalState 	= globalState;
	}

	public Object getOwner() {
		return owner;
	}
	public void setOwner(Object owner) {
		this.owner = owner;
	}
	public State getCurrentState() {
		return currentState;
	}
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	public State getPrivState() {
		return prevState;
	}
	public void setPrivState(State privState) {
		this.prevState = privState;
	}
	public State getGlobalState() {
		return globalState;
	}
	public void setGlobalState(State globalState) {
		this.globalState = globalState;
	}
	
	public void update() {
		if(this.globalState != null) {
			this.globalState.execute(owner);
		}
		if(this.currentState != null) {
			currentState.execute(owner);
		}
	}
	
	/**
	 * 새로운 상태로 변화시킨다.	
	 * @param newState 변화시키고자 하는 새로운 상태
	 */
	public void changeState(State newState) {
		// 이전 상태의 기록을 유지한다.
		this.prevState = this.currentState;
		// 기존 상태의 exit 메소드를 호출한다.
		this.currentState.exit(owner);
		// 상태를 새로운 상태로 변화시킨다.
		this.currentState = newState;
		// 새로운 상태의 enter메소드를 호출한다.
		this.currentState.enter(owner);
	}
	
	public void revertToPrevState() {
		changeState(prevState);
	}
}
