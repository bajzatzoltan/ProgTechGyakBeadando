package DB.DBStrucure;

public class Relation<P, C> implements IRelation, Cloneable {
    private P parent;
    public P getParent() {
        return parent;
    }
    private C child;
    public C getChild() {
        return child;
    }
    public Relation(P parent, C child){
        this.parent = parent;
        this.child = child;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
