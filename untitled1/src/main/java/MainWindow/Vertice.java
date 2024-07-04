package MainWindow;

public class Vertice{
    //поля класса
    private int name;
    private boolean lable; //метка для алг Прима

    public Vertice(int name_input){
        name = name_input;
        lable = false;
    }

    public int get_name(){
        return name;
    }

    public void setLable() {
        lable = true;
    }

    public boolean getLable(){
        return lable;
    }
}
