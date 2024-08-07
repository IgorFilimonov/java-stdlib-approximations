// Generated by the LibSL translator.  DO NOT EDIT!
// sources:
//  - java/lang/Float.lsl:35
//  - java/lang/Float.main.lsl:18
//
package generated.java.lang;

import java.lang.Class;
import java.lang.Comparable;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * FloatAutomaton for LSLFloat ~> java.lang.Float
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(java.lang.Float.class)
public final class Float implements LibSLRuntime.Automaton, Comparable<Float> {
    private static final long serialVersionUID = -2671257302660747028L;

    public static final int BYTES = 4;

    public static final int SIZE = 32;

    public static final int MAX_EXPONENT = 127;

    public static final int MIN_EXPONENT = -126;

    public static final float MAX_VALUE = 3.4028235E38f;

    public static final float MIN_VALUE = 1.4E-45f;

    public static final float MIN_NORMAL = 1.17549435E-38f;

    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;

    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;

    public static final float NaN = 0.0f / 0.0f;

    public static final Class TYPE = java.lang.Float.class;

    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public float value;

    @LibSLRuntime.AutomatonConstructor
    public Float(Void __$lsl_token, final byte p0, final float p1) {
        this.__$lsl_state = p0;
        this.value = p1;
    }

    @LibSLRuntime.AutomatonConstructor
    public Float(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, 0.0f);
    }

    /**
     * [CONSTRUCTOR] FloatAutomaton::<init>(LSLFloat, double) -> void
     * Source: java/lang/Float.main.lsl:126
     */
    public Float(double v) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.value = ((float) v);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] FloatAutomaton::<init>(LSLFloat, float) -> void
     * Source: java/lang/Float.main.lsl:132
     */
    public Float(float v) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.value = v;
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [SUBROUTINE] FloatAutomaton::_getRawBits(float) -> int
     * Source: java/lang/Float.main.lsl:74
     */
    private static int _getRawBits(float v) {
        int result = 0;
        /* body */ {
            if (v != v) {
                result = 2143289344;
            } else {
                if ((1.0f / v) == NEGATIVE_INFINITY) {
                    result = -2147483648;
                } else {
                    if (v == 0.0f) {
                        result = 0;
                    } else {
                        if (v == POSITIVE_INFINITY) {
                            result = 2139095040;
                        } else {
                            if (v == NEGATIVE_INFINITY) {
                                result = -8388608;
                            } else {
                                result = Engine.makeSymbolicInt();
                                Engine.assume(result != 2143289344);
                                Engine.assume(result != -2147483648);
                                Engine.assume(result != 0);
                                Engine.assume(result != 2139095040);
                                Engine.assume(result != -8388608);
                                if (v < 0.0f) {
                                    Engine.assume(result < 0);
                                } else {
                                    Engine.assume(result > 0);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * [SUBROUTINE] FloatAutomaton::_parse(String) -> float
     * Source: java/lang/Float.main.lsl:105
     */
    private static float _parse(String str) throws java.lang.NumberFormatException {
        float result = 0.0f;
        /* body */ {
            if (str == null) {
                throw new NullPointerException();
            }
            LibSLRuntime.todo();
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::compare(float, float) -> int
     * Source: java/lang/Float.main.lsl:140
     */
    public static int compare(float a, float b) {
        int result = 0;
        // WARNING: no state checks in static context
        /* body */ {
            if ((a == b) || (a != a) || (b != b)) {
                result = 0;
            } else {
                if (a < b) {
                    result = -1;
                } else {
                    result = 1;
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::floatToIntBits(float) -> int
     * Source: java/lang/Float.main.lsl:157
     */
    public static int floatToIntBits(float value) {
        int result = 0;
        // WARNING: no state checks in static context
        /* body */ {
            result = _getRawBits(value);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::floatToRawIntBits(float) -> int
     * Source: java/lang/Float.main.lsl:163
     */
    public static int floatToRawIntBits(float value) {
        int result = 0;
        // WARNING: no state checks in static context
        /* body */ {
            result = _getRawBits(value);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::hashCode(float) -> int
     * Source: java/lang/Float.main.lsl:169
     */
    public static int hashCode(float value) {
        int result = 0;
        // WARNING: no state checks in static context
        /* body */ {
            result = _getRawBits(value);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::intBitsToFloat(int) -> float
     * Source: java/lang/Float.main.lsl:175
     */
    public static float intBitsToFloat(int value) {
        float result = 0.0f;
        // WARNING: no state checks in static context
        /* body */ {
            if (value == 2143289344) {
                result = NaN;
            } else {
                if (value == -2147483648) {
                    result = -0.0f;
                } else {
                    if (value == 0) {
                        result = 0.0f;
                    } else {
                        if (value == 2139095040) {
                            result = POSITIVE_INFINITY;
                        } else {
                            if (value == -8388608) {
                                result = NEGATIVE_INFINITY;
                            } else {
                                result = Engine.makeSymbolicFloat();
                                Engine.assume(result != 0.0f);
                                Engine.assume(result == result);
                                Engine.assume(result != POSITIVE_INFINITY);
                                Engine.assume(result != NEGATIVE_INFINITY);
                                if (value < 0) {
                                    Engine.assume(result < 0.0f);
                                } else {
                                    Engine.assume(result > 0.0f);
                                }
                            }
                        }
                    }
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::isFinite(float) -> boolean
     * Source: java/lang/Float.main.lsl:205
     */
    public static boolean isFinite(float f) {
        boolean result = false;
        // WARNING: no state checks in static context
        /* body */ {
            if (f <= 0.0f) {
                f = 0.0f - f;
            }
            result = f <= MAX_VALUE;
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::isInfinite(float) -> boolean
     * Source: java/lang/Float.main.lsl:215
     */
    public static boolean isInfinite(float v) {
        boolean result = false;
        // WARNING: no state checks in static context
        /* body */ {
            result = (v == POSITIVE_INFINITY) || (v == NEGATIVE_INFINITY);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::isNaN(float) -> boolean
     * Source: java/lang/Float.main.lsl:222
     */
    public static boolean isNaN(float v) {
        boolean result = false;
        // WARNING: no state checks in static context
        /* body */ {
            result = v != v;
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::max(float, float) -> float
     * Source: java/lang/Float.main.lsl:228
     */
    public static float max(float a, float b) {
        float result = 0.0f;
        // WARNING: no state checks in static context
        /* body */ {
            if (a != a) {
                result = a;
            } else {
                if ((a == 0.0f) && (b == 0.0f) && ((1.0f / a) == NEGATIVE_INFINITY)) {
                    result = b;
                } else {
                    if (a >= b) {
                        result = a;
                    } else {
                        result = b;
                    }
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::min(float, float) -> float
     * Source: java/lang/Float.main.lsl:241
     */
    public static float min(float a, float b) {
        float result = 0.0f;
        // WARNING: no state checks in static context
        /* body */ {
            if (a != a) {
                result = a;
            } else {
                if ((a == 0.0f) && (b == 0.0f) && ((1.0f / b) == NEGATIVE_INFINITY)) {
                    result = b;
                } else {
                    if (a <= b) {
                        result = a;
                    } else {
                        result = b;
                    }
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::sum(float, float) -> float
     * Source: java/lang/Float.main.lsl:262
     */
    public static float sum(float a, float b) {
        float result = 0.0f;
        // WARNING: no state checks in static context
        /* body */ {
            result = a + b;
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::toHexString(float) -> String
     * Source: java/lang/Float.main.lsl:268
     */
    public static String toHexString(float f) {
        String result = null;
        // WARNING: no state checks in static context
        /* body */ {
            if (f != f) {
                result = "NaN";
            } else {
                if (f == POSITIVE_INFINITY) {
                    result = "Infinity";
                } else {
                    if (f == NEGATIVE_INFINITY) {
                        result = "-Infinity";
                    } else {
                        if ((1.0f / f) == NEGATIVE_INFINITY) {
                            result = "-0x0.0p0";
                        } else {
                            if (f == 0.0f) {
                                result = "0x0.0p0";
                            } else {
                                if (f == 1.0f) {
                                    result = "0x1.0p0";
                                } else {
                                    if (f == -1.0f) {
                                        result = "-0x1.0p0";
                                    } else {
                                        result = Engine.makeSymbolic(String.class);
                                        Engine.assume(result != null);
                                        final int len = result.length();
                                        Engine.assume(len >= 7);
                                        Engine.assume(len <= 14);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::toString(float) -> String
     * Source: java/lang/Float.main.lsl:289
     */
    public static String toString(float f) {
        String result = null;
        // WARNING: no state checks in static context
        /* body */ {
            result = LibSLRuntime.toString(f);
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::valueOf(float) -> Float
     * Source: java/lang/Float.main.lsl:305
     */
    public static java.lang.Float valueOf(float f) {
        java.lang.Float result = null;
        // WARNING: no state checks in static context
        /* body */ {
            result = (java.lang.Float) ((Object) new Float((Void) null, 
                /* state = */ Float.__$lsl_States.Initialized, 
                /* value = */ f
            ));
        }
        // WARNING: no state transitions in static context
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::byteValue(LSLFloat) -> byte
     * Source: java/lang/Float.main.lsl:315
     */
    public byte byteValue() {
        byte result = ((byte) 0);
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((byte) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::compareTo(LSLFloat, LSLFloat) -> int
     * Source: java/lang/Float.main.lsl:321
     */
    public int compareTo(Float anotherFloat) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final float a = this.value;
            final float b = ((Float) ((Object) anotherFloat)).value;
            if ((a == b) || (a != a) || (b != b)) {
                result = 0;
            } else {
                if (a < b) {
                    result = -1;
                } else {
                    result = 1;
                }
            }
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::doubleValue(LSLFloat) -> double
     * Source: java/lang/Float.main.lsl:341
     */
    public double doubleValue() {
        double result = 0.0d;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((double) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::equals(LSLFloat, Object) -> boolean
     * Source: java/lang/Float.main.lsl:347
     */
    public boolean equals(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if ((obj instanceof java.lang.Float)) {
                result = this.value == ((Float) ((Object) obj)).value;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::floatValue(LSLFloat) -> float
     * Source: java/lang/Float.main.lsl:356
     */
    public float floatValue() {
        float result = 0.0f;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::hashCode(LSLFloat) -> int
     * Source: java/lang/Float.main.lsl:362
     */
    public int hashCode() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _getRawBits(this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::intValue(LSLFloat) -> int
     * Source: java/lang/Float.main.lsl:368
     */
    public int intValue() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((int) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::isInfinite(LSLFloat) -> boolean
     * Source: java/lang/Float.main.lsl:374
     */
    public boolean isInfinite() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (this.value == POSITIVE_INFINITY) || (this.value == NEGATIVE_INFINITY);
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::isNaN(LSLFloat) -> boolean
     * Source: java/lang/Float.main.lsl:381
     */
    public boolean isNaN() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value != this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::longValue(LSLFloat) -> long
     * Source: java/lang/Float.main.lsl:387
     */
    public long longValue() {
        long result = 0L;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((long) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::shortValue(LSLFloat) -> short
     * Source: java/lang/Float.main.lsl:393
     */
    public short shortValue() {
        short result = ((short) 0);
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = ((short) this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] FloatAutomaton::toString(LSLFloat) -> String
     * Source: java/lang/Float.main.lsl:399
     */
    public String toString() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.toString(this.value);
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(Float.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
