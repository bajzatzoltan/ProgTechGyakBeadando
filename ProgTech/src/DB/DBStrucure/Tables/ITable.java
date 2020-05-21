package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import java.util.List;

public interface ITable <T, E>{
    void Insert(T individual) throws Exception;
    void Delete (int ID);
    void Update(int ID, T individual) throws Exception;
    E GetInstanceByID(int ID) throws CloneNotSupportedException;
    List<E> SelectAll() throws CloneNotSupportedException;

}
