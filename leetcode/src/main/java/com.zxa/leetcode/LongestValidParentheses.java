package zxa.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname LongestValidParentheses
 * @Date 2020/7/4 10:21 上午
 * @Created by zhangxinan
 * 最长有效括号
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		int i = longestValidParentheses2(")()())");
		System.out.println(i);
	}


	/**
	 * 只考虑了成对
	 *
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses2(String s) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		char[] chars = s.toCharArray();
		stack.push(-1);
		for (int i = 0; i < chars.length; i++) {
			char aChar = chars[i];
			if (aChar == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if(stack.isEmpty()){
					stack.push(i);
				} else {
					max = max > i - stack.peek() ? max : i - stack.peek();
				}
			}
		}
		return max;

	}

	/**
	 * 只考虑了成对
	 *
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if (stack.isEmpty()) {
				if (aChar == '(') {
					stack.push(aChar);
					continue;
				} else {
					continue;
				}
			}
			char c = stack.peek().charValue();
			if (c == '(') {
				if (aChar != ')') {
					stack.pop();
				}
				stack.push(aChar);
			}
			if (c == ')') {
				if (aChar != '(') {
					stack.pop();
				}
				stack.push(aChar);
			}

		}

		if (!stack.isEmpty() && stack.peek() == '(') {
			stack.pop();
		}
		return stack.size();


	}
}
