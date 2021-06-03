/**
 * Integrantes:
 * Pietro Zuntini Bonfim    RA: 743588
 */

package ast;

/**
 * Id "." Id
 */
public class UnaryMessagePassingToExpr extends Expression {

    public UnaryMessagePassingToExpr(Variable instanceVar, TypeCianetoClass sourceClass, MethodDec methodCalled) {
        this.instanceVar = instanceVar;
        this.sourceClass = sourceClass;
        this.methodCalled = methodCalled;
    }

    @Override
    public Type getType() {
        return methodCalled.getReturnType();
    }

    @Override
    public void genC(PW pw, boolean putParenthesis) {
        pw.print("_"+this.sourceClass.getName()+"_"+this.methodCalled.getId()+"(_"+this.instanceVar.getId()+")");
    }

    @Override
    public void genJava(PW pw) {
        pw.print(instanceVar.getId());
        pw.print(".");
        pw.print(methodCalled.getId() + "()");
    }

    private Variable instanceVar;
    private TypeCianetoClass sourceClass;
    private MethodDec methodCalled;
}
