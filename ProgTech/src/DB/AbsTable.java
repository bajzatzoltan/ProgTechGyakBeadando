package DB;

public abstract class AbsTable {
    public abstract void SelectAll(); // minden sort visszaad
    public abstract void Insert(IIndividual individual); // csak beszúr egy új sort a végére
    public abstract void Delete (IIndividual individual); // végigiterálunk a listán és ha a not null propertik megegyeznek akkor végrehajtja a műveletet
    public abstract void Update(IIndividual individual); //végigiterálunk a listán és ha a not null propertik megegyeznek akkor végrehajtja a műveletet

}
