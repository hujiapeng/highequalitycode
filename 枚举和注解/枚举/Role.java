package hqcode.枚举和注解.枚举;

public enum Role {
    Admin("管理员", new LifeTime(), new Scope()), User("普通用户", new LifeTime(), new Scope());

    private String name;
    //角色生命期
    private LifeTime lifeTime;
    //权限范围
    private Scope scope;

    Role(String _name, LifeTime _lifeTime, Scope _scope) {
        this.name = _name;
        this.lifeTime = _lifeTime;
        this.scope = _scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LifeTime getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(LifeTime lifeTime) {
        this.lifeTime = lifeTime;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }
}


class LifeTime {

}

class Scope {

}
