package edu.project4;

import edu.project4.FractalFlame.RecordClasses.Rect;

public final class Constants {
    public static final int WIDTH = 2560;
    public static final int HEIGHT = 1440;
    public static final int ITERATIONS_FOR_CENTER = 20;
    public static final double RECT_X = -1;
    public static final double RECT_WIDTH = 2;
    public static final double RECT_Y = -1;
    public static final double RECT_HEIGHT = 2;
    public static final Rect RECT = new Rect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
    public static final int COUNT_AFFINE_TRANSFORMATIONS = 15;
    public static final double GAMMA = 1.9;
    public static final long COUNT_SAMPLES = 3_000L;
    public static final long COUNT_ONE_SAMPLE = 40_000L;
    public static final int SYMMETRY = 3;
    public static final double A_AFFINE_MAX = 1;
    public static final double A_AFFINE_MIN = -1;
    public static final double B_AFFINE_MAX = 1;
    public static final double B_AFFINE_MIN = -1;
    public static final double C_AFFINE_MAX = 1;
    public static final double C_AFFINE_MIN = -1;
    public static final double D_AFFINE_MAX = 1;
    public static final double D_AFFINE_MIN = -1;
    public static final double E_AFFINE_MAX = 1;
    public static final double E_AFFINE_MIN = -1;
    public static final double F_AFFINE_MAX = 1;
    public static final double F_AFFINE_MIN = -1;

    private Constants() {
    }
}
