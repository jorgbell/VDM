package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: Lambda.kt */
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String renderLambdaToString = Reflection.renderLambdaToString(this);
        Intrinsics.checkNotNullExpressionValue(renderLambdaToString, "Reflection.renderLambdaToString(this)");
        return renderLambdaToString;
    }
}
