package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;
import java.util.List;

public interface ITable <T>{
    void Insert(T individual); // csak beszúr egy új sort a végére
    void Delete (T individual); // végigiterálunk a listán és ha a not null propertik megegyeznek akkor végrehajtja a műveletet
    void Update(T individual); //végigiterálunk a listán és ha a not null propertik megegyeznek akkor végrehajtja a műveletet
    void AddRelation();
    List<T> SelectAll() throws CloneNotSupportedException;

}
