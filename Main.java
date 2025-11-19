/**
 * Name: William Wilson
 * Date: 10/11/21
 * Description:Programmng Assignment 5
 */
 
 import java.util.Scanner;
 
 class Main{
	// entry point
	public static Stack<Character> operatorStack;
	public static Queue<Character> infixQueue;
	public static Queue<Character> postfixQueue;
	public static Stack<Integer> evalStack;
	public static Scanner s;
	public static int a;
	public static int b;
	public static char token;
	public static int finalResult;
	public static String postfix = "";
	
	// main function
	public static void main(String[] args){
		s = new Scanner(System.in);
		System.out.print("Enter infix expression: ");
		String equation = s.nextLine();
		System.out.println("Summary");
		System.out.println("-------");
		System.out.println("  Infix: " + equation);
		System.out.println("Postfix: " + infixToPostfix(equation));
		System.out.println("Back to Infix: " + postfixToInfix(infixToPostfix(equation)));
		System.out.println(" Result: " + evalPostfix(infixToPostfix(equation)));
		
	}
	
	// sets the priority for which math value is greater
	public static int getInfixPriority(char c){
		switch(c){
			
			case '+':
			case '-':{
				return 1;
			}
			
			case '*':
			case '/':{
				return 2;
			}
			
			case '^':{
				return 3;
			}
			
			case ')':
			case '(':{
				return 4;
			}
		}
		
		return 0;
		
	}
	
	// sets the priority for which math values should happen first
	public static int getStackPriority(char c){
		switch(c){
			
			case '+':
			case '-':{
				return 1;
			}
			
			case '*':
			case '/':
			case '^':{
				return 2;
			}
		}
		return 0;
	}
	
	// checks if the value c is between 0 and 9
	public static boolean isOperand(char c){
		return c >= '0' && c <= '9';
	}
	
	// will perform a certain operation for the given operator between the two values
	public static int eval(char operator, int a, int b){
		switch(operator){
			
			case '+':{
				return a + b;
			}
			
			case '-':{
				return a - b;
			}
			
			case '*':{
				return a * b;
			}
			
			case '/':{
				return a / b;
			}
			
			case '^':{
				return (int)Math.pow(a, b);
			}
			
			default:{
				return -1;
			}
		}
	}
	
	// infix to postfix function
	public static String infixToPostfix(String infixString){
		postfixQueue = new Queue<Character>();
		operatorStack = new Stack<Character>();
		infixQueue = new Queue<Character>();
		
		// will add all of the values in the equation to the queue
		for(int i = 0; i < infixString.length(); i++){
			infixQueue.enqueue(infixString.charAt(i));
		}
		
		// checks if the queue is not empty, if it is true, then the queue will dequeue the first value to token
		while(!infixQueue.isEmpty()){
			token = infixQueue.dequeue();
			if(isOperand(token)){
				postfixQueue.enqueue(token);
			}
			
			// checks if the token is a right parenthesis, if it is, it will be added to the operatorStack
			else if(token == ')'){
				char c = operatorStack.pop();
				while(c != '('){
					c = operatorStack.pop();
					postfixQueue.enqueue(c);
				}
			}
			
			// checks if operatorStack is not empty, if true then the values will be added to the postfixQueue
			else{
				if(!operatorStack.isEmpty()){
					char c = operatorStack.peek();
					while(getStackPriority(c) >= getInfixPriority(token)){
						c = operatorStack.pop();
						postfixQueue.enqueue(c);
						if(!operatorStack.isEmpty()){
							c = operatorStack.peek();
						}
						else{
							break;
						}
					}
				}
				
				operatorStack.push(token);
			}
			
		}
		
		// checks if the operatorStack is not empty, if true, then the c value will be added to the queue
		while(!operatorStack.isEmpty()){
			char c = operatorStack.pop();
			postfixQueue.enqueue(c);
		}
		
		// will added the values from the postfixQueue to the string postfix
		while(!postfixQueue.isEmpty()){
			postfix += postfixQueue.dequeue();
		}
		
		// returns the postfix string
		return postfix;
	}
	
	// finds the result of the given equation
	public static int evalPostfix(String postfixString){
		postfixQueue = new Queue<Character>();
		evalStack = new Stack<Integer>();
		finalResult = 0;
		
		// adds all the values to the postfixQueue
		for(int i = 0; i < postfixString.length(); i++){
			postfixQueue.enqueue(postfixString.charAt(i));
		}
		
		// checks if the postfixQueue is not empty, if it is then it will be dequeued to token
		while(!postfixQueue.isEmpty()){
			token = postfixQueue.dequeue();
			
			// checks if the value is between 0 and 9, is so, it will be added to evalStack
			if(isOperand(token)){
				evalStack.push(Character.getNumericValue(token));
			}
			
			// will give a and b a value and then will perform the certain operation
			else{
				a = evalStack.pop();
				b = evalStack.pop();
				int answer = eval(token, b, a);
				evalStack.push(answer);
			}
		}
		
		// checks if the eval stack is not empty, if so the final result will be returned
		if(!evalStack.isEmpty()){
			finalResult = evalStack.pop();
			return finalResult;
		}
		
		// returns error value
		return -1;
	}
	
	// was able to get this far on the postfix to infix, the only problem is that it prints it out backwards
	public static String postfixToInfix(String postfixString){
		// creating new stacks and queues
		Queue<Character> postfixToInfixQueue = new Queue<Character>();
		Stack<String> postfixToInfixStack = new Stack<String>();
		
		// adds the contents of the string to the queue
		for(int i = 0; i < postfixString.length(); i ++){
			postfixToInfixQueue.enqueue(postfixString.charAt(i));
		}
		
		// checks if the queue is not empty, then if that is true then the contents will be dequeued from the queue
		while(!postfixToInfixQueue.isEmpty()){
			char c = postfixToInfixQueue.dequeue();
			if(isOperand(c)){
				postfixToInfixStack.push("" + c);
			}
			else{
				postfixToInfixStack.push("(" + postfixToInfixStack.pop() + c + postfixToInfixStack.pop() + ")");
			}
		}
		
		// checks if the stack is not empty, if that is true then it i=will pop from the stack
		if(!postfixToInfixStack.isEmpty()){
			return postfixToInfixStack.pop();
		}
		
		return "";
		
	}
	
 }