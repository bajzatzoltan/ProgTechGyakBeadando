package DB.DBStrucure;

public class Relation<P, C> implements IRelation {
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
}
