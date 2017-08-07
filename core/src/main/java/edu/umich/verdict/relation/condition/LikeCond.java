package edu.umich.verdict.relation.condition;

import edu.umich.verdict.VerdictContext;
import edu.umich.verdict.parser.VerdictSQLParser.Like_predicateContext;
import edu.umich.verdict.relation.expr.Expr;

public class LikeCond extends Cond {
    
    private Expr left;
    
    private Expr right;
    
    private boolean not;

    public Expr getLeft() {
        return left;
    }

    public void setLeft(Expr left) {
        this.left = left;
    }

    public Expr getRight() {
        return right;
    }

    public void setRight(Expr right) {
        this.right = right;
    }

    public boolean isNot() {
        return not;
    }

    public void setNotExists(boolean notExists) {
        this.not = notExists;
    }
    
    public LikeCond(Expr left, Expr right, boolean not) {
        this.left = left;
        this.right = right;
        this.not = not;
    }

    public static LikeCond from(VerdictContext vc, Like_predicateContext ctx) {
        Expr left = Expr.from(vc, ctx.expression(0));
        Expr right = Expr.from(vc, ctx.expression(1));
        boolean not = (ctx.NOT() != null)? true : false;
        
        return new LikeCond(left, right, not);
    }

    @Override
    public Cond withTableSubstituted(String newTab) {
        return new LikeCond(getLeft().withTableSubstituted(newTab), getRight().withTableSubstituted(newTab), isNot());
    }
    
    @Override
    public String toString() {
        return toSql();
    }

    @Override
    public String toSql() {
        StringBuilder sql = new StringBuilder();
        sql.append(left.toSql());
        if (isNot()) {
            sql.append(" NOT");
        }
        sql.append(" LIKE ");
        sql.append(right.toSql());
        return sql.toString();
    }

    @Override
    public boolean equals(Cond o) {
        if (o instanceof LikeCond) {
            return getLeft().equals(((LikeCond) o).getLeft())
                   && getRight().equals(((LikeCond) o).getRight())
                   && (isNot() == ((LikeCond) o).isNot());
        }
        return false;
    }

}
