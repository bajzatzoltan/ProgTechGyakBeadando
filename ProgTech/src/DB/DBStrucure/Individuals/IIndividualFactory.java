package DB.DBStrucure.Individuals;

public interface IIndividualFactory{
    public IIndividual GetIndividual(int ID, String tableName);
}
