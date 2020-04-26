package DB.DBStrucure;

//singleton

import java.util.ArrayList;
import java.util.List;

public class Relations_tbl <P, C> {
    private volatile static Relations_tbl instance;
    private List<Relation> listRelations;
    public List<Relation> GetListRelations() {
        //deep copy kell
        return listRelations;
    }
    private Relations_tbl() {
        listRelations = new ArrayList<Relation>();
    }
    public static Relations_tbl GetInstance() {
        if (instance.equals(null)) {
            instance = new Relations_tbl();
        }
        return instance;
    }
    public Relation AddRelation(P parent, C child) {
        Relation relation = new Relation(parent, child);
        listRelations.add(relation);
        return relation;
    }
    public void RemoveRelation(Relation relation) { //ezt átgondolni hogy legyen, a relation-t a táblákban kell tárolni valószínű

    }
}



