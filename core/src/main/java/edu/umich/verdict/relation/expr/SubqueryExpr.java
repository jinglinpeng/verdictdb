package edu.umich.verdict.relation.expr;

import edu.umich.verdict.VerdictContext;
import edu.umich.verdict.parser.VerdictSQLParser;
import edu.umich.verdict.relation.ExactRelation;
import edu.umich.verdict.relation.Relation;

public class SubqueryExpr extends Expr {
	
	private Relation subquery;
	
	public SubqueryExpr(Relation subquery) {
		this.subquery = subquery;
	}
	
	public static SubqueryExpr from(Relation r) {
		return new SubqueryExpr(r);
	}
	
	public static SubqueryExpr from(VerdictContext vc, VerdictSQLParser.Subquery_expressionContext ctx) {
		return from(ExactRelation.from(vc, ctx.subquery().select_statement()));
	}
	
	public Relation getSubquery() {
		return subquery;
	}

	@Override
	public <T> T accept(ExprVisitor<T> v) {
		return v.call(this);
	}
	
	@Override
	public String toString() {
		return "(" + subquery.toString() + ")";
	}

	@Override
	public Expr withTableSubstituted(String newTab) {
		return this;
	}
	
	@Override
	public String toSql() {
		return "(" + subquery.toSql() + ")";
	}
}
