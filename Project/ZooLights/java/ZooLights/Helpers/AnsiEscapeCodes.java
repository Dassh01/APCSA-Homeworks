package ZooLights.Helpers;

public class AnsiEscapeCodes {
    // Text Attributes
    public static final String RESET = "\033[0m";
    public static final String BOLD = "\033[1m";
    public static final String DIM = "\033[2m";
    public static final String ITALIC = "\033[3m";
    public static final String UNDERLINE = "\033[4m";
    public static final String BLINK = "\033[5m";
    public static final String REVERSE = "\033[7m";
    public static final String HIDDEN = "\033[8m";
    public static final String STRIKETHROUGH = "\033[9m";

    // Foreground Colors
    public static final String FG_BLACK = "\033[30m";
    public static final String FG_RED = "\033[31m";
    public static final String FG_GREEN = "\033[32m";
    public static final String FG_YELLOW = "\033[33m";
    public static final String FG_BLUE = "\033[34m";
    public static final String FG_MAGENTA = "\033[35m";
    public static final String FG_CYAN = "\033[36m";
    public static final String FG_WHITE = "\033[37m";
    public static final String FG_BRIGHT_BLACK = "\033[90m";
    public static final String FG_BRIGHT_RED = "\033[91m";
    public static final String FG_BRIGHT_GREEN = "\033[92m";
    public static final String FG_BRIGHT_YELLOW = "\033[93m";
    public static final String FG_BRIGHT_BLUE = "\033[94m";
    public static final String FG_BRIGHT_MAGENTA = "\033[95m";
    public static final String FG_BRIGHT_CYAN = "\033[96m";
    public static final String FG_BRIGHT_WHITE = "\033[97m";

    // Background Colors
    public static final String BG_BLACK = "\033[40m";
    public static final String BG_RED = "\033[41m";
    public static final String BG_GREEN = "\033[42m";
    public static final String BG_YELLOW = "\033[43m";
    public static final String BG_BLUE = "\033[44m";
    public static final String BG_MAGENTA = "\033[45m";
    public static final String BG_CYAN = "\033[46m";
    public static final String BG_WHITE = "\033[47m";
    public static final String BG_BRIGHT_BLACK = "\033[100m";
    public static final String BG_BRIGHT_RED = "\033[101m";
    public static final String BG_BRIGHT_GREEN = "\033[102m";
    public static final String BG_BRIGHT_YELLOW = "\033[103m";
    public static final String BG_BRIGHT_BLUE = "\033[104m";
    public static final String BG_BRIGHT_MAGENTA = "\033[105m";
    public static final String BG_BRIGHT_CYAN = "\033[106m";
    public static final String BG_BRIGHT_WHITE = "\033[107m";

    // Cursor Control
    public static final String CURSOR_UP = "\033[{n}A";
    public static final String CURSOR_DOWN = "\033[{n}B";
    public static final String CURSOR_FORWARD = "\033[{n}C";
    public static final String CURSOR_BACKWARD = "\033[{n}D";
    public static final String CURSOR_POSITION = "\033[{row};{col}H";
    public static final String SAVE_CURSOR_POSITION = "\033[s";
    public static final String RESTORE_CURSOR_POSITION = "\033[u";
    public static final String HIDE_CURSOR = "\033[?25l";
    public static final String SHOW_CURSOR = "\033[?25h";
}