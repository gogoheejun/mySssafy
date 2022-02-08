package com.ssafy.pcs;

import java.util.Stack;

public class StackAPITest {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<>();
		System.out.println(stack.size()+"//"+stack.isEmpty());
		
		stack.push("김태희");
		stack.push("양희준");
		stack.push("이서");
		
		System.out.println(stack.size()+"//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size()+"//"+stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.size()+"//"+stack.empty());
		
	}

}
