package DB.DBStrucure;

public interface IRelation <P, C>{
    public P getParent();
    public C getChild();
}
