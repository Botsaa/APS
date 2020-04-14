package aps1.ast;

import java.util.List;

import aps0.ast.ASTident;
import aps0.interfaces.IASTexpression;
import aps0.interfaces.IASTstatement;
import aps0.interfaces.IASTvisitor;

public class ASTcall implements IASTstatement {
	
	private final ASTident proc;
	private final List<IASTexpression> args;
	
	public ASTcall(ASTident proc, List<IASTexpression> args) {
		this.proc = proc;
		this.args = args;
	}
	
	public ASTident getProc() {
		return this.proc;
	}
	
	public List<IASTexpression> getArgs() {
		return this.args;
	}

	@Override
	public <Result, Env, Err extends Exception> Result accept(IASTvisitor<Result, Env, Err> visitor, Env env)
			throws Err {
		return visitor.visit(this, env);
	}

}
