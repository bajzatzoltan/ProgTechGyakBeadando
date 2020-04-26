package DB.DBStrucure;

//singleton

import java.util.List;

public class Relations_tbl <P, C> {
    private volatile static Relations_tbl instance;

    private List<Relation> relations;

    public List<Relation> Relations() {
        //deep copy kell
        return relations;
    }

    private Relations_tbl() {

    }

    public static Relations_tbl GetInstance() {
        if (instance.equals(null)) {
            instance = new Relations_tbl();
        }
        return instance;
    }

    public Relation AddRelation(P parent, C child) {
        Relation relation = new Relation(parent, child);
        relations.add(relation);
        return relation;
    }

    public void RemoveRelation(Relation relation) { //ezt átgondolni hogy legyen, a relation-t a táblákban kell tárolni valószínű

    }
}



