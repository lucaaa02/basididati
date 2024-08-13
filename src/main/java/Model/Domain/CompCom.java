package Model.Domain;

public enum CompCom {
    MOTHERBOARD(1, "Scheda Madre"),

    USB_CONNECTOR(2, "Connettore USB"),
    BATTERY(3, "Batteria"),
    SCREEN(4, "Schermo"),
    RAM(5,"RAM"),
    FAN(7,"Ventola"),
    TASTIERA(6,"Tastiera");

    private final int code;
    private final String description;

    CompCom(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public static void main(String[] args) {
    }
    public String getDescription() {
        return description;
    }

    public static String getDescriptionByCode(int code) {
        for (CompCom component : CompCom.values()) {
            if (component.getCode() == code) {
                return component.getDescription();
            }
        }
        return "Invalid component code";
    }
}
