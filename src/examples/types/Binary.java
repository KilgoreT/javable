package examples.types;

import org.omg.PortableInterceptor.INACTIVE;

public class Binary {

    public static final int UP = 1;
    public static final int DOWN = 1 << 1;
    public static final int LEFT = 1 << 2;
    public static final int RIGHT = 1 << 3;
    public static final int START = LEFT << 2;
    public static final int END = RIGHT << 2;
    public static final int DIRECTION_FLAG_COUNT = 8;
    public static final int RELATIVE_DIR_FLAGS =
                    START |
                    END |
                    ((START | END) << DIRECTION_FLAG_COUNT) |
                    ((START | END) << (2 * DIRECTION_FLAG_COUNT));

    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;

    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ACTION_STATE_DRAG = 2;




    public static void main(String[] args) {
        //System.out.println("UP    = " + Integer.toBinaryString(1) + "b       = " + (1));
        //System.out.println("DOWN  = " + Integer.toBinaryString(1 << 1) + "b      = " + (1 << 1));
        //System.out.println("LEFT  = " + Integer.toBinaryString(1 << 2) + "b     = " + (1 << 2));
        //System.out.println("RIGHT = " + Integer.toBinaryString(1 << 3) + "b    = " + (1 << 3));
        System.out.println("START = " + Integer.toBinaryString(LEFT << 2) + "b   = " + (LEFT << 2));
        //System.out.println("END   = " + Integer.toBinaryString(RIGHT << 2) + "b  = " + (RIGHT << 2));
        //System.out.println("START|END = " + Integer.toBinaryString(START | END));
        //System.out.println("((START | END) << DIRECTION_FLAG_COUNT) = " + Integer.toBinaryString(((START | END) << DIRECTION_FLAG_COUNT)));
        //System.out.println("START | END | ((START | END) << DIRECTION_FLAG_COUNT) = " + Integer.toBinaryString(START | END | ((START | END) << DIRECTION_FLAG_COUNT)));
        //System.out.println("(START | END) << (2 * DIRECTION_FLAG_COUNT) = " + Integer.toBinaryString((START | END) << (2 * DIRECTION_FLAG_COUNT)));
        System.out.println("RELATIVE_DIR_FLAGS = " + Integer.toBinaryString(RELATIVE_DIR_FLAGS));

        int dragFlags = UP | DOWN;
        int swipeFlags = LEFT | START;
        //System.out.println("idle flaf = " + Integer.toBinaryString(makeFlag(ACTION_STATE_IDLE, dragFlags | swipeFlags)));
        //System.out.println("swipe flaf = " + Integer.toBinaryString(makeFlag(ACTION_STATE_SWIPE, swipeFlags)));
        //System.out.println("drop flaf = " + Integer.toBinaryString(makeFlag(ACTION_STATE_DRAG, dragFlags)));
        //System.out.println("all = " + Integer.toBinaryString(makeMovementFlags(dragFlags, swipeFlags)));

        int flags = makeMovementFlags(dragFlags, swipeFlags);
        System.out.println("flags = " + Integer.toBinaryString(flags));
        int masked = makeMovementFlags(dragFlags, swipeFlags) & RELATIVE_DIR_FLAGS;
        System.out.println("masked = " + Integer.toBinaryString(masked));
        System.out.println("Without START, END: " + Integer.toBinaryString(flags &= ~masked));
        //flags |= masked >> 2;
        //System.out.println("if ltr            : " + Integer.toBinaryString(flags));
        flags |= ((masked >> 1) & ~RELATIVE_DIR_FLAGS);
        flags |= ((masked >> 1) & RELATIVE_DIR_FLAGS) >> 2;
        System.out.println("if rtl            : " + Integer.toBinaryString(flags));

    }

    public static int makeFlag(int actionState, int directions) {
        return directions << (actionState * DIRECTION_FLAG_COUNT);
    }
    public static int makeMovementFlags(int dragFlags, int swipeFlags) {
        return makeFlag(ACTION_STATE_IDLE, swipeFlags | dragFlags)
                | makeFlag(ACTION_STATE_SWIPE, swipeFlags)
                | makeFlag(ACTION_STATE_DRAG, dragFlags);
    }
}
