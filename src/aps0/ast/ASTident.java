package aps0.ast;

import aps0.interfaces.IASTexpression;
import aps0.interfaces.IASTvisitor;

public class ASTident implements IASTexpression {
	
	private final String name;

	public ASTident(String name) {
		this.name = name;
	}
	
	public String getString() {
		return this.name;
	}

	@Override
	public String toPrologString() {
		return name;
	}
	
	@Override
	public <Result, Env, Err extends Exception> Result accept(IASTvisitor<Result, Env, Err> visitor, Env env)
			throws Err {
		return visitor.visit(this, env);
	}
	
}