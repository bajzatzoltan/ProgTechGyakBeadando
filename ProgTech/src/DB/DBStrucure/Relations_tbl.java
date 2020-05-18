package DB.DBStrucure;

//singleton

import javax.crypto.ExemptionMechanism;
import java.util.ArrayList;
import java.util.List;

public class Relations_tbl <P, C> {
    private volatile static Relations_tbl instance;
    private List<Relation> listRelations;
    public List<Relation> GetListRelations() throws CloneNotSupportedException{
        List<Relation> cloneList = new ArrayList<Relation>();
        for (Relation x: listRelations) {
            cloneList.add((Relation)x.clone());
        }
        return cloneList;
    }
    private Relations_tbl() {
        listRelations = new ArrayList<Relation>();
    }
    public static Relations_tbl GetInstance() {
        if (instance == null) {
            instance = new Relations_tbl();
        }
        return instance;
    }
    public void AddRelation(P parent, C child) {
        Relation relation = new Relation(parent, child);
        if ( !IsContainRelation(relation) ){
            listRelations.add(relation);
        }
        else {
            throw new ArrayStoreException("Relations_tbl.ListRelations already contains this relation");
        }
    }
    public void RemoveRelation(Relation relation) {
        int index = 0;
        while(index < listRelations.size()){
            if (listRelations.get(index).getParent().getClass().getSimpleName() == relation.getParent().getClass().getSimpleName() &&
                    listRelations.get(index).getChild().getClass().getSimpleName() == relation.getChild().getClass().getSimpleName()){
                listRelations.remove(index);
                index = listRelations.size() + 1;
            }
            index++;
        }
        if (index == listRelations.size()){
            throw  new ArrayIndexOutOfBoundsException("ListRelations does not contain this relation");
        }
    }
    public boolean IsContainRelation(Relation relation){
        boolean result = false;
        for (Relation x : listRelations) {
            if (x.getParent() == relation.getParent() && x.getChild() == relation.getChild()) {
                result = true;
            }
        }
        return result;
    }



}



