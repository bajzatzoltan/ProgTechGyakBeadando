package DB;

public abstract class AbsTable {
    public abstract void SelectAll();
    public abstract void Insert(IIndividual individual);
    public abstract void DeleteByID (int ID);
    public abstract void UpdateByID(int ID, IIndividual individual);

}
