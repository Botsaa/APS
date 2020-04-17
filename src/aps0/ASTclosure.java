package aps0;

import java.util.List;

import interfaces.IASTexpression;
import interfaces.IASTvisitor;
import interpreter.ExpressionEvaluator;

public class ASTclosure implements IASTexpression {
	
	private final IASTexpression expr;
	private final List<IASTexpression> arguments;
	
	public ASTclosure(IASTexpression expr, List<IASTexpression> arguments) {
		this.expr = expr;
		this.arguments = arguments;
	}

	public IASTexpression getExpr() {
		return this.expr;
	}
	
	public List<IASTexpression> getArguments() {
		return this.arguments;
	}

	@Override
	public <Result, Env, Err extends Exception> Result accept(IASTvisitor<Result, Env, Err> visitor, Env env)
			throws Err {
		return visitor.visit(this, env);
	}
	
	@Override
	public <Result, Env, Err> Result accept(ExpressionEvaluator<Result, Env, Exception> visitor, Env env)
			throws Exception {
		return visitor.visit(this, env);
	}

}
