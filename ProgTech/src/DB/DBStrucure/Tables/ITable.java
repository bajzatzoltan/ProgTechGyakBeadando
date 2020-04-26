package DB.DBStrucure.Tables;

import DB.DBStrucure.Individuals.IIndividual;

public interface ITable {
    void Insert(IIndividual individual); // csak beszúr egy új sort a végére
    void Delete (IIndividual individual); // végigiterálunk a listán és ha a not null propertik megegyeznek akkor végrehajtja a műveletet
    void Update(IIndividual individual); //végigiterálunk a listán és ha a not null propertik megegyeznek akkor végrehajtja a műveletet
    void AddRelation();

}
