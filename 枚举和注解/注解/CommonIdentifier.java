package hqcode.枚举和注解.注解;

public enum CommonIdentifier implements Identifier {
    Reader,Author,Admin;
    @Override
    public boolean identify() {
        return false;
    }
}
