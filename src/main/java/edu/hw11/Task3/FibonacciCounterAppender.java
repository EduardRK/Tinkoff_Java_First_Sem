package edu.hw11.Task3;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

public class FibonacciCounterAppender implements ByteCodeAppender {
    private static final int N_INDEX = 0;
    private static final int X_INDEX = 1;
    private static final int Y_INDEX = 2;
    private static final int I_INDEX = 3;
    private static final int VARIABLES_COUNT = 3;
    private static final int MAX_STACK = 4;
    private static final int MAX_LOCAL_VARIABLES = 4;

    @Override
    public @NotNull Size apply(
        @NotNull MethodVisitor methodVisitor,
        Implementation.@NotNull Context context,
        @NotNull MethodDescription methodDescription
    ) {
        methodVisitor.visitCode();

        Label elseLabel = new Label();

        //if block
        methodVisitor.visitVarInsn(Opcodes.ILOAD, N_INDEX);
        methodVisitor.visitJumpInsn(Opcodes.IFNE, elseLabel);
        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, N_INDEX);
        methodVisitor.visitInsn(Opcodes.I2L);
        methodVisitor.visitInsn(Opcodes.LRETURN);

        methodVisitor.visitLabel(elseLabel);

        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);

        //set variables
        methodVisitor.visitInsn(Opcodes.ICONST_1);
        methodVisitor.visitVarInsn(Opcodes.ISTORE, X_INDEX); // x
        methodVisitor.visitInsn(Opcodes.ICONST_1);
        methodVisitor.visitVarInsn(Opcodes.ISTORE, Y_INDEX); // y
        methodVisitor.visitInsn(Opcodes.ICONST_2);
        methodVisitor.visitVarInsn(Opcodes.ISTORE, I_INDEX); // i

        Label breakForLabel = new Label();
        Label forLabel = new Label();

        //for block
        methodVisitor.visitLabel(forLabel);

        methodVisitor.visitFrame(
            Opcodes.F_APPEND,
            VARIABLES_COUNT,
            new Object[] {Opcodes.INTEGER, Opcodes.INTEGER, Opcodes.INTEGER},
            0,
            null
        );
        methodVisitor.visitVarInsn(Opcodes.ILOAD, I_INDEX);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, N_INDEX);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, breakForLabel);

        methodVisitor.visitVarInsn(Opcodes.ILOAD, X_INDEX);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, Y_INDEX);
        methodVisitor.visitInsn(Opcodes.IADD);
        methodVisitor.visitVarInsn(Opcodes.ISTORE, Y_INDEX);

        methodVisitor.visitVarInsn(Opcodes.ILOAD, Y_INDEX);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, X_INDEX);
        methodVisitor.visitInsn(Opcodes.ISUB);
        methodVisitor.visitVarInsn(Opcodes.ISTORE, X_INDEX);

        methodVisitor.visitIincInsn(I_INDEX, 1);

        methodVisitor.visitVarInsn(Opcodes.ILOAD, I_INDEX);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, N_INDEX);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, forLabel);

        methodVisitor.visitLabel(breakForLabel);

        //return block
        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, Y_INDEX);
        methodVisitor.visitInsn(Opcodes.I2L);
        methodVisitor.visitInsn(Opcodes.LRETURN);

        methodVisitor.visitMaxs(MAX_STACK, MAX_LOCAL_VARIABLES);
        methodVisitor.visitEnd();

        return new Size(MAX_STACK, MAX_LOCAL_VARIABLES);
    }
}
