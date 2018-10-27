package pl.eavo.model;

public enum AlarmType {
    SUCCESS("success"),
    INFO("info"),
    WARNING("warning"),
    DANGER("danger");

    private final String alert;

    private AlarmType(String s) {
        alert = s;
    }

    public String toString() {
        return this.alert;
    }
}
