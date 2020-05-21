package Client.DMLOperation;

public abstract class JoinSelectDecorator implements  IJoinSelect{
    private IJoinSelect joinSelect;
    public JoinSelectDecorator(IJoinSelect joinSelect){
        this.joinSelect = joinSelect;
    }
    @Override
    public String decorate() throws Exception {
        return joinSelect.decorate();
    }
}
