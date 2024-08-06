package Model.Domain;

public enum CompTel {MOTHERBOARD(1, "Scheda Madre"),
    BATTERY(3, "Batteria"),
    SCREEN(4, "Schermo"),
    USB_CONNECTOR(2, "Connettore USB");

    private final int code;
    private final String description;

    CompTel(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static String getDescriptionByCode(int code) {
        for (CompTel component : CompTel.values()) {
            if (component.getCode() == code) {
                return component.getDescription();
            }
        }
        return "Invalid component code";
    }
}
