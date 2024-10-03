package model.Treinamento;

public class Treinamento {
    private int id;
    private String tipo;
    private Date dataInicio;
    private Date dataFinal;
    private List<TreinoDia>;

    private void adicionarTreinoDia(TreinoDia treinoDia){
        System.out.println(treinoDia + " adicionado");
    }

    private void removerTreinoDia(TreinoDia treinoDia){
        System.out.println(treinoDia + " removido");
    }

    public Treinamento(int id, String tipo, Date dataInicio, Date dataFinal, List<TreinoDia> treinoDias) {
        this.id = id;
        this.tipo = tipo;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.treinoDias = treinoDias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    
}
