package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import java.util.List;

public interface ITable <T>{
    void Insert(T individual);
    void Delete (int ID);
    void Update(int ID, T individual);
    T GetInstanceByID(int ID) throws CloneNotSupportedException;
    List<T> SelectAll() throws CloneNotSupportedException;

}
