package model.entity;

public interface EntityConInterface {

    String valueName = null;
    Object value = null;
    Class valueClass = null;

    void setValue(Object value);

    String getValueName();
    Class getValueClass();
    Object getValue();
}
